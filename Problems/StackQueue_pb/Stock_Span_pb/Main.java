
public class Main{

    public static int[] stackSpanRange_bruteforce(int[] arr){
    	int[] stockRange = new int[arr.length];
    	stockRange[0] = 1;
    	for(int i=1; i<arr.length; i++){
    		stockRange[i] = 1;
    		for(int j=i-1; ((j>=0) && (arr[i] >= arr[j]) ); j--){
    			stockRange[i]++;
    		}
    	}
    	return stockRange;
    }

    public static void  printArr(int[] arr){
    	for(int i:arr ) System.out.print(i + " ");
    		System.out.println("");

    	
    }
	public static void main(String[] args){
		int[] stocks = {10,7,5,2,1,3,6,8,11};
		printArr(stackSpanRange_bruteforce(stocks));


	}

}


/*
1 1 1 1 1 3 5 7 9 
*/