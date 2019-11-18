/*
Single Linked List with head and tail pointer.
It has not very much sense if I’ve no prev item pointer : how can I insert a node at tail, without making the next point of the last but one element pointing to the new element ?!?

Here the alternative is using an addittional node for tail (and head for simmetry) which a predefind value of -1 : must consider this situation in case I need to count linkedList item number
*/



class Node{
    int data;
    Node next;

    public Node(int d){
      data = d;
      next = null;
    }
  
}



class LinkedList{
    Node head = null; 
    Node tail = null;
    int length;
  
    public LinkedList(){
        length = 0 ;
    }
  
  
    public boolean greater(int v1, int v2){
        return v1 > v2;
    }
  
    public boolean smaller(int v1, int v2){
        return v1 < v2;
    }
  
    public boolean greaterEq(int v1, int v2){
        return v1 >= v2;
    }
  
    public boolean smallerEq(int v1, int v2){
        return v1 <= v2;
    }
  
    // * Like in the single list with head pointer
    public void printList(){
      Node ptr = head;
  
      if (isEmpty()) return;
      
      while( ptr.next != null){
        System.out.println(ptr.next.data);
        ptr = ptr.next;
      }
  
    }  
  
  
    public int size(){
        return length;
    }
  
    public boolean isEmpty(){
      if ( head == null || length <=0 ) {
        System.out.println("The list is empty");
        return true;
      }
      else return false;
    }
  

  
    // O(1) :
    public void insertAtHead(int d){
      Node node = new Node(d);
      if (isEmpty()){
        head = node;
        tail = node;
        length++;
        return;
      }
      node.next = head.next;
      head      = node;
      length++;
    }
    
    
  
    // O(1) :
    public void appendAtTail(int d){
      Node node = new Node(d);
      if (isEmpty()){
        System.out.println("First element...");
        head = node;
        tail = node;
        length++;
        return;
      }
      node.next = tail.next;    
      tail      = node;
      length++;
    }
    

    
    
    public void insertSortedNode(int d) { // ascending order
        Node node = new Node(d);
    
        // no elements in list
        if (head == null && tail == null) { // first node
          head = node;  
          tail = node;
          length++;
          return;
        }

        Node ptr  = head; // cursor pointer
    
        // ptr.next != null means : last node
        while (ptr.next != null && greater(node.data, ptr.next.data))
          ptr = ptr.next;
    
        node.next = ptr.next;
        ptr.next = node;
        length++;

        // inserted last element? update tail pointer
        if (node.next == null) tail = node;
    
      }
    
    
    // time complexity worst case O(N)
    public void deleteNode(int d) {
        if (isEmpty()) return;
        Node ptr = head;

        
        while (ptr.next != null) {
          if (ptr.next.data == d) {       
            ptr.next = ptr.next.next;
    
            // deleted last element? update tail pointer
            if (ptr.next == null) tail = ptr;
    
            length--;
            return;
          }else ptr = ptr.next;     
        }
    
        System.out.println("Element not present in list.");
    }
  
  
    // delete list quick
    public void deleteListQuick() {
      head = null;
      tail = null;
      length = 0;   
    }
    
}




public class Main {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();

    System.out.println("\nInsert node without sorting");
    list.appendAtTail(27);
    list.appendAtTail(12);
    list.appendAtTail(1);
    list.appendAtTail(1009);
    list.appendAtTail(4);
    list.appendAtTail(5);
    list.appendAtTail(23);
    list.appendAtTail(9);

    list.printList();
    
    System.out.println("\nDelete node in unsorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);
    list.printList();
    
    System.out.println("\nClear list.");
    list.deleteListQuick();
    list.printList();
        
    System.out.println("\nInsert node in sorted List");
    list.insertSortedNode(27);
    list.insertSortedNode(12);
    list.insertSortedNode(1);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(5);
    list.insertSortedNode(23);
    list.insertSortedNode(9);
    list.appendAtTail(27);
    list.insertSortedNode(20000);

    list.printList();
    
    System.out.println("\nDelete node in sorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);

    System.out.println("\nDelete LAST node in sorted listed");
    list.deleteNode(2000);


    
    list.printList();
    

  }

}
