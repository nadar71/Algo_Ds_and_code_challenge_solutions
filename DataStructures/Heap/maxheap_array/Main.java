
// USING AN ARRAY 
// EASY, but immutable : 
// when you add an element you must create a new array...and copy all the previous values!!

class MaxPriorityQueue{
  int length;
  int[]  arr;
  int middleIndex;
  int greatest_idx = -1; // STORE the index of the greatest of the 2 children
  

  public  MaxPriorityQueue(int[] arr){
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

    if (left  < length)   greatest_idx = left;  // init from left child
    if (right < length && arr[right]> arr[left])  greatest_idx = right; // take the greatest_idx of the 2 children
    if (greatest_idx != -1 && arr[greatest_idx] > arr[pos]){
      swap(pos,greatest_idx);
      goDown(greatest_idx);
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



// MAIN  MaxPriorityQueue ---------------------------------------------------------------------

public class Main{

  public static void main(String args[]){
    int[] arr = {1,2,3,4,5,6,7,8};
    MaxPriorityQueue pq = new MaxPriorityQueue(arr);
    pq.createPriorityQueue();
    pq.printArr();

    pq.add(0);
    pq.printArr();
  
    System.out.println("\nAdd a new heap value : ");
    pq.add(9);
    pq.printArr();

    
    System.out.println("\nAdd another new heap value : ");
    pq.add(19);
    pq.printArr();
    
    System.out.println("\nAdd another new heap value : ");
    pq.add(21);
    pq.printArr();
    
    System.out.println("\nAdd another new heap value : ");
    pq.add(33);
    pq.printArr();
    
    System.out.println("\nAdd a generic value : ");
    pq.add(12);
    pq.printArr();
    
    System.out.println("\nGet heap value : "+pq.getHeapValue());
    pq.printArr();
    
    System.out.println("\nDelete item 92 not present : ");
    pq.removeItem(92);
    
    
    System.out.println("\nDelete item 4 PRESENT : ");
    pq.removeItem(4);
    pq.printArr();


  }
}

/*

8 5 7 4 1 6 3 2 
8 5 7 4 1 6 3 2 0 

Add a new heap value : 
9 8 7 4 5 6 3 2 0 1 

Add another new heap value : 
19 9 7 4 8 6 3 2 0 1 5 

Add another new heap value : 
21 9 19 4 8 7 3 2 0 1 5 6 

Add another new heap value : 
33 9 21 4 8 19 7 2 0 1 5 6 3 

Add a generic value : 
33 9 21 4 8 19 12 2 0 1 5 6 3 7 

Get heap value : 33
21 19 12 8 9 7 4 0 1 5 6 3 2 

Delete item 92 not present : 
Element not present.

Delete item 4 PRESENT : 
21 19 12 8 9 7 0 1 5 6 3 2 







*/