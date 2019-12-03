class QuickSort2{ 
    int[] arr;
    
    public void swap(int first, int second){
      int tmp     = arr[first];
      arr[first]  = arr[second];
      arr[second] = tmp;
     }

    public int partition(int left, int right){
      int pivot = arr[(int)(left+right)/2]; // best case
      while(left <= right){
        // find element to the left that must be to the right because greater then pivot
        while (arr[left]<pivot) left++;
        
        // find element to the right that must be to the left because smaller then pivot
        while (arr[right]>pivot) right--;

        // swap items and move indexes forward
        if (left <= right){
          swap(left, right);
          left++;
          right--;
        }

      }
      
      return left;
      
    }

    
    public int[] sorting(int[] arr){
      this.arr = arr;
      sort(0, arr.length-1);
      return arr;
    }


    // Quick sort implementation
    public void sort(int left,int right){
        // set the pivot at last element
        int pivotIdx = partition(left, right);
        
        if(left<pivotIdx-1) sort(left,pivotIdx-1);
        if(pivotIdx<right)  sort(pivotIdx, right);
    }


}
