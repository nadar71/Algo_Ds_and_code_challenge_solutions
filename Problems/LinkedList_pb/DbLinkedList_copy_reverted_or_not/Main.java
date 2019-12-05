/*
- Copy sorted double list in the same order in another list
- Copy a sorted double list reverted in another
*/

class DoubleLinkedListUtil extends DoubleLinkedList{
  
  // Copy a sorted list reverted in another
  public DoubleLinkedList copyListReverted(){
    Node ptr = head;
    DoubleLinkedList list2 = new DoubleLinkedList();
    
    while(ptr != null){
    	list2.appendAtHead(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }


  // Copy sorted list in the same order in another list
  public DoubleLinkedList copySameOrder(){
    Node ptr = head;
    DoubleLinkedList list2 = new DoubleLinkedList();
    
    while(ptr != null){
      list2.appendAtTail(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }
  
  
}


public class Main {

  public static void main(String args[]) {
    DoubleLinkedListUtil list  = new DoubleLinkedListUtil();
    DoubleLinkedList list2 = new DoubleLinkedList();

    System.out.println("\nInsert node 1st list");
    list.appendAtTail(27);
    list.appendAtTail(12);
    list.appendAtTail(1009);
    list.appendAtTail(4);
    list.appendAtTail(23);
    list.appendAtTail(9);

    list.printList();
    
    System.out.println("\nrevert list in  2nd list and print : ");
    list2 = list.copyListReverted();
    list2.printList();
    // System.out.println("\n2nd list length : "+list2.length);

    System.out.println("\nCopy list in 2nd list IN THE SAME ORDER and print : ");
    list2 = list.copySameOrder();
    list2.printList();
    
  
  }

}

/*

Insert node 1st list
The list is empty
First element...
27 12 1009 4 23 9  

revert list in  2nd list and print : 
The list is empty
9 23 4 1009 12 27  

Copy list in 2nd list IN THE SAME ORDER and print : 
The list is empty
First element...
27 12 1009 4 23 9 
*/
