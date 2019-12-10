public class Main{  
    public void maxsubarraySum(int[] arr){
      int length        = arr.length;
      int maxSoFar      = 0;
      int maxEndingHere = 0;
      for(int i = 0; i < length; i++){
        maxEndingHere += arr[i];
        if (maxEndingHere < 0) maxEndingHere = 0;
        if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
      } 
      System.out.println(maxSoFar);    
    }
    
    
    public static void main(String[] args) 
    { 
        int[] arr = {1,-2,3,4,-4,6,-14,8,2};
        Main m = new Main();
        m.maxsubarraySum(arr);
    } 

}


/*
10
*/