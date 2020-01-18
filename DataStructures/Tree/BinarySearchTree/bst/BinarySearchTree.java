package bst;

import java.util.Arrays;

import tree.BinaryTree;
import tree.Node;

public class BinarySearchTree extends BinaryTree {

	// create from sorted array
	public void createBSTFromArray(int[] arr) {
		Arrays.sort(arr);
		root = createBST(arr, 0, arr.length - 1);
	}

	public Node createBST(int[] arr, int start, int end) {

		if (start > end)
			return null;
		int mid = (int) (start + end) / 2;

		Node node = new Node(arr[mid]);
		node.left = createBST(arr, start, mid - 1);
		node.right = createBST(arr, mid + 1, end);

		return node;
	}

	// insert in a bst
	public void insertBST(int value) {
		root = makeInsertionBST(value, root);
	}

	public Node makeInsertionBST(int value, Node node) {

		if (node == null)
			node = new Node(value);
		else {

			if (node.data > value)
				node.left = makeInsertionBST(value, node.left);
			else
				node.right = makeInsertionBST(value, node.right);
		}
		return node;
	}

	// check value in Bst
	public boolean isInBST(int value) {
		if (root == null) return false;
		
		Node prt = root;
		while (prt != null) {
			if (prt.data == value) return true;
			else if (prt.data > value) prt = prt.left;
			else if (prt.data < value) prt = prt.right;
		}

		return false;
	}

	// get min/max value :
	public int getMin() {
		if (root == null) {
			System.out.print("Empty tree");
			return -1;
		}
		
		Node prt = root.left;
		while (prt.left != null) prt = prt.left;
		
		return prt.data;
	}

	
	public int getMax() {
		if (root == null) {
			System.out.print("Empty tree");
			return -1;
		}
		
		Node prt = root.right;
		while (prt.right != null)  prt = prt.right;
		
		return prt.data;
	}


		public int getMin(Node start) {
		if (start == null) {
			System.out.print("Empty tree");
			return -1;
		}
		
		Node prt = start.left;
		if (prt == null) return start.data; 
		while (prt.left != null) prt = prt.left;
		
		return prt.data;
	}

	
	public int getMax(Node start) {
		if (start == null) {
			System.out.print("Empty tree");
			return -1;
		}
		
		Node prt = start.right;
		if (prt == null) return start.data;
		while (prt.right != null)  prt = prt.right;
		
		return prt.data;
	}
	
	// validate BST
	public  boolean isBST(Node root){
		return checkBSTValidity(root);
	}


	public  boolean checkBSTValidity(Node start){
		if ( start == null) return true;

		if ( (start.left  != null && getMax(start.left)>start.data)  ||
		     (start.right != null && getMin(start.right)<=start.data) )  return false;

		return checkBSTValidity(start.left) && checkBSTValidity(start.right);
	}


	// delete Node in bst
	public  void BSTdeleteNode(Node start, int data){
		root = doDelete(start, data);
	}


	public Node doDelete(Node start, int data){
		if ( start == null) return null;

		if (data > start.data)      start.right = doDelete(start.right,data);
		else if (data < start.data) start.left  = doDelete(start.left,data);
		// equal to data
		else{
			// only 1 child
			if(start.left  == null) return start.right;
			if(start.right == null) return start.left;

			// 2 children
			// get the in order successor  = leftmost node in right subtree
			start.data = getMin(start.right);
			// delete the in order successor 
			start.right = doDelete(start.right,start.data);
		}
		return start;		
	}


	// least common ancestor
	public int BSTLeastCommonAncestor(Node start, int n1, int n2){
		return lcmCalc(start, n1,n2);
	}


	public int lcmCalc(Node start, int n1, int n2){
		if ( start == null) return Integer.MAX_VALUE;

		if (start.data > n1 && start.data > n2) return lcmCalc(start.left,n1,n2);
		if (start.data < n1 && start.data < n2) return lcmCalc(start.right,n1,n2);
		// System.out.println("		start.data : "+start.data);
		return start.data;		
	}



	// trim outside range min/max
	public void BSTtrimOutsideRange(Node start, int min, int max){
		root = doTrim(start, min, max);
	}


	public Node  doTrim(Node start, int min, int max){
		if ( start == null) return null;

		start.left = doTrim(start.left, min, max);
		start.right = doTrim(start.right, min, max);

		if (start.data < min) return start.right;
		if (start.data > max) return start.left;

		return start;		
	}


	// print in range
	public void BSTPrintInsideRange(Node start, int min, int max){
		doPrint(start, min, max);
	}


	public void  doPrint(Node start, int min, int max){
		if ( start == null) return ;

		doPrint(start.left, min, max);

		if ( start.data >= min && start.data <= max) 
			System.out.println(start.data);

		doPrint(start.right, min, max);

	}




		// find nearest value turning down
	public int findFloor(Node start, int value){
	    Node ptr = start;
	    int floor = Integer.MAX_VALUE;
	    while( ptr != null){
	      if(ptr.data == value ) {
	    	  	floor = ptr.data;
	    	  	break;
	      }

	      else if (ptr.data > value )  // need to find smaller 
	    	    ptr = ptr.left;

	      else if (ptr.data < value ) { // find it: first node less the value
	        floor = ptr.data;       
	        ptr  = ptr.right;
	      }
	    }
	    return floor;
	  }


	  // find nearest value turning up
	  public int findCeil(Node start, int value){
	    Node ptr = start;
	    int ceil = Integer.MIN_VALUE;
	    while( ptr != null){
	      if(ptr.data == value ) {
		    	  ceil = ptr.data;
		    	  break;
	      }

	      else if (ptr.data > value ) { // need to find greater 
	          ceil = ptr.data;
	          ptr = ptr.left;
	      }
	      else if (ptr.data < value )  // find it: first node less the value               
	    	  ptr  = ptr.right;
	      

	    }
	    return ceil;
	  }






}
