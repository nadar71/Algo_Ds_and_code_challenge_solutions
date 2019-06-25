import java.util.ArrayList;

class MaxPriorityQueue{
  int length;
  ArrayList<Integer> arr;
  int middleIndex;

  public  MaxPriorityQueue(){
     arr         = new ArrayList<Integer>();       
  }

  // init with an external array
  public  MaxPriorityQueue(int [] array){
     arr         = new ArrayList<Integer>();
     // init with array data
     for(Integer i: array) arr.add(i);        
  }



  public void createPriorityQueue(){
    length      = arr.size();
    middleIndex = (int) ( (length-1)/2 );

    for(int i = middleIndex; i>=0; i--){
      goDown(i);  // go to the start of the array, down with index
    }
  }

  public int cmp(int x, int y){
    return x-y;
  }


  // store value y in x and viceversa
  public void swap(int idx1,int idx2){
      int tmp    = arr.get(idx1);
      arr.set(idx1, arr.get(idx2));
      arr.set(idx2, tmp);
  }





  public void goDown(int pos){
    int left  = 2*pos+1;
    int right = left +1;

    int greatest = -1; // STORE the greatest of the 2 children
    int tmp;

    if (left  < length)   greatest = left;  // init from left child
    if (right < length && cmp(arr.get(right), arr.get(left))>0)  greatest = right; // take the greatest of the 2 children
    if (greatest != -1 && cmp(arr.get(greatest), arr.get(pos))>0){
      swap(pos,greatest);
      goDown(greatest);
    }
  }

  // used by add a new element, to keep the heap a min heap
  public void goUp(int pos){
    int parent = (int) (pos-1)/2;
    int tmp;

    if (parent < 0) return;

    if (cmp(arr.get(parent),arr.get(pos))<0){
      swap(parent,pos);
      System.out.println("\nSwap");
      printArr();
      goUp(parent);
    }
    System.out.println("\n");
  }


  // add a new element at the end of the array
  public void add(int value){
    arr.add(value);    
    length = arr.size();
    System.out.println("last item added : "+ arr.get(length-1) + " length : " + length +"\n");
    printArr();
    goUp(length-1);
  }


  // return the root value, that is the max value
  public int remove(){
    int value = arr.get(0);

    // move last element to root
    arr.set(0,arr.get(length-1));
    
    // delete last element and update length
    arr.remove(length-1);
    length = arr.size();

    System.out.println("Root removed, first iteration");
    printArr();
    
    // recover heap property
    goDown(0);
    return value;
  }



  public void printArr(){
    for(Integer i : arr) System.out.print(i+" ");
  }
  
  
  
  // filter  K smallest value from a stream ( here as array)
  public void filterKSmallest(int[] input, int k){
    if (k<=0) {
      System.out.println("K must be > 0");
      return;
    }
    
    
    if (k >= input.length) {
      System.out.println("K must be < input array size");
      return;
    }
    
    int length = input.length;
    int[] tmp  = copyArray(input,0,k-1);
    
    setQueueArray(tmp);
    createPriorityQueue();
  
    for(int i=k; i<input.length; i++){
      if (input[i] < rootPeek()) {
          setRoot(input[i]);
          goDown(0);
      }
    }
  }
  
    // helper methods 
  
  // set a new arraylist for MinPriorityQueue
  
  public void setQueueArray(int[] array){
    arr = new ArrayList<Integer>();
     // init with array data
     for(Integer i: array) arr.add(i);
    
  }
  
  
  // copy a part of the array in another
  public int[] copyArray(int[] input, int start, int end){
    int[] tmp = new int[end - start +1];
    for(int i=start; i<=end; i++ ) tmp[i] = input[i];
    return tmp;
  }
  
  
  // get the root value
  public int rootPeek(){
    return arr.get(0);
  }
  
  // set root
  public void setRoot(int value){
    arr.set(0,value);
  }
  
  // return heap arr
  public ArrayList<Integer> getHeapArr(){
    return arr;
  }
  
  // return the root value, that is the max value
  public void removeForHeapSorting(){
      
      if (length-1 < 0) return;

      // swap the root with last element
      swap(0, length-1);
  
      // decrease array's size by 1,to avoid to count the last element
      length--;
  
        // System.out.print("\nRoot swapped : ");
        // printArr();
      
      // recover heap property
      goDown(0);
  
  
        // after recover heap property
        // System.out.println("\nHeap recovered : ");
        // printArr();
  }
  
  
  public void HeapSort(){
      for(int i = 0; i <= arr.size(); i++) removeForHeapSorting();
  }
  
  

}



// MAIN  MaxPriorityQueue ---------------------------------------------------------------------

public class Main{

  public static void main(String args[]){
    int[] arr = {1,2,3,4,5,6,7,8};
    MaxPriorityQueue pq = new MaxPriorityQueue();


    for(int i=0; i<arr.length; i++){ pq.add(arr[i]); }
    pq.printArr();
    
    
    pq.add(9);
    pq.printArr();

    pq.add(1);
    pq.printArr();


  }
}