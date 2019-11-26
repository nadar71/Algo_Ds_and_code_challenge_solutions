/*
Primes calculation : need optimization tecnique, the complexity (and the time too) 
grow in an exponential way; it O(e^n)
e^2000000
*/


import java.util.*;



public class SumPrimesMin2Mln{

   public static void main(String args[]){
   	boolean isPrime=false;
   	long sumPrime=0;
   	for(int p=1; p<2000000; ++p){
   	  isPrime=true;	
   	  for(int d=2;d<p;++d){
   	    if (p%d==0)	isPrime=false;
   	  }//2° for
   	  if (isPrime) {
   	  	sumPrime += (long)p;
   	  	System.out.println("Is a prime : " + p + " and the sum is now : " + sumPrime);
   	  	}
   	}//1° for
   	System.out.println("The total sum is : " + sumPrime);
   
   }




}