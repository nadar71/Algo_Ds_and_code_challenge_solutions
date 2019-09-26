/*
Single Linked List with only head pointer (not tail pointer)
*/


class Node {
	int data;
	Node next;
	
	public Node() {
		data = -1;
		next = null;
	}

	public Node(int d) {
		data = d;
		next = null;
	}

}



class LinkedList {
	Node head;
	int length;

	public LinkedList() {
		head = new Node();
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
		Node link = head.next;
		if (link == null) {
			System.out.println("The list is empty");
			return;
		}
		while (link != null) {
			System.out.println(link.data);
			link = link.next;
		}
		System.out.println();
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return length <= 0;
	}

	// time complexity O(n)
	public void append(int d) {
		Node node = new Node(d);
		Node ptr = head; // cursor pointer

		// empty list, first node
		if (head.next == null) {
			head.next = node;
			length++;
			return;
		}

		while (ptr.next != null)
			ptr = ptr.next;
		ptr.next = node;
		length++;
	}

	// delete list
	public void deleteNode(int d) {
		Node ptr = head;
		if (head.next == null) {
			System.out.println("The list is empty");
			return;
		}
		

		while (ptr.next != null) {
			if (ptr.next.data == d) {				
				ptr.next = ptr.next.next;
				length--;
				return;
			}else ptr = ptr.next;			
		}

		System.out.println("Element not present in list.");
	}
		
	// delete list
	public void deleteList() {
		Node ptr = head;
		if (head.next == null) {
			System.out.println("The list is empty");
			return;
		}
		while (ptr.next != null) {
			Node tmp = ptr.next;
			ptr.next = null;
			ptr = tmp;
			length--;
		}
	}
	
	

	// time complexity worst case O(N)
	public void insertSortedNode(int d) { // ascending order
		Node node = new Node(d);
		Node ptr  = head; // cursor pointer

		// no elements in list
		if (head.next == null) { // first node
			head.next = node;			       
			length++;
			return;
		}

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

		System.out.println("Insert node without sorting");
		list.append(27);
		list.append(12);
		list.append(1);
		list.append(1009);
		list.append(4);
		list.append(5);
		list.append(23);
		list.append(9);

		list.printList();
		
		System.out.println("Delete node in unsorted listed");
		list.deleteNode(1009);
		list.deleteNode(1);
		list.deleteNode(5);
		list.printList();
		
		System.out.println("Clear list.");
		list.deleteList();
		list.printList();
        
		System.out.println("Insert node in sorted List");
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
		
		System.out.println("Delete node in sorted listed");
		list.deleteNode(1009);
		list.deleteNode(1);
		list.deleteNode(5);
		
		list.printList();

	}

}
