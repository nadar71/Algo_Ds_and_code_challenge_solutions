import java.util.*;


public class SquareSum100{
   
   public static void main(String args[]){
   	int squareSum=0;
   	int numSumSquare=0;
   	for(int i=1;i<=100;i++){
   	  squareSum    += i*i;
   	  numSumSquare += i;
   	}
   	numSumSquare = numSumSquare*numSumSquare;
   	System.out.println(" Sum of the Square : " + squareSum + "\n");
   	System.out.println(" Square of the sum : " + numSumSquare + "\n");
   	System.out.println(" Differences : " + (numSumSquare - squareSum) + "\n");
   	
   	
   }

}