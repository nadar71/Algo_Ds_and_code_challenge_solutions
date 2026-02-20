// t: O(N) s: O(1)

fun main(){  
    println(fatt_01(5))
    println(fatt_02(5))

}


fun fatt_01(num: Int): Int{
    var res = 1
    var n = num
    while (n > 0){
        res = res * n
        n--
    }
    return res
}


fun fatt_02(num:Long): Long{
    var res: Long = 1
    for(i in num downTo 1 step 1) res = res * i
    return res
}


