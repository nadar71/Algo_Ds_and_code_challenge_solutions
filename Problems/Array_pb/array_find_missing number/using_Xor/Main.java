/*
Find 1 missed number; can be used if they are more
t : O(n)
s : O(1)
*/


import java.util.BitSet;
public class Main{

  public static int findMissing(int[] arr, int range){
    int xorSum = 0;
    
    for(int i = 0; i < range; i++)      xorSum ^= i;
    for(int i = 0; i < arr.length; i++) xorSum ^= arr[i];

    return xorSum;

  }

  public static void main(String args[]){    
    int[] data = {0,1,2,3,4,6,7,8,9,10,11,12};      
    System.out.println("Missing number : " + findMissing(data,13)); 

    int[] data_01 = {0,1,2,3,4,5,6,7,8,9,10,12};      
    System.out.println("Missing number : " + findMissing(data_01,13));    
  }
}

/*
Missing number : 5
Missing number : 11
*/