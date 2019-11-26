import java.io.*;
import java.util.*;


public class Tre_01{
  
  public static void main(String args[]) throws IOException{
   long p;
   long d;
   //String limit = "600851475143";
   String limit = "100000";
   
   int  isPrime;
   long last=0;
   File prime = new File("numeriPrimi.txt");
   BufferedWriter wr = new BufferedWriter(new FileWriter(prime)); 

  
   for (p=2; p < Long.valueOf(limit); ++p){
    isPrime = 1;
    
    	
    for(d=2;d<p;++d){
    	if (p%d == 0) isPrime=0; 
    	if (isPrime != 0) {
    	     wr.write(p+"\n");	
    	     last = p;
    	     break;
    	  }
    	}
    	
   }  

   System.out.println("the greatest prime in the range specified is : " + last);	
   wr.close();
  }//main

}