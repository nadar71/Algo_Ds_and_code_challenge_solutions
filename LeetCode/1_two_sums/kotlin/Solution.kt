


/*
TODO : Emprove
*/

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var result: IntArray = IntArray(2)
        if (nums.size <=0 ) return result

        var hm = HashMap<Int, Int>()               
        
        for(i in nums.indices){
            var check = target - nums.get(i)
            if (hm[check] != null)  {
                result.set(0, hm[check]!!)
                result.set(1, i)
                return result
            } else 
                hm.put(nums.get(i),i)
        
        }
        return result       
     }
}


/*
RESULT :
Runtime: 192 ms, faster than 70.41% of Kotlin online submissions for Two Sum.
Memory Usage: 37.2 MB, less than 54.33% of Kotlin online submissions for Two Sum.
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