fun main(){  
    val binDigits = arrayOf(0,1)
    val octDigits = arrayOf(0,1,2,3,4,5,6,7,8)        
    val hexDigits = arrayOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
    val digits = StringBuilder()
    
    
    
    fun baseConversion(num: Int, base: Int){
        val digit = num % base
        val result = (num /base).toInt()
        if (result > 0 ) baseConversion(result, base)
        digits.append(
	        when(base){
                2  -> binDigits[digit]
                8  -> octDigits[digit]
                else -> hexDigits[digit]
            }
        )
    }   
    
    baseConversion(12,16)
    println(digits)
    digits.clear()

    baseConversion(250,16)
    println(digits)
    digits.clear()

    baseConversion(100,8)
    println(digits)
    digits.clear()

    baseConversion(12,2)
    println(digits)
    digits.clear()
}


/*
C
FA
144
1100
*/

