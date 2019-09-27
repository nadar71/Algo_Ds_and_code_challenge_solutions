/*

- Copy sorted list in the same order in another list

- Copy a sorted list reverted in another

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
    head   = new Node();
    length = 0;
  }

  public boolean greater(int v1, int v2) {
    return v1 > v2;
  }
  
  
  public void printList() {
    Node ptr = head.next;
    if (isEmpty()) return;

    while (ptr != null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }
    System.out.println();
  }

  public boolean isEmpty() {
    if (head.next == null || length <=0) {
      System.out.println("The list is empty");
      return true;
    }
    else return false;
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
  
  
  // time complexity O(1)
  public void insertHead(int data){
      Node node = new Node(data);
      node.next = head.next;
      head.next = node;
      length++;
  }
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    length    = 0;    
  }
  
  
  // Copy a sorted list reverted in another
  public LinkedList copyListReverted(){
    Node ptr = head.next;
    LinkedList list2 = new LinkedList();
    
    while(ptr != null){
      list2.insertHead(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }


  // Copy sorted list in the same order in another list
  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();
    LinkedList list2 = new LinkedList();

    System.out.println("Insert node 1st list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.append(4);
    list.append(23);
    list.append(9);

    list.printList();
    
    System.out.println("revert list in  2nd list and print : ");
    list2 = list.copyListReverted();
    list2.printList();
  
  }

}
