import java.util.Queue;
import java.util.LinkedList;

class Stack{
	Queue<Integer> q1, q2;

	public Stack(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	public void push(int data){
		q1.add(data);
	} 


	public int pop(){
	    if (isEmpty()) return -1;
		if (q2.size() > 0) return q2.remove();

		while (q1.size() > 0) q2.add(q1.remove());
		return q2.remove();

	}

	public boolean isEmpty(){
		return (q1.size() <= 0 && q2.size() <= 0);
	}


}

public class Main{
    
    public static void main (String[] args) {
        Stack  st = new Stack();

    System.out.println("Queue create, is empty.");
	System.out.println(st.pop());

    System.out.println("Add first 4 items to queue.");
	st.push(1);
	st.push(2);
	st.push(3);
	st.push(4);

    System.out.println("remove 4 items from queue.");
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st.pop());

    System.out.println("Add first 3 items to queue.");
	st.push(5);
	st.push(6);
	st.push(7);

    System.out.println("remove 3 items from queue.");
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st.pop());
        
    }
	





}