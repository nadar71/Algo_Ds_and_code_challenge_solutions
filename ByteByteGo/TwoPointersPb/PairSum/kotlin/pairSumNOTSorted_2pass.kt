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
    // val list = mutableListOf<Int>()        // -> []
    val list = mutableListOf(4,-3,-1,7,3,11,8)   // -> [4, 0, 2, 6]
    // val list = mutableListOf(7)            // -> []
    // val list = mutableListOf(3,4)        // -> [0, 1]
    // val list = mutableListOf(4,3)        // -> [0, 1]
    // val list = mutableListOf(3,5)        // -> []
    // val list = mutableListOf(5,3)        // -> []
    // val list = mutableListOf(3,4,3)        // -> [0, 2]
    // val list = mutableListOf(3,4,4)        // -> [0, 2]
    // val list = mutableListOf(3,-1,4)       // -> [0, 2]
    // val list = mutableListOf(-4,-1,2,-3,)    // target -7 -> [3, 0]

    for((index,value) in list.withIndex()){
      hashmap.put(value, index)    
    }
    
    
    for((key, value) in hashmap){
      val num = key 
      val key1 = target - num
      val value1 = hashmap[key1]
  
      if (value != null && value1 != null ) {
          result.add(value)
          result.add(value1)
          hashmap.put(key1, null)
      }       
    }
    println(result)
    
}
