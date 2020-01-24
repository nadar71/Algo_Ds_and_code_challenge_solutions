

import java.util.Stack;

public class Main {

	public static boolean isPalindrome(String expr) {
		if (expr.length() <= 1) return true;

		Stack<Character> stack = new Stack<>();
		int length = expr.length(); 
		int mid    = (int) length/2; 
		
		boolean isOdd = true;
		if (length % 2 == 0) isOdd = false; 
		
 		int count = 0;
		for (int i = 0; i < length; i++) {
			char c = expr.charAt(i);
			if (count < mid) stack.push(c);
			else {
				if (isOdd == true) continue;
				if (c != stack.pop()) return false;
			}
      count++;
		}

		return true;
	}

	public static void main(String args[]) {
		String expr_01 = "{[(())]}"; // false
		String expr_02 = "abcdcba";  // true
		String expr_03 = "abccba";   // true
		String expr_04 = "abcdef";
		String expr_05 = "abcccba";  // true
		String expr_06 = "a";        // true
		String expr_07 = "ab";
		String expr_08 = "";        // true

		System.out.println("expr_01 is palindrome ? " + isPalindrome(expr_01));
		System.out.println("expr_02 is palindrome ? " + isPalindrome(expr_02));
		System.out.println("expr_03 is palindrome ? " + isPalindrome(expr_03));
		System.out.println("expr_04 is palindrome ? " + isPalindrome(expr_04));
		System.out.println("expr_05 is palindrome ? " + isPalindrome(expr_05));
		System.out.println("expr_06 is palindrome ? " + isPalindrome(expr_06));
		System.out.println("expr_07 is palindrome ? " + isPalindrome(expr_07));
		System.out.println("expr_08 is palindrome ? " + isPalindrome(expr_08));

	}

}
