

/*
Print all the anagrams of a string

*/
public class Main{


	public static void printAnagram(String str){
		String[] letters = str.split("");	
		
		printArray(letters);

		int len = str.length();

		anagram(letters, len, len);
	}


	public static void anagram(String[] letters, int max, int n){
	    if ( max == 1 ) System.out.println(joinLetters(letters));

	    for(int i = -1; i < max-1; i++){

	    	if (i != -1) swap(letters, i, max-1);	    
	    	anagram(letters, max-1, n);	    
	    	if (i != -1) swap(letters, i, max-1);
	    }

	}

    
    public static String joinLetters(String[] letters){
    	int len = letters.length;
    	StringBuilder res = new StringBuilder(len);

    	for(int i=0; i < len; i++ )
    		res.append(letters[i]);

    	return res.toString();

    }



    public static void swap(String[] arr, int first, int second){
      String tmp     = arr[first];
      arr[first]  = arr[second];
      arr[second] = tmp;
     }

    
    public static void printArray(String[] arr){
    	for(String i: arr) System.out.print(i + " ");
    	System.out.println("");
    }

 

	public static void main(String args[]){
		String str1 = "cavallo";
		String str2 = "mostro";
		String str3 = " ";
		String str4 = "";
		
		String str5 = "lordvader";
		
		

		System.out.println(" Anagram of string : " + str1 ); printAnagram(str1);
		System.out.println(" -------------------------------");
		
		System.out.println(" Anagram of string : " + str2 ); printAnagram(str2);
		System.out.println(" -------------------------------");
		
		System.out.println(" Anagram of string : " + str3 ); printAnagram(str3);
		System.out.println(" -------------------------------");
		
		System.out.println(" Anagram of string : " + str4 ); printAnagram(str4);
		System.out.println(" -------------------------------");
		
		System.out.println(" Anagram of string : " + str5 ); printAnagram(str5);
		System.out.println(" -------------------------------");
        



	}
}

/*

*/