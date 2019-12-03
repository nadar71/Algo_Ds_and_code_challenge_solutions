

public class Main{

	public static void printArray(int[] arr){
		for(int i:arr) System.out.print(i + " "); 
		System.out.println("");

	}
	
	public static void main(String args[]){
		BubbleSortImproved bs = new BubbleSortImproved();
		int[] arr = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};

		printArray(bs.sorting(arr));


	}





}