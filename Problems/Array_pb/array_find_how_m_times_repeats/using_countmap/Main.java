/*
Using HashMap as a CountMap :
- put all the data in countmap
  if not present : 1
  present        : increment value --> print the value

t : O(n)
s : O(n);
*/

import  java.util.HashMap;
import  java.util.Map;

public class Main{

  public static void findHowManyRepeats(int[] arr){
    if (arr.length <=0 ){
          System.out.println("Array empty");
          return;
      }
        
  HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

  for(int item : arr){
    Integer check = hm.get(item) ;
    if ( check == null) hm.put(item,1);
    else if (check >= 1) hm.put(item, ++check);
  }
  System.out.println("");
    
    for(Map.Entry item: hm.entrySet())
    if ((int)item.getValue() > 1) System.out.println("This number : "+item.getKey() + " repeats times : "+item.getValue());
      
  }
  


  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12};     
    findHowManyRepeats(data);    
  }
}

/*

This number : 2 repeats times : 3
This number : 4 repeats times : 3
This number : 6 repeats times : 2
This number : 8 repeats times : 2
This number : 10 repeats times : 2
This number : 12 repeats times : 2



*/