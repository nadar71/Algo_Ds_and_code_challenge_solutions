/*
Find more than 1 missed number
t : O(n)
s : O(n);
*/


import  java.util.HashMap;
import  java.util.Map;


public class Main{

  public static void findMissing(int[] arr, int n){
    if (arr.length <=0 ){
          System.out.println("Array empty");
          return;
  }
        
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    for(int i=0;i<arr.length;i++) 
        hm.put(arr[i],1);
      

    for(int i=0; i<n; i++) 
        if( hm.get(i) == null) System.out.println("Missed : "+i);  
    

  }

  public static void main(String args[]){    
    // int[] data ={0,1,2,3,4,6,7,8,9,10,12};  
    int[] data ={8,9,0,6,7,1,2,3,4,10,12};     
    findMissing(data,13);    
  }
}

/*
Missed : 5
Missed : 11



*/