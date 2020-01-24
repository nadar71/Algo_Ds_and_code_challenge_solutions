

/*
Compare 2 strings:
0   : equals
-1  : str1 < str2 (the 1st is equal to 2nd but less)
1   : str1 > str2 (the 1st is equal to 2nd but greater)
n > 0 or <0  : the difference in ascii code between the first char different

*/
public class Main{


	public static int strCmp(String str1, String str2){
		int idx = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		int min  = len1;
		if (len1 > len2) min = len2;

		while (idx < min && str1.charAt(idx) == str2.charAt(idx) ) idx++;

		if ( idx == len1 && idx == len2 ) return 0;
		
		
		else if ( len1 == idx) return -1; // idx is always equal to min
		else if ( len2 == idx) return  1;
		//  else if ( len1 == idx  || len2 == idx ) return (len1-len2)/Math.abs(len1-len2);
		
		else return (str1.charAt(idx) - str2.charAt(idx));


	}


	public static void main(String args[]){
		String str1 = "cavallo";
		String str2 = "cavallo";
		String str3 = "cane";
		String str4 = "cavalla";
		String str5 = "caval";


		System.out.println(" Compare : " + str1 + " and " + str2 + " " + strCmp(str1, str2));
		System.out.println(" Compare : " + str1 + " and " + str3 + " " + strCmp(str1, str3));
		System.out.println(" Compare : " + str1 + " and " + str4 + " " + strCmp(str1, str4));
		System.out.println(" Compare : " + str3 + " and " + str1 + " " + strCmp(str3, str1));
		System.out.println(" Compare : " + str1 + " and " + str5 + " " + strCmp(str1, str5));
		System.out.println(" Compare : " + str5 + " and " + str1 + " " + strCmp(str5, str1));




	}
}