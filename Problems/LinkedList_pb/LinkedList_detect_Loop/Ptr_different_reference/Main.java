package LinkedList;

/*

- Create on purposely a loop in a list using a tail pointer
- Detect the loop : slow pointer - fast pointer or reversing list
- Print list with loop
- Detect loop type
- Remove loop

Use a tail pointer for pointing to last item and a function findNode 
to create a loop on a choosen data/node and then test the find loop 
and remove loop algorithm

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
  Node tail = null; // pointing to last item in list
  int length;
  Node nodeInLoop;

  public LinkedList() {
    nodeInLoop = null;
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
  // ** Modified version with tail : every append tail must be updated
  public void append(int d) {
    Node node = new Node(d);

    // empty list, first node
    if (head == null) {
      head = node;
      tail = node;
      length++;
      return;
    }

    Node ptr = head; // cursor pointer    

    while (ptr.next != null)
      ptr = ptr.next;
      
    ptr.next  = node;
    tail      = node;
    length++;
  }
  
  

  // delete list quick
  public void deleteListQuick() {
    head        = null;
    tail        = null;
    nodeInLoop  = null;
    length      = 0;    
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
    return tail;
  }
  
  
  // Create loop on a specific node
  public void createLoop(int start){
    if (tail == null ) System.out.println("Empty list");
    
    Node found = findItem(start);
    if (found != null) {
      tail.next = found;
      // System.out.println("ELEMENTO prim del loop : "+tail.data);
    }
    else System.out.println("Element not found");
  }
  
  
  // Detect loop using 2 reference. 
  // if there is a loop, they somewhere point the same node 
  // inside the loop or at head if it's a circular list
  public boolean isLoop(){
    Node ptr,ptr_fast;
    ptr = ptr_fast = head;
    
    while (ptr != null && ptr_fast != null && ptr_fast.next != null){         
        ptr = ptr.next;
        ptr_fast = ptr_fast.next.next;
      if ( ptr == ptr_fast ) return true;        
    }
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
  public boolean isLoop_byReverting(){
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
  public int checkLoopType(){
    Node ptr, ptr_fast;
    ptr =  ptr_fast = head;


    while (ptr != null && ptr_fast != null && ptr_fast.next != null){

      if ( ptr.next == head || ptr_fast.next.next == head){
        nodeInLoop = ptr;
        System.out.println("Circular List.");
        return 1;
      }
      ptr      = ptr.next;
      ptr_fast = ptr_fast.next.next;
      
      if ( ptr == ptr_fast){
        nodeInLoop = ptr;
        System.out.println("Generic loop in linear List.");
        return 2;
      }     

    }

    System.out.println("No loop found.");
    return 0;
  }
  
  
  /*
  If loop point is at head, circular list, must get the node before it, and put its next=null
  If  "     "   is generic, must use a 2nd ptr to nodeInLoop: it mets with ptr=head at loop point (!!!)
  
  About type 2, how to find the loopPoint :
  - isLoop() and  checkLoopType() use the slow pointer/fast pointer strategy
  - given k nodes before loops, and LOOP_SIZE the loop dimension
  - when slow ptr go through k nodes, the fast ptr has at 2k node (i.e. it's k nodes inside the loop)
  - so the 2 ptr are at distance LOOP_SIZE-k
  - because they move each of them of 1 step, they keep the distance LOOP_SIZE-k costant 
  - when they met inside the loop they are at the same distance, so they are at k nodes from the loop point
  - add another ptr starting from head, and move them and 1 of the remainders (slow of fast) until they meet
  - where they meet is the loop point   
  */
  public void removeLoop(){
    int type = checkLoopType();
    Node ptr = head;
    if (type == 1){ // node loop at head
       while(ptr.next != head){
          ptr = ptr.next;
       }
       ptr.next = null;

    }else if(type == 2){
       Node ptr_02 = nodeInLoop;
       while(ptr.next != ptr_02.next){
          ptr = ptr.next;
          ptr_02 = ptr_02.next;
       }
       ptr_02.next = null;

    } else return;
  }

 
  /*
  Get loop point :  explanation the same as for removeLoop()
  */
  public Node getLoopPoint(){
    int type = checkLoopType();
    Node ptr = head;
    if (type == 1){ // node loop at head
       while(ptr.next != head){
          ptr = ptr.next;
       }
       return ptr.next;

    }else if(type == 2){
       Node ptr_02 = nodeInLoop;
       while(ptr.next != ptr_02.next){
          ptr = ptr.next;
          ptr_02 = ptr_02.next;
       }
       return ptr_02.next;

    } else return null;
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
    System.out.println("Result by reverting list : " + list.isLoop_byReverting());
    
    
    System.out.println("Get the last item : " + (list.getLastItem()).data);

    System.out.println("\nMake a loop at element 9 : ");
    list.createLoop(9);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_byReverting());

    if (list.isLoop() == true )  {
      System.out.println("The loop is at item : " + list.getLoopPoint().data);
      System.out.println("DEBUG loop is at item : " + list.tail.next.data);

      System.out.println("Loop type : "+list.checkLoopType());
    }

    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_byReverting());
    
    
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
    list.createLoop(27);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    if (list.isLoop()  == true  )  {
      System.out.println("The loop is at item : " + list.getLoopPoint().data);
      System.out.println("DEBUG loop is at item : " + list.tail.next.data);
      System.out.println("Loop type : ");
      list.checkLoopType();
    }
    
    
    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    System.out.println("Result by reverting list : " + list.isLoop_byReverting());
    
  
  }

}

/*
Insert node in list
27
12
1009
4
23
9
19
24
39

Check if there is a loop.
Result : false
Result by reverting list : false
Get the last item : 39

Make a loop at element 9 : 
Check if there is a loop.
Result : true
Result by reverting list : true
Generic loop in linear List.
The loop is at item : 9
DEBUG loop is at item : 9
Generic loop in linear List.
Loop type : 2

Now remove the loop
Generic loop in linear List.
Check if there is a loop.
Result : false
Result by reverting list : false

Recreate list without loop
27
12
1009
4
23
9
19
24
39

Set loop as circular list
Check if there is a loop.
Result : true
Circular List.
The loop is at item : 27
DEBUG loop is at item : 27
Loop type : 
Circular List.

Now remove the loop
Circular List.
Check if there is a loop.
Result : false
Result by reverting list : false

*/