
class BubbleSortImproved{
  private int[] data;

  public int[] sorting(int[] d){
    data = d;
    int length = data.length;
    boolean swapped = true;
    
    for(int i=0; i<length-1 ; i++){
      if   (swapped) swapped = false;
      else break;                     // the remaining part already sorted, stop loop

      for(int j=0; j<length-i-1; j++){
          if(data[j] > data[j+1]){
            int tmp   = data[j];
            data[j]   = data[j+1];
            data[j+1] = tmp;
            swapped = true;
          }

      }
    }

    return data;
  }
}

