// Given an array of integers sorted in ascending order and a target value, 
// return the indexes of any pair of numbers in the array that sum to the target. 
// The order of the indexes in the result doesn't matter. 
// If no pair is found, return an empty array.


// with 2 pass, 1st to store all array in hashmap : 
// t: O(n)+O(m) ~ O(n)
// s: O(n)


fun main() {
    // val target = -7
    val target = 7
    val result = ArrayList<Int?>()
    val hashmap = hashMapOf<Int,Int?>()
    
    // val arr = arrayOf<Int>()        // -> []
    val arr = arrayOf(4,-3,-1,7,3,11,8)   // -> [4, 0, 2, 6]
    // val arr = arrayOf(7)            // -> []
    // val arr = arrayOf(3,4)        // -> [0, 1]
    // val arr = arrayOf(4,3)        // -> [0, 1]
    // val arr = arrayOf(3,5)        // -> []
    // val arr = arrayOf(5,3)        // -> []
    // val arr = arrayOf(3,4,3)        // -> [0, 2]
    // val arr = arrayOf(3,4,4)        // -> [0, 2]
    // val arr = arrayOf(3,-1,4)       // -> [0, 2]
    // val arr = arrayOf(-4,-1,2,-3,)    // target -7 -> [3, 0]

    for(i in 0..arr.size - 1 ){
      hashmap.put(arr[i], i)    
    }
    
    
    for((key, value) in hashmap){
      val targetKey = target - key
  
      if (value != null && hashmap[targetKey] != null ) {
          result.add(value)
          result.add(hashmap[targetKey])
          hashmap.put(targetKey, null) // delete used value to avoid duplicated in revers order
      }       
    }
    println(result)
    
} 
