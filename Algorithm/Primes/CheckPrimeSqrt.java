
public class CheckPrimeSqrt{

	public static boolean isPrime(int n){
		if (n <= 2) return false;
		int sqrt = (int) Math.sqrt(n);
		for(int i=3; i <= sqrt; i++){
			if (n % i == 0) return false;
		}
		return true;
	}
}