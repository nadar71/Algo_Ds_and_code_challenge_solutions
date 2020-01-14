/*
Easy HashTable sample implemented as an array of predefined length.
Using Object.hashcode and LinkedList
*/

import java.util.LinkedList;

class HashTable{
  public int tableSize;

  public LinkedList<Node>[] list;


  public HashTable(){
     tableSize = 512;
     list      = new LinkedList[tableSize];
  }



    class Node{
      int key;
      int data;

      public Node(int key, int data){
        this.key  = key;
        this.data = data;
      }
    }



  // Get the hash code for the key. 
  public int getHashCode(Integer key){
    return key.hashCode();  
  }
  
  // reduce the hashcode value (here making the mod of it), and getting the index inside the hashtable
  // to make index range smaller and array dimension not too big
  public int getIndex(int key){
    int hashcode = getHashCode(key);
    // System.out.println("hashcode test : "+hashcode);
    return hashcode % tableSize;
  }


  // to keep things simple, key and  data associated are int
  public void insert( int key, Integer data ){
    if (data == null) data = key;

    int index  = getIndex(key);
    LinkedList<Node> head  = list[index];    // there is already a key at that index ( = collision)
    Node node =  new Node(key, data);

    
    // No collision for index 
    if (head == null){
       list[index] = new LinkedList<Node>();
       list[index].add(node);
       // System.out.println("Check list insert : " + list[index].get(0).data);
       return;
    }
    
    
    // Collision : add/update key in the chained  list
    for(Node n : head){
      if (n.key == key) n.data = data;
      return;
    }
    head.add(node);
    
    
  }




  public boolean remove(int key){    
    int index = getIndex(key);
    LinkedList<Node> head = list[index];
    
    // not present
    if (head == null) return false;

    int count = 0;
    for(Node n: head){
      if (n.key == key){
        head.remove(count);
        return true;
      }
      count++;
    }

    return false;

  }





  public boolean find(int key){
    int  index = getIndex(key);
    LinkedList<Node> head  = list[index];

    for(Node n:head){
      if(n.key == key) return true;
    }

    return false;
  }


  public Integer getData(int key){
    int index = getIndex(key);
    // System.out.print("index check : "+index);
    LinkedList<Node> head = list[index];
    
    if (head == null) return null;
    
    for(Node n:head){
      if(n.key == key) return n.data;
    }
    return null;
  }
  
  
  
  public void print(){
    for(int i=0; i<tableSize; i++){
      System.out.print("Print for index value : "+i+" Values :: ");

      LinkedList<Node> head = list[i];
      if (head == null) {
        System.out.println("0");
        continue;
      }
      for(Node n:head){
        System.out.println(n.data);
      }
    }
  }


  
}







public class Main{

  public static void main(String args[]){
    HashTable ht = new HashTable();

    // to keep things simple : data is equals to 2*key 
    // A realistic example, it could have been a list of phone numbers (keys) associated to name (value)
    for(int i=51; i<110; i++){
      ht.insert(i,2*i);
    }

    System.out.println("Common operations : ");
    System.out.println("get value at key 60 : "+ht.getData(60));
    System.out.println("get value at key 80 : "+ht.getData(80));
    System.out.println("get value at key 102 : "+ht.getData(102));
    
    System.out.println("search for key 100 : "+ht.find(100));
    System.out.println("remove for key 100 : "+ht.remove(100));
    System.out.println("search for key 100 : "+ht.find(100));
    System.out.println("remove for key 100 : "+ht.remove(100));
    
    
    System.out.println("get value for key 101 : "+ht.getData(101));
    System.out.println("Insert data with collision for index 101" +
           "(corrisponding for hashtable of size=512 to key 101 as well as key : 512*101+101) = 51813) ");
    ht.insert(51813,999);
    System.out.println("get value for key 101 : "+ht.getData(101));
    System.out.println("get all value for key 51813 : "+ht.getData(51813));
    
    System.out.println("\nremove for key 51813 (in chained list) : "+ht.remove(51813));
    System.out.println("get value for key 101 : "+ht.getData(101));
    System.out.println("get all value for key 51813 : "+ht.getData(51813));
    
    System.out.println("\nInsert data with collision for index 101" +
           "(corrisponding for hashtable of size=512 to key 101 as well as key : 512*101+101) = 51813) ");
    ht.insert(51813,999);
    System.out.println("get value for key 101 : "+ht.getData(101));
    System.out.println("get all value for key 51813 : "+ht.getData(51813));
    
    System.out.println("\nremove for key 101 (at start of chained list) : "+ht.remove(101));
    System.out.println("get value for key 101 : "+ht.getData(101));
    System.out.println("get all value for key 51813 : "+ht.getData(51813));
    
    


  }
}


/*
Common operations : 
get value at key 60 : 120
get value at key 80 : 160
get value at key 102 : 204
search for key 100 : true
remove for key 100 : true
search for key 100 : false
remove for key 100 : false
get value for key 101 : 202
Insert data with collision for index 101(corrisponding for hashtable of size=512 to key 101 as well as key : 512*101+101) = 51813) 
get value for key 101 : 202
get all value for key 51813 : null

remove for key 51813 (in chained list) : false
get value for key 101 : 202
get all value for key 51813 : null

Insert data with collision for index 101(corrisponding for hashtable of size=512 to key 101 as well as key : 512*101+101) = 51813) 
get value for key 101 : 202
get all value for key 51813 : null

remove for key 101 (at start of chained list) : true
get value for key 101 : null
get all value for key 51813 : null





*/