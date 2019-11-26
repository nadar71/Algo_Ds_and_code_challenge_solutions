/*
1) Using arrays, suppose integer array with length n : 
* suppose we can create a new auxiliary array tmp:
- create tmp = new int[n]
- scan array, set for each item i  tmp[i]=1 if not present, else increase its value
- scan tmp and print all the items which have tmp[i]>1

t : O(n) + O(n) ~ O(2n)
s : O(n);

*/


public class Main{

  public static void findRepeats(int[] arr){
    if (arr.length <= 0 ) return;

    int[] tmp = new int[arr.length];

    for(int i=0;i<arr.length;i++) { 
      int k = arr[i];
      if ( tmp[k] <= 0)  tmp[k] = 1;
      else tmp[k]++;
    }

    for(int i=0;i<tmp.length;i++) {    
      if ( tmp[i] > 1)  System.out.println("This number : "+i+ " repeats times : "+tmp[i]);
    }
      
  }

  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12};     
    findRepeats(data);    
  }
}