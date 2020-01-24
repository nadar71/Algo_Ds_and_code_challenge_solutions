


class StringUtil {

	public String reverse(String str){
		StringBuilder strb = new StringBuilder(str);

		int upper 		 = str.length()-1;
		int lower 		 = 0;
		

		while(lower < upper){
			char tmp  = strb.charAt(upper);
			strb.setCharAt(upper, strb.charAt(lower));
			strb.setCharAt(lower, tmp);
			
			lower++;
			upper--;
		}

		return strb.toString();

	}

	
}



public class Main{


	public static void main(String args[]){
		String str      = "Gigliola";
		StringUtil util = new StringUtil();
		
		System.out.println("reverted : "+util.reverse(str));
		
	}
}


