/*
Find more than 1 missed number
t : O(n)
s : O(n)
*/


import java.util.BitSet;
public class Main{

  public static void findMissing(int[] arr, int n){
    int missNumsCount = n-arr.length;
    BitSet bset  = new BitSet(n); // by default at creation all bits are set to 0
    System.out.println("missNumsCount : " + missNumsCount); 

    // set bit corresponding to number not missed to 1
    for(int i:arr) bset.set(i);

    // the missed number are the idx for the bit remained to 0 (=clear bit)
    int idxLastMissedNum = 0;
    for(int i=0;i<missNumsCount;i++){
      idxLastMissedNum = bset.nextClearBit(idxLastMissedNum);
      System.out.println("A Missed number is : "+idxLastMissedNum);
      idxLastMissedNum++;
    }
  }

  public static void main(String args[]){    
    int[] data = {0,1,2,3,4,6,7,8,9,10,12};      
    findMissing(data,13);    
  }
}