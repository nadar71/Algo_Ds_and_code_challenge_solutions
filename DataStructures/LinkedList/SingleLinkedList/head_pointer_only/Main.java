/*
Single Linked List with only head pointer (not tail pointer)
*/


class Node {
	int data;
	Node next;


	public Node(int d) {
		data = d;
		next = null;
	}

}



class LinkedList {
	Node head = null ;
	int length;

	public LinkedList() {
		// head   = new Node();
		length = 0;
	}

	public boolean greater(int v1, int v2) {
		return v1 > v2;
	}

	public boolean smaller(int v1, int v2) {
		return v1 < v2;
	}

	public boolean greaterEq(int v1, int v2) {
		return v1 >= v2;
	}

	public boolean smallerEq(int v1, int v2) {
		return v1 <= v2;
	}

	public void printList() {
		Node ptr = head;
		if (isEmpty()) return;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		if (head == null || length <=0) {
			System.out.println("The list is empty");
			return true;
		}
		else return false;
	}

	// time complexity O(n)
	public void append(int d) {
		Node node = new Node(d);
		// empty list, first node
		if (head == null) {
		  head = node;
		  length++;
		  return;
		}
		
		Node ptr = head; // cursor pointer

		while (ptr.next != null)
			ptr = ptr.next;
		ptr.next = node;
		length++;
	}

	// delete node
	public void deleteNode(int d) {
		Node ptr = head;
		if (isEmpty()) return;
		
		while (ptr.next != null) {
			if (ptr.next.data == d) {				
				ptr.next = ptr.next.next;
				length--;
				return;
			}else ptr = ptr.next;			
		}

		System.out.println("Element not present in list.");
	}
		
	// delete list deeply
	public void deleteListDeep() {
		if (isEmpty()) return;
		Node ptr = head;

		while (ptr.next != null) {
			Node tmp = ptr.next;
			ptr.next = null;
			ptr = tmp;
			length--;
		}
	}


	// delete list quick
	public void deleteListQuick() {
		head = null;
		length = 0;		
	}
	

	// time complexity worst case O(N)
	public void insertSortedNode(int d) { // ascending order
		Node node = new Node(d);

		// no elements in list
		if (head == null) { // first node
			head = node;			       
			length++;
			return;
		}
		
		Node ptr  = head; // cursor pointer

		// ptr.next != null means : last node
		while (ptr.next != null && greater(node.data, ptr.next.data))
			ptr = ptr.next;

		node.next = ptr.next;
		ptr.next = node;
		length++;

	}
}


public class Main {

	public static void main(String args[]) {
		LinkedList list = new LinkedList();

		System.out.println("\nInsert node without sorting");
		list.append(27);
		list.append(12);
		list.append(1);
		list.append(1009);
		list.append(4);
		list.append(5);
		list.append(23);
		list.append(9);

		list.printList();
		
		System.out.println("\nDelete node in unsorted listed");
		list.deleteNode(1009);
		list.deleteNode(1);
		list.deleteNode(5);
		list.printList();
		
		System.out.println("\nClear list.");
		list.deleteListDeep();
		list.printList();
        
		System.out.println("\nInsert node in sorted List");
		list.insertSortedNode(27);
		list.insertSortedNode(12);
		list.insertSortedNode(1);
		list.insertSortedNode(1009);
		list.insertSortedNode(4);
		list.insertSortedNode(5);
		list.insertSortedNode(23);
		list.insertSortedNode(9);
		list.append(27);

		list.printList();
		
		System.out.println("\nDelete node in sorted listed");
		list.deleteNode(1009);
		list.deleteNode(1);
		list.deleteNode(5);
		
		list.printList();

	}

}
