
/*
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)

t : O(n)  
s : ~O(n/2)
*/


import java.util.Arrays;

// ------------------- HashTable
class HashTable{
  public final int tableSize;

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


  public int compare(int a, int b){
    return a-b;
  }



  // Get the hash code for the key. To keep things simple, here is a dummy hash function : 
  // it get the key, then simply return the key.
  // If as example the entry key was a phone number associated to employee
  // I can use the last 3 number as hashcode, and then hashtable index would be taken from this in computeHash
  public int getHashCode(int key){
    return key;
  }
  
  // reduce the hashcode value (here making the mod of it), and getting the index inside the hashtable
  // to make index range smaller and array dimension not too big
  public int computeHash(int key){
    int hashValue = 0;
    hashValue     = getHashCode(key);
    return hashValue % tableSize;
  }


  // to keep things simple, the key and the data associated are the same, here the field could have been only one
  public void insert( int key, Integer data ){
    if (data == null) data = key;

    int index  = computeHash(key);
    Node head  = list[index];
    while( head != null ){              // Collision : key  already in hashtable, put it in the linked list
      
      if(compare(head.key, key) == 0){  // Update : In case key is already present in list : exit
        head.data = data;
        return;
      }
      head = head.next;                 // put it at the end of the list
    }

    // No collision, new key; list.get(index) = null because that node at that index is not present
    list[index] =  new Node(key, data, list[index]);
  }




  public boolean remove(int key){    
    Node nextNode;
    int index = computeHash(key);
    Node head = list[index];
    
    // if is a head key node, delete pointing to the next node 
    // (which will be : 
    // - null it is a key node with no list chained to it) 
    // - the next node in the chained list
    if(  (head != null) && (compare(head.key,key) == 0) ){
      list[index] = head.next;
      return true;
    }


    // it is not head key node : search in the chained list
    while( head != null){
      nextNode = head.next;
      if ( (nextNode != null) && (compare(nextNode.key,key) == 0)  ){
        head.next = nextNode.next;
        return true;
      }else{
        head = nextNode;
      }
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
    int index = computeHash(key);
    Node head = list[index];

    while(head != null){
      if(head.key == key) return true; // key node
      head = head.next;                // search in chained list
    }
    return false;
  }


  public Integer getData(int key){
    int index = computeHash(key);
    Node head = list[index];

    while(head != null){
      if(head.key == key) return head.data; // key node
      head = head.next;                     // search in chained list
    }
    return null;
  }

  
}






// ------------------- CountMap

class CountMap{
  public int sizeCountMap;
  public HashTable hm;

  public CountMap(){
    sizeCountMap  = 0;  // NB : size of the key and their repetition, not that of hashtable
    hm            = new HashTable();
  }


 
  public void insert(int key){
    sizeCountMap++;
    if(hm.find(key)){      // if already in hm, increment value
      int cnt = hm.getData(key);
      hm.insert(key, cnt+1);
    } else { 
      hm.insert(key, 1);   // else if new, set 1
    }
  }




  public void remove(int key){
    if(hm.find(key)){
      if(hm.getData(key) == 1){
        hm.remove(key);
      }else{
        decrementDataBy(key, 1);
      }
    }
    sizeCountMap--;
    
  }



  public void decrementDataBy(int key, int dec){
    int cnt = hm.getData(key);
    hm.insert(key, cnt-1);

  }

  public Integer getData(int key){
    if(hm.find(key)) return hm.getData(key);
    else return 0;
  }

  public boolean find(int key){
    return hm.find(key);
  } 


  public int size(){
    return sizeCountMap;
  }


  public void print(){
    hm.print();
  }
  

 
}



public class Main{
  

  public boolean isPalindromePerm(String inputStr){
    if (inputStr.length() <= 0 ) return true;
    CountMap cm = new CountMap();  // the hashmap of the count map must have size of 128 
  
    int len = inputStr.length();
    boolean isStrOdd;
    int countOdds  = 0;
    int countSpace = 0;
    
  
  
    for(int i=0; i<len; i++)  {
      char c = inputStr.charAt(i);
      if (c != ' '){
        if (c>='A' && c<='Z') c += 32; // make all lower case
        cm.insert(c);
      }else{
        countSpace++;
      }
    }  
    
    if ((len-countSpace) % 2 == 0) isStrOdd = false; else isStrOdd = true;
    
  
    for(int i=0; i<len; i++)  {
      char c = inputStr.charAt(i);
      System.out.println("Char : "+c);
      if(c == ' ') continue;
      int count = cm.getData(c);
      
      System.out.println("Counts : "+count); 
      if ( count % 2 != 0 ) {
        if (isStrOdd){
        
            if (countOdds >= 1 ) 
              return false;
            else {
              countOdds++;
            }
        } else return false;
        
        
      }
    }
  
    return true;
  }



  public static void main(String args[]){  
    Main m = new Main();

    String s1 ="Tact Coa";  // true
    System.out.println("palidrome s1: " + m.isPalindromePerm(s1));
    
    String s2 ="Tact    Coa"; // true
    System.out.println("palidrome s2: " + m.isPalindromePerm(s2));
    
    String s3 ="Tacte Coaeo";  // true
    System.out.println("palidrome s3: " + m.isPalindromePerm(s3));
 
    String s4 ="Tate Caeo ";  // false
    System.out.println("palidrome s4: " + m.isPalindromePerm(s4));
    
    
    System.out.println("-------------------------------" );
    
    String s11 ="tact coa";  // true
    System.out.println("palidrome s1: " + m.isPalindromePerm(s11));
    
    String s22 ="tact    coa"; // true
    System.out.println("palidrome s2: " + m.isPalindromePerm(s22));
    
    String s33 ="tacte coaeo";  // true
    System.out.println("palidrome s3: " + m.isPalindromePerm(s33));
 
    String s44 ="tate caeo ";  // false
    System.out.println("palidrome s4: " + m.isPalindromePerm(s44));
          
  }
    
} 