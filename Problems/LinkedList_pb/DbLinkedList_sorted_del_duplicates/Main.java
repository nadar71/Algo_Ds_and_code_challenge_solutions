/*
- Remove duplicates in a sorted double list
*/

class DoubleLinkedListUtil extends DoubleLinkedList{
  
  // Copy a sorted list reverted in another
  public void removeDuplicates(){
    Node ptr = head;
    
    while(ptr != null){
      if(ptr.next != null){
        
          if (ptr.next == tail && ptr.data == ptr.next.data){
          ptr.next = null;
          tail = ptr;
          return;
        } 

          if( ptr.data == ptr.next.data && ptr.next.next != null ) {
            ptr.next.next.prev = ptr;
            ptr.next = ptr.next.next;
        }         
      }
      ptr = ptr.next;
      
    }
        
  }

  
}


public class Main {

  public static void main(String args[]) {
    DoubleLinkedListUtil list  = new DoubleLinkedListUtil();

    System.out.println("Insert node with sorting");
    list.insertSortedNode(27);
    list.insertSortedNode(27);
    list.insertSortedNode(12);
    list.insertSortedNode(12);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(4);
    list.insertSortedNode(23);
    list.insertSortedNode(9);
    list.insertSortedNode(9);
    list.insertSortedNode(1009);
    list.insertSortedNode(25);
    list.insertSortedNode(31);
    

    list.printList();
    
    System.out.println("Remove duplicates from list : ");
    list.removeDuplicates();
    list.printList();
    
  
  }

}

/*

Insert node with sorting
The list is empty

Insert as head : 27
4 4 9 9 12 12 23 25 27 27 31 1009 1009  
Remove duplicates from list : 
4 9 12 23 25 27 31 1009  
 
*/
