/*
Test cases :
"Mr John Smith    ",13
"   ",0
"nospaces",8

a very long string

* "   ",3
* "",0
* "Mr John Smith       ",14


t : O(n)  
s : O(n)


This solution avoid a pass and it's ok with all the test cases
*/

import java.util.Arrays;

public class Main{

    public String replaceSpaces(String s, int trueLength){
      if (s.length == 0  || trueLength == 0) return s;

      char[] str = s.toCharArray();

      int index = str.length;
      for(int i=trueLength-1 ; i >= 0 ; i--){
        if (str[i] = ' '){
          str[index-1] = '0';
          str[index-2] = '2';
          str[index-3] = '%';
          index -= 3;
        } else {
          str[index-1] = str[i];
          index--;
        }
      }
      // return Arrays.toString(str);
      return String.valueOf(str);
    }




  public static void main(String args[]){  
    Main m = new Main();

    String s1 ="Mr John Smith    ";
    System.out.println("Urlify : " + m.replaceSpaces(s1,13));

    String s1 ="Mr John Smith       ";
    System.out.println("Urlify : " + m.replaceSpaces(s1,14));

    String s1 ="   ";
    System.out.println("Urlify : " + m.replaceSpaces(s1,0));

    String s1 ="";
    System.out.println("Urlify : " + m.replaceSpaces(s1,0));
          
  }
    
}  