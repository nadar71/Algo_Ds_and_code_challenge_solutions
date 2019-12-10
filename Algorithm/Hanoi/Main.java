/*
n disks : 
(2^n) - 1 moves required
2^(n - 1) moves required
Time complexity : O(2^n)
*/


public class Main{ 

    public void hanoi(int n, char src, char dst, char tmp){
      if (n < 1) return;  
      hanoi(n-1, src,tmp, dst);
      System.out.println("Moving "+n+" from peg "+src+" to peg : "+dst);
      hanoi(n-1, tmp, dst,src);
    }    
    
    public static void main(String[] args) 
    { 
        
        Main m = new Main();
        m.hanoi(3,'A','C','B');
    } 

}




/*

                                 3 A,C,B
                            /                \
                           /                  \
                     2 A,B,C                2 B,C,A
                    /       \               /      \
                   /         \             /        \
                1 A,C,B   1 C,B,A      1 A,C,B     1 B,C,A   
*/

