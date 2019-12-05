/*
- Revert a double linked list
*/

class DoubleLinkedListUtil extends DoubleLinkedList{
  
  // Copy a sorted list reverted in another
  public void reverseList(){
    Node ptr = head;
    Node tmp;
    if (ptr == null) return;
    
    
    while(ptr.next != null){
      tmp = ptr.next;
      ptr.next = ptr.prev;
      ptr.prev = tmp;
      ptr = tmp;
    }

    tail = head;
    head = ptr;
    ptr.next = ptr.prev;
    ptr.prev = null;
    
    /* alternative :
    while(ptr != null){
        tmp = ptr.next;
        ptr.next = ptr.prev;
        ptr.prev = tmp;
        if(ptr.prev == null) {
                tail = head;
            head = ptr;
            return;
        }
        ptr = tmp;
      }
    */
        
  }

  
  
}


public class Main {

  public static void main(String args[]) {
    DoubleLinkedListUtil list  = new DoubleLinkedListUtil();

    System.out.println("\nInsert node without sorting");
    
    list.insertSortedNode(27);
    list.insertSortedNode(12);
    list.insertSortedNode(1);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(5);
    list.insertSortedNode(23);
    list.insertSortedNode(9);
    
    list.printList();
    
    System.out.println("\nReverse list : ");
    list.reverseList();
    list.printList();
    
  
  }

}

/*

Insert node without sorting
The list is empty

Insert as head : 27
1 4 5 9 12 23 27 1009  

Reverse list : 
1009 27 23 12 9 5 4 1  
*/
