
class HeapSort extends MaxPriorityQueue {

  public HeapSort(int[] input) {
    super(input);
    createPriorityQueue(); 
  }
    

  public int getHeapValueForSorting() {
    int heapValue = arr.get(0);
    if (length - 1 <= 0)
      return arr.get(1);
    swap(0, length - 1);
    length--;
    goDown(0);
    return heapValue;
  }
  
  

  public int[] doHeapSort(int[] input) {
    int result[] = new int[input.length];
    
    for (int i = 0; i < input.length; i++) {
      int heapValue = getHeapValueForSorting();
      result[i] = heapValue;
    }

    return result;
  }
  
  
  

  public static void printArray(int[] arr) {
    for (int i : arr)
      System.out.print(i + " ");
    System.out.println("");
  }

}