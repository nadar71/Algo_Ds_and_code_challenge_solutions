/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

import java.util.*;
import java.io.*;


public class FindPrimes{

ArrayList<Long> primeSeries;
 

  public FindPrimes(long limit){
  	
  long temp;	
  double quotient,rest;
  long intQuot;
  boolean find=false, done=false;
  
  primeSeries = new ArrayList<Long>();
  
  BufferedWriter out; 
  
  
    try{
        
        out = new BufferedWriter(new FileWriter(new File("listOfPrimes.txt")));
        
    	while(done != true ){
  		//select each number within limit,starting from 2
  		for(long i=1;i<limit;i++){
  			find=true; //...suppose it's prime
  			temp=i;    // temp will be used as quotient
  			
  			//test if number selected in temp has any more divisor than 1 or himself
  			//temp-1 exclude himself as a divisor
  			for(long j=temp-1;j>1;j--){
  				//DEBUG System.out.printf("\nIl numero in testing e' %d e lo divido per %d", i,j); 
  				 				
  				quotient = (double)i/j;
  				intQuot  = (long)quotient;
  				if( (rest = quotient-intQuot)==0 ) {
  					find=false;
  					break; //find a divisor  				
  				}
  				
  			}//for 2
  			if (find == true) {
  				//primeSeries.add(i);
  				
  				//DEBUG 
  				System.out.printf("  %d  NUMERO PRIMO \n",i);
  				
  				out.write(String.valueOf(i));
  				out.write("\n");
  			    }
  			    
  			
  		}//for 1
  		done = true;
  	}//while
  	
  	out.close();
  	
  	
     }catch(IOException e){
     	System.out.println("Errore nella scrittura su file "+ e.getMessage());
     }	
  	
 
  	
 }//constructor
  	
  	
  	

}