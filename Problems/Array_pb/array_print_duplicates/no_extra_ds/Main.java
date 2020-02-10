/*
Print the duplicates in unsorted array
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays;

public class Main{


	public static void printDup(int[] arr){
		if (arr.length <=0 ){
	        System.out.println("Array empty");
	        return;
	    }
        Arrays.sort(arr);
        printArray(arr);
	    int length = arr.length;
	    int i = 0;
	    for(int j = 1; j < length; j ++){
	    	if( arr[j] != arr[i]){
	    	  i++;
	    	  arr[i] = arr[j];
	    	}
            else System.out.println("Find a duplicate for "+arr[i]+" at position : "+j);
	    }

	}
	
	public static void printArray(int[] arr){
    	for(int i: arr) System.out.print(i + " ");
    	System.out.println("");
    }

	public static void main(String args[]){
		int[] arr = {11,3,2,1,2,3,5,66,7,3,1,4,5,77,8,5,2,11};
		printDup(arr);

		int[] arr1 = {};
		printDup(arr1);

		int[] arr2 = {1,1,1,1,1,1,1,1};
		printDup(arr2);

	}
}


/*
1 1 2 2 2 3 3 3 4 5 5 5 7 8 11 11 66 77 
Find a duplicate for 1 at position : 1
Find a duplicate for 2 at position : 3
Find a duplicate for 2 at position : 4
Find a duplicate for 3 at position : 6
Find a duplicate for 3 at position : 7
Find a duplicate for 5 at position : 10
Find a duplicate for 5 at position : 11
Find a duplicate for 11 at position : 15
Array empty
1 1 1 1 1 1 1 1 
Find a duplicate for 1 at position : 1
Find a duplicate for 1 at position : 2
Find a duplicate for 1 at position : 3
Find a duplicate for 1 at position : 4
Find a duplicate for 1 at position : 5
Find a duplicate for 1 at position : 6
Find a duplicate for 1 at position : 7



*/