// Given an array of integers sorted in ascending order and a target value, 
// return the indexes of any pair of numbers in the array that sum to the target. 
// The order of the indexes in the result doesn't matter. 
// If no pair is found, return an empty array.

// t: O(n), s: O(1)
fun main(){  
    // val target = -7
    val target = 7
    
    // test case
    // val list = arrayOf<Int>()             // -> []
    val list = arrayOf(-3,-1,3,4,7,8,11)     // -> [1, 5, 2, 3]
    // val list = arrayOf(7)                 // -> []
    // val list = arrayOf(1,1,1,1)           // -> []
    // val list = arrayOf(3,4)               // -> [0, 1]
    // val list = arrayOf(3,5)               // -> []
    // val list = arrayOf(3,3,4)             // -> [0, 2]
    // val list = arrayOf(-1,3,4)            // -> [1, 2]
    // val list = arrayOf(-4,-3,-1)          // target = -7 -> [0, 1]
    
    pairSumToTarget(list, target)
}


// 2 pointers, sorted array
fun pairSumToTarget(array: Array<Int>, target: Int): ArrayList<Int>? {
    val result = ArrayList<Int>() // store the items pair summing to target or empty array
    var start = 0
    var end   = array.size-1
    
    if (end <= 0 ) { println(result); return null }
    
    while(start < end){
        val test = array[start] + array[end]
        when  {
            test < target -> start++
            test > target -> end--
            else -> {
                result.add(start)
                result.add(end) 
                start++
                end--
            } 
        }
    }    
    println(result)
    return result
}

