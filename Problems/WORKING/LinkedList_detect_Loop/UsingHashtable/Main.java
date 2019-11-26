/*
NOT WORKING AT THE MOMENT!
- Create loop in a list
- Detect the loop : using hashtable
- Print list with loop
- Detect loop type
- Remove loop

Use a tail pointer for pointing to last item, a function findNode 
and another for creating a loop on a choosen data/node

*/


// -----------------------------------------------------------------------------
//                        LINKED LIST NODE
// -----------------------------------------------------------------------------
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

// -----------------------------------------------------------------------------
//                                HASHTABLE
// -----------------------------------------------------------------------------
class HashTable{
  public int tableSize;

  public HashNode[] list;


  public HashTable(){
     tableSize = 512;
     list      = new HashNode[tableSize];
  }



    class HashNode{
      Node key;
      int data;
      HashNode next;

      public HashNode(Node key, int data, HashNode next){
        this.key  = key;
        this.data = data;
        this.next = next;
      }
    }


  public boolean isEqual(Node a, Node b){
    return a == b;
  }



  // Get the hash code for the key. To keep things simple, here is a dummy hash function : 
  // it get the key, then simply return the key.
  // If as example the entry key was a phone number associated to employee
  // I can use the last 3 number as hashcode, and then hashtable index would be taken from this in computeHash
  public int getHashCode(Node key){
    System.out.print("Node index hex value : "+key);
    int hashvalue = Integer.parseInt(key.toString().substring(5),16);
    System.out.print("Hashvalue : "+key);
    return hashvalue;
  }
  
  // reduce the hashcode value (here making the mod of it), and getting the index inside the hashtable
  // to make index range smaller and array dimension not too big
  public int computeHash(Node key){
    int hashValue = getHashCode(key);
    int hashCode  = hashValue % tableSize;
    return hashCode;
  }


  // to keep things simple, the key and the data associated are the same, here the field could have been only one
  public void insert( Node key, int data ){
    int index  = computeHash(key);
    HashNode head  = list[index];           // there is already a value at that index ( = collision)
    while( head != null ){              // Collision : key  already in hashtable, put it in the linked list
      
      if(isEqual(head.key, key) == true){  // Update : In case key is already present in list : overwrite and then exit
        head.data = data;
        return;
      }
      head = head.next;                 // put it at the end of the list
    }

    // No collision, new key; list.get(index) = null because that node at that index is not present
    list[index] =  new HashNode(key, data, list[index]);
  }




  public boolean remove(Node key){    
    HashNode nextHashNode;
    int index = computeHash(key);
    HashNode head = list[index];
    
    // if is a head key node, delete pointing to the next node 
    // (which will be : 
    // - null it is a key node with no list chained to it) 
    // - the next node in the chained list
    if(  (head != null) && (isEqual(head.key,key) == true) ){
      list[index] = head.next;
      return true;
    }


    // it is not head key node : search in the chained list
    while( head != null){
      if ( (head.next != null) && (isEqual(head.next.key,key) == true)  ){
        head.next = head.next.next;
        return true;
      }else{
        head = head.next;
      }
    }
    return false;
  }



  public void print(){
    for(int i=0; i<tableSize; i++){
      System.out.print("Print for index value : "+i+" Values :: ");

      HashNode head = list[i];
      if (head == null) {
        System.out.println("0");
        continue;
      }
      while(head != null){
        System.out.println(head.data);
        head = head.next;
      }
    }
  }


  public boolean find(Node key){
    int index = computeHash(key);
    HashNode head = list[index];

    while(head != null){
      if(head.key == key) return true; // key node
      head = head.next;                // search in chained list
    }
    return false;
  }


  public Integer getData(Node key){
    int index = computeHash(key);
    HashNode head = list[index];

    while(head != null){
      if(head.key == key) return head.data; // key node
      head = head.next;                     // search in chained list
    }
    return null;
  }

  
}



class HashNode {
  int data;
  HashNode next;

  public HashNode() {
    data = -1;
    next = null;
  }
  
  public HashNode(int d) {
    data = d;
    next = null;
  }

}



// -----------------------------------------------------------------------------
//                                LINKED LIST 
// -----------------------------------------------------------------------------
class LinkedList {
  Node head;
  Node tail; // pointing to last item in list
  int length;
  Node loopNode;

  public LinkedList() {
    head   = new Node();
    tail   = new Node();
    loopNode = null;
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
  // ** Modified version with tail : every append tail must be updated
  public void append(int d) {
    Node node = new Node(d);
    Node ptr = head; // cursor pointer

    // empty list, first node
    if (head.next == null) {
      head.next = node;
      tail.next = node;
      length++;
      return;
    }

    while (ptr.next != null)
      ptr = ptr.next;
    ptr.next  = node;
    tail.next = node;
    length++;
  }
  
  

  // delete list quick
  public void deleteListQuick() {
    head.next = null;
    tail.next = null;
    loopNode  = null;
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
  
  
  // Get last item : O(1)
  public Node getLastItem(){
    return tail.next;
  }
  
  
  // Create loop on a specific node
  public void createLoop(int start){
    if (tail.next == null ) {
      System.out.println("Empty list");
    }
    Node found = findItem(start);
    if (found != null) tail.next.next = found;
    else System.out.println("Element not found");
  }
  
  
  // Detect loop using hashtable :
  public boolean isLoop(){
    Node ptr      = head;
    HashTable ht  = new HashTable();
    
    while (ptr.next != null){
      if (ht.find(ptr)) {
        System.out.println("ptr.data : "+ptr.data);
        System.out.println("ptr.next.data : "+ptr.next.data);
        loopNode = ptr;
        return true;
      }
      ptr = ptr.next;      
    }
    ht.insert(ptr, ptr.data);
    loopNode = null;
    ht.print();
    return false;
  }
  

  

  
  
  
  // check the kind of loop
  public void checkLoopType(){
    this.isLoop();
    
    if (loopNode !=null && loopNode == head.next) 
       System.out.println("Circular List");
    else if (loopNode !=null)
        System.out.println("Normal loop in linear List");
  }
  
  
  // remove loop: in my case I have tail.next which point to the loop node
  // so I can break the loop setting :
  // if tail.next.next  point not to head : tail.next.next = null
  // if tail.next.next  point to head : must find the the item pointing to tail.next node
  //                                    and then make its next reference pointing to null
  //                                    and tail.next poit to this node.
  // NB : the head has data = -1 by convention, other ways can be found of course!
  // otherwise
  // I must search for the loop point modifiying isLoop() and getting the 
  // reference to the loop node for both cases
  public void removeLoop(){
    if (tail.next.next != null) {
       if (tail.next.next.data == -1) {
         Node ptr = head;
         while(ptr.next.next.data != -1){
           ptr = ptr.next;
         }
         tail.next = ptr.next;
         ptr.next.next = null;
       }
       else tail.next.next = null;
    }
  }
  
  
  
 
}


public class Main {

  public static void main(String args[]) {
    LinkedList list  = new LinkedList();

    System.out.println("Insert node in list");
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
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());

    
    System.out.println("Get the last item : " + (list.getLastItem()).data);
     
    System.out.println("\nMake a loop at element 23 : ");
    list.createLoop(23);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    if (list.loopNode != null )  {
      System.out.println("The loop is at item : " + list.loopNode.data);
      System.out.println("Loop type : ");
      list.checkLoopType();
    }
    
    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());

    
    System.out.println("\nRecreate list without loop");
    list.deleteListQuick();
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
    
    System.out.println("Set loop as circular list");
    list.createLoop(-1);
    
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());
    if (list.loopNode != null )  {
      System.out.println("The loop is at item : " + list.loopNode.data);
      System.out.println("Loop type : ");
      list.checkLoopType();
    }
    
    
    System.out.println("\nNow remove the loop");
    list.removeLoop();
    System.out.println("Check if there is a loop.");
    System.out.println("Result : " + list.isLoop());

    
    
  
  }

}
