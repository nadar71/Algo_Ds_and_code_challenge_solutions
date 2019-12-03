public class Main{

  public static void main(String args[]){
    int[] arr = {8,7,6,5,4,3,2,1};
    HeapSort hs = new HeapSort(arr);
    
    System.out.println("Sorted in ascending order : ");
    arr = hs.doHeapSort(arr);
    HeapSort.printArray(arr);
  }
}

