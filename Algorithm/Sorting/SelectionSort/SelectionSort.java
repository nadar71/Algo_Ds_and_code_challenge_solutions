class SelectionSort{
  private int[] data;
    
  public int[] sortingMovMin(int[] d){
    data = d;
    int length = data.length; 

    for(int i=0; i<length-1; i++){
      int min = i;                 // supposed position for min
      for(int j = i+1; j<length; j++){
        if(data[j]<data[min]){
          min=j;
        }
      }
      int tmp   = data[i];
      data[i]   = data[min]; //put the current min before
      data[min] = tmp;
    }  
    return data;
  }
  
  
  public int[] sortingMovMax(int[] d){
    data = d;
    int length = data.length; 

    for(int i=0; i<length-1; i++){
      int max = i;                 // supposed position for max
      for(int j = i+1; j<length; j++){
        if(data[j]>data[max]){
          max=j;
        }
      }
      int tmp   = data[i];
      data[i]   = data[max]; //put the current max after
      data[max] = tmp;
    }  
    return data;
  }
  
  
} 