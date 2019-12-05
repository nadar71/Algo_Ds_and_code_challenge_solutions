
public class LinkedList {
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


