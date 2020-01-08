/*
Binary tree example, inserted manually node by node.
- in order, pre order, post order trasversal
- DFS search
- BFS search
*/



import java.util.LinkedList;


class Node { 
    int data; 
    boolean visited;
    Node left, right; 
  
    public Node(int item) 
    { 
        visited = false;
        data  = item; 
        left = right = null; 
    } 
}

class BinaryTree { 
 
    Node root; 
    int current_level = 0;
    int tree_depth    = 0;
  
  
    BinaryTree() { 
        root = null; 
    } 


    BinaryTree(int data){ 
        root = new Node(data); 
    } 
  



    public Node newNode(int data){
         return new Node(data);
    }



    public void inOrderTraversal(Node node){
      if (node != null){
          inOrderTraversal(node.left);
          node.visited = true;
          System.out.println("Node : "+node.data);
          inOrderTraversal(node.right);
      }
    }



    public void preOrderTraversal(Node node){
      if (node != null){
          node.visited = true;
          System.out.println("Node : "+node.data);
          preOrderTraversal(node.left);      
          preOrderTraversal(node.right);
      }

    }


    public void postOrderTraversal(Node node){
      if (node != null){
          postOrderTraversal(node.left);      
          postOrderTraversal(node.right);
          node.visited = true;
          System.out.println("Node : "+node.data);
      }

    }
    
    
    public void clearVisitedNodes(Node node){
      if (node != null){
          clearVisitedNodes(node.left);
          clearVisitedNodes(node.right);
          node.visited = false;
      }
    }



    // using DFS for traversing the tree
    // Search for next nodes
    public void search(Node node) {
      if (node == null) return;   // tree empty or end last children
      node.visited = true;

      System.out.print(node.data + " ");
           
      if ( (node.left  != null) && (!node.left.visited)  ) {
          search(node.left);
          if  (node != root) current_level++;
          // System.out.println("Current Level : "+current_level+"\n");
          
        }

      if ( (node.right != null) && (!node.right.visited) ) 
        search(node.right);     
      

     }


    // DFS traversal
    public void DFS(Node node) {    
      search(node);
      tree_depth = current_level; 
      System.out.println("Tree depth : "+tree_depth);
     }



    // prints BFS traversal from a given source s 
    public void BFS(Node node) 
    { 
  
        // Create a queue for BFS 
        LinkedList<Node> queue = new LinkedList<Node>(); 
  
        // Mark the current node as visited and enqueue it 
        node.visited = true; 
        queue.add(node); // add at the end of the queue, starting from root
  
        while (queue.size() != 0) 
        { 
            // Dequeue a node from queue and print it 
            node = queue.poll(); 
            node.visited = true;
            System.out.print(node.data+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it visited and enqueue it                       
            if ( (node.left  != null) && (!node.left.visited)  ) {
              queue.add(node.left);              
            }

            if ( (node.right != null) && (!node.right.visited) ) 
            queue.add(node.right); 

        }
    } 
} 





public class Main{
      public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree(); 
  
        tree.root       = tree.newNode(1); 
  
        /* following is the tree after above statement 
  
              1 
            /   \ 
          null  null     */
  
        tree.root.left        = tree.newNode(2); 
        tree.root.left.right  = tree.newNode(5); 
        tree.root.right       = tree.newNode(3); 
        tree.root.right.left  = tree.newNode(7);
  
        /* 2 and 3 become left and right children of 1 
                 1 
             /      \ 
            2        3 
          /    \    /  \ 
        null    5  7  null  */
  
  
        tree.root.left.left = tree.newNode(4);
        
        /* 4 becomes left child of 2 
                    1 
                /       \ 
               2          3 
             /   \       /  \ 
            4     5     7   null
           /   \ 
          null  null 
         */

        System.out.println("In order traversal");
        tree.inOrderTraversal(tree.root);


        System.out.println("Pre order traversal");
        tree.preOrderTraversal(tree.root);

        System.out.println("Post order traversal");
        tree.postOrderTraversal(tree.root);

        tree.clearVisitedNodes(tree.root);
        System.out.println("DFS traversal");
        tree.DFS(tree.root);

        tree.clearVisitedNodes(tree.root);
        System.out.println("BFS traversal");
        tree.BFS(tree.root);

        TreeUtil.displayTree(tree.root);
    } 
}
