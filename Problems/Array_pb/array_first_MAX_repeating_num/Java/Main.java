import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Main{

  public int findNumMoreRepeated(int[] arr){
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxRepets = 0;
    int indxOfMaxRep = 0;
    for(int i=0;i<arr.length;i++){
      if (hm.containsKey(arr[i])) {
        int value = (Integer)hm.get(arr[i]);
        value++;
        if (value>maxRepets) {
          maxRepets    = value;
          indxOfMaxRep = arr[i];
        }
        hm.put(arr[i],value);
      }else {
    	    hm.put(arr[i],1);
      }
    }  
    // hashMapContentPrint(hm);
    return indxOfMaxRep;    

  }
  
  /*
  public void hashMapContentPrint(HashMap m) {
	  Set set     = m.entrySet();
	  Iterator it = set.iterator();
	  while(it.hasNext()) {
		  Map.Entry e = (Map.Entry)it.next();
		  System.out.println("For the key : "+e.getKey() + " the values is : "+e.getValue());
 	  }
  }
  */
  

  public static void main(String args[]){  
	Main m = new Main();
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,4,10,12};     
    System.out.println("Num with max repetitions : " + m.findNumMoreRepeated(data));
    
  }
  
}
