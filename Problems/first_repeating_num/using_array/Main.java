/*
1) Using an array
t : O(n)
s : O(n)
*/

public class Main{

  public static void findFirstRepeating(int[] arr){
    if (arr.length <= 0 ) return;

    int[] tmp = new int[arr.length];

    for(int i=0;i<arr.length;i++) { 
      int k = arr[i];
      if ( tmp[k] <= 0)  tmp[k] = 1;
      else tmp[k]++;
    }

    
    for(int i=0;i<arr.length;i++) { 
      int k = arr[i];
      if ( tmp[k] > 1)  {
        System.out.println("First repeating number : "+k);
        break;
      }
    }

    

    
      
  }

  public static void main(String args[]){    
    // int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12};     
    int[] data ={1,2,3,2,1}; 
    findFirstRepeating(data);    
  }
}