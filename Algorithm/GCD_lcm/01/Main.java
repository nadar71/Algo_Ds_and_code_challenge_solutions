/*
GCD recursively
lcm with euclide's formula
*/

public class Main{

	public static int GCD(int m, int n){
		if (m < n) return GCD(n,m);
		if (m % n) return n;
		return GCD(n, m % n);
	}

	public static int lcm(int m, int n){
		return (m*n/GCD(m,n));
	}

	public static void main(String[] args){
		System.out.println("GCD : "+GCD(18,12));
		System.out.println("lcm : "+lcm(18,12));			
	}
}

