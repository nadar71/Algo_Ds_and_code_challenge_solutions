

/*
Convert string to upper/lower chars
*/

public  class Main{

	public static char toUpper(Character c){
	  char res = '0';
	  if ('a' <= c && c <= 'z') 
	    res = (char)(c - 'a' + 'A');
	  return res;
	}

	public static char toLower(Character c){
	  char res = '0';
	  if ('A' <= c && c <= 'Z') 
	    res = (char)(c - 'A' + 'a');
    return res;
	}

	public static char toReverseCase(Character c){
	  char res = '0';
	  if ('a' <= c && c <= 'z') 
	    res = (char)(c - 'a' + 'A');
	  if ('A' <= c && c <= 'Z') 
	    res = (char)(c - 'A' + 'a');
	  return res;
	}


	public static String stringToUpper(String str){
		StringBuilder result = new StringBuilder(str.length());
		for(int i = 0; i < str.length(); i++){
			result.append(toUpper(str.charAt(i)));
		}
		return result.toString();
	}


	public static String stringTolower(String  str){
		StringBuilder result = new StringBuilder(str.length());
		for(int i = 0; i < str.length(); i++){
			result.append(toLower(str.charAt(i)));
		}
		return result.toString();
	}

	public static String stringReverseCase(String  str){
		StringBuilder result = new StringBuilder(str.length());
		for(int i = 0; i < str.length(); i++){
			result.append(toReverseCase(str.charAt(i)));
		}
		return result.toString();
	}




	public static void main(String args[]){
	  
	  // clearifier :
	  System.out.println("a in int is : "+(int)'a');
	  System.out.println("A in int is : "+(int)'A');
	  
		String str = "marte";
		String str1 = "GALASSIA";

		System.out.println(str + " converted to upper :  "+stringToUpper(str));
		System.out.println(str1 + " converted to lower :  "+stringTolower(str1));
		
		System.out.println(str + " reverse case :  "+stringReverseCase(str));
		System.out.println(str1 + " reverse case :  "+stringReverseCase(str1));
		

	}
}

/*
a in int is : 97
A in int is : 65
marte converted to upper :  MARTE
GALASSIA converted to lower :  galassia
marte reverse case :  MARTE
GALASSIA reverse case :  galassia


*/