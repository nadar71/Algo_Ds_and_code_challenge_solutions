
public class BubbleSort{
  private int[] data;

  public int[] sorting(int[] d){
    data = d;
    int length = data.length;

    for(int i=0; i<length-1 ; i++){
      for(int j=0; j<length-i-1; j++){
          if(data[j] > data[j+1] ){
            int tmp       = data[j];
            data[j]   = data[j+1];
            data[j+1] = tmp;
          }

      }
    }

    return data;
  }
}
