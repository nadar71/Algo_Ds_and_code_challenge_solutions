
// t: O(m) where m>n, greatest array size 
// s: O()

import kotlin.math.abs

fun findPairSum2Arrays(a1: Array<Int>, a2: Array<Int>, sum: Int): ArrayList<Int>?{
    if (a1.size == 0 || a2.size == 0 ) return null
    val result = ArrayList<Int>() 
    val hashmap = HashMap<Int,Int>()
    var arrayMax = arrayOf<Int>()
    var arrayMin = arrayOf<Int>()    
    val s1 = a1.size-1
    val s2 = a2.size-1
    var min = 0
    var max = 0
	if (s1 > s2) {
        max = s1 
        arrayMax = a1
        min = s2
        arrayMin = a2
    } else {
        max = s2 
        arrayMax = a2
        min = s1
        arrayMin = a1
    }
    
    for ((i,v) in arrayMax.withIndex()){
        val value  = arrayMax[i] 
        val target = sum - value
        val stored = hashmap.get(target)
        if (i < min){
            val item = arrayMin[i]
            if (hashmap.get(item) == null ) hashmap.put(item,i)
        }
        if (hashmap.get(target) != null) {
            result.add(i)
            result.add(hashmap.get(target)!!)
        }		
    }
    return result
}


fun printArray(arr: ArrayList<Int>?){
    if (arr == null) println("Empty array")
    else for(i in arr) print("${i},")
}


fun main(){
    val arr_01 = arrayOf(1,7,3,4,5,2,0)    
    val arr_02 = arrayOf(2,1,3,5,4,2,1,0,9,7)
	printArray(findPairSum2Arrays(arr_01, arr_02, 6))
    
    println()
    val arr_03 = arrayOf(1,-7,-3,4,-5,2,0)    
    val arr_04 = arrayOf(-2,1,-3,-5,-4,-2,-1,0,9,7)
	printArray(findPairSum2Arrays(arr_03, arr_04, 4))
   
    
}
