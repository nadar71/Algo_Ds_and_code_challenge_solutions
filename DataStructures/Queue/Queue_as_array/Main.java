/*
Queue as array
*/


class MyQueue{
	class Node{
		int data;

		public Node(int data){
			this.data = data;
		}
	}


	public int QUEUE_LIMIT = 1000;
	private int first = -1;
	private int last  = -1;
	private int length = 0;
	private Node[] queue = new Node[QUEUE_LIMIT];

	public void add(int data){
		Node node = new Node(data);
		queue[++last] = node;
		if (first < 0 ) first = last;
	}

	public int remove(){
	  if (first > last) return -1;
    int data = queue[first].data;
    first++;
		return data;
	}


	public int peek(){
		return queue[first].data;
	}


	public boolean isEmpty(){
		return (first < 0);

	}


	public int getLength(){
		return (last-first+1);

	}

	
	public void print(){
		int ptr = first;

		while(ptr <= last){
			System.out.println("Item : "+queue[ptr].data);
			ptr++;
		}

	}





}



public class Main{ 
    public static void main(String[] args) 
    { 
        
        MyQueue mq = new MyQueue();
        System.out.println("The queue is empty? " + mq.isEmpty() );
        mq.add(20);
        mq.add(10);
        mq.add(13);

        System.out.println("After insertions: ");
        mq.print();
        
        System.out.println("First item : "+mq.peek());
        System.out.println("Length: "+mq.getLength());
        
 
        System.out.println("Remove : "+mq.remove());
        System.out.println("Remove : "+mq.remove());
        mq.print();
        System.out.println("Length: "+mq.getLength());
        System.out.println("Remove : "+mq.remove());
        System.out.println("Remove : "+mq.remove());

        mq.print();
        System.out.println("Length: "+mq.getLength());

    } 

}

