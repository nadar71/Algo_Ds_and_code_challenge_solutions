/*
t : O(n)
s : O(n)
*/

public class Main{

  public static void findEdges(int[] arr){
    if (arr.length <= 0 ) return;
    int max = 0;
    int min = 0;

  
    for(int i=0;i<arr.length;i++) { 
      if (arr[i] > max)  max = arr[i];
      if (arr[i] < min)  min = arr[i];
    }

    System.out.println("Max : "+max+ " Min : "+min);
    
  }  
  

  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12};     
    findEdges(data);  
  }
  
}