import java.util.ArrayList;
import java.util.HashSet;

class Node {
	int data;
	Node next;
	int length;

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
		Node end = new Node(d);
		Node ptr = head;
		// empty list, first node
		if (head == null) {
			ptr = end;
			length++;
			return;
		}

		while (ptr.next != null)
			ptr = ptr.next;

		ptr.next = end;
		length++;
	}

	// delete list
	public void deleteNode(int d) {
		Node ptr = head;
		if (ptr == null) {
			System.out.println("The list is empty");
			return;
		}

		while (ptr.next != null) {
			if (ptr.next.data == d) {
				ptr.next = ptr.next.next;
				length--;
			} else
				ptr = ptr.next;
		}
	}

	// delete list
	public void deleteList() {
		Node ptr = head;
		if (ptr == null) {
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
	public void insertSortedNode(int d) {
		Node n = new Node(d);
		Node ptr = head;

		// ptr.next != null means : last node
		while (ptr.next != null && greater(n.data, ptr.next.data))
			ptr = ptr.next;

		// no elements in list
		if (ptr.next == null) { // first node
			n.next = null; // unnecessary, all node are init with next = null,put for clarity
			ptr.next = n;
			length++;
		} else {
			n.next = ptr.next;
			ptr.next = n;
			length++;
		}

	}

	





	public void deleteDups() {
		Node ptr = head;
		HashSet<Integer> set = new HashSet<>();
		while (ptr.next != null) {
			if (set.contains(ptr.next.data)) {
				ptr.next = ptr.next.next;
			} else {
				set.add(ptr.next.data);
			}
			ptr = ptr.next;
			if (ptr == null)
				break;
		}
	}



	

}

public class Main {

	public static void main(String args[]) {
		LinkedList list = new LinkedList();

		System.out.println("Insert node without sorting");
		list.append(27);
		list.append(12);
		list.append(1);
		list.append(27);
		list.append(4);
		list.append(1);
		list.append(23);
		list.append(9);
		list.append(27);

		list.printList();

		list.deleteDups();
		System.out.println("\nDuplicates Deleted");
		list.printList();

	}

}
