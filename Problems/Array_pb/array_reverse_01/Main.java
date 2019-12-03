// without using another array t: O(n/2) O(1)
public class Main{  
    public void reverseArray(int[] arr){
      int length       = arr.length;
      int midth_length = (int) length/2;
      for(int i = 0; i< midth_length; i++){
        int tmp         = arr[length-i-1];
        arr[length-i-1] = arr[i];
        arr[i]          = tmp;
      }
      printArr(arr);
    }
    
    public void printArr(int[] arr){
      for(int i : arr){
          System.out.print(" " + i );
      }
      System.out.println();
    }
    
    
    public static void main(String[] args) 
    { 
        int[] arr = {1,2,3,4,5,6,7};
        Main m = new Main();
        m.printArr(arr);
        m.reverseArray(arr);

    } 
}
