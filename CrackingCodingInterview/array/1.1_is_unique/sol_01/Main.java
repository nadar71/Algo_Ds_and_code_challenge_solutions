/*
1) With consent using additional structure : 
Using auxiliary array; suppose ascii extended 256 char (= 128 char max)
t : O(n)
s : O(128)
NB : the solutions make the assumption of ascii code of 128 char
*/

public class Main{

  public static boolean isUnique(String s){
    int slength = s.length();
    if (slength <= 0)   return true;
    if (slength > 128 ) return false;

    boolean[] check = new boolean[128];
  
    for(int i=0;i<slength;i++) { 
      int c = s.charAt(i);
      if (check[c]) {
        System.out.println("This is doubled : "+s.charAt(i));
        return false;
      }
      else check[c] = true;
    }

    return true;
    
  }  
  

  public static void main(String args[]){    
    String data ="This is a test for false";     
    System.out.println(isUnique(data));  
    data ="ThIs_1S-a.8e7t+for/F4l53"; 
    System.out.println(isUnique(data));   
  }
  
}