



public class Main{

	public static boolean matchExpr(String expr, String str){
		return doMatching(expr, str, 0, 0);	
	}


	public static boolean doMatching(String expr, String str, int i, int j){
		if ( i == expr.length() && j == str.length()) return true;

		if ( ( i == expr.length() && j != str.length())  ||  
			 ( i != expr.length() && j == str.length()) )
			return false;

		if (expr.charAt(i) == '?' || expr.charAt(i) == str.charAt(j))  
			return doMatching(expr, str, i+1, j+1);

		if (expr.charAt(i) == '*') 
			return doMatching(expr, str, i+1, j) || 
		           doMatching(expr, str, i, j+1) ||
		           doMatching(expr, str, i+1, j+1);

		return false;

	}


	public static void main(String args[]){
		String str = "abccdefgh";
		System.out.println("a*: Match? " + matchExpr("a*", str));
		System.out.println("abc*: Match? " + matchExpr("abc*", str));
		System.out.println("abc?defgh: Match? " + matchExpr("abc?defgh", str));
		System.out.println("abc: Match? " + matchExpr("abc", str));
		System.out.println("abcc*: Match? " + matchExpr("abcc*", str));
		System.out.println("i: Match? " + matchExpr("i", str));
		System.out.println("abccdefgh*: Match? " + matchExpr("abccdefgh*", str));
		System.out.println("a?ccde?gh: Match? " + matchExpr("a?ccde?gh", str));



	}




}



/*

a*: Match? true
abc*: Match? true
abc?defgh: Match? true
abc: Match? false
abcc*: Match? true
i: Match? false
abccdefgh*: Match? false
a?ccde?gh: Match? true

*/