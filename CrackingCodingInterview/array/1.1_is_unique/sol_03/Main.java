/*
3) With NO consent using additional structure : 
t : O(n^2)
s : O(1)
NB : the solutions make the assumption of ascii code of 128 char
*/


public class Main{

  public static boolean isUnique(String s){
    int slength = s.length();
    if (slength <= 0)   return true;
    if (slength > 128 ) return false;

    int check = 0;
  
    for(int i=0;i<slength;i++) { 
      int c = s.charAt(i) ;

      for(int j=i+1;j<slength;j++) { 
      int  d = s.charAt(j);
       if (  c == d ) {
        System.out.println("This is doubled : "+s.charAt(i));
        return false;
       }
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