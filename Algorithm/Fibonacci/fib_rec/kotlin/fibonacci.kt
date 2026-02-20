// t:O(2^N) s:O(1)

fun main(){  
    println(fibRec(5))
}


fun fibRec(n:Int): Int{
    if (n <= 1) return n
    return fibRec(n-1)+fibRec(n-2)
}

