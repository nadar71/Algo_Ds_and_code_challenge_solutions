

/*
UNCOMPLETE, WORKING ON
*/
public class Main{


	public static getMaxArea(int[] arr){
		int size = arr.length;
		MyStack stk = new MyStack();
		int maxArea = 0;
		int top;
		int topArea;
		int i = 0;
		while(i < size){
			while(  i < size && 
				   (stk.isEmpty() || arr[stk.peek() <= arr[i]) ){
				stk.push(i);	
			    i++;
			}

			while ( !stk.isEmpty() &&
					(i == size || arr[stk.peek() > arr[i]) ){
				top = stk.peek();
				stk.pop();
				topArea = arr[top]*(stk.isEmpty() ? i: i-stk.peek()-1);
				if (maxArea < topArea) maxArea = topArea;
			}
		}
	}
	


	public static void main(String[] args){
		


	}
}