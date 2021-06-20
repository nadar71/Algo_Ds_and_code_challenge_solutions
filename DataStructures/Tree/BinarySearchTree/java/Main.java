import java.util.Arrays;
import java.util.LinkedList;
import bst.BinarySearchTree;
import tree.BinaryTree;
import tree.TreeUtil;
import tree.Node;


public class Main{
    public static void main(String[] args) 
    { 
        BinarySearchTree tree = new BinarySearchTree(); 
        // int[] arr= {1,2,3,4,5,6,7,8,9,10};
        int[] arr= {11,2,33,412,6,7,8,1,29,0,113};        
        tree.createBSTFromArray(arr);

        System.out.println("In order traversal");
        // tree.inOrderTraversal(tree.root);
        
        System.out.println("DFS traversal");
        tree.DFS(tree.root);
        System.out.println("");
        
        TreeUtil.displayTree(tree.root);
        
        System.out.println("Insert a new node : ");
        tree.insertBST(27);
        System.out.println("DFS traversal");
        tree.DFS(tree.root);
        System.out.println("");
        TreeUtil.displayTree(tree.root);
        
        
        System.out.println("113 is in the tree?" + tree.isInBST(113));
        System.out.println("12 is in the tree?" + tree.isInBST(12));
        
        System.out.println("The max is : " + tree.getMax());
        System.out.println("The min is : " + tree.getMin());
        
        System.out.println("The tree is a BST ? " + tree.isBST(tree.root));
        
        
        System.out.println("Create a normal binary from the same array " );
        BinaryTree btree = new BinaryTree();
        btree.createBinaryTree(arr);
        System.out.println("The tree is a BST ? " + tree.isBST(btree.root));
        
        
        System.out.println("Delete node 11 from BST " );
        tree.BSTdeleteNode(tree.root, 11);
        System.out.println("Delete node 29 from BST " );
        tree.BSTdeleteNode(tree.root, 29);
        System.out.println("Delete node 412 from BST " );
        tree.BSTdeleteNode(tree.root, 412);
        System.out.println("Delete the ROOT NODE 8 from BST " );
        tree.BSTdeleteNode(tree.root, 8);
        TreeUtil.displayTree(tree.root);
        
        System.out.println("The least common ancenstor between 1 and 7 is :  " + tree.BSTLeastCommonAncestor(tree.root, 1, 7));
        System.out.println("The least common ancenstor between 0 and 33 is :  " + tree.BSTLeastCommonAncestor(tree.root, 0, 33));
        System.out.println("The least common ancenstor between 6 and 7 is :  " + tree.BSTLeastCommonAncestor(tree.root, 6, 7));

        System.out.println("Trim all nodes between 4 and 50");
        tree.BSTtrimOutsideRange(tree.root, 4, 50);
        TreeUtil.displayTree(tree.root);
        
        
        System.out.println("Print inside range of 5, 30");
        tree.BSTPrintInsideRange(tree.root, 5, 30);

        System.out.println("Find floor for 4 : "+tree.findFloor(tree.root, 4));
        
        System.out.println("Find ceiling for 8 : "+tree.findCeil(tree.root, 8));
        
        
        

    }
  }

