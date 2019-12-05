/*

- Copy sorted list in the same order in another list

- Copy a sorted list reverted in another

*/

class LinkedListUtil extends LinkedList{
  
  // Copy a sorted list reverted in another
  public LinkedList copyListReverted(){
    Node ptr = head;
    LinkedList list2 = new LinkedList();
    
    while(ptr != null){
      list2.insertAtHead(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }


  // Copy sorted list in the same order in another list
  public LinkedList copySameOrder(){
    Node ptr = head;
    LinkedList list2 = new LinkedList();
    
    while(ptr != null){
      list2.append(ptr.data);
      ptr = ptr.next;
    }
    
    return list2;
    
  }
  
  
}


public class Main {

  public static void main(String args[]) {
  LinkedListUtil list  = new LinkedListUtil();
    LinkedList list2 = new LinkedList();

    System.out.println("\nInsert node 1st list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.append(4);
    list.append(23);
    list.append(9);

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
27 12 1009 4 23 9  

revert list in  2nd list and print : 
9 23 4 1009 12 27  

Copy list in 2nd list IN THE SAME ORDER and print : 
27 12 1009 4 23 9  
*/
