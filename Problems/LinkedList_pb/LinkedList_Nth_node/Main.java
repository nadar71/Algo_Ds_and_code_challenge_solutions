/*

- Get the N-th element from start
- Get the N-th element from end : 2 approaches

*/

class LinkedListUtil extends LinkedList{
  
  // find list length . O(n)
  public int findLength(){
    Node ptr  = head;
    int count = 0;
    while (ptr != null) {
      ptr = ptr.next;
      count++;
    }
    
    return count;
  }

  
  // Get N-th element from start :O(N)
  public int getNFromStart(int n){
    Node ptr = head;
    int count = 1;
    while (ptr.next != null && count < n) {
      ptr = ptr.next;
      count++;
    }
    return ptr.data;
  }
  
  
  
  // Get N-th element from end LINEARLY : O(length-(N-1))
  public int getNFromEnd(int n){
    Node ptr = head;
    int count = 1;
    // if list length not known, must use findLength()
    while (ptr.next != null && count < length - (n - 1)) { 
      ptr = ptr.next;
      count++;
    }
    return ptr.data;
  }
  

  
  
  // Get N-th element from end using 2 references starting at different steps : O(length-(N-1))
  public int getNFromEnd_diffSteps(int n){
    Node ptr1 = head;
    Node ptr2 = head;
    int count = 1;
    while (ptr1.next != null ) { 
      ptr1 = ptr1.next;
      if ( count >= n) ptr2 = ptr2.next;
      count++;
    }
    
    return ptr2.data;
  }
  
  
  

  
  
}


public class Main {

  public static void main(String args[]) {
  LinkedListUtil list  = new LinkedListUtil();

    System.out.println("\nInsert node in list");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.append(4);
    list.append(23);
    list.append(9);
    list.append(19);
    list.append(24);
    list.append(39);

    list.printList();
    
    int n = 0;
    System.out.println("\nGet Element at position "+n+" in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("\nGet Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("\n2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));
    
    
    
    n = 5;
    System.out.println("\nGet Element at position "+n+" in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("\nGet Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("\n2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));
    
    
    
    n = list.length;
    System.out.println("\nGet Element at last position in list from start: ");
    System.out.println("Result : " + list.getNFromStart(n));
    
    System.out.println("\nGet Element at last position in list from end: ");
    System.out.println("Result : " + list.getNFromEnd(n));
    
    System.out.println("\n2 steps : Get Element at position "+n+" in list from end: ");
    System.out.println("Result : " + list.getNFromEnd_diffSteps(n));


    
  
  }

}


/*

Insert node in list
27 12 1009 4 23 9 19 24 39  

Get Element at position 0 in list from start: 
Result : 27

Get Element at position 0 in list from end: 
Result : 39

2 steps : Get Element at position 0 in list from end: 
Result : 39

Get Element at position 5 in list from start: 
Result : 23

Get Element at position 5 in list from end: 
Result : 23

2 steps : Get Element at position 5 in list from end: 
Result : 23

Get Element at last position in list from start: 
Result : 39

Get Element at last position in list from end: 
Result : 27

2 steps : Get Element at position 9 in list from end: 
Result : 27

*/