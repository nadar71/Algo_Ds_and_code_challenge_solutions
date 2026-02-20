// t: O(n) s: O(1)


fun main(){
    var test = arrayOf(1,2,3,4,5,6,7)

    println("\nGeneric case:")
    printArray("Original array content: ",test)
    rotateLeft(test,3)
    printArray("rotateLeft(test,3)",test)
    test = arrayOf(1,2,3,4,5,6,7)
    rotateRight(test,5)
    printArray("rotateRight(test,5)",test)
    
    
    
    println("\nRotate Empty array")
    test = arrayOf()
    printArray("Original array content:  ",test)
    rotateLeft(test,3)
    printArray("rotateLeft(test,3)",test)
    test = arrayOf()
    rotateRight(test,4)
    printArray("rotateRight(test,4)",test)
    
    
    
    println("\nRotate with r > array length")
    test = arrayOf(2,3,4,5)
    printArray("Original array content: ",test)  
    rotateLeft(test,6)
    printArray("rotateLeft(test,6)",test)
    
    test = arrayOf(2,3,4,5)
    rotateLeft(test,9)
    printArray("rotateLeft(test,9)",test)
    
    test = arrayOf(2,3,4,5)
    rotateRight(test,7)
    printArray("rotateRight(test,7)",test)
    
    test = arrayOf(2,3,4,5)
    rotateRight(test,14)
    printArray("rotateRight(test,14)",test)

}



fun rotateLeft(array: Array<Int>, k: Int){
    val length = array.size
    var r = k
    if (k == 0 || k == length || length == 0) return
    if (k > length) r = k % length
    
    reverseArray(array, 0, r-1)
    reverseArray(array, r, length-1)
    reverseArray(array, 0, length-1)   
}



fun rotateRight(array: Array<Int>, k: Int){
    val length = array.size
    var r = k
    if (k == 0 || k == length || length == 0) return
    if (k > length) r = k % length
    
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


inline fun <reified T> printArray(msg: String, array: Array<T>){
    println(msg)
    for(item in array){
        print(" $item ")
    }  
    println()
}





/*
Generic case:
Original array content: 
 1  2  3  4  5  6  7 
rotateLeft(test,3)
 4  5  6  7  1  2  3 
rotateRight(test,5)
 3  4  5  6  7  1  2 

Rotate Empty array
Original array content:  

rotateLeft(test,3)

rotateRight(test,4)


Rotate with r > array length
Original array content: 
 2  3  4  5 
rotateLeft(test,6)
 4  5  2  3 
rotateLeft(test,9)
 3  4  5  2 
rotateRight(test,7)
 3  4  5  2 
rotateRight(test,14)
 4  5  2  3 
 */