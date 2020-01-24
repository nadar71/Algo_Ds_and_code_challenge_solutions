/*
Check if 1 string is a permutation of another
*/

public  class Main{

	public static boolean isPermutation(String str1, String str2){
    	  if (str1.length() != str2.length()) return false;
    	  int length =  str1.length();
    	  int count[] = new int[256];

    	  for(int i = 0; i < 256; i++ ) count[i] = 0;
    	  
    	  for(int i = 0; i < length; i++){
    	    int ch = str1.charAt(i);
    	    // System.out.println("ch :"+ch);
    	    count[ch]++;
    	    ch = str2.charAt(i);
    	    count[ch]--;
    	  }
    	  
    	  for(int i = 0; i < 256; i++ ) {
    	    if (count[i] > 0) return false;
    	  }
    	  
    	  return true;
		
		}



	public static void main(String args[]){
		String str1 = "mreasrde";
		String str2 = "rdemreas";
		String str3 = "mreasrda";
		

    // System.out.println(" 'a' int code  : "+Integer.toHexString(a));
		System.out.println("Is permutation? "+isPermutation(str1, str2));
		System.out.println("Is permutation? "+isPermutation(str1, str3));
	}
}