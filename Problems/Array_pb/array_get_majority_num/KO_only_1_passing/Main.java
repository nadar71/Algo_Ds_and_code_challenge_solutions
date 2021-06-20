/*
** ERRORS
Only ne pass of the array, but it must be sorted
- t:O(nlogn)
- s:O(1)

*/

import java.util.Arrays;

public class Main{


	public static int findMajorityNum(int[] arr){
		int len = arr.length;		
		if (len <=0 ) return -1;		
		
		int i = 0;
		int max = -1;
		int currentMax = -1;
		int countMax = 0;
		int currentCountMax = 0;
		
		
		Arrays.sort(arr);

		for(int j=1; j<len; j++){
		  if (arr[j] != arr[i]) i++;
		  else{
		  	if (max != arr[i] ) {
		  	    if (countMax > currentCountMax){
		  	        currentMax = max;
		  		    currentCountMax = countMax;
		  		    System.out.println("currentMax : " + max +  " currentCountMax : " + currentCountMax  );
		  	    }
		  	    max = arr[i];
		  	    countMax = 1;
		  		System.out.println("max : " + max  );
		  	} else countMax++;
		  	System.out.println(" countMax : " + countMax );
		  }	
		}

		if (currentCountMax > ((int) len/2) ) return currentMax;
		else return -1;

	}

	

	public static void main(String args[]){
		int[] test_01 = {3, 3, 4, 2, 4, 4, 2, 4, 4, 4};
		System.out.println("Majority item : " + findMajorityNum(test_01));

		int[] test_02 = {3, 3, 4, 2, 4, 4, 2, 4};
		System.out.println("Majority item : " + findMajorityNum(test_02));
		
		int[] test_03 = {3, 3, 3, 2, 3, 3, 2, 4};
		System.out.println("Majority item : " + findMajorityNum(test_03));

	}
}