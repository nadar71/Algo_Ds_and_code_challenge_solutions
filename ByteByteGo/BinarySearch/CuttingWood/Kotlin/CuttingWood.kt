// You are given an array representing the heights of trees, and an integer k representing the total length of wood that needs to be cut.
// For this task, a woodcutting machine is set to a certain height, H. 
// The machine cuts off the top part of all trees taller than H, while trees shorter than H remain untouched. 

// Determine the highest possible setting of the woodcutter (H) so that it cuts at least k meters of wood ( they can be more than k) 
// Assume the woodcutter cannot be set higher than the height of the tallest tree in the array.
 
 
// overall : 
// t: O(nlog(m))
// s: O(1)


// t: O(log(m))
fun cutting_wood(heights: ArrayList<Int>, k: Int): Int{
    var left = 0
    var right = arrayMax(heights) 
    
    while(left < right){
        // Bias the midpoint to the right during the upper-bound binary search.
        var mid = (left + right)/2 + 1
        if (cutsEnoughWood(mid, k, heights)) left = mid
        else right = mid - 1                
    }
    return right
}


// t: O(n)
fun cutsEnoughWood(H: Int, k: Int, heights: ArrayList<Int>): Boolean{
    var woodCut = 0
    for(height in heights){
        if (height > H) woodCut += (height - H)
    }  
    return woodCut >= k
}

fun arrayMax(a: ArrayList<Int>): Int{
    var max = 0
    for( i in a) if (i > max) max = i
    return max   
}

fun printArray(arr: ArrayList<Int>?){
    if (arr == null) println("Empty array")
    else for(i in arr) print("${i},")
}

fun main(){
    val arr_01 = arrayListOf(1,7,23,44,25,12,0)       
	println(cutting_wood(arr_01,12))
    
    val arr_02 = arrayListOf(2, 6, 3, 8)       
	println(cutting_wood(arr_02, 4))
    
    val arr_03 = arrayListOf(2,4,13,24)       
	println(cutting_wood(arr_03, 10))
}
