// another 2 pointer solution

fun main() {
    val array = arrayOf(1,2,3,4,5,6)
    var size = array.size
    println("Forward : ")
    arrayPrint(array)       
    var index: Int = array.size/2-1
    var start = index
    var offset: Int = 0
    
    if (size % 2 == 0) offset = 1
    if (size % 2 > 0) offset = 2
    
    while( index >= 0){
        val tmp = array[index]
        array[index] = array[start + offset]
        array[start + offset] = tmp
        index--
        offset++
    }
    println("Reverted : ")
    arrayPrint(array)       
}

fun arrayPrint(array: Array<Int>){
    for(i in array ) println(i)
}

