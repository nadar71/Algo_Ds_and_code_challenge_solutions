/*
t : O(n)
s : O(1)
*/


public class Main {

  
  public String stringCompression(String s1){

    int l = s1.length();
    char currentChar;
    char previousChar = '#';
    int count = 0;
    StringBuilder comp = new StringBuilder();
    
    for(int i=0; i<l; i++){
      currentChar = s1.charAt(i);
      if (i>0){
        count ++; 
        if(currentChar != previousChar || i==l-1) {                  
            comp.append(previousChar);
            if (count>1) comp.append(count);
            count = 0;
            previousChar = currentChar;
        }

      } else previousChar = currentChar; // init

    }
    
    String res = comp.toString();
    if (res.length() < l) return res; else return s1;
    
  }


  public static void main(String args[]){  
    Main m = new Main();

    String s1 ="aabcccccaaa";  
    System.out.println(m.stringCompression(s1));
    
          
  }
    
}