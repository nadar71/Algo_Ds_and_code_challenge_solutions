/*
RobinKarp algo : WITH ERRORS, ONLY DRAFT
*/

import java.util.HashMap;

public class Main{


	public int robinKarp(String pattern, String text ){
		return executeRK(text, pattern);
	}

	public int executeRK(String pattern, String text){
		int n = text.length();
		int m = pattern.length();


		int prime = 101;
		int powm  = 1; 

		int TextHash = 0;
		int PatternHash = 0;

		if ( m == 0 || m > n) return -1;

		for(int i = 0; i < m-1; i++) powm = (powm << 1)% prime;

		for(int i = 0; i < m; i++) {
			PatternHash = (PatternHash << 1) + (pattern.charAt(i).codePointAt(0)) % prime;
			TextHash    = (TextHash  << 1)   + (text.charAt(i).codePointAt(0)) % prime;

		}

		for(int i = 0; i < n - m; i++){
			if (TextHash == PatternHash){
				for(int j = 0; j < m; j++)
					if (pattern.charAt(j) != text.charAt(i+j)) break;
				if (j == m) return i;
			}
		
		TextHash =  (( TextHash - (text.charAt(i).codePointAt(0) * powm) << 1) + text.charAt(i).codePointAt[0] ) % prime;

		if (TextHash < 0) TextHash = TextHash + prime;

		}

		return -1;

	}



	public static void main(String args[]){
		String word = "cane";
		String text = "asd ff cane ffsfgcane";
		System.out.println("Result : " + robinKarp(word, text));

	}




}