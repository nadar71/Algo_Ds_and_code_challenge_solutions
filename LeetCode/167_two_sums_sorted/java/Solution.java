
// TODO : Emprove memory usages
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (result.length <= 0 ) return result;
        
        int low = 0;
        int high = numbers.length - 1;
        
        while(low < high){
            if (numbers[low] + numbers[high] < target) low++;
            else if (numbers[low] + numbers[high] > target) high --;
            else break;
        }
        
        if(low < high){
            result[0] = ++low;
            result[1] = ++high;
        }
        
        return result;         
    }
}



/*
RESULT :
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 39.4 MB, less than 32.66% of Java online submissions for Two Sum II - Input array is sorted.
Next challenges:
Two Sum IV - Input is a BST
Two Sum Less Than K
*/