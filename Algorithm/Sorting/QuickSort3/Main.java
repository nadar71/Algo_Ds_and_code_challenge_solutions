public class Main{

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i + " "); 
		System.out.println("");

	}
	
	public static void main(String args[]){
		QuickSort3 bs = new QuickSort3();
		
		int[] arr = {3,4,2,1,6};
		printArray(bs.sorting(arr));
		
		int[] arr1 = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
		printArray(bs.sorting(arr1));
		
		
		int[] arr2 = {47,89,18,14,2,3,4,665,3,2,4,6,8,9,3,2,12,13,1};
		printArray(bs.sorting(arr2));

	}

}