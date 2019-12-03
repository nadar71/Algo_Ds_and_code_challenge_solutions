class BucketSort{ 
    int[] arr;
    public BucketSort(int[] arr){
        this.arr = arr;
    }
    
    
    public int[] sort(int lowerRange,int upperRange){
      int   range = upperRange - lowerRange;
      int[] count = new int[range];

      for(int i=0; i<arr.length; i++) count[arr[i]-lowerRange]++;
      
      int j = 0;
      for(int i=0; i<range; i++){
        for(; count[i]>0; count[i]--){
          arr[j++] = i + lowerRange;
        }
      }
      
      return arr;
        
    }


    
}
