

public class Main{

  public static boolean checkAnagramm(String s1, String s2){
    if (s1.length() != s2.length()) return false;

    CountMap cm = new CountMap();
    for(int i=0; i < s1.length(); i++){
        cm.insert((int)s1.charAt(i));
    }

    for(int i=0; i < s2.length(); i++){
        cm.remove((int)s2.charAt(i));
    }

    return (cm.size() == 0);
  }



  public static void main(String args[]){
    String s1 = "sdfafdeasfasrf";
    String s2 = "sdfafdeasfasrf";
    System.out.println("Result : "+checkAnagramm(s1,s2));
    
    s1 = "dog";
    s2 = "godot";
    System.out.println("Result : "+checkAnagramm(s1,s2));
    
    s1 = "dog";
    s2 = "god";
    System.out.println("Result : "+checkAnagramm(s1,s2));
    
    
    s1 = "dogod";
    s2 = "godog";
    System.out.println("Result : "+checkAnagramm(s1,s2));

  }



}