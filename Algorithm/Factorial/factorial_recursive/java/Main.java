// t: O(N) s: O(N)

public class Main{ 

    public void printFact(int n){
      System.out.println("Result : "+factorial(n));
    }

    public int factorial(int i){
      if (i<=1) return 1;
      return i*factorial(i-1);  
    }
    
    
    public static void main(String[] args) 
    { 
        
        Main m = new Main();
        m.printFact(10);
    } 

}
