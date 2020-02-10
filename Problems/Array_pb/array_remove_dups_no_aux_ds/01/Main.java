/*
Remove duplicates in an array without using another ds
*/


/*
Brute force solution:
Using 1st assumption :  is the nums all positive ones, or in a range ?
- if in range, I can pass 1 time the array and substituting the duplicates with -1
- then in a second pass, I'll substitute -1 with the next != -1 number
in both case t : O(n)

==> if it is negative too, I can use Integer[] so it admit the null value, and substitute the null values as above
      
    

*/

import java.util.HashMap;
import java.util.Map;

public class Main{



    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = tmp;
        
    }
    
	public static void removeDup(int[] arr){
	    if (arr.length <=0 ){
	        System.out.println("Array empty");
	        return;
	    }
	    
	    int idx = 1;
	    int length = arr.length;

	    while(idx < length){
	        if(arr[idx] == arr[idx-1]){
	            int currentDup = arr[idx];
	            while(idx < length && arr[idx] == currentDup){ 
	                arr[idx] = -1;
	                idx++;
	            }
	        } else idx++;
	     }
	        
	    printArray(arr);
	    System.out.println("");
	    
	    idx = 0;
	    int idxNextItem = 0;
	    int count = 0;

	    while( idx < length){ 
	        if(arr[idx] == -1){
	            idxNextItem = idx;
	            
	            while(idxNextItem < length-1 && arr[idxNextItem] == -1 )  idxNextItem++;
	            
	            swap(arr, idx, idxNextItem);
	        } 
	        
	        if(arr[idx] != -1) count++; 
	        
	        idx++;
	    }
	    
	    printArray(arr);
	    System.out.println("New length : "+count);
	    System.out.println("");
	    
	}
	
	public static void printArray(int[] arr){
	    for(int i: arr) System.out.print(" " + i);
	    System.out.println("");
	    
	}

	public static void main(String args[]){
		int[] arr = {1,1,2};
		removeDup(arr);

		int[] arr1 = {0,0,1,1,1,2,2,2,2,2,3,3,4};
		removeDup(arr1);

		int[] arr2 = {1,1,1,1,1,1,1,1};
		removeDup(arr2);
		
		
		int[] arr3 = {1,2,2,2,2,2};
		removeDup(arr3);

	}
}
