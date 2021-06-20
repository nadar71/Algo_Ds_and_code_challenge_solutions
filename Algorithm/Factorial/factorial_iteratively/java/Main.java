// t: O(N) s: O(1)

public class Main{

    public static void factorial(int n){
    	int res = n;
    	for(int i=n; i>1; i--) res = res*(i-1);
    	 System.out.println("Result : "+res);
    }

	public static void main(String[] args){
	   factorial(4);
	}
}