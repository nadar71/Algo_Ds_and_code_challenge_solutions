/*
#2 : convert 1st string to char array and count char occurencies; then check 2nd string chars, 
and check if it has for each char the same number then 1st 
- assume that we use ascii encoding

t : O(n) + O(n) ~ O(2n) 
s : O(1)
*/

import java.util.Arrays;

public class Main{

     boolean isPermutation(String s, String t){
     if(s.length() != t.length()) return false;
    
     int[] letters = new int[128];
    
     char[] chars_s = s.toCharArray(); 
     for(char c:chars_s){  // count the number for each chars in the string
        letters[c]++;
     }
    
     // check if the chars in the 2nd string are all in the 1st and in the same number
     for(int i=0; i<t.length(); i++ ){
        char c = t.charAt(i);
        letters[c]--;
        if(letters[c] < 0) return false;    
     }
    
     return true;
    
    
    }
    
    
  

  public static void main(String args[]){  
    Main m = new Main();
    
    String s1 ="This is a test for false";   
    String s2 ="This is a test for true";   
    System.out.println("Permutation? " + m.isPermutation(s1,s2));
    
    String s3 ="This is a test for false"; 
    String s4 ="falseThisis a test for  "; 
    System.out.println("Permutation? " + m.isPermutation(s3,s4));
    
    
  }
  
  
}