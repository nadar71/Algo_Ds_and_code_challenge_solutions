/*
String permutations
*/

public class Main{
    
    public static void getPermutations(String str){
    	permutation(str, "");
    }

	public static void permutation(String str, String prefix){
		if (str.length() == 0) {
			System.out.println(prefix + " ");
		} else {
			for(int i=0; i < str.length(); i++){
				String tmp = str.substring(0,i) + str.substring(i+1);
				permutation(tmp,prefix+charAt(i));
			}
		}		
	}


	public static void main(String[] args){
		
		getPermutations("Ciao");


	}

}