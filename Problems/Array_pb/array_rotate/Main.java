// t: O(n)
public class Main{  

    public void rotateArr(int[] arr,int length, int k){
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, length-1);
        reverseArray(arr, 0, length-1);
    }

    public void reverseArray(int[] arr, int start, int end){
      for(int i = start, j = end; i < j; i++, j-- ){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = tmp;
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
        // m.reverseArray(arr, 3, 5);
        m.rotateArr(arr, 7, 4);

    } 
}

// OUTPUT :
// 4 3 2 1 5 6 7     // reverseArray(arr, 0, k-1);                                                                                                                  
// 4 3 2 1 7 6 5     // reverseArray(arr, k, length-1);                                                                                                                
// 5 6 7 1 2 3 4     // reverseArray(arr, 0, length-1);