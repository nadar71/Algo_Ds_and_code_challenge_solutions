
class Convert_base{
    val mask: String = "0123456789ABCDEF";
    val conversion: ArrayList<Char> = ArrayList<Char>()

    fun convert(num: Int, base: Int){
        var digit  = num % base
        var result = (num / base).toInt()
        if (result > 0 ) convert(result,base)
        conversion.add(mask.get(digit))
    }

    fun convertToBase(num: Int, base: Int){
        conversion.clear()
        convert(num, base)
        for(c in conversion) print(c)
        println()
    }




}

fun main(){
    val conv = Convert_base()
    conv.convertToBase(12,16)
    conv.convertToBase(124,16)
    conv.convertToBase(6,8)
    conv.convertToBase(12,8)
    conv.convertToBase(12,2)
    conv.convertToBase(112,2)
    conv.convertToBase(0,2)
    conv.convertToBase(1,2)
    conv.convertToBase(2,2)
}


/*
C
7C
6
14
1100
1110000
0
1
10

*/