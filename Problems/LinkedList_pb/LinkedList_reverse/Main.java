/*
Reverse list iteratively and recursively
*/

class Node {
  int data;
  Node next;

/*
  public Node() {
    data = -1;
    next = null;
  }
  */
  
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

  


  // delete list quick
  public void deleteListQuick() {
    head = null;
    length = 0;   
  }
  
  // invert linked list LINEARLY
  // header --> a --> b --> c --> null
  public void reverseList(){
    Node curr = head;
    Node prev = null;
    Node next = null;
    
    while(curr != null){
      next = curr.next; // store the next item to invert
      curr.next = prev; // the curr.next will previous : null, a, b 
      prev = curr;      // the next previous will be the present current
      curr = next;      // the current will the stored next
    }
    
    head = prev;
  }
  
  // invert linked list RECURSIVELY
  public void reverseListRec(){
    head = reverseUtil(head, null);
  }
  
  public Node reverseUtil(Node curr, Node next){
    Node prev;
    if (curr == null) return curr;
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
    
    System.out.println("\nReverse list : ");
    list.reverseList();
    list.printList();
    
    
    System.out.println("\nRecursively Reverse list : ");
    list.reverseListRec();
    list.printList();
    
    
  }

}
