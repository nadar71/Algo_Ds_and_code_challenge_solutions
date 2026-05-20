// t: O(n)  s: O(n)
fun printMaxOccurrencesNumber(arr: Array<Int>?){
    if (arr == null || arr.size <= 0) {println("Empty array."); return}
    var maxRepeats = 0
    var item = 0
    val hashMap = HashMap<Int,Int>() // value, repeats
    for((i,v) in arr!!.withIndex()){
        if (hashMap[v] != null) {
            var repeats = hashMap[v]!!
            repeats++
            hashMap.put(v,repeats)
            println("${v} repeats in hashMap[v]: ${hashMap[v]}")
            if (repeats > maxRepeats){
                maxRepeats = repeats
				item = v
            }                      
        }
        else hashMap.put(v,1)
    } 
    println("maxRepeats: $maxRepeats for item : $item")
}


fun main(){
    val arr_01 = arrayOf(1,2,3,4,5,6,7)
    printMaxOccurrencesNumber(arr_01)
    
    val arr_02 = arrayOf(1,2,2,3,4,5,5,6,7,4)
    printMaxOccurrencesNumber(arr_02)  
    
    val arr_03 = emptyArray<Int>()
    printMaxOccurrencesNumber(arr_03)   
    
    val arr_04 = null
    printMaxOccurrencesNumber(arr_04) 
    
    val arr_05 = arrayOf(1,2,2,3,4,5,5,3,6,7,4,3,3,7,3)
    printMaxOccurrencesNumber(arr_05)  
    
}
