/*
1) Using array
t : O(n)
s : O(n)
*/

public class Main{

  public static void findRepeating(int[] arr){
    if (arr.length <= 0 ) return;

    int[] tmp = new int[arr.length];

    for(int i=0;i<arr.length;i++) { 
      int k = arr[i];
      if ( tmp[k] <= 0)  tmp[k] = 1;
      else tmp[k]++;
    }

    for(int i=0;i<tmp.length;i++) {    
      if ( tmp[i] > 1)  System.out.println("This number : "+i+ " repeats. ");
    }
      
  }

  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12};     
    findRepeating(data);    
  }
}