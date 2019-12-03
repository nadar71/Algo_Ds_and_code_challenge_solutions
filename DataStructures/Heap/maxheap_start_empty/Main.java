import java.util.ArrayList;

class MaxPriorityQueue{
  int length;
  ArrayList<Integer> arr;
  int middleIndex;
  int greatest = -1; // STORE the greatest of the 2 children


  // init with an external array
  public  MaxPriorityQueue(int[] array){
     arr    = new ArrayList<Integer>();
     length = arr.size();
     for(int i: array) arr.add(i);        
  }



  public void createPriorityQueue(){
    length      = arr.size();
    middleIndex = (int) ( (length-1)/2 );

    for(int i = middleIndex; i>=0; i--) goDown(i);  // go to the start of the array, down with index
  }



  // store value y in x and viceversa
  public void swap(int idx1,int idx2){
      int tmp    = arr.get(idx1);
      arr.set(idx1, arr.get(idx2));
      arr.set(idx2, tmp);
  }




  // used by create a new heap from array or add a new element, to keep the heap a max/min heap
  // percolate down items not in order to maintain a the greatest/smallest value
  public void goDown(int pos){
    int left  = 2*pos+1;
    int right = left +1;

    if (left  < length)   greatest = left;  // init from left child
    if (right < length && arr.get(right)    > arr.get(left) ) greatest = right; // take the greatest of the 2 children
    if (greatest != -1 && arr.get(greatest) > arr.get(pos) ){
      swap(pos,greatest);
      goDown(greatest);
    }
  }

  // used by add a new element, to keep the heap a max/min heap
  // percolate up a the greatest/smallest value
  public void goUp(int pos){
    int parent = (int) (pos-1)/2;
    int tmp;

    if (parent < 0) return;

    if (arr.get(parent) < arr.get(pos)){
      swap(parent,pos);
      System.out.println("\nSwap");
      printArr();
      goUp(parent);
    }
    System.out.println("\n");
  }


  // add a new element at the end of the array
  // then  using createPriorityQueue to keep max/min heap order
  public void add(int value){
    arr.add(value);    
    length = arr.size();
    createPriorityQueue();
  }

  // add a new element at the end of the array
  // then using goUp percolate up of th result to keep max/min heap order
  public void addAlternative(int value){
    arr.add(value);    
    length = arr.size();
    goUp(length-1);
  }




  // return the root value, that is the max value
  public int getHeapValue(){
    int heapValue = arr.remove(0);
    createPriorityQueue();
    return heapValue;
  }

  // remove generic item
  public void removeItem(int item){
    if (arr.contains(item) == false) {
      System.out.println("Item not present");
      return;
    }
    arr.remove(arr.indexOf(item));
  }


  public void printArr(){
    for(Integer i : arr) System.out.print(i+" ");
    System.out.println("");
  }
  
  /*
  
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
  
  
  // check the root value
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
  */
  
  

}



// MAIN  MaxPriorityQueue ---------------------------------------------------------------------

public class Main{

  public static void main(String args[]){
    int[] arr = {1,2,3,4,5,6,7,8};
    MaxPriorityQueue pq = new MaxPriorityQueue(arr);
    pq.createPriorityQueue();
    pq.printArr();

    System.out.println("\nAdd generic value : ");
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
    

  }
}

/*
8 5 7 4 1 6 3 2 

Add generic value : 
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
Item not present



*/