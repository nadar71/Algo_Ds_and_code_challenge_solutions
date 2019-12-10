/*
Compute fibonacci sequence till n
t : O(2^N)
s : O(1)
*/
public class Main{
	public static int fibonacci(int n){
		int a = 0;
		int b = 1;
		for(int i=1; i<n ;i++ ){
			int tmp = b;
			b = a + b;
			a = tmp;			
		}
		return b;
	}

	public static void main(String[] args){
		System.out.println("Result : "+fibonacci(3));
	}


}