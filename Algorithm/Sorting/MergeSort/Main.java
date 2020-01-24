


public class Main{

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i + " "); 
		System.out.println("");
	}
	
	public static void main(String args[]){
	  
		MergeSort bs = new MergeSort();
		int[] arr = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
		printArray(bs.mergeSort(arr));
		
		MergeSort_02 ms = new MergeSort_02();
		int[] arr2 = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
		printArray(ms.mergeSort(arr2));


	}

}