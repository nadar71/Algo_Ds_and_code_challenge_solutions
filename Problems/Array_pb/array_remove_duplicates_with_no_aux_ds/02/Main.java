/*
Brute force solution:
- using a workaround to remove duplicates and another to give the new length : must merge the 2
- using a time complexity : O(n^2)

updates on : https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
*/


class Main{
    
    public static void printArray(int[] arr){
	    for(int i: arr) System.out.print(" " + i);
	    System.out.println("");
	    
	}
	

    
    
    public static int newLengthWithoutDuplicates(int[] arr) {
        if (arr.length <=0 ){
	        return 0;
	    }
	    
	    int idx = 1;
	    int length = arr.length;
        int newLength = length;
        
        
	    while(idx < length){
	        if(arr[idx] == arr[idx-1]){
	            int currentDup = arr[idx];
	            while(idx < length && arr[idx] == currentDup){ 	                
	                idx++;
                    newLength--;
	            }
	        } else idx++;
	     }
	    
	    System.out.println("New length correct : "+newLength);
        return newLength;
        
    }
    
    
    
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = tmp;
        
    }
    
    public static void translateArrayOf(int[] arr, int start,int end ){
        int offset = (arr.length-1) - end;
        for(int i = 0; i < offset; i++){
            arr[start+i] = arr[end+i+1];
        }
    }
    
    
    
    public static int removeDuplicates(int[] arr) {
        if (arr.length <=0 ){
	        return 0;
	    }
	    
	    int result = newLengthWithoutDuplicates(arr);
	    
	    int idx = 1;
	    int length = arr.length;
        int newLength = length;
        
        
	    while(idx < length){
	        if(arr[idx] == arr[idx-1] && idx < newLength) {
	            int idxTmp = idx+1;
	            newLength--;
	            int currentDup = arr[idx];
	            while(idxTmp < length && arr[idxTmp] == currentDup){ 
	                idxTmp++;
                    newLength--;
	            }
	            translateArrayOf(arr, idx, idxTmp-1);
	        }
	        idx++;
	     }
	        
	    
	    printArray(arr);
	    System.out.println("New length : "+newLength);
	    System.out.println("");
	    
        // return newLength;
        return result;
        
    }
    

    
    
    


	public static void main(String[] args) {
		int[] arr = {1,1,2};
		newLengthWithoutDuplicates(arr);
		removeDuplicates(arr);

		
		int[] arr_a = {1,1,2,2,3};
		newLengthWithoutDuplicates(arr_a);
		removeDuplicates(arr_a);
		
		int[] arr_b = {1,1,2,2};
		newLengthWithoutDuplicates(arr_b);
		removeDuplicates(arr_b);
		
		int[] arr_c = {1,1,2,2,3,3};
		newLengthWithoutDuplicates(arr_c);
		removeDuplicates(arr_c);
		
		int[] arr_d = {1,1,2,2,3,3,3};
		newLengthWithoutDuplicates(arr_d);
		removeDuplicates(arr_d);

		int[] arr1 = {0,0,1,1,1,2,2,2,2,2,3,3,4};
		newLengthWithoutDuplicates(arr1);
		removeDuplicates(arr1);

		int[] arr2 = {1,1,1,1,1,1,1,1};
		newLengthWithoutDuplicates(arr2);
		removeDuplicates(arr2);
		
		
		int[] arr3 = {1,2,2,2,2,2};
		newLengthWithoutDuplicates(arr3);
		removeDuplicates(arr3);
		
	}
}
