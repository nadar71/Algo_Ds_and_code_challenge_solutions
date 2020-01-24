

public  class Main{

	public static boolean orderMatching(String pattern, String text){
		int idxText = 0;
		int idxPattern = 0;
		int textLength = text.length();
		int patternLength = pattern.length();

		for(idxText = 0; idxText < textLength; idxText++){
			if (text.charAt(idxText) == pattern.charAt(idxPattern) ) idxPattern++;
		    if (idxPattern == patternLength) return true;
		 }
		 
		 return false;   

	}


	public static void main(String args[]){
		String text = "abcdefghilmnopqrstv";
		String pattern1 = "chilo";
		String pattern2 = "chiamo";

		System.out.println("Pattern1 is orderMatching ? "+orderMatching(pattern1, text));
		System.out.println("Pattern2 is orderMatching ? "+orderMatching(pattern2, text));



	}
}