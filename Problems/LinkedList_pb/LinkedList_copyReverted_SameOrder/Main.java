/*

- Copy sorted list in the same order in another list

- Copy a sorted list reverted in another

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
    if (isEmpty()) return;
    Node ptr = head;
    
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
  
  
  // time complexity O(1)
  public void insertHead(int data){
      Node node = new Node(data);

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
  

  // delete list quick
  public void deleteListQuick() {
    head      = null;
    length    = 0;    
  }
  
  
  // Copy a sorted list reverted in another
  public LinkedList copyListReverted(){
    Node ptr = head;
    LinkedList list2 = new LinkedList();
    
    while(ptr != null){
      list2.insertHead(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }


  // Copy sorted list in the same order in another list
  public LinkedList copySameOrder(){
    Node ptr = head;
    LinkedList list2 = new LinkedList();
    
    while(ptr != null){
      list2.append(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }
  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();
    LinkedList list2 = new LinkedList();

    System.out.println("\nInsert node 1st list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.append(4);
    list.append(23);
    list.append(9);

    list.printList();
    
    System.out.println("\nrevert list in  2nd list and print : ");
    list2 = list.copyListReverted();
    list2.printList();
    // System.out.println("\n2nd list length : "+list2.length);

    System.out.println("\nCopy list in 2nd list IN THE SAME ORDER and print : ");
    list2 = list.copySameOrder();
    list2.printList();
    
  
  }

}
