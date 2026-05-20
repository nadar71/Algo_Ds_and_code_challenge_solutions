// t: O(n) 
// s: O(n)


fun printArrayDuplicate(arr: Array<Int>?){
    if (arr == null || arr.size <= 0) {println("Empty array."); return}
    var duplicateFound = false
    val hashMap = HashMap<Int,Int?>()
    for((i,v) in arr!!.withIndex()){
        if (hashMap[v] != null) {
            println("duplicate: ${i}")
            duplicateFound = true
        }
        else hashMap.put(v,i)
    } 
    println("Are there duplicates? ${duplicateFound}")
}


fun main(){
    val arr_01 = arrayOf(1,2,3,4,5,6,7)
    printArrayDuplicate(arr_01)
    
    val arr_02 = arrayOf(1,2,2,3,4,5,5,6,7,4)
    printArrayDuplicate(arr_02)  
    
    val arr_03 = emptyArray<Int>()
    printArrayDuplicate(arr_03)   
    
    val arr_04 = null
    printArrayDuplicate(arr_04) 
    
}
