// t: O(N) s: O(N)
fun main(){  
    println(fatt(5L))
}


fun fatt(n:Long): Long{
    if (n == 1L) return n   
    return n*fatt(n-1)
}

