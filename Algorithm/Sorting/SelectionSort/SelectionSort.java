class SelectionSort{
  private int[] data;

  public int[] sorting(int[] d){
    data = d;
    int length = data.length; 

    for(int i=0; i<length-1; i++){
      int min = i;                 // supposed position for min
      for(int j = i+1; j<length; j++){
        if(data[j]<data[min]){
          min=j;
        }

        int tmp       = data[i];
        data[i]   = data[min];
        data[min] = tmp;
      }
    }  
    return data;
  }
  
} 
