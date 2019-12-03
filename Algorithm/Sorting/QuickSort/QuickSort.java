class QuickSort{ 
    int[] arr;
    
    public void swap(int first, int second){
      int tmp     = arr[first];
      arr[first]  = arr[second];
      arr[second] = tmp;
     }

    public int partition(int low, int high){
      int pivot = arr[high]; // set the pivot at last element
      // int pivot = arr[(int)(high+low)/2];
      int i = low-1;
      for(int j=low; j<high; j++){
        if(arr[j] <= pivot){
          i++;
          swap(i,j);
        }
      }

      swap(i+1, high);
      return i+1;
      
    }


    public int[] sorting(int[] arr){
      this.arr = arr;
      sort(0, arr.length-1);
      return arr;
    }
    


    // Quick sort implementation
    public void sort(int low,int high){
      if(low < high){
        
        int pivotIdx = partition(low, high);

        // sort subarray with items smaller/greater then the pivot
        sort(low,pivotIdx-1);
        sort(pivotIdx+1, high);
      }

    }


}
