/*

- intersecting 2 lists
- Detect the intersection

*/

class Node {
  int data;
  Node next;

  public Node() {
    data = -1;
    next = null;
  }
  
  public Node(int d) {
    data = d;
    next = null;
  }

}



class LinkedList {
  Node head;
  int length;
  boolean intersectFlag = false;

  public LinkedList() {
    head   = new Node();
    length = 0;
  }

  
  public void printList() {
    Node ptr = head.next;
    if (isEmpty()) return;

    while (ptr != null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }
    System.out.println();
  }

  public boolean isEmpty() {
    if (head.next == null || length <=0) {
      System.out.println("The list is empty");
      return true;
    }
    else return false;
  }


  // time complexity O(n)
  public void append(int d) {
    Node node = new Node(d);
    Node ptr = head; // cursor pointer

    // empty list, first node
    if (head.next == null) {
      head.next = node;
      length++;
      return;
    }

    while (ptr.next != null)
      ptr = ptr.next;
    ptr.next  = node;
    length++;
  }
  
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    length    = 0;    
  }

  
  // Find item : O(length)
  public Node findItem(int n){
    Node ptr = head;
    while(ptr != null){
      if (ptr.data == n) return ptr;
      ptr = ptr.next;
    }
    return null;
  }
  
  
  
  // connect present list to header.next of another list2
  public void connectList(LinkedList list2){
    Node ptr = head;
    
    // get the last node
    while(ptr.next != null){
      ptr = ptr.next;
    }
    
    // connect to list2
    ptr.next = list2.head.next;
  }
  
  
  /*
  // check intersection of this list with another
  public Node getIntersection(LinkedList list2){
    // in this case I use length properties; otherwise must use getLength
    int l1 = this.length;
    int l2 = list2.length;
    
    Node ptr  = this.head;
    Node ptr2 = list2.head;
    
    
    if (l1>l2){
      int diff = l1-l2;
      while(diff>0){
        ptr2 = ptr2.next;
        diff--;
      }
      System.out.println("l1>l2 : Debug : node at which they at same distance : "+ptr2.data);
    } else if (l1<l2){
      int diff = l2-l1;
      while(diff>0){
        ptr = ptr.next;
        diff--;
      }
      System.out.println("l1<l2 : Debug : node at which they at same distance : "+ptr.data);
    }
    
    while(ptr != null && ptr2 != null){
      if(ptr == ptr2) {
         intersectFlag = true;
         return ptr;
       }
       ptr  = ptr.next;
       ptr2 = ptr2.next;
    }
    intersectFlag = false;
    return null;
  }
  */
  
  
  
  // check intersection of this list with another
  public Node getIntersection(LinkedList list2){
      int l1 = this.length;
      int l2 = list2.length;
      int diff = 0;
      Node ptr1 = this.head;
      Node ptr2 = list2.head;
      
      if (l1 < l2){
          Node tmp = ptr1;
          ptr1      = ptr2;
          ptr2     = tmp;
          diff = l2 -l1;
      } else diff = l1 -l2;
      
      while(diff > 0) {
          ptr1 = ptr1.next;
          diff--;
      }
      
      while( ptr1 != ptr2){
          ptr1 = ptr1.next;
          ptr2 = ptr2.next;
      }
      
      if (ptr1 != null ) intersectFlag = true;
      
      return ptr1;
  }
  
  
 
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();
    LinkedList list2  = new LinkedList();
    LinkedList list3  = new LinkedList();
    
    System.out.println("Create 1st list different part");
    list.append(27);
    list.append(12);
    list.append(1009);
    list.printList();
    
    System.out.println("Create 2nd list different part");
    list2.append(4);
    list2.append(23);
    list2.append(9);
    list2.append(19);
    list2.append(24);
    list2.append(39);
    list2.printList();
    
    
    
    System.out.println("Create 3rd list, common part of the 2 lists");
    list3.append(100);
    list3.append(230);
    list3.append(900);
    list3.append(1900);
    list3.append(2400);
    list3.append(3900);
    list3.printList();
    
    
    System.out.println("Connect the 1+3 lists");
    list.connectList(list3);
    list.printList();
    
    
    System.out.println("Connect the 2+3 lists");
    list2.connectList(list3);
    list2.printList();
    
    System.out.println("Check fo intersection bewtween list 1 and 2");
    Node intersection = list.getIntersection(list2);
    if (list.intersectFlag){
       System.out.println("Result : " + list.intersectFlag + " and the node is : " + intersection.data);
       list.printList();
    }
    else
       System.out.println("No intersection found");
 
  
  }

}

/*
Create 1st list different part
27
12
1009

Create 2nd list different part
4
23
9
19
24
39

Create 3rd list, common part of the 2 lists
100
230
900
1900
2400
3900

Connect the 1+3 lists
27
12
1009
100
230
900
1900
2400
3900

Connect the 2+3 lists
4
23
9
19
24
39
100
230
900
1900
2400
3900

Check fo intersection bewtween list 1 and 2
Result : true and the node is : 100
27
12
1009
100
230
900
1900
2400
3900




*/
