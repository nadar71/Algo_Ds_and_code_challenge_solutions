/*
Single Linked List with head and tail pointer
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
    Node head ; 
    Node tail ;
    int length;
  
    public LinkedList(){
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
    public void appendHead(int d){
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
    public void appendTail(int d){
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
        ptr.next = node;
        length++;
    
      }
    
    
    // time complexity worst case O(N)
    public void deleteNode(int d) {
        Node ptr = head;
        if (isEmpty()) return;
        
        while (ptr.next != null) {
          if (ptr.next.data == d) {       
            ptr.next = ptr.next.next;
    
            // deleted last element? update tail pointer
            if (ptr.next == null) tail.next = ptr;
    
            length--;
            return;
          }else ptr = ptr.next;     
        }
    
        System.out.println("Element not present in list.");
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
    LinkedList list = new LinkedList();

    System.out.println("Insert node without sorting");
    list.appendTail(27);
    list.appendTail(12);
    list.appendTail(1);
    list.appendTail(1009);
    list.appendTail(4);
    list.appendTail(5);
    list.appendTail(23);
    list.appendTail(9);

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
    list.appendTail(27);

    list.printList();
    
    System.out.println("Delete node in sorted listed");
    list.deleteNode(1009);
    list.deleteNode(1);
    list.deleteNode(5);
    
    list.printList();
    

  }

}
