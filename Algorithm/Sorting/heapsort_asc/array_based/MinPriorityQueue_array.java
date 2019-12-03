

public class MinPriorityQueue_array{
  int length;
  int[]  arr;
  int middleIndex;
  int smallest_idx = -1; // STORE the index of the smallest of the 2 children
  

  public  MinPriorityQueue_array(int[] arr){
     this.arr    = arr;
     length      = arr.length;
     middleIndex = (int) ( (length-1)/2 );
  }

  public void createPriorityQueue(){
    // go to the start of the array, down with index
    middleIndex = (int) ( (arr.length-1)/2 );
    for(int i = middleIndex; i>=0; i--) goDown(i);  
  }


  // store value y in x and viceversa
  public void swap(int idx1,int idx2){
      int tmp    = arr[idx1];
      arr[idx1]  = arr[idx2];
      arr[idx2]  = tmp;
  }



  // used by create a new heap from array or add a new element, to keep the heap a max/min heap
  // percolate down items not in order to maintain a the greatest/smallest value
  public void goDown(int pos){
    int left  = 2*pos+1;
    int right = left +1;

    if (left  < length)   smallest_idx = left;  // init from left child
    if (right < length && arr[right] < arr[left])  smallest_idx = right; // take the greatest_idx of the 2 children
    if (smallest_idx != -1 && arr[smallest_idx] < arr[pos]){
      swap(pos,smallest_idx);
      goDown(smallest_idx);
    }
  }
  
  public void add(int item){
    copyArrayInAnother(0,length-1,length+1);
    arr[length-1] = item;
    createPriorityQueue();
  }
  
  public int getHeapValue(){
    int heapValue = arr[0];
    copyArrayInAnother(1,length-1,length-1);
    createPriorityQueue();
    return heapValue;
  }
  
  public void removeItem(int item){
    int index = find(item);
    if( index == -1) {
      System.out.println("Element not present.");
      return;
    }
    
    copyArrayInAnother_ExcludingIndexInterval(0,index, index+1,length-1);
    createPriorityQueue();
  }
  

  public void copyArrayInAnother(int start, int end, int newArrayLength){
    int[] tmp_arr = new int[newArrayLength];
    int count = 0;
    for(int i = start; i<= end; i++){
      tmp_arr[count] = arr[i];
      count++;
    }
    arr = tmp_arr;
    length = arr.length;
  }
  
  public int find(int item){
    for(int i=0; i < arr.length; i++)
      if (arr[i] == item) return i;
    return -1;
  }
  
  public void copyArrayInAnother_ExcludingIndexInterval(int start1, int end1,int start2, int end2){
    int newArrayLength = (end1-start1) + (end2-start2) + 1;
    int[] tmp_arr = new int[newArrayLength];
    int count = 0;
    for(int i = start1; i< end1; i++){
      tmp_arr[count] = arr[i];
      count++;
    }
    
    for(int i = start2; i<= end2; i++){
      tmp_arr[count] = arr[i];
      count++;
    }
    arr = tmp_arr;
    length = arr.length;
  }
  

  public void printArr(){
    for(int i : arr) System.out.print(i+" ");
    System.out.println("");
  }

}
