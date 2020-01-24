
/*
Search a word in a text by brute force
*/
public class Main{

	public static int bruteForcePatternSearch(String word, String text){
		int n = text.length();
		int m = word.length();

		int i = 0;
		int j = 0;
        int count = 0;
		while( i <= n-m){
			j = 0;
			while(j < m  && word.charAt(j) == text.charAt(i+j)) j++;
			if (j == m)  count++;
			i++;
		}
		return count;
	}



	public static void main(String args[]){
		String word = "cane";
		String text = "asd ff cane ffsfgcane";
		System.out.println("Result : " + bruteForcePatternSearch(word, text));

	}

}

/*
Result : 2
*/