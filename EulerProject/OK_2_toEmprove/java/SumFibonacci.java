/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

Find the sum of all the even-valued terms in the sequence which do not exceed four million.
*/

import java.io.*;
import java.util.*;

public class SumFibonacci{

//Attributes
private static ArrayList<Integer> fibSeries = new ArrayList<Integer>();
private static ArrayList<Integer> evenFibSeries = new ArrayList<Integer>();

private static int count=2, evenSum=2; //...that's why it starts from 1, not 0....


//Methods



//End/////////////////////////////////////////7

  public static void main(String args[]){
  	
  	//...that's why it starts from 1, not 0....
  	fibSeries.add(0,1);
        fibSeries.add(1,2);	
  
  	
  	System.out.printf("\n il primo numero della serie e' %d",fibSeries.get(0));
  	System.out.printf("\n il secondo numero della serie e' %d",fibSeries.get(1));
  	
  	
  	while(true){
  		//create fibonacci's series
  		fibSeries.add(count,fibSeries.get(count-1)+fibSeries.get(count-2));
  		
  		//DEBUG
  		System.out.printf("\nIl numero %d delle serie di fibonacci e' %d", count+1, fibSeries.get(count));
  		
  		if ( (fibSeries.get(count)%2)==0 ){
  			
  			//extracts  even number of Fibonacci's series
  			evenFibSeries.add(fibSeries.get(count));
  			
  			//DEBUG
  			System.out.printf("\nIl numero PARI  delle serie di fibonacci e' %d", fibSeries.get(count));
  			  			
  			//checks if 4 million is reached
  			//if ( (evenSum + evenFibSeries.get(evenFibSeries.size()-1)) >= 4000000  ) break;
  			
  			//checks if the number found is greater then 4 million is reached
  			if ( ( evenFibSeries.get(evenFibSeries.size()-1)) >= 4000000  ) break;
  				
  			//sums them
  			evenSum += evenFibSeries.get(evenFibSeries.size()-1);
  			}
  			
  		count += 1;
  		
  	}//while
  	
  	
  	System.out.printf("\nLa somma dei numeri pari della serie di Fibonacci sotto 4mln e' : %d", evenSum);
  }


}