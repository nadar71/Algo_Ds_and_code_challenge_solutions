

// t: O(n)
// s: O(1)

fun findMissing(arr: Array<Int>, range: Int): Int{
    if (arr.size == 0) return -1
    var xorSum = 0
    for (i in 0..range-1) xorSum = xorSum xor i
    for (i in arr)      xorSum = xorSum xor i
    return xorSum    
}


fun main(){
    val arr_01 = arrayOf(0,1,2,3,4,6,7,8,9,10,11,12)
    println("Missing number : " + findMissing(arr_01, 13))
    
    val arr_02 = arrayOf(0,1,2,3,4,5,6,7,8,9,10,12)
    println("Missing number : " + findMissing(arr_02, 13)) 
    
    val arr_03 = emptyArray<Int>()
    println("Missing number : " + findMissing(arr_03, 13))  
    
    val arr_04 = arrayOf(4,6,7,3,10,11,8,9,0,1,2,12)
    println("Missing number : " + findMissing(arr_04, 13))      
    
}
