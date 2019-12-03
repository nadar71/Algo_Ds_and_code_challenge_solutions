import java.util.*;
import java.io.*;

import timing.*;

public class Uno_02 extends Thread{
  static int result = 0;
  static int tmp=0;
  
  static boolean calc_3= true;
  static boolean calc_5= true;
  
  public void run(){
   //private static File res= new File("result_02.txt");
   //private static BufferedWriter out;  	
   
   /* 01 : mine :266333:wrong: it sums the multiple of both, 2 times than !!*/
   /* 01_1: now i changed for taking care of this....*/
   int i=1;
   
   while(calc_3 || calc_5){
    if(calc_5){
      if ((tmp=5*i)<1000) 
         { if ( tmp % 3 != 0 ) result += tmp; } 
         else {calc_5 = false;};
    }
    
    if(calc_3){
      if ((tmp=3*i)<1000) 
         { result += tmp; } 
         else {calc_3 = false;};
    } 
      	
    i++; 
  	  	
   }//while
   

   
    
   /* 02 : method from internet, better
   
   for (int i = 0; i < 1000; ++i)
   {
	if (i % 3 == 0 || i % 5 == 0)
	//out.write(String.valueOf(i));	 		
	//out.write("\n");
	result += i;
   }
   */
   //output
   System.out.println("Totale : " + result);  
  }
  
  public static void main(String args[]){
  	Chronometer chron = new Chronometer();
  	Uno_02 problem = new Uno_02();
  	
  	chron.run(problem);
  	System.out.println(chron.getElapsedTime());
  	
  	}
  
  
  
}