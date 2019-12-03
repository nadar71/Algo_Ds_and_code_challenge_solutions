public class CountMap{
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