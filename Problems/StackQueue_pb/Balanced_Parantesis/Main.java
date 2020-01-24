package balancedParentesis;


/*
- scan expression (a string, an array of character)
- push in stack if it is {[(
- pop from stack when found )]} : the popped out is not ([{, then error 
 */

import java.util.Stack;

public class Main {

	public static boolean isBalancedParenthesis(String expr) {
		Stack<Character> stack = new Stack<>();
		int length = expr.length();
		boolean result = false;
		for (int i = 0; i < length; i++) {
			char c = expr.charAt(i);
			char test;
			switch (c) {
			case '{':
			case '[':
			case '(':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty())
					result = false;
				else {
					test = stack.pop();
					if (test == '(')
						result = true;
					else
						result = false;
					break;
				}

			case ']':
				if (stack.isEmpty())
					result = false;
				else {
					test = stack.pop();
					if (test == '[')
						result = true;
					else
						result = false;
					break;
				}
			case '}':
				if (stack.isEmpty())
					result = false;
				else {
					test = stack.pop();
					if (test == '{')
						result = true;
					else
						result = false;
					break;
				}
			default:
				break;
			}
		}
		if (!stack.isEmpty())
			result = false;
		return result;
	}

	public static void main(String args[]) {
		String expr_01 = "{[(())]}";
		String expr_02 = "{(())]}";
		String expr_03 = "{[())]}";
		String expr_04 = "{[(())]}{";
		String expr_05 = "{{";
		String expr_06 = "{[(())";
		String expr_07 = ")]}";

		System.out.println("expr_01 is balanced ? " + isBalancedParenthesis(expr_01));
		System.out.println("expr_02 is balanced ? " + isBalancedParenthesis(expr_02));
		System.out.println("expr_03 is balanced ? " + isBalancedParenthesis(expr_03));
		System.out.println("expr_04 is balanced ? " + isBalancedParenthesis(expr_04));
		System.out.println("expr_05 is balanced ? " + isBalancedParenthesis(expr_05));
		System.out.println("expr_06 is balanced ? " + isBalancedParenthesis(expr_06));
		System.out.println("expr_07 is balanced ? " + isBalancedParenthesis(expr_07));

	}

}
