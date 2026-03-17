// Given an array of integers NOT sorted and a target value, 
// return the indexes of any pair of numbers in the array that sum to the target. 
// The order of the indexes in the result doesn't matter. 
// If no pair is found, return an empty array.


// with 1 pass only, storing + searching in hashmap : 
// t: O(n) the same as 2 pass but simplify code
// s: O(n)

fun main() {
    // val target = -7
    val target = 7
    val result = ArrayList<Int>()
    
    val hashmap = hashMapOf<Int,Int>()
    // val arr = arrayOf<Int>()        // -> []
    val arr = arrayOf(4,-3,-1,7,3,11,8)   // -> [4, 0, 6, 2]
    // val arr = arrayOf(7)            // -> []
    // val arr = arrayOf(3,4)        // -> [1, 0]
    // val arr = arrayOf(4,3)        // -> [1, 0]
    // val arr = arrayOf(3,5)        // -> []
    // val arr = arrayOf(5,3)        // -> []
    // val arr = arrayOf(3,4,3)        // -> [1, 0]
    // val arr = arrayOf(3,4,4)        // -> [1, 0, 2, 0]
    // val arr = arrayOf(3,-1,4)       // -> [2, 0]
    // val arr = arrayOf(-4,-1,2,-3,)    // target -7 -> [3, 0]

    
    for ( i in 0..arr.size-1){
        val num = arr[i]
        val searchedKey = target - num
        val index = hashmap[searchedKey]
        if (index != null){
          result.add(i)
          result.add(index)          
        } else hashmap.put(num, i)                
    }  
    println(result)
           
}
