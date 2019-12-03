import java.util.ArrayList;
class MinPriorityQueue{
  int length;
  ArrayList<Integer> arr;
  int middleIndex;
  int smallest = -1; // STORE the smallest of the 2 children



  public  MinPriorityQueue(){
     arr = new ArrayList<Integer>();
  }

  // init with an external array
  public  MinPriorityQueue(int [] array){
     arr = new ArrayList<Integer>();
     // init with array data
     for(Integer i: array) arr.add(i); 
  }

  public void createPriorityQueue(){
    length      = arr.size();
    middleIndex = (int) ( (length-1)/2 );

    for(int i = middleIndex; i>=0; i--){
      goDown(i);
    }
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

    if (left  < length) smallest = left;
    if (right < length && arr.get(right) < arr.get(left))  smallest = right;
    if (smallest != -1 && arr.get(smallest) < arr.get(pos)) {
      swap(pos,smallest);
      goDown(smallest);
    }
  }
  
  // used by add a new element, to keep the heap a min heap
  public void goUp(int pos){
    int parent = (int) (pos-1)/2;;
    int tmp;

    if (parent < 0) return;

    if (arr.get(parent) > arr.get(pos)) {
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
    for(int i : arr) System.out.print(i+" ");
    System.out.println("");
  }

}

