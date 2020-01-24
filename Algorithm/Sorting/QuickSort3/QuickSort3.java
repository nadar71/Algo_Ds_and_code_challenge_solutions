/*
Best case when the pivot is at left; worste at middlle and wthe worst at right
*/
public class QuickSort3{ 
    int[] arr;
    
    public void swap(int first, int second){
      int tmp     = arr[first];
      arr[first]  = arr[second];
      arr[second] = tmp;
     }
    
    
    public int[] quickSort(int[] arr){
      this.arr = arr;
      int size = arr.length;
      sort(0,size-1);
      return arr;
    }
    

    public void sort(int lower, int upper){
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
      sort(start, upper-1);
      sort(upper+1, stop);
    }


}
