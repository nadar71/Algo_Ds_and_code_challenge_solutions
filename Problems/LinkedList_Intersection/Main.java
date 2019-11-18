/*

- intersecting 2 lists
- Detect the intersection

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
  boolean intersectFlag = false;

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
    ptr.next  = node;
    length++;
  }
  
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    length    = 0;    
  }

  
  // Find item : O(length)
  public Node findItem(int n){
    Node ptr = head;
    while(ptr != null){
      if (ptr.data == n) return ptr;
      ptr = ptr.next;
    }
    return null;
  }
  
  
  
  // connect present list to header.next of another list2
  public void connectList(LinkedList list2){
    Node ptr = head;
    
    // get the last node
    while(ptr.next != null){
      ptr = ptr.next;
    }
    
    // connect to list2
    ptr.next = list2.head.next;
  }
  
  
  // check intersection of this list with another
  public Node getIntersection(LinkedList list2){
    // in this case I use length properties; otherwise must use getLength
    int l1 = this.length;
    int l2 = list2.length;
    
    Node ptr  = this.head;
    Node ptr2 = list2.head;
    
    
    if (l1>l2){
      int diff = l1-l2;
      while(diff>0){
        ptr2 = ptr2.next;
        diff--;
      }
    } else if (l1<l2){
      int diff = l2-l1;
      while(diff>0){
        ptr = ptr.next;
        diff--;
      }
    }
    
    while(ptr.next != null && ptr2.next != null){
      if(ptr.next == ptr2.next) {
         intersectFlag = true;
         return ptr.next;
       }
       ptr  = ptr.next;
       ptr2 = ptr2.next;
    }
    intersectFlag = false;
    return null;
  }
  
  
  
 
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();
    LinkedList list2  = new LinkedList();
    
    System.out.println("Create 1st list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.printList();
    
    System.out.println("Create 2nd list");
    list2.append(4);
    list2.append(23);
    list2.append(9);
    list2.append(19);
    list2.append(24);
    list2.append(39);
    list2.printList();
    
    
    System.out.println("Connect the 2 lists");
    list.connectList(list2);
    
    System.out.println("Connect 1st list with 2nd list");
    Node intersection = list.getIntersection(list2);
    if (list.intersectFlag){
       System.out.println("Result : " + list.intersectFlag + " and the node is : " + intersection.data);
       list.printList();
    }
    else
       System.out.println("No intersection found");
 
  
  }

}
