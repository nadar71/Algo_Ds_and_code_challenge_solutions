public class Main{

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i + " "); 
		System.out.println("");

	}
	
	public static void main(String args[]){
		int[] arr = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
		BucketSort bs = new BucketSort(arr);		
		printArray(bs.sort(0,700));
		
		
		int[] arr1 = {3,4,2,1,6,5,7,8,1,1};         
        bs = new BucketSort(arr1);
        printArray(bs.sort(0, 20));

	    int[] arr2 = {30,43,21,31,26,45};
        bs = new BucketSort(arr2);
        printArray(bs.sort(20, 50));


	}

}