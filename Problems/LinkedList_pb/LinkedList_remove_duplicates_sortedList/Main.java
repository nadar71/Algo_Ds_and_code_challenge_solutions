/*
Remove duplicates from sorted LinkedList
*/

class LinkedListUtil extends LinkedList{
  
  // delete duplicates in a sorted list
  public void removeDuplicates(){
    Node ptr = head;
    
    while(ptr.next != null){
      if (ptr.next.data == ptr.data) ptr.next = ptr.next.next;
      if (ptr.next != null) ptr = ptr.next;
    }
    
    /* or
    while(ptr != null){
      if (ptr.next != null && ptr.next.data == ptr.data) 
        ptr.next = ptr.next.next;
      else
        ptr = ptr.next;
    }
    */
  }
  
  
  
  
}


public class Main {

  public static void main(String args[]) {
    LinkedListUtil list = new LinkedListUtil();

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

    list.printList();
    
    System.out.println("Remove duplicates from list : ");
    list.removeDuplicates();
    list.printList();
  
  }

}

/*
Insert node with sorting
27 4 4 9 9 12 12 23 27 1009 1009  
Remove duplicates from list : 
27 4 9 12 23 27 1009 
*/
