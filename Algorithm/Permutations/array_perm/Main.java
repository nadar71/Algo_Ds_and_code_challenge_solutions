
/*
Integer array permutations
*/

public class Main{
    
    public static void swap(int[] arr, int i, int j){
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }

	public static void permutations(int[] arr, int i, int length){
		if (i == length) return
		int j=i;
	    for(j=i; j<length; j++){
	    	swap(i,j);
	    	printArray(arr);
	    	permutations(arr,i,j);
	    	swap(i,j);
	    	printArray(arr);
	    }
	}

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i+" ");
		System.out.print("");
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		permutations(arr,0,arr.length);


	}

}