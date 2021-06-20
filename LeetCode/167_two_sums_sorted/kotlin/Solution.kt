
// TODO : emprove speed
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var result = IntArray(2)
        if (numbers.size <= 0 ) return result
        
        var low = 0
        var high = numbers.size - 1
        
        while (low < high){
            if (numbers.get(low) + numbers.get(high) < target) low++
            else if (numbers.get(low) + numbers.get(high) > target) high--
            else break
        }
        
        
        if (low < high){
            result.set(0, ++low)
            result.set(1, ++high)
        }
        
        return result
        
    }
}


/*
RESULT
Runtime: 192 ms, faster than 60.67% of Kotlin online submissions for Two Sum II - Input array is sorted.
Memory Usage: 36.4 MB, less than 44.67% of Kotlin online submissions for Two Sum II - Input array is sorted.
Next challenges:
Two Sum IV - Input is a BST
Two Sum Less Than K
*/