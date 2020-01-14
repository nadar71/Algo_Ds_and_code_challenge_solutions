// ------------------- CountMap

import java.util.HashMap;
import java.util.Map;

class CountMap{
  public HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
  


 
  public void insert(int key){
    if(hm.containsKey(key)){      
      int cnt = hm.get(key);
      hm.put(key, ++cnt);
    } else { 
      hm.put(key, 1);   
    }
  }




  public void remove(int key){
    hm.remove(key);    
  }



  public boolean decrementData(int key){
    if(hm.containsKey(key)){      
      int cnt = hm.get(key);
      hm.put(key, --cnt);
      return true;
    } else { 
      return false;
    }

  }

  public Integer getDataCount(int key){
    if(hm.containsKey(key)) return hm.get(key);
    else return 0;
  }

  public boolean find(int key){
    return hm.containsKey(key);
  } 



  public void print(){
    for(Map.Entry item: hm.entrySet()){
       System.out.println("Key : "+item.getKey() + " Value : " + item.getValue() );
    }
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