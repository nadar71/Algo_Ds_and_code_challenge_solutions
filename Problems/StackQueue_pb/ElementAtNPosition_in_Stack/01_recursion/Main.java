/*
Print stack element at position n : using recursion
*/

import java.util.Stack;

public class Main{
    static int peekValue = -1;   

    public static int peekElementAt(Stack<Integer> stack, int n){
    	if (stack.isEmpty() || n > stack.size()) return -1;
  		int length  = stack.size();
  		int count   = 0;
  		peekValue     = -1;
  		search(stack, n, count);
  		return peekValue;
    }


    public static void search(Stack<Integer> stack, int n, int count){
    	if (stack.isEmpty()) return ;
  		else{
  			int tmp = stack.pop();
  			count++;
  			if (count == n) peekValue = tmp;
  			search(stack,n, count);
  			stack.push(tmp);
  		}
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
		
		System.out.println(" Element at position 1 : " + peekElementAt(stack, 1));
		System.out.println(" Element at position 2 : " + peekElementAt(stack, 2));
		System.out.println(" Element at position 3 : " + peekElementAt(stack, 3));
		System.out.println(" Element at position 4 : " + peekElementAt(stack, 4));

		printStack(stack);

	}


}


/*
1 2 3 4  
 Element at position 1 : 4
 Element at position 2 : 3
 Element at position 3 : 2
 Element at position 4 : 1
1 2 3 4  

*/