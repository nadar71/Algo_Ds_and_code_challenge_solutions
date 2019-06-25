import java.util.ArrayList;
class MinPriorityQueue{
  int length;
  ArrayList<Integer> arr;
  int middleIndex;


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

}





// MAIN  MinPriorityQueue ---------------------------------------------------------------------

public class Main{

  public static void main(String args[]){
    int[] arr = {9,8,7,6,4,3,2,1};
    MinPriorityQueue pq = new MinPriorityQueue();


    for(int i=0; i<arr.length; i++){ pq.add(arr[i]); }
    pq.printArr();
    
    
    pq.add(10);
    pq.printArr();

    pq.add(5);
    pq.printArr();

    pq.add(0);
    pq.printArr();


  }
}