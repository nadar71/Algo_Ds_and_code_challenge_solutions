
class ArrayUtil{

  int arr[];
  
  public void setArray(int[] data){
    arr = data;
  }
  
	// swap array values
	public void swap( int i, int j){
		int tmp = arr[i];
		arr[i]  = arr[j];
		arr[j]  = tmp;
	}


	public void permutation( int start, int end){
	    if (start == end ) {
	      printArray();
	      return;
	    }


      for(int i = start; i <= end; i++){
  	    	swap(start, i);
  	    	permutation(start+1, end);
  	    	swap(start, i);
  	  }

	}

    public void printArray(){
    	for(int i: arr) System.out.print(i + " ");
    	System.out.println("");
    }
}

public class Main{

    public static void main(String args[]){
    	ArrayUtil util = new ArrayUtil();
    	int[] data = {1,2,3};
    	util.setArray(data);
    	util.permutation(0, data.length-1);
    }

}

/*
num of permutations : 3! = 6

1 2 3 
1 3 2 
2 1 3 
2 3 1 
3 2 1 
3 1 2 

*/