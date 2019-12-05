/*
- Find list Length
- Compare 2 sorted list recursively
*/



class LinkedListUtil extends LinkedList{

  // find list length . O(n)
  public int findLength(){
    Node ptr = head;
    int count = 0;
    while (ptr != null) {
      ptr = ptr.next;
      count++;
    }   
    return count;
  }
  
  
  
  // Compare sorted list recursively : 
  public boolean compareWith(LinkedList list2){
    return compareHelper(this.head, list2.head);
  }
  
  public boolean compareHelper(Node head1,Node head2){
    if (head1 == null && head2 == null) return true;
    if ( (head1 == null && head2 != null) || 
         (head1 != null && head2 == null) ) return false;
       
    if (head1.data == head2.data) return compareHelper(head1.next,head2.next);
    else return false;
  }
  

  
  
}


public class Main {

  public static void main(String args[]) {
  LinkedListUtil list  = new LinkedListUtil();

    System.out.println("\nFind empty list length : "+list.findLength());

    System.out.println("\nInsert node 1st list");
    list.insertSortedNode(27);
    
    System.out.println("1-element-list length : "+list.findLength());
    
    System.out.println("\nInsert new items :");
    list.insertSortedNode(12);
    list.insertSortedNode(1009);
    list.insertSortedNode(4);
    list.insertSortedNode(23);
    list.insertSortedNode(9);

    list.printList();
    
    System.out.println("Find list length : "+list.findLength());
    
    
    
    System.out.println("\nCompare lists unequals with 2nd empty : ");
    LinkedList list2 = new LinkedList();
    System.out.println("\nResult : " + list.compareWith(list2));
    
    
    System.out.println("\nInsert in list 2 the same items, and compare lists equals : ");
    list2.deleteList();
    list2.insertSortedNode(27);
    list2.insertSortedNode(12);
    list2.insertSortedNode(1009);
    list2.insertSortedNode(4);
    list2.insertSortedNode(23);
    list2.insertSortedNode(9);
    System.out.println("\nResult : " + list.compareWith(list2));
    

    System.out.println("\nAdd more items in list 2, Compare lists unequals for length : ");
    list2.deleteList();
    list2.insertSortedNode(27);
    list2.insertSortedNode(12);
    list2.insertSortedNode(1009);
    list2.insertSortedNode(4);
    list2.insertSortedNode(23);
    list2.insertSortedNode(9);
    list2.insertSortedNode(9999);
    System.out.println("\nResult : " + list.compareWith(list2));
    
    System.out.println("\nCompare lists unequals for content : ");
    list2.deleteList();
    list.insertSortedNode(27);
    list2.insertSortedNode(1);
    list2.insertSortedNode(10);
    list2.insertSortedNode(34);
    list2.insertSortedNode(43);
    list2.insertSortedNode(8);
    System.out.println("\nResult : " + list.compareWith(list2));
    
    System.out.println("\nCompare lists unequals with 1st empty : ");
    list.deleteList();
    System.out.println("\nResult : " + list.compareWith(list2));
  
  
  }

}

/*

Find empty list length : 0

Insert node 1st list
Find 1-element-list length : 1

 Insert new items :
27 4 9 12 23 1009  
Find list length : 6

Compare lists unequals with 2nd empty : 

Result : false

Insert in list 2 the same items, and compare lists equals : 

Result : true

Add more items in list 2, Compare lists unequals for length : 

Result : false

Compare lists unequals for content : 

Result : false

Compare lists unequals with 1st empty : 

Result : false

*/
