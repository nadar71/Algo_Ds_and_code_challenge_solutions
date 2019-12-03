/*
Remove duplicates from sorted LinkedList
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
  Node head = null;
  int length;

  public LinkedList() {
    length = 0;
  }

  public boolean greater(int v1, int v2) {
    return v1 > v2;
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

  public boolean isEmpty() {
    if (head == null || length <=0) {
      System.out.println("The list is empty");
      return true;
    }
    else return false;
  }


  // time complexity worst case O(N)
  public void insertSortedNode(int d) { // ascending order
    Node node = new Node(d);

    // no elements in list
    if (head == null) { 
      head = node;            
      length++;
      return;
    }

    Node ptr  = head; 


    // ptr.next != null means : last node
    while (ptr.next != null && greater(node.data, ptr.next.data))
      ptr = ptr.next;

    node.next = ptr.next;
    ptr.next = node;
    length++;

  }

  


  // delete list quick
  public void deleteListQuick() {
    head = null;
    length    = 0;    
  }
  
  
  // delete duplicates in a sorted list
  public void removeDuplicates(){
    Node ptr = head;
    
    while(ptr.next != null){
      if (ptr.next.data == ptr.data) ptr.next = ptr.next.next;
      if (ptr.next != null) ptr = ptr.next;
    }
    
    /* or
    while(ptr != null){
      if (ptr.next != null && ptr.next.data == ptr.data) 
        ptr.next = ptr.next.next;
      else
        ptr = ptr.next;
    }
    */
  }
  
  
  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();

    System.out.println("Insert node with sorting");
    list.insertSortedNode(27);
    list.insertSortedNode(27);
    list.insertSortedNode(12);
    list.insertSortedNode(12);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(4);
    list.insertSortedNode(23);
    list.insertSortedNode(9);
    list.insertSortedNode(9);
    list.insertSortedNode(1009);

    list.printList();
    
    System.out.println("Remove duplicates from list : ");
    list.removeDuplicates();
    list.printList();
  
  }

}
