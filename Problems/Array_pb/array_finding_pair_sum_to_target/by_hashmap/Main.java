
/*
Given an array of n numbers, find 2 elements such their sum is equal to x, the target.
Number in array can be negative.

Constrain added :
The return value is an array of integer rapresenting the index(not the value) of the 2 values, or an empty array if there is no couple.

Sorting is no more applicable, must use hashmap.


[]  target = 9
[1,2,3]  target = 6
[2, 7, 11, 15], target = 9
[-3,4,3,90]   target = 0

*/



import java.util.HashMap;

class Main {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length <= 0) return result;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0 ; i < nums.length; i++){
            int check = target-nums[i];
            if(hm.get(check) != null ) {
                result[0] = hm.get(check);
                result[1] = i ;
                return result;
            } else hm.put(nums[i],i);
        }
        return result;
    }  
        


    public static void main(String args[]){
    	
    	int target    = 9;
    	int[] result  = new int[2];

    	int[] test_01 = {};
    	result = twoSum(test_01,target);
    	if (result[0] != result[1]  ) System.out.println("The numbers are at position : "+result[0]+" and "+result[1]);
    	else System.out.println("Empty array or no solution ");

    	
    	target    = 6;
    	int[] test_02 = {1,2,3};
    	result = twoSum(test_02,target);
    	if (result[0] != result[1]  ) System.out.println("The numbers are at position : "+result[0]+" and "+result[1]);
    	else System.out.println("Empty array or no solution ");


    	
    	target    = 9;
    	int[] test_03 = {2, 7, 11, 15};
    	result = twoSum(test_03,target);
    	if (result[0] != result[1]  ) System.out.println("The numbers are at position : "+result[0]+" and "+result[1]);
    	else System.out.println("Empty array or no solution ");

    	target    = 0;
    	int[] test_04 = {-3,4,3,90};
    	result = twoSum(test_04,target);
    	if (result[0] != result[1]  ) System.out.println("The numbers are at position : "+result[0]+" and "+result[1]);
    	else System.out.println("Empty array or no solution ");
    	    

    }

}


/*
Empty array or no solution 
Empty array or no solution 
The numbers are at position : 0 and 1
The numbers are at position : 0 and 2

*/