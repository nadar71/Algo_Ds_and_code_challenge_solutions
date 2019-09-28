/*

- Get the N-th element from start
- Get the N-th element from end : 2 approaches

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
  
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    length    = 0;    
  }

  
  
  // find list length . O(n)
  public int findLength(){
    Node ptr = head;
    int count = 0;
    while (ptr.next != null) {
      ptr = ptr.next;
      count++;
    }
    
    return count;
  }
  
  // Get N-th element from start :O(N)
  public int getNFromStart(int n){
    Node ptr = head.next;
    int count = 1;
    while (ptr.next != null && count < n) {
      ptr = ptr.next;
      count++;
    }
    return ptr.data;
  }
  
  
  
  // Get N-th element from end LINEARLY : O(length-(N-1))
  public int getNFromEnd(int n){
    Node ptr = head.next;
    int count = 1;
    // if list length not known, must use findLength()
    while (ptr.next != null && count < length - (n - 1)) { 
      ptr = ptr.next;
      count++;
    }
    return ptr.data;
  }
  

  
  
  // Get N-th element from end using 2 references starting at different steps : O(length-(N-1))
  public int getNFromEnd_diffSteps(int n){
    Node ptr1 = head.next;
    Node ptr2 = head.next;
    int count = 1;
    // if list length not known, must use findLength()
    while (ptr1.next != null && count <= n) { 
      ptr1 = ptr1.next;
      count++;
    }
    
    while (ptr1.next != null && ptr2.next != null) { 
      ptr2 = ptr2.next;
    }
    
    return ptr2.data;
  }
  
  
  

  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();

    System.out.println("Insert node in list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.append(4);
    list.append(23);
    list.append(9);
    list.append(19);
    list.append(24);
    list.append(39);

    list.printList();
    
    int n = 0;
    System.out.println("Get Element at position "+n+" in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));
    
    
    
    n = 5;
    System.out.println("Get Element at position "+n+" in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));
    
    
    
    n = list.length;
    System.out.println("Get Element at last position in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("Get Element at last position in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));


    
  
  }

}
