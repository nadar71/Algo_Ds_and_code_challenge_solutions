
/*
Check if 1 string is a palindrome
*/

public  class Main{

    public static boolean isPalindrome(String str){
          if (str.length() == 0) return true;
          int i = 0;
          int j = str.length()-1;
          while( i < j && str.charAt(i) == str.charAt(j)){
            i++; j--;
          }

          if (i < j) return false; else return true;
        
        }



    public static void main(String args[]){
    String str1 = "abccba";
    String str2 = "aba";
    String str3 = "aa";
    String str4 = " ";
    String str5 = "a";
    String str6 = "";
    String str7 = "abcca";
    String str8 = "accba";
    String str9 = "abc";
        

    // System.out.println(" 'a' int code  : "+Integer.toHexString(a));
    System.out.println(str1 + " Is palindrome? "+isPalindrome(str1));
    System.out.println(str2 + " Is palindrome? "+isPalindrome(str2));
    System.out.println(str3 + " Is palindrome? "+isPalindrome(str3));
    System.out.println(str4 + " Is palindrome? "+isPalindrome(str4));
    System.out.println(str5 + " Is palindrome? "+isPalindrome(str5));
    System.out.println(str6 + " Is palindrome? "+isPalindrome(str6));
    System.out.println(str7 + " Is palindrome? "+isPalindrome(str7));
    System.out.println(str8 + " Is palindrome? "+isPalindrome(str8));
    System.out.println(str9 + " Is palindrome? "+isPalindrome(str9));
    }
}