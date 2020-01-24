/*
Print stack element at position n using a stack built on an array
*/


public class Main{

	public static void main(String[] args){
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		stack.print();
		
		System.out.println(" Element at position 1 : " + stack.peekAt(1));
		System.out.println(" Element at position 2 : " + stack.peekAt(2));
		System.out.println(" Element at position 3 : " + stack.peekAt(3));
		System.out.println(" Element at position 4 : " + stack.peekAt(4));

		stack.print();

	}


}

/*
Item : 4
Item : 3
Item : 2
Item : 1
 Element at position 1 : 1
 Element at position 2 : 2
 Element at position 3 : 3
 Element at position 4 : 4
Item : 4
Item : 3
Item : 2
Item : 1
 
*/