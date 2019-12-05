class InsertionSort{
  private int[] data;
  
  public int[] sorting(int arr[]) 
  { 
      int length = arr.length; 
      for (int i = 1; i < length; i++) { 
          int tmp = arr[i]; 
          int j = i - 1; 

          // Move elements of arr[0..i-1] greater than arr[i], 
          // 1 position ahead of their current position 
          while (j >= 0 && arr[j] > tmp) { 
              arr[j + 1] = arr[j]; 
              j--; 
          } 
          arr[j + 1] = tmp; 
      } 
      
      return arr;
  }

  
  
}
