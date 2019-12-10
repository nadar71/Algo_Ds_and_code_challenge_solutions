/*
t:O(2^N)
s:O(N)

*/

public class Main{
	public static int fibonacci(int n){
		if (n <= 0) return 0;
		if (n <= 2) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}

	public static void main(String[] args){
		System.out.println("Result : "+fibonacci(5));
	}
}