/*
Print the duplicates in unsorted array
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Main{



	public static void printDup(int[] arr){
	    if (arr.length <=0 ){
	        System.out.println("Array empty");
	        return;
	    }
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for(int item : arr){
			Integer check = hm.get(item) ;
			if ( check == null) hm.put(item,1);
			else if (check >= 1) {
			    hm.put(item, ++check);
			    System.out.println("Duplicated value : "+item);
			}
		}
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
