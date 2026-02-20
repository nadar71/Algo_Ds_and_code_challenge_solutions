
// reverse only a part of the array, from start to end: t: O(n), s: O(1)

fun main(){
    var test = arrayOf(1,2,3,4,5,6,7)
    printArray("original array: ",test)
   
    reverseArrayPart(test, 0, 3)
    printArray("reverseArrayPart(0,3)",test)
    
    test = arrayOf(1,2,3,4,5,6,7)
    reverseArrayPart(test, 4, 6)
    printArray("reverseArrayPart(4,6)",test)
}

fun reverseArrayPart(array: Array<Int>, start: Int, end: Int){ 
    var s = start
    var e = end
    while(s<e){  
        val tmp  = array[s]
        array[s] = array[e]
        array[e] = tmp
        s++ 
        e--       
    }
}

inline fun <reified T> printArray(msg: String, array: Array<T>){
    println(msg)
	for(item in array){
        print(" $item ")
    }  
    println()
}

