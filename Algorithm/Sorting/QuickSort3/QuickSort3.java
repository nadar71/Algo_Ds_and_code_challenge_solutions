// NB : works only with worse case pivot at left (lower index), with others fails ?
public class QuickSort3{ 
    int[] arr;
    
    public void swap(int first, int second){
      int tmp     = arr[first];
      arr[first]  = arr[second];
      arr[second] = tmp;
     }
    
    
    public int[] sorting(int[] arr){
        this.arr = arr;
      int size = arr.length;
      quicksortExecute(0,size-1);
      return arr;
    }
    

    public void quicksortExecute(int lower, int upper){
      if (upper < lower) return;

      int pivot = arr[lower];
      int start = lower;
      int stop  = upper;

      while(lower < upper){
        // keep on till we find a number > pivot or index cross
        while((arr[lower] <= pivot) && (lower < upper)){
          lower++;
        }

        // the same, but for number < pivot
        while((arr[upper] > pivot) && (lower <= upper)){
          upper--;
        }

        // invert indexes :
        if (lower < upper) swap(upper, lower); 
      }
      // put the pivot in upper position
      swap(upper,start);
      quicksortExecute(start, upper-1);
      quicksortExecute(upper+1, stop);
    }


}
