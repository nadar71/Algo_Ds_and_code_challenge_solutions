/*
1) Using arrays, suppose integer array with length n : 
* suppose we know the integer range of the integer in the array or that we calculate that finding the max in the array:
- find the maxRange
- create tmp = new int[maxRange]
- scan array, set for each item i  tmp[i]=1 if not present, else increase its value
- scan tmp and print all the items which have tmp[i]>1

t : O(n) + O(n) ~ O(2n)
s : O(maxRange);

*/


public class Main{

  public static void findRepeats(int[] arr){
    if (arr.length <= 0 ) return;
    int range = findMax(arr)+1;

    int[] tmp = new int[range];

    for(int i=0 ; i<arr.length; i++) { 
      int k = arr[i];
      if ( tmp[k] <= 0)  tmp[k] = 1;
      else tmp[k]++;
    }

    for(int i=0;i<tmp.length;i++) {    
      if ( tmp[i] > 1)  System.out.println("This number : "+i+ " repeats times : "+tmp[i]);
    }
      
  }

  public static int findMax(int arr[]){
    int max = 0;
    for(int i=0; i<arr.length; i++)
      if (arr[i] > max) max = arr[i];

    return max;    
  }

  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12,56};     
    findRepeats(data);    
  }
}