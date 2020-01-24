
/*
Check if the string is composed by unique character only
*/

public  class Main{

    public static boolean isUniqueChars(String str){
          if (str.length() == 0) return true;
          int strlen = str.length();
          int[] bitArray = new int[128];
          for(int i = 0; i < bitArray.length-1; i++ ) bitArray[i] = 0;
          for(int i = 0; i < strlen; i++ ){
             char c = str.charAt(i);
             /* // in case only literlas, use bitarray[26]
             if ( 'A' <= c  && 'Z' >= c) c = c - 'A'; // uppercase
             else if ( 'a' <= c  && 'z' >= c) c = c - 'a'; // lowercase
             else { 
                System.out.println(c + " is a not allowed char ");
                return false;
             }
             */
             if (bitArray[c] != 0) return false;  
             bitArray[c] = 1;      
          }
          return true;
    }
          




    public static void main(String args[]){
    String str1 = "aAbcd";
    String str2 = "ABab";
    String str3 = "a1234d";
    String str4 = "~asd";
    String str5 = "~asd~";
    String str6 = "";
    String str7 = " ";
    String str8 = "  ";
    String str9 = "1232abc";
    String str10 = ">123abc>";
    String str11 = ">123abc";
        

    // System.out.println(" 'a' int code  : "+Integer.toHexString(a));
    System.out.println(str1 + " Is unique? "+isUniqueChars(str1));
    System.out.println(str2 + " Is unique? "+isUniqueChars(str2));
    System.out.println(str3 + " Is unique? "+isUniqueChars(str3));
    System.out.println(str4 + " Is unique? "+isUniqueChars(str4));
    System.out.println(str5 + " Is unique? "+isUniqueChars(str5));
    System.out.println(str6 + " Is unique? "+isUniqueChars(str6));
    System.out.println(str7 + " Is unique? "+isUniqueChars(str7));
    System.out.println(str8 + " Is unique? "+isUniqueChars(str8));
    System.out.println(str9 + " Is unique? "+isUniqueChars(str9));
    System.out.println(str10 + " Is unique? "+isUniqueChars(str10));
    System.out.println(str11 + " Is unique? "+isUniqueChars(str11));
    }
}