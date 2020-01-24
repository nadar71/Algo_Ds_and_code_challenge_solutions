/*
Print stack element at position n using another stack
*/

import java.util.Stack;

public class Main{

    public static int peekElementAt(Stack<Integer> stack, int n){
    	if (stack.isEmpty() || n > stack.size()) return -1;
    	Stack<Integer> auxStack = new Stack();
  		int length  = stack.size();
  		int count   = 1;
  		int peekValue  = -1;
  		while(count <= n && stack.size() > 0){
  			int tmp = stack.pop();
  			auxStack.push(tmp);
  			if (count == n) {
  				peekValue = tmp;
  				break;
  			}
  			count++;
  		}
  		while(auxStack.size() > 0 ){
  			stack.push(auxStack.pop());
  		}  		
  		return peekValue;
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