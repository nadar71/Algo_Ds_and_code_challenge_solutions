import java.util.ArrayList;
public class Main{ 
    ArrayList<Character> digits;

    public Main(){
      digits = new ArrayList<>();
    }

    public void convertNumber(int n, int base){
      String conv = "0123456789ABCDEF";  // could use an array of character as well
      int digit   = n % base; 
      
      int result  = (int)n/base;
      if (result>0) convertNumber(result, base);  
      digits.add(conv.charAt(digit));   
    }

    public void printDigits(){
      for(Character i:digits){
        System.out.print(i);
      }
      System.out.println("");
    }
    
    public void reset(){
      digits.clear();
    }

    
    
    
    public static void main(String[] args) 
    { 
        
        Main m = new Main();
        m.convertNumber(10,16);
        m.printDigits();
        m.reset();
        
        m.convertNumber(10,2);
        m.printDigits();
        m.reset();
        
        m.convertNumber(10,8);
        m.printDigits();
    } 

}
