

/*
Reverse the words' order in a string, that is :  there is a dog cat => dog a is there

*/
public class Main{


	public static String reverseWordInString(String str){

		int len   = str.length();
		if (len == 0) return str;


		int lower = 0;
		int upper = -1;

		for(int i=0; i < len; i++){
			if (str.charAt(i) == ' ' || i == len-1 ){
			    // System.out.println("_lower : " + lower + " _upper : " + upper);
				if ( i == len-1) str = reverse(str, lower, upper+1);
				else str = reverse(str, lower, upper);
				lower = i + 1;
				upper = i;
			} else upper++;
		}
		
		return reverse(str, 0, len-1);	
	}


	public static String reverse(String str, int lower, int upper){
	  StringBuilder strb = new StringBuilder(str);

		while(lower < upper){
			char tmp  = strb.charAt(upper);
			strb.setCharAt(upper, strb.charAt(lower));
			strb.setCharAt(lower, tmp);
			
			lower++;
			upper--;
		}
		return strb.toString();

	}



 

	public static void main(String args[]){
		String str1 = "cavallo";
		String str2 = "sono andato al lavoro";
		String str3 = " ";
		String str4 = "";
		String str5 = "123 per partire via!";
		
		

		System.out.println(" Reversed string : "  + reverseWordInString(str1));
		System.out.println(" Reversed string : "  + reverseWordInString(str2));
		System.out.println(" Reversed string : "  + reverseWordInString(str3));
		System.out.println(" Reversed string : "  + reverseWordInString(str4));
		System.out.println(" Reversed string : "  + reverseWordInString(str5));




	}
}

/*
 Reversed string : cavallo
 Reversed string : lavoro al andato sono
 Reversed string :  
 Reversed string : 
 Reversed string : via! partire per 123



*/