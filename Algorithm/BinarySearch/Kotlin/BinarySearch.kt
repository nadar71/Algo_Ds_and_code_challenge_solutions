// t: O(logN) (log base 2)
// s: O(1)


fun binarySearch(arr: Array<Int>, value: Int): Int{
    var mid = 0
    var low = 0
    var high = arr.size - 1

    while (low <= high){
        mid = ((low + high)/2).toInt()
        if ((value) > arr[mid]) low = mid + 1
        else if ((value) < arr[mid]) high = mid - 1
        else return mid

    }
    return -1
}


// OR, in case not present, suggest the index for insertion

fun binarySearch_01(arr: Array<Int>, value: Int): Int{
    var mid = 0
    var low = 0
    var high = arr.size - 1

    while (low < high){
        mid = ((low + high)/2).toInt()
        if (arr[mid] >= value) high = mid
        else low = mid + 1

    }
    
    return low
}



fun main(){
    val arr = arrayOf(1,2,3,4,5,6,7)
    println(binarySearch(arr,5))

    val arr = arrayOf(1,2,3,4,6,7)
    println(binarySearch(arr,5))
    
}
