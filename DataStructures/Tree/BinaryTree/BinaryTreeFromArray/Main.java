import java.util.LinkedList;


public class Main{
    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree(); 
        // int[] arr= {1,2,3,4,5,6,7,8,9,10};
        int[] arr= {11,2,33,412,6,7,8,1,29,0,113};
        tree.createBinaryTree(arr);

        System.out.println("In order traversal");
        // tree.inOrderTraversal(tree.root);
        
        System.out.println("DFS traversal");
        tree.DFS(tree.root);
        System.out.println("");
        
        TreeUtil.displayTree(tree.root);
    }
  }

