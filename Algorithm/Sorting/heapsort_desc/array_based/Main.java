public class Main{

  public static void main(String args[]){
    int[] arr = {1,2,3,4,5,6,7,8};
    HeapSort hs = new HeapSort(arr);
    
    System.out.println("Sorted in descending order : ");
    arr = hs.doHeapSort(arr);
    HeapSort.printArray(arr);
  }
}

