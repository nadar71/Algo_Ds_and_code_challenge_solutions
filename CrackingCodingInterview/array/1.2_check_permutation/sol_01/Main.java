/*
#1 : string permutation one each other means same chars in different order : sort and then check string equality
t : O(logn ~ O(nlogn)
s : O(1)
*/


import java.util.Arrays;

public class Main{

    String sort(String s){
      char[] chars_s = s.toCharArray();
      java.util.Arrays.sort(chars_s);
      return new String(chars_s);
    }
    
    
    boolean isPermutation(String s, String t){
      if (s.length() != t.length()) return false;
      
      s = sort(s);
      t = sort(t);
    
      return s.equals(t);
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