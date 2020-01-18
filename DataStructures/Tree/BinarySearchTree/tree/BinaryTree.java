package tree;

public class BinaryTree 
{ 

    // Root of Binary Tree 
    public Node root; 
  
    // Constructors 
    public BinaryTree(int data) 
    { 
        root = new Node(data); 
    } 
  
    public BinaryTree() 
    { 
        root = null; 
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

    
    // using DFS for traversing the tree
    // Search for next nodes
    public void search(Node node) {
      if (node == null) return;
      node.visited = true;

      System.out.print(node.data + " ");
           
      if ( (node.left  != null) && (!node.left.visited)  ) search(node.left);
      if ( (node.right != null) && (!node.right.visited) ) search(node.right);     

     }


    // DFS traversal. 
    public void DFS(Node node) {    
      search(node);
     }
    


    // PROBLEM SOLUTION : OK
    public void createBinaryTree(int[] arr){
        root = generate(arr,0);     // start from array index 0
    }

    
    public Node generate(int[] arr, int start){
        int  size  = arr.length;
        Node curr  = newNode(arr[start]);

        int  left  = 2 * start + 1;
        int  right = 2 * start + 2;

        if (left  < size) curr.left  = generate(arr,left);

        if (right < size) curr.right = generate(arr,right);

        return curr;
        
    }

} 