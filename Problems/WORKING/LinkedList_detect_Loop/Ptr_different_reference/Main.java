/*

- Create loop in a list
- Detect the loop : spfp or reversing list
- Print list with loop
- Detect loop type
- Remove loop

Use a tail pointer for pointing to last item, a function findNode 
and another for creating a loop on a choosen data/node

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
  Node tail; // pointing to last item in list
  int length;
  Node loopNode;

  public LinkedList() {
    head   = new Node();
    tail   = new Node();
    loopNode = null;
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
  // ** Modified version with tail : every append tail must be updated
  public void append(int d) {
    Node node = new Node(d);
    Node ptr = head; // cursor pointer

    // empty list, first node
    if (head.next == null) {
      head.next = node;
      tail.next = node;
      length++;
      return;
    }

    while (ptr.next != null)
      ptr = ptr.next;
    ptr.next  = node;
    tail.next = node;
    length++;
  }
  
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    tail.next = null;
    loopNode  = null;
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
  
  
  // Get last item : O(1)
  public Node getLastItem(){
    return tail.next;
  }
  
  
  // Create loop on a specific node
  public void createLoop(int start){
    if (tail.next == null ) {
      System.out.println("Empty list");
    }
    Node found = findItem(start);
    if (found != null) tail.next.next = found;
    else System.out.println("Element not found");
  }
  
  
  // Detect loop using 2 reference :
  public boolean isLoop(){
    Node ptr      = head;
    Node ptr_fast = head;
    
    while (ptr.next != null && ptr_fast.next.next != null){
      ptr      = ptr.next;
      ptr_fast = ptr_fast.next.next;
      if (ptr.next == ptr_fast.next) {
        loopNode = ptr.next;
        return true;
      }
    }
    loopNode = null;
    return false;
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
  
  // Detect loop using list inversion :
  public boolean isLoop_reverting(){
    Node prev_head = head;
    this.reverseList();
    if (prev_head == head) {
      this.reverseList();
      return true;
    }
    else {
      this.reverseList();
      return false;
    }
    
  }
  
  
  
  // check the kind of loop
  public void checkLoopType(){
    this.isLoop();
    
    if (loopNode !=null && loopNode == head.next) 
       System.out.println("Circular List");
    else if (loopNode !=null)
        System.out.println("Normal loop in linear List");
  }
  
  
  // remove loop: in my case I have tail.next which point to the loop node
  // so I can break the loop setting :
  // if tail.next.next  point not to head : tail.next.next = null
  // if tail.next.next  point to head : must find the the item pointing to tail.next node
  //                                    and then make its next reference pointing to null
  //                                    and tail.next poit to this node.
  // NB : the head has data = -1 by convention, other ways can be found of course!
  // otherwise
  // I must search for the loop point modifiying isLoop() and getting the 
  // reference to the loop node for both cases
  public void removeLoop(){
    if (tail.next.next != null) {
       if (tail.next.next.data == -1) {
         Node ptr = head;
         while(ptr.next.next.data != -1){
           ptr = ptr.next;
         }
         tail.next = ptr.next;
         ptr.next.next = null;
       }
       else tail.next.next = null;
    }
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
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_reverting());
    
    
    System.out.println("Get the last item : " + (list.getLastItem()).data);
     
    System.out.println("\nMake a loop at element 23 : ");
    list.createLoop(23);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_reverting());
    if (list.loopNode != null )  {
      System.out.println("The loop is at item : " + list.loopNode.data);
      System.out.println("Loop type : ");
      list.checkLoopType();
    }
    
    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_reverting());
    
    
    System.out.println("\nRecreate list without loop");
    list.deleteListQuick();
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
    
    System.out.println("Set loop as circular list");
    list.createLoop(-1);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    if (list.loopNode != null )  {
      System.out.println("The loop is at item : " + list.loopNode.data);
      System.out.println("Loop type : ");
      list.checkLoopType();
    }
    
    
    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_reverting());
    
    
    
  
  }

}
