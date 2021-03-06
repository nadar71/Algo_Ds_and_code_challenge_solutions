import java.util.ArrayList;
class MinPriorityQueue{
  int length;
  ArrayList<Integer> arr;
  int middleIndex;

  public  MinPriorityQueue(){
     arr = new ArrayList<Integer>();
  }
  
  // init with an array
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

    int small = -1; // keep the smaller of the 2 children
    int tmp;

    if (left  < length) small = left;
    if (right < length && cmp(arr.get(right), arr.get(left))<0)  small = right;
    if (small != -1 && cmp(arr.get(small), arr.get(pos))<0){
      swap(pos,small);
      goDown(small);
    }
  }


  // used by add a new element, to keep the heap a min heap
  public void goUp(int pos){
    int parent = (int) (pos-1)/2;;
    int tmp;

    if (parent < 0) return;

    if (cmp(arr.get(parent),arr.get(pos))>0){
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
  
  
  public void printArr(){
    for(int i : arr) System.out.print(i+" ");
  }
  
  
  // filter  K largest value from a stream ( here as array)
  public void filterKLargestFromStream(int newNum, int k){
    // edge cases
    if (k<=0) {
        System.out.println("K must be > 0");
        return;
    }
  
    if (arr.size() < k) {
      add(newNum);
    } else {
      if (newNum > rootPeek()) {
          setRoot(newNum);
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




// ------------------------------ Test class
public class Main{

  public static void main(String args[]){
    int[] arr = {91,18,73,26,45,13,22,11,55,32,77,659,2,1,9,80,43,25,16,7,88,62,34,5,67,123};
    
    MinPriorityQueue pq = new MinPriorityQueue();

    int k = 5;
    System.out.println("First "+k+ " largest number in array");
    for(int i=0; i< arr.length; i++){
      pq.filterKLargestFromStream(arr[i],k);
    }
    pq.printArr();


    // check
    System.out.println("\nOrdered array :  ");
    MinPriorityQueue check = new MinPriorityQueue(arr);
    check.createPriorityQueue();
    check.HeapSort();
    check.printArr();


  }
}