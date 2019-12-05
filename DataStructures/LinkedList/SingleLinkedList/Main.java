

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
		length = 0;
	}



	public void printList() {
	    Node ptr = head;

	    if (isEmpty())
	      return;

	    while (ptr != null) {
	      System.out.print(ptr.data + " ");
	      ptr = ptr.next;
	    }
	    System.out.println(" ");

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


	public void insertAtHead(int d) {
		Node node = new Node(d);
		// empty list, first node
		if (head == null) {
		  head = node;
		  length++;
		  return;
		}
		
		node.next = head; 
		head      = node;
		length++;
	}

	// delete node
	public void deleteNode(int d) {
		if (isEmpty()) return;
		
		// delete at head
		if (d == head.data) {
			head = head.next;
			length--;
			return;
		}		
		
		Node ptr = head;
		
		
		while (ptr.next != null && d != ptr.next.data) {
			  ptr = ptr.next;
		}
		
		if(ptr.next == null) {
			System.out.println("Element not present.");
		}else {
			ptr.next  = ptr.next.next;
			length--;
			return;
		}
	
	}


	// delete list 
	public void deleteList() {
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
		while (ptr.next != null && node.data > ptr.next.data)
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

		System.out.println("\nInsert node at start of the list");
		list.insertAtHead(10);
		list.insertAtHead(20);
		list.insertAtHead(30);

		list.printList();

		
		System.out.println("\nDelete node in unsorted listed");
	    list.deleteNode(1009);
	    list.deleteNode(1);
	    list.deleteNode(5);
	    list.printList();

	    System.out.println("\nDelete first node");
	    list.deleteNode(30);
	    list.printList();

	    System.out.println("\nDelete second node");
	    list.deleteNode(20);
	    list.printList();

	    System.out.println("\nDelete last node");
	    list.deleteNode(9);
	    list.printList();

	    System.out.println("\nDelete node not present");
	    list.deleteNode(99999);
		
		System.out.println("\nClear list.");
		list.deleteList();
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

/*
 
Insert node without sorting
27 12 1 1009 4 5 23 9  

Insert node at start of the list
30 20 10 27 12 1 1009 4 5 23 9  

Delete node in unsorted listed
30 20 10 27 12 4 23 9  

Delete first node
20 10 27 12 4 23 9  

Delete second node
Element not present.
20 10 27 12 4 23 9  

Delete last node
20 10 27 12 4 23  

Delete node not present
Element not present.

Clear list.
The list is empty

Insert node in sorted List
27 1 4 5 9 12 23 1009 27  

Delete node in sorted listed
27 4 9 12 23 27  
*/
