/*
Can check more then 1 number missed, starting from 0:


- sort (O(logn) / O(nlogn)) using array.sort for java (using dual pivot quicksort, better);

t : ~ O(n)
s : O(n)

NB : using BitSet is quicker (use nextClearBit) and use less space; moreover doesn''t need sorting;     
*/

import java.util.Arrays;

public class Main{

  public static void findMissing(int[] arr, int n){
    Arrays.sort(arr);
    int[] check = new int[n]; // they are all set to 0 by default in java

    for(int i=0;i<arr.length;i++) 
      check[arr[i]] = 1;
      

    for(int i=0;i<check.length;i++) 
      if( check[i] == 0) System.out.println("Missed : "+i);  
  }

  public static void main(String args[]){    
    // int[] data ={0,1,2,3,4,6,7,8,9,10,12};  
    int[] data ={8,9,0,6,7,1,2,3,4,10,12};     
    findMissing(data,13);    
  }
}


