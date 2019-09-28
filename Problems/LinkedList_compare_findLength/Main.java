/*
- Find list Length
- Compare 2 sorted list recursively
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


  // time complexity worst case O(N)
  public void insertSortedNode(int d) { // ascending order
    Node node = new Node(d);
    Node ptr  = head; // cursor pointer

    // no elements in list
    if (head.next == null) { // first node
      head.next = node;            
      length++;
      return;
    }

    // ptr.next != null means : last node
    while (ptr.next != null && greater(node.data, ptr.next.data))
      ptr = ptr.next;

    node.next = ptr.next;
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
  
  
  
  // Compare sorted list recursively : 
  public boolean compareWith(LinkedList list2){
    return compareHelper(this.head, list2.head);
  }
  
  public boolean compareHelper(Node head1,Node head2){
    if (head1.next == null && head2.next == null) return true;
    if ( (head1.next == null && head2.next != null) || 
         (head1.next != null && head2.next == null) ) return false;
       
    if (head1.next.data == head2.next.data) return compareHelper(head1.next,head2.next);
    else return false;
  }
  

  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();

    System.out.println("Find empty list length : "+list.findLength());

    System.out.println("Insert node 1st list");
    list.insertSortedNode(27);
    
    System.out.println("Find 1-element-list length : "+list.findLength());
    list.insertSortedNode(12);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(23);
    list.insertSortedNode(9);

    list.printList();
    
    System.out.println("Find list length : "+list.findLength());
    
    
    
    System.out.println("Compare lists unequals with 2nd empty : ");
    LinkedList list2 = new LinkedList();
    System.out.println("Result : " + list.compareWith(list2));
    
    
    System.out.println("Compare lists equals : ");
    list2.deleteListQuick();
    list2.insertSortedNode(27);
    list2.insertSortedNode(12);
    list2.insertSortedNode(1009);
    list2.insertSortedNode(4);
    list2.insertSortedNode(23);
    list2.insertSortedNode(9);
    System.out.println("Result : " + list.compareWith(list2));
    

    System.out.println("Compare lists unequals for length : ");
    list2.deleteListQuick();
    list2.insertSortedNode(27);
    list2.insertSortedNode(12);
    list2.insertSortedNode(1009);
    list2.insertSortedNode(4);
    list2.insertSortedNode(23);
    list2.insertSortedNode(9);
    list2.insertSortedNode(9999);
    System.out.println("Result : " + list.compareWith(list2));
    
    System.out.println("Compare lists unequals for content : ");
    list2.deleteListQuick();
    list.insertSortedNode(27);
    list2.insertSortedNode(1);
    list2.insertSortedNode(10);
    list2.insertSortedNode(34);
    list2.insertSortedNode(43);
    list2.insertSortedNode(8);
    System.out.println("Result : " + list.compareWith(list2));
    
    System.out.println("Compare lists unequals with 1st empty : ");
    list.deleteListQuick();
    System.out.println("Result : " + list.compareWith(list2));
  
  
  }

}
