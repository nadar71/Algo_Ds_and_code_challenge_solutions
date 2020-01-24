

public class Main{


	public static long powerOf(long x, long n){
		if ( n == 0) return 1;
		else {
			return x * powerOf(x, n-1);		
		}
	}


	public static long powerOf_02(long x, long n){
		long value;
		if ( n == 0) return 1;
		else if (n%2 == 0){
			value = powerOf(x, (int)n/2);
			return value * value;
		} else {
			value = powerOf(x, (int)n/2);
			return x * value * value;		
		}
	}

	public static void main(String args[]){
		// powerOf
		System.out.println("Power of 45 at 7:"+powerOf(45L,7L));
		System.out.println("Power of 26 at 5:"+powerOf(26L,5L));
		System.out.println("Power of 13 at 8:"+powerOf(13L,8L));
		System.out.println("Power of 18 at 6:"+powerOf(18L,6L));
		System.out.println("Power of 13 at 0:"+powerOf(13L,0L));
		System.out.println("Long.MAX_VALUE at 23 :"+ Long.MAX_VALUE);
		System.out.println("Power of Long.MAX_VALUE at 23 (it will fails):"+powerOf(Long.MAX_VALUE,23L));
		System.out.println("Power of 23 at Long.MAX_VALUE (it will fails):"+powerOf(Long.MAX_VALUE,23L));


    System.out.println("-------------");
    
    
		// powerOf_02
		System.out.println("Power of 45 at 7:"+powerOf_02(45L,7L));
		System.out.println("Power of 26 at 5:"+powerOf_02(26L,5L));
		System.out.println("Power of 13 at 8:"+powerOf_02(13L,8L));
		System.out.println("Power of 18 at 6:"+powerOf_02(18L,6L));
		System.out.println("Power of 13 at 0:"+powerOf_02(13L,0L));
		System.out.println("Long.MAX_VALUE at 23 :"+ Long.MAX_VALUE);
		System.out.println("Power of Long.MAX_VALUE at 23 (it will fails):"+powerOf_02(Long.MAX_VALUE,23L));
		System.out.println("Power of 23 at Long.MAX_VALUE (it will fails):"+powerOf_02(Long.MAX_VALUE,23L));

	}
}

/*
Power of 45 at 7:373669453125
Power of 26 at 5:11881376
Power of 13 at 8:815730721
Power of 18 at 6:34012224
Power of 13 at 0:1
Long.MAX_VALUE at 23 :9223372036854775807
Power of Long.MAX_VALUE at 23 (it will fails):9223372036854775807
Power of 23 at Long.MAX_VALUE (it will fails):9223372036854775807
-------------
Power of 45 at 7:373669453125
Power of 26 at 5:11881376
Power of 13 at 8:815730721
Power of 18 at 6:34012224
Power of 13 at 0:1
Long.MAX_VALUE at 23 :9223372036854775807
Power of Long.MAX_VALUE at 23 (it will fails):9223372036854775807
Power of 23 at Long.MAX_VALUE (it will fails):9223372036854775807

*/