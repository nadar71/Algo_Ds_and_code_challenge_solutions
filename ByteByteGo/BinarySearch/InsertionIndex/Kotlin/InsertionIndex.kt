// t: O(logN) (log base 2)
// s: O(1)

// You are given a sorted array that contains unique values, along with an integer target.
// - If the array contains the target value, return its index.
// - Otherwise, return the insertion index. 
//   This is the index where the target would be if it were inserted in order, maintaining the sorted sequence of the array.


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
