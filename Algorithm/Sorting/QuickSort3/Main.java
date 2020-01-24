public class Main{

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i + " "); 
		System.out.println("");

	}
	
	public static void main(String args[]){
		QuickSort3 qs = new QuickSort3();
				
		// pivot is 12 at left 
		int[] arr1 = {12,2,3,4,665,3,2,4,6,8,9,3,2,13,47,89,18,14};
		printArray(qs.quickSort(arr1));
		
		// pivot is 12 almost in the middle
		int[] arr2 = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
		printArray(qs.quickSort(arr2));

		// pivot is 12 at left 
		int[] arr3 = {2,3,4,665,3,2,4,6,8,9,3,2,13,47,89,18,14,12};
		printArray(qs.quickSort(arr3));


	}

}