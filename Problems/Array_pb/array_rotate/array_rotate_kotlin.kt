fun main(){
    var test = arrayOf(1,2,3,4,5,6,7)
    rotateLeft(test,3)
    printArray(test)
    test = arrayOf(1,2,3,4,5,6,7)
    rotateRight(test,5)
    printArray(test)
    
    test = arrayOf()
    rotateLeft(test,3)
    printArray(test)
    test = arrayOf()
    rotateRight(test,4)
    printArray(test)
    
    test = arrayOf(2,3,4,5)
    rotateLeft(test,6)
    printArray(test)
    test = arrayOf(2,3,4,5)
    rotateRight(test,7)
    printArray(test)  
}



fun rotateLeft(array: Array<Int>, k: Int){
    val length = array.size
    var r = k
    if (k == 0 || k == length || length == 0) return
    if (k > length) r = k - length
    
    reverseArray(array, 0, r-1)
    reverseArray(array, r, length-1)
    reverseArray(array, 0, length-1)   
}



fun rotateRight(array: Array<Int>, k: Int){
    val length = array.size
    var r = k
    if (k == 0 || k == length || length == 0) return
    if (k > length) r = k - length
    
    reverseArray(array, 0, length-1-r)
    reverseArray(array, length-r, length-1)
    reverseArray(array, 0, length-1)   
}

fun reverseArray(array: Array<Int>, start: Int, end: Int){ 
    var s = start
    var e = end
    while(s<e){  
        val tmp = array[s]
        array[s] = array[e]
        array[e] = tmp
        s++ 
        e--       
    }
}


inline fun <reified T> printArray(array: Array<T>){
    println("\nwrite array content: ")
	for(item in array){
        print(" $item ")
    }    
}
