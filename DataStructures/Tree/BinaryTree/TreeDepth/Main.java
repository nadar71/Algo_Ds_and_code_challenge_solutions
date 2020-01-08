import java.util.LinkedList;


public class Main{
    public static void main(String[] args) 
    { 
            System.out.println("--------------- First tree ---------------");
        BinaryTree tree = new BinaryTree(); 
        int[] arr= {11,2,33,412,6,7,8,1,29,0,113};
        tree.createBinaryTree(arr);

        System.out.println("In order traversal");
        // tree.inOrderTraversal(tree.root);
        
        System.out.println("DFS traversal");
        tree.DFS(tree.root);
        System.out.println("");
        
        TreeUtil.displayTree(tree.root);
        
        TreePrintByLevel.printByLevel(tree.root);
        
        System.out.println("TreeDepth : "+TreeDepth.treeDepth(tree.root));
        
        
        System.out.println("--------------- Second tree  ---------------");
        
        BinaryTree tree2 = new BinaryTree(); 
        int[] arr2= {4,1,2,36,77,1,987,111,3,115,32,53,4,56,78,5,124,891,7};
        tree2.createBinaryTree(arr2);

        TreeUtil.displayTree(tree2.root);
        
        TreePrintByLevel.printByLevel(tree2.root);
        
        System.out.println("TreeDepth : "+TreeDepth.treeDepth(tree2.root));
        
    }
  }

