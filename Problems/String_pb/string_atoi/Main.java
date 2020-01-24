
/*
ASCII to int conversion
*/

public  class Main{

	public static int atoi(String str){
		int value = 0;
		int size  = str.length();  
		for(int i = 0; i < size; i++){
			int ch = str.charAt(i);
			value = (value << 3) + (value << 1) + (ch -'0');
		}

		return value;

	}


	public static void main(String args[]){
		String str = "marte";
		String str1 = "galassia";
		

		System.out.println(str + " converted to int :  "+atoi(str));
		System.out.println(str1 + " converted to int :  "+atoi(str1));



	}
}

/*
marte converted to int :  666333
galassia converted to int :  605564319

*/