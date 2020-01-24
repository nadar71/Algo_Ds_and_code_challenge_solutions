/*
Reverse a stack with no other ds, easier algo then previous
*/

import java.util.Stack;

public class Main{
   
    public static void insertAtBottom(Stack<Integer> stack, int value ){
		if (stack.isEmpty()) stack.push(value);
		else{
			int tmp = stack.pop();
			insertAtBottom(stack,value);
			stack.push(tmp);
		}
	}
	
	
	
	public static void revert(Stack<Integer> stack){
    	if (stack.isEmpty() ) return ;
    	insertAtBottom(stack, stack.pop());  
	}
	
	
    

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

		printStack(stack);

		revert(stack);
		printStack(stack);

	}


}


/*
1 2 3 4  
4 1 2 3  

*/