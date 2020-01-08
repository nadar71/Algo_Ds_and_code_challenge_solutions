/*
GCD, lcm with euclide's formula iterative
*/

public class Main{

	public static int GCD(int m, int n){
		while( m != n){
			if (m > n) 
				m = m - n;
			else 
				n = n - m;
		}
		return n;
	}
    
    public static int lcm(int m, int n){
		return (m*n/GCD(m,n));
	}


	public static void main(String[] args){
		System.out.println("GCD : "+GCD(18,12));
		System.out.println("lcm : "+lcm(18,12));			
	}
}

