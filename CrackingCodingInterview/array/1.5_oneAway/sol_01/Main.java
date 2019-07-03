

/*

t : O(n)
s : O(1)

*/


public class Main {

  public boolean checkDiff(int a, int b){
    int c = a-b;
    if (c<0) c *= -1;
    if (c>1) return false; else return true;
  }

  public boolean oneAway(String s1,String s2){

    int l1 = s1.length();
    int l2 = s2.length();
    String ls, ss;
    int diffCount  = 0;
    
    if (!checkDiff(l1,l2)) return false;

    // longest and shortest string
    ls = (l1 > l2) ? s1 : s2;
    ss = (l1 > l2) ? s2 : s1;
    

    int idx_ss = 0;
    int idx_ls = 0;
    while(idx_ls < ls.length() && idx_ss < ss.length()) {

      // insertion : 1 allowed
      if (idx_ls == ls.length()-1 && idx_ss == ss.length()-2)
        if (diffCount == 1)  return false;  else diffCount++;

      // removing, replacing : 1 allowed

      if (ls.charAt(idx_ls) == ss.charAt(idx_ss)) {
          idx_ss++;
          idx_ls++;
      } else {          
          if (diffCount == 1)  return false;  else diffCount++;    // remove
          idx_ls++;  
          if (ls.charAt(idx_ls) != ss.charAt(idx_ss)) idx_ss++;  // replace
      }

    } // while

    return true;
    
  }


  public static void main(String args[]){  
    Main m = new Main();

    String s1 ="pale";  
    String s2 ="ple";
    System.out.println(m.oneAway(s1,s2));

    String s3 ="pales";  
    String s4 ="pale";
    System.out.println(m.oneAway(s3,s4));

    String s5 ="pale";  
    String s6 ="bale";
    System.out.println(m.oneAway(s5,s6));    

    String s7 ="pale";  
    String s8 ="bae";
    System.out.println(m.oneAway(s7,s8));    
    
    String s9 ="apple";  
    String s10 ="aple";
    System.out.println(m.oneAway(s9,s10)); 
    
    
    String s11 ="apple";  
    String s12 ="apl";
    System.out.println(m.oneAway(s11,s12)); 
          
  }
    
}
