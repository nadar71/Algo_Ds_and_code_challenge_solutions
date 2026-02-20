// Compute fibonacci sequence till n : 
// t : O(N) s : O(1)

fun main(){  
    println(fib(5))

}

fun fib(n:Int): Int{
    var prev = 0
    var next = 1
    for(i in 1..<n){
        val tmp = next
        next = prev + next
        prev = tmp
    }
    return next
}

