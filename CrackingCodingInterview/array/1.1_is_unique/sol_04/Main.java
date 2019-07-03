/*
4) With consent to sort string :
t : O(n)
s : O(1)
NB : the solutions make the assumption of ascii code of 128 char
*/

import java.util.Arrays;

public class Main{

  public static boolean isUnique(String s){
    int slength = s.length();
    if (slength <= 0)   return true;
    if (slength > 128 ) return false;

    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    
  
    for(int i=0;i<arr.length;i++) { 
       if (  i<arr.length-1 && arr[i] == arr[i+1] ) {
        System.out.println("This is doubled : "+s.charAt(i));
        return false;
       }
      }

    return true;    
  }  
  

  public static void main(String args[]){    
    String data ="This is a test for false";     
    System.out.println(isUnique(data));  

    data ="uniqUe str";
    System.out.println(isUnique(data));  

    data ="unike str";
    System.out.println(isUnique(data));  
  }
}