class InsertionSort{
  private int[] data;

  public int[] sorting(int[] d){
    data = d;
    int length = data.length;  

    for(int i=1; i<length; i++){
      int tmp = data[i];
      for(int j=i; j<0; j--){
        if(data[j-1] > tmp){
            data[j] = data[j-1];        // keep scanning down the array till reaching the right position for tmp
        }else continue;       // return to the outer loop

        data[j] = tmp;       // set tmp in right position, where now data[j-1] is not greater than it
      }

    }
    return data;
  }  
  
}
