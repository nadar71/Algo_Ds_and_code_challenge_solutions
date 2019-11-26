import java.io.*;


public class Square{
	
	public static void main(String args[]){
		double num = -9.50;
		double square = num;
		int i = (int)num;
		
		
    /*
		if ( ((Math.ceil(num)-num)<1) && ((Math.ceil(num)-num)>0) )  {       // float
			square = num/(1/num);
	  }
	  else
	  {                         // int
		  while (i > 1) {
			  square = square -(-num);
			 i--;
			}
		  System.out.println(square);
		}
		*/
		
		// or, easely, as below. Is good for negative number too
		if ( square != 0)   {       
			square = square/(1/square);
	  }
	  else { square = 0; }
		System.out.println(square);

		
		
	 }
	 
	
	}