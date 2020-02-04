/*
Rotate right

t: O(n)
*/


public class Main{  

    public void rotateArr(int[] arr, int k){
        int length = arr.length;
        if ( length == 0 || k == length) return;
        if (k > length) k =  k - length;
        
        reverseArray(arr, 0, length-1-k);
        reverseArray(arr, length-k, length-1);
        reverseArray(arr, 0, length-1);
    }


    
    public void reverseArray(int[] arr, int start, int end){
      for(int i = start, j = end; i < j; i++, j-- ){
        int tmp = arr[j];
        arr[j]  = arr[i];
        arr[i]  = tmp;
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
        
        Main m = new Main();
        
        int[] arr = {1,2,3,4,5,6,7};
        m.rotateArr(arr, 3);
        System.out.println();
        
        int[] arr1 = {};
        m.rotateArr(arr1, 3);
        System.out.println();
        
        int[] arr2 = {1,2,3};
        m.rotateArr(arr2, 4);
        System.out.println();

    } 
}

/*
 4 3 2 1 5 6 7
 4 3 2 1 7 6 5
 5 6 7 1 2 3 4


 2 1 3
 2 1 3
 3 1 2


*/

