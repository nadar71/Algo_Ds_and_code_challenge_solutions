/*
Reverse a stack with no auxiliary ds or other stack
*/

import java.util.Stack;

public class Main{
   
	
	public static void reverseStack(Stack<Integer> stack){
		if (stack.isEmpty()) return;
		else{
			int tmp = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, tmp);
		}

	}
	
	public static void insertAtBottom(Stack<Integer> stack, int value){
		if (stack.isEmpty()) stack.push(value);
		else{
			int tmp = stack.pop();
			insertAtBottom(stack,value);
			stack.push(tmp);
		}
	}


    /* This DOESN'T WORK !!

    public static void reverseStack2(Stack<Integer> stack){
		if (stack.isEmpty()) return;
		int length = stack.size();
		while(length > 0 ){
			insertAtBottom(stack, stack.pop());
			length--;
		}

	}

    */

	public static void printStack(Stack<Integer> st){
		if (st.isEmpty()) {
		  System.out.print(" Stack empty "); 
		  return ;
		}
		for(Integer item: st) System.out.print(item + " ");
		System.out.println(" ");	
	}


	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		// stack pop : 1,2,3,4 
		printStack(stack);
		reverseStack(stack);

		// stack pop expected after reversion : 4,3,2,1
		printStack(stack);

	}


}