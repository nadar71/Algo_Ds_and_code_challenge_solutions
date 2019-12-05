class Node {
  int data;
  Node next, prev;
  int length;

  public Node(int d) {
    data = d;
    next = null;
    prev = null;
  }

}

class DoubleLinkedList {
  Node head;
  Node tail;
  int length;

  public DoubleLinkedList() {
    head = null;
    tail = null;
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
    if (head == null || length <= 0) {
      System.out.println("The list is empty");
      return true;
    } else
      return false;
  }

  // O(1) :
  public void appendAtHead(int d) {
    Node node = new Node(d);
    if (isEmpty()) {
      head = node;
      tail = node;
      length++;
      return;
    }
    node.next = head;
    head = node;
    length++;
  }

  // O(1) :
  public void appendAtTail(int d) {
    Node node = new Node(d);
    if (isEmpty()) {
      System.out.println("First element...");
      head = node;
      tail = node;
      length++;
      return;
    }
    tail.next = node; // tail.next it's the current last node
    node.prev = tail;
    tail = node;
    length++;
  }

  // O(N)
  public void insertSortedNode(int d) { // ascending order
    Node node = new Node(d);

    // insert as head, no elements in list
    if (isEmpty()) { // first node
      System.out.println("\nInsert as head : " + node.data);
      head = node;
      tail = node;
      length++;
      return;
    }

    // insert before head
    if (node.data < head.data) {
      node.next = head;
      head = node;
      length++;
      return;
    }

    Node ptr = head;

    while (ptr.next != null && node.data > ptr.next.data) {
      ptr = ptr.next;
    }

    // insert at tail
    if (ptr.next == null) {
      ptr.next = node;
      node.prev = ptr;
      tail = node;
      length++;
    } else { // insert a generic position
      /* it's ok, but give problem with reversing the list!
      node.next = ptr.next;
      node.prev = ptr.next.prev;
      ptr.next.prev = node;
      ptr.next = node;
      */
      node.next = ptr.next;
      node.prev = ptr;
      ptr.next = node;
      node.next.prev = node;

    }

  }

  // time complexity worst case O(N)
  // O(1) in case of node to be deleted at the start/end of list
  public void deleteNode(int d) {
    Node ptr = head;

    // delete at start
    if (d == head.data) {
      head = head.next;
      return;
    }

    // delete at end
    if (d == tail.data) {
      Node prev = tail.prev;
      prev.next = null;
      tail = prev;
      return;
    }

    // delete inside list
    while (ptr.next != null && ptr.next.data != d) { 
      ptr = ptr.next;
    }

    if (ptr.next == null) { 
      System.out.println("node not present in list");
    } else {
      ptr.next.next.prev = ptr.next.prev;
      ptr.next = ptr.next.next;
      length--;
      return;
    }

  }

  // delete list 
  public void deleteList() {
    head = null;
    tail = null;
    length = 0;
  }

}

public class Main {

  public static void main(String args[]) {
    DoubleLinkedList list = new DoubleLinkedList();

    System.out.println("Insert node without sorting");
    list.appendAtTail(27);
    list.appendAtTail(12);
    list.appendAtTail(1);
    list.appendAtHead(110);
    list.appendAtTail(1009);
    list.appendAtTail(4);
    list.appendAtTail(5);
    list.appendAtHead(36);
    list.appendAtTail(23);
    list.appendAtTail(9);
    list.appendAtHead(111);

    list.printList();

    System.out.println("\nDelete node in unsorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);
    list.printList();

    System.out.println("\nDelete first node");
    list.deleteNode(111);
    list.printList();

    System.out.println("\nDelete second node");
    list.deleteNode(110);
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
    list.appendAtTail(27);

    list.printList();

    System.out.println("\nDelete node in sorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);

    list.printList();

  }

}

/*
 Insert node without sorting The list is empty First element... 111 36 110 27
 12 1 1009 4 5 23 9
 
 Delete node in unsorted listed 111 36 110 27 12 4 23 9
 
 Delete first node 36 110 27 12 4 23 9
 
 Delete second node 36 27 12 4 23 9
 
 Delete last node 36 27 12 4 23
 
 Delete node not present node not present in list
 
 Clear list. The list is empty
 
 Insert node in sorted List The list is empty
 
 Insert as head : 27 1 4 5 9 12 23 27 1009 27
 
 Delete node in sorted listed 4 9 12 23 27 27
 */
