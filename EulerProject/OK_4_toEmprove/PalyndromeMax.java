/*
TODO
- avoid multiple reptition of result
*/


import java.io.*;
import java.util.*;


public class PalyndromeMax{
   
  public static  boolean isPalindrome(int num){
   	String number = Integer.toString(num);
   	
   	//odd number length
   	if (number.length()%2 != 0) return false;
   	for(int i=0; i<number.length()/2; i++){
   	  /*debug	
   	  System.out.println("the length : " + number.length());	
   	  System.out.println("the half length : " + number.length()/2);	
          System.out.println("from left : n." + i + " " + number.charAt(0+i));
          System.out.println("from right : n." + ((number.length())-i-1) + " " +  number.charAt((number.length())-i-1));	
          */
          	
   	  if(number.charAt(0+i)!=number.charAt(number.length()-i-1)) return false;  	 	
   	}
   	return true;	
   }
   
   
   public static void main(String args[]){
   	
   	//Debug : System.out.println("il numero 345543 è " + isPalindrome(345543));
   	int max=1;

   	for(int i=999;i>0;i--){
   	  for(int j=999;j>0;j--){   		
   	   int prod = i*j;
   	   if (isPalindrome(prod)){  	   	
   	   	if (prod<=max) {
   	   	 System.out.println("Il palindromo piu' grande e' : " +max);
   	   	 break ; //System.exit(0);
   	   	}
   	   	else {max=prod; }
   	   }
	
   	  }//for
   		
   	}//for
   	
   }
   
   
   
}