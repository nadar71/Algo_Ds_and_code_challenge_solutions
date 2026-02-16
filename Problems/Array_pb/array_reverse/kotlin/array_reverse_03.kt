
// kotlin
// 1 and 2  pointer solution: t: O(n), s: O(1)

fun main(){
    val test = arrayOf(1,2,3,4,5)
    printArray(test)
    invArray_01(test)
    printArray(test)
    invArray_02(test)
    printArray(test)
}


// 1 pointer solution: t: O(n), s: O(1)
fun invArray_01(array: Array<Int>){
    val size   = array.size      
    val middle = size/2   
             
    for(i in 0 until middle){  
        var tmp         = array[size-1-i]
        array[size-1-i] = array[i]
        array[i]        = tmp       
    }        
}

// 2 pointer solution: t: O(n), s: O(1)
fun invArray_02(array: Array<Int>){
    var start = 0
    var end   = array.size-1
             
    while(start < end){  
        val tmp = array[start]
        array[start] = array[end]
        array[end] = tmp
        start++ 
        end--       
    }
}


inline fun <reified T> printArray(array: Array<T>){
    for(item in array){
        print(" $item ")
    }
    println()
}



