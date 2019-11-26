import java.io.*;



public class Tre_0201{

 public static void main(String Args[]){
  String  max = "600851475143";   
  //String  max = "60";
  boolean isPrime;
  
  for(long  i=(Long.valueOf(max)-1)/99997;i>0;--i){
  isPrime = true;
  //debug
  System.out.printf("counting %d \n " , i);  	
  
   if(Long.valueOf(max) % i == 0){ //no rest,  it's a divisor of max
      //debug
      //System.out.println("This a divisor , but maybe or not a prime number : " + i);
      //if (i == Long.valueOf("600000000000")) System.out.println("This  600000000000" );
      
      for(long  j=2;j<i;++j){
      	if (i % j == 0) {
      	  isPrime=false;
      	  continue;
      	}
      }
      if (isPrime){
        System.out.println("The greatest prime is :" + i);
        break;
      }
   }//1° if
   	 	
  }//for
   
 }//main
 
}