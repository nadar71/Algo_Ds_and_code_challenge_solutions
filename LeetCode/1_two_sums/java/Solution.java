/*
NOTES

TESTS
[] 
[1,2,3]  target = 6
[2, 7, 11, 15], target = 9
[-3,4,3,90]   0

SOLUTIONS
Solution_05
apart all the other solutions that I've designed in [1], another could be this :
- sort the array
- get a number
- make target - number = diff 
- apply binary search between number position and the end of array

*/
import java.util.Arrays;
// import java.util.Math;

/* solution with sorting: not allowed
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length <= 0) return result;
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            if (nums[low]+nums[high] < target) low++;
            else if (nums[low]+nums[high] > target) high--;
            else break;
        }
        
        if (low < high) {
            result[0] = low;
            result[1] = high;
        }
        return result;   
        
    }
*/

// Solution using hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length <= 0) return result;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0 ; i < nums.length; i++){
            int check = target-nums[i];
            if(hm.get(check) != null ) {
                result[0] = hm.get(check);
                result[1] = i ;
                return result;
            } else hm.put(nums[i],i); // store the index in nums, not the value
        }
        return result;
    }
}


/*
es. 
target = 7
nums = {1,5,2,7}

i = 0 nums[0] = 1
check = 7-1 = 6
hm.get(6) = null => hm.put(1,0)

i = 1 nums[1] = 5
check = 7-5 = 2
hm.get(2) = null => hm.put(5,1)


i = 2 nums[2] = 2
check = 7-2 = 5
hm.get(5) != null => result[0] = hm.get(5) = 1  
                     result[1] = 2 

*/


/*
RESULT
Runtime: 1 ms, faster than 73.38% of Java online submissions for Two Sum.
Memory Usage: 39.2 MB, less than 44.92% of Java online submissions for Two Sum.
Next challenges:
3Sum
4Sum
Two Sum II - Input array is sorted
Two Sum III - Data structure design
Subarray Sum Equals K
Two Sum IV - Input is a BST
Two Sum Less Than K
Max Number of K-Sum Pairs
Count Good Meals
*/                     