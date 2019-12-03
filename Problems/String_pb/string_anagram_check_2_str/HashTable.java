/*
Easy HashTable sample implemented as an array of predefined length.
Using a demo Hash function to return value from a key
*/

public class HashTable{
  public int tableSize;

  public Node[] list;


  public HashTable(){
     tableSize = 512;
     list      = new Node[tableSize];
  }



    class Node{
      int key;
      int data;
      Node next;

      public Node(int key, int data, Node next){
        this.key  = key;
        this.data = data;
        this.next = next;
      }
    }



  // Get the hash code for the key. 
  // To keep things simple, here is a dummy hash function : it get the key, then simply return the key.
  // If as example the entry key was a phone number associated to employee
  // I can use the last 3 number as hashcode, and then hashtable index would be taken from this in getIndex.
  // Or can use Object.hashcode() too
  public int demoHashFunction(int key){
    return key;  
  }
  
  // reduce the hashcode value (here making the mod of it), and getting the index inside the hashtable
  // to make index range smaller and array dimension not too big
  public int getIndex(int key){
    int hashValue = demoHashFunction(key);
    return hashValue % tableSize;
  }


  // to keep things simple, key and  data associated are int
  public void insert( int key, Integer data ){
    if (data == null) data = key;

    int index  = getIndex(key);
    Node head  = list[index];    // there is already a key at that index ( = collision)
    Node newNode =  new Node(key, data, null);

    
    // No collision for index 
    if (head == null){
       list[index] = newNode;
       return;
    }
    
    
    // Collision : add/update key in the chained  list
    while( head.next != null ){       
      
      // key already present : update 
      if(head.key == key){       
        head.data = data;
        return;
      }
      head = head.next;          
    }
    
    // key not present in the chained list  for that index: 
    // put new node at the end 
    head.next = newNode; 
    
  }




  public boolean remove(int key){    
    int index = getIndex(key);
    Node head = list[index];
    
    // not present
    if (head == null) return false;
    
    //firstnode
    if(head.key == key){
       list[index] = list[index].next;
       return true;
    }
    
    
    // search in the chained list
    while( head.next != null){
      if ( head.next.key == key)  {
        head.next = head.next.next;
        return true;
      }
      head = head.next;
    }
    return false;

  }



  public void print(){
    for(int i=0; i<tableSize; i++){
      System.out.print("Print for index value : "+i+" Values :: ");

      Node head = list[i];
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



  public boolean find(int key){
    int index = getIndex(key);
    Node head = list[index];

    while(head != null){
      if(head.key == key) return true; // key node
      head = head.next;                // search in chained list
    }
    return false;
  }


  public Integer getData(int key){
    // System.out.println("Searching for key : "+key);
    int index = getIndex(key);
    Node head = list[index];
    // System.out.println("index : "+index);
    
    while(head != null){
      // System.out.println("key : "+head.key);
      // System.out.println("data : "+head.data);
      if(head.key == key) return head.data; // key node
      head = head.next;                     // search in chained list
    }
    return null;
  }

  
}

