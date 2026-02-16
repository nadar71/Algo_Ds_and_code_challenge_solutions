// without using another array t: O(n/2) O(1)
// 1 pointer solution: Exchange the first middle items of the array with the last middle items of the array using 1 pointer.
// without using another array t: O(n/2) O(1)
// reverse the whole array :
// swap the values at start , index i going forward 
// till midth_length with those at end going backward (length-1-i) 
// end when i == mid_length


public class Main{  
    public void reverseArray(int[] arr){
      int size       = arr.length;
      int middle     = size/2;
      for(int i = 0; i < middle; i++){
        int tmp         = arr[size-i-1];
        arr[size-i-1]   = arr[i];
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

