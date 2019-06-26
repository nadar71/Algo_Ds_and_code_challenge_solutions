/*
2) With consent using additional structure : 
Using a bit vector : using only a int as a marker for char present or not.
NB : can''t distinguish between lower/upper case, suppose that the string is 
with chars in [a-z]
NB : the solutions make the assumption of ascii code of 128 char

*/

public class Main{

  public static boolean isUnique(String s){
    int slength = s.length();
    if (slength <= 0)   return true;
    if (slength > 128 ) return false;

    int check = 0;
  
    for(int i=0;i<slength;i++) { 
      int c = s.charAt(i) - 'a';
      System.out.println("Char: " + s.charAt(i) +" in ascii code: "+c+" and bit: "+(1 << c));
      if (  (check & (1 << c)) >0 ) {
        System.out.println("This is doubled : "+s.charAt(i));
        return false;
      }
      else check |= (1 << c);
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