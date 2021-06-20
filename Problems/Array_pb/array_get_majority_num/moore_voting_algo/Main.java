/*
- get a count var, set index idxMaj for current majority value, and set it equal to the first item index, 0
- scan array, increase count when arr[i] == arr[idxMaj] , decrease otherwise.
- if count == 0, the candidate has changed, so put idxMaj = i, count = 1
- at the end of first scan, the candidate = arr[idxMaj]
- count how many time it appears inside the arr, then check if > n/2
*/


public class Main{

    public static int findMajorityNum(int[] arr){
    	int count = 1;
    	int idxMaj = 0;
    	int candidate = -1;

    	for(int i=1; i < arr.length; i++){
    		if(arr[i] == arr[idxMaj]) count++;
    		else count--;

    		if( count == 0 ) {
    			idxMaj = i;
    			count = 1;
    		}
    	}

    	candidate = arr[idxMaj];
    	count = 0;
    	for(int i=0; i < arr.length; i++)
    		if (candidate == arr[i]) count++;

    	if (count > (int) arr.length/2) return candidate; else return -1;


    }



	public static void main(String args[]){
		int[] test_01 = {3, 3, 4, 2, 4, 4, 2, 4, 4, 4};
		System.out.println("Majority item : " + findMajorityNum(test_01));

		int[] test_02 = {3, 3, 4, 2, 4, 4, 2};
		System.out.println("Majority item : " + findMajorityNum(test_02));
		
		int[] test_03 = {3, 3, 3, 2, 3, 3, 2, 4};
		System.out.println("Majority item : " + findMajorityNum(test_03));

	}
}

/*
Majority item : 4
Majority item : -1
Majority item : 3

*/
