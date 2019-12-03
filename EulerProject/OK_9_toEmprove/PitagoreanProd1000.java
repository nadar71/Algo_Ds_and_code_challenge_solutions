import java.io.*;



public class PitagoreanProd1000{

  static int activate(){
       for(int a=1000;a>0;a--){
  	for(int b=1000;b>0;b--){
  	  for(int c=1000;c>0;c--){
  	  	if ( (a+b+c==1000) && (
  	  	     (a*a+b*b==c*c)||
  	  	     (a*a+c*c==b*b)||
  	  	     (b*b+c*c==a*a) )
  	  	    ) {
  	  	    	System.out.println("The numbers :  " + a + " " + b + " " + c + "\n");
  	  	    	return a*b*c;
  	  	    	}
  	   	
  	  }	
  	 }	
  	} return -1; 	
  }
  
  
   //425 375 200

   //31875000

  public static void main(String args[]){
         System.out.println("The product : " + activate());
  	
  }

}