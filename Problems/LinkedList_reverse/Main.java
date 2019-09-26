/*
Reverse list iteratively and recursively
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
    Node ptr = head;
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
    length = 0;   
  }
  
  // invert linked list
  public void reverseList(){
    Node curr = head;
    Node prev = null;
    Node next = null;
    
    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    
    head = prev;
  }
  
  // invert linked list RECURSIVELY
  public void reverseListRec(){
    head = reverseUtil(head, null);
  }
  
  public Node reverseUtil(Node curr, Node next){
    Node prev;
    if (curr == null) return null;
    if (curr.next == null) {
      curr.next = next;
      return curr;
    }
    
    prev = reverseUtil(curr.next, curr);
    curr.next = next;
    return prev;
    
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
    
    System.out.println("Reverse list : ");
    list.reverseList();
    list.printList();
    
    
    System.out.println("Recursively Reverse list : ");
    list.reverseListRec();
    list.printList();
    
    
  }

}
