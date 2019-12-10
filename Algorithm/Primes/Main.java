

public class Main{
	public static void main(String[] args){
		// sqrt
		CheckPrimeSqrt check = new CheckPrimeSqrt();
		System.out.println(30 + " is prime? "+check.isPrime(30));
		System.out.println(97 + " is prime? "+check.isPrime(97));

		// eratostene
		SieveOfEratostene sieve = new SieveOfEratostene();
		sieve.createSieve(30);
		sieve.printArray();
		
		sieve.createSieve(50);
		sieve.printArray();


	}
}

/*

2 3 5 7 11 13 17 19 23 29 
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
*/