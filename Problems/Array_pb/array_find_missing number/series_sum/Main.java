/*
NB : works only for 1 number missed
AND
if  the number starts from 1, not from 0 : 0 must be not included in number series
*/

t : O(n)
s : O(1)

public class Main{

  public static int findMissing(int[] arr, int n){
    int expectedSum = n*(n+1)/2;
    int currentSum  = 0;

    for(int i:arr) currentSum += i;

    return expectedSum-currentSum;
  }

  public static void main(String args[]){    
    int[] data = {1,2,3,4,6,7,8,9};      
    System.out.println("The missing number is : "+findMissing(data,9));    
  }
}