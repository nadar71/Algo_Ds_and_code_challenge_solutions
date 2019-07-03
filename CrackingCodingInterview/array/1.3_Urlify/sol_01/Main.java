/*
Test cases :
"Mr John Smith    ",13
"   ",0
"nospaces",8

a very long string

* "   ",3
* "",0
* "Mr John Smith       ",14


t : O(n) + O(n) ~ O(2n) 
s : O(n)
*/

import java.util.Arrays;

public class Main{
    public String replaceSpaces(String s, int trueLength){
      int spaceCount = 0, index;
      char[] str = s.toCharArray();

      for(int i=0; i < trueLength;i++)
        if (str[i] == ' ') spaceCount++;

      index = trueLength + 2*spaceCount; 
      if (trueLength < str.length) str[trueLength] = '\0';
      for(int i= trueLength-1; i>=0; i--){
        if (str[i] == ' '){
          str[index-1] = '0';
          str[index-2] = '2';
          str[index-3] = '%';
          index = index - 3;
        } else {
          str[index-1] = str[i];
          index--;
        }
      }
      return String.valueOf(str);
    }



  public static void main(String args[]){  
    Main m = new Main();
    String s1 ="Mr John Smith    ";

    System.out.println("Urlify : " + m.replaceSpaces(s1,13));
          
  }
    
}    

/*
NB : because the string has all spaces at the end, with the approach on the book 
     we could not evaluate the case where we have 1 spaces at the end
     in fact it will fail with  "Mr John Smith     ",14 : it counts the last space too
     
     fail with :
     "   ",3 : in this case is a wrong data entry, there are only the 3 spaces (the string) 
               but not the char for the spaces (4*3  = 12)
     "",0

TODO : make an approach which calculate this eventuality
*/