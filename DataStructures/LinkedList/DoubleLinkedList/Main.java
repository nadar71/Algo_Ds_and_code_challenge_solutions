class Node{
    int data;
    Node next, prev;
    int length;

    public Node(int d){
      data = d;
      next = null;
      prev = null;
      length = 0;
    }
  
}


class DoubleLinkedList{
      Node head ; 
      Node tail ;
      int length;
    
      public DoubleLinkedList(){
          head = new Node(-1);
          tail = new Node(-1);
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
        if ( head.next == null || length <=0 ) {
          System.out.println("The list is empty");
          return true;
        }
        else return false;
      }
      
      
      
      
      // O(1) :
      public void appendAtHead(int d){
        Node start = new Node(d);
        if (isEmpty()){
          head.next = start;
          tail.next = start;
          length++;
          return;
        }
        start.next = head.next;
        head.next  = start;
        length++;
      }
      
      
      
      // O(1) :
      public void appendAtTail(int d){
        Node end = new Node(d);
        if (isEmpty()){
          System.out.println("First element...");
          head.next = end;
          tail.next = end;
          length++;
          return;
        }
        tail.next.next = end;    // tail.next  it's the current last node
        tail.next  = end;
        length++;
      }
      
      
      

     
      // O(N)
      public void insertSortedNode(int d) { // ascending order
        Node node = new Node(d);
        Node ptr  = head; // cursor pointer
    
        // no elements in list
        if (head.next == null && tail.next == null) { // first node
          head.next = node;  
          tail.next = node;
          length++;
          return;
        }
    
        // ptr.next != null means : last node
        while (ptr.next != null && greater(node.data, ptr.next.data))
          ptr = ptr.next;
    
        node.next = ptr.next;
        node.prev = ptr;
        ptr.next = node;
        length++;
    
      }
  
  
  
  
  
      // time complexity worst case O(N)
      // but can be set to O(1) in case of sorted list and node to be deleted at the start/end of list
      public void deleteNode(int d){
        Node ptr = head;
        while(ptr.next.next != null && ptr.next.data != d){  // next.next to avoid to loose the last node
          ptr = ptr.next;
        }
        
      
        if (ptr.next.next == null){ // reach the last node
          if (ptr.data == d) {      
            ptr.next.prev = null; // to avoid null reference in node deleted by gc
            tail.next = ptr;
            ptr.next  = null;  // become the new tail list point
            length--;
          }else System.out.println("node not present in list");    
        } else{
          ptr.next.prev = null;
          ptr.next      = ptr.next.next; 
          length--;
        }
      }
    
    
      // delete list quick
      public void deleteListQuick() {
        head.next = null;
        tail.next = null;
        length = 0;   
      }


}




public class Main {

  public static void main(String args[]) {
    DoubleLinkedList list = new DoubleLinkedList();

    System.out.println("Insert node without sorting");
    list.appendAtTail(27);
    list.appendAtTail(12);
    list.appendAtTail(1);
    list.appendAtHead(110);
    list.appendAtTail(1009);
    list.appendAtTail(4);
    list.appendAtTail(5);
    list.appendAtHead(36);
    list.appendAtTail(23);
    list.appendAtTail(9);
    list.appendAtHead(111);


    list.printList();
    
    System.out.println("Delete node in unsorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);
    list.printList();
    
    System.out.println("Clear list.");
    list.deleteListQuick();
    list.printList();
        
    System.out.println("Insert node in sorted List");
    list.insertSortedNode(27);
    list.insertSortedNode(12);
    list.insertSortedNode(1);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(5);
    list.insertSortedNode(23);
    list.insertSortedNode(9);
    list.appendAtTail(27);

    list.printList();
    
    System.out.println("Delete node in sorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);
    
    list.printList();
    

  }

}
