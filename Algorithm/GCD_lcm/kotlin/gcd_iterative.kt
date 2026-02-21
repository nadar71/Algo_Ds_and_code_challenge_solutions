// GCD iterative
// t: O(N) s: O(1)

fun main(){    
    println(GCD(270, 192))
    println(GCD(36, 24))
}



fun GCD(dividend: Int, divisor: Int): Int{
    var a = dividend
    var b = divisor
    var r = a%b
    var q = a/b
    while (r > 0){        
        a = b    // divisor become dividend :        
        b = r    // reminder become divisor :                 
        r = a%b  // compute new r                
        q = a/b  // compute new q          
    }
    return b
}

