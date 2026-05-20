// t: O(logN) (log base 2)
// s: O(1)


public class Main{
  public int BinarySearch(int[] arr, int value){
    int mid ;
    int low  = 0;
    int high = arr.length - 1;

    while( low <= high ){
        mid = (int)(low + high )/2;
        if (value > arr[mid]) low = mid + 1;
        else if (value < arr[mid])  high = mid - 1;
        else return mid;
    }
    return -1;

  }


  public static void main(String args[]){  
    Main m = new Main();  
    int[] test = {0,1,2,3,4,5,6,7};
    int toSearch = 2; 
    System.out.println(m.BinarySearch(test, toSearch));   
  }
  
}
