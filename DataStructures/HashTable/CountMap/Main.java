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
      hm.insert(key, ++cnt);
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
    hm.insert(key, --cnt);

  }

  public Integer getDataCount(int key){
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

  public static void main(String args[]){
    
    int[] data = {2,3,2,2,1,3,3,4,4,3,32,1,4,5,6,6,6,6,7,8,9,1,1,2,3};
    
    
    CountMap cm = new CountMap();
    
    System.out.println("Create my map. ");
    for(int i=0;i<data.length;i++){
      cm.insert(data[i]);
    }
    
    System.out.println("Found 299 ? "+cm.find(299));
  
    cm.insert(2);
    System.out.println("Found 2 ? "+cm.find(2));
    cm.insert(2); 
    System.out.println("Found 2 ? "+cm.find(2));

    System.out.println("Found is ? "+cm.getDataCount(2));

    cm.remove(2);
    System.out.println("Found 2 ? "+cm.find(2));
    System.out.println("Count is : "+cm.getDataCount(2));

    System.out.println("Count is : "+cm.getDataCount(332));
    
    // System.out.println("Count Map value : ");
    // cm.print();
    
    for(int i=0;i<data.length;i++){
      Integer numCount = cm.getDataCount(i);
      if (numCount != null) System.out.println("For "+i+" counts are : "+numCount);
    }
    
    

  }
}