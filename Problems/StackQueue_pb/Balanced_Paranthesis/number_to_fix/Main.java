/*
Check if the brackets are balanced; if they are not, 
output the number of brackets to add to fix unbalancing, otherwise return 0.

- scan expression (a string, an array of character)
- push in stack if it is {[(
- peek from stack when found )]} : increment result if is not ([{, otherwise pop out 
 */

/*
Full problem text :
Bracket Match
A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.
Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.
Explain the correctness of your code, and analyze its time and space complexities.
Examples:
input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2

Constraints:
[time limit] 5000ms
[input] string text
1 ≤ text.length ≤ 5000
[output] integer

NB : check Problems/Generics  sections  for solutions without using stack or whatever

*/

import java.util.Stack;

public class Main {

	public static int matchBrackets(String expr) {
		Stack<Character> stack = new Stack<>();
		int length = expr.length();
		int result = 0;
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
					result++;
				else {
					test = stack.peek();
					if (test != '(') result++;
					else stack.pop();
				}
				break;

			case ']':
				if (stack.isEmpty())
					result++;
				else {
					test = stack.peek();
					if (test != '[') result++;
					else stack.pop();
				}
				break;
			case '}':
				if (stack.isEmpty())
					result++;
				else {
					test = stack.peek();
					if (test != '{') result++;
					else stack.pop();
				}
				break;
			default:
				break;
			}
		}
		while (!stack.isEmpty()) {
		    stack.pop();
		    result++;
		}
		
		return result;
	}

	public static void main(String args[]) {
		String expr_01 = "{[(())]}";  // 0
		String expr_02 = "{(())]}";   // 1 *
		String expr_03 = "{[())]}";   // 1 *
		String expr_04 = "{[(())]}{"; // 1
		String expr_05 = "{{";        // 2
		String expr_06 = "{[(())";    // 2
		String expr_07 = ")]}";       // 3
		String expr_08 = ")]}{[(";    // 6
		String expr_09 = "()))(";     // 3

		System.out.println("How many correction for expr_01 ? " + matchBrackets(expr_01));
		System.out.println("How many correction for expr_02 ? " + matchBrackets(expr_02));
		System.out.println("How many correction for expr_03 ? " + matchBrackets(expr_03));
		System.out.println("How many correction for expr_04 ? " + matchBrackets(expr_04));
		System.out.println("How many correction for expr_05 ? " + matchBrackets(expr_05));
		System.out.println("How many correction for expr_06 ? " + matchBrackets(expr_06));
		System.out.println("How many correction for expr_07 ? " + matchBrackets(expr_07));
		System.out.println("How many correction for expr_08 ? " + matchBrackets(expr_08));
		System.out.println("How many correction for expr_09 ? " + matchBrackets(expr_09));
		

	}

}


/*
How many correction for expr_01 ? 0
How many correction for expr_02 ? 1
How many correction for expr_03 ? 1
How many correction for expr_04 ? 1
How many correction for expr_05 ? 2
How many correction for expr_06 ? 2
How many correction for expr_07 ? 3
How many correction for expr_08 ? 6
How many correction for expr_09 ? 3



*/