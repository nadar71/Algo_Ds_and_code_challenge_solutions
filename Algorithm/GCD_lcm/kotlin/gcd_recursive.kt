// GCD recursive
// t: O(N) s: O(1)


fun main(){    
    println(GCD(270, 192))
}



fun GCD(a: Int, b: Int): Int{
    var r = a%b
    var q = a/b
    if (r > 0) return GCD(b,r) else return b
}
