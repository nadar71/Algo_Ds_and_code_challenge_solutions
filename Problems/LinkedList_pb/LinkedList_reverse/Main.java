/*
Reverse list iteratively and recursively
*/


  
class LinkedListUtil extends LinkedList{

  // invert linked list LINEARLY
  // header --> a --> b --> c --> null
  public void reverseList(){
    Node curr = head;
    Node prev = null;
    Node next = null;
    
    while(curr != null){
      next = curr.next; // store the next item to be inverted

      curr.next = prev; // the curr.next will be the previous : null, a, b 
      prev = curr;      // the next previous will be the present current
      curr = next;      // the current will be the stored next
      
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
    LinkedListUtil list = new LinkedListUtil();

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

/*
Insert node without sorting
27 12 1 1009 4 5 23 9  

Reverse list : 
9 23 5 4 1009 1 12 27  

Recursively Reverse list : 
27 12 1 1009 4 5 23 9 
*/