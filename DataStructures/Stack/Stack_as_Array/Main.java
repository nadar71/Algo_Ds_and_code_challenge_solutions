
class MyStack{

    class Node{
        int data;

        public Node(int data){
            this.data = data;
        }
    }
    
    int STACK_LIMIT = 1000;
    Node stack_arr[] = new Node[STACK_LIMIT];

    int top = -1; // bottom : index = 0;


    public void push(int data){
        Node node = new Node(data);
        stack_arr[++top] = node;
    }


    public int pop(){  
      if (isEmpty()) return -1;
        int data =  stack_arr[top--].data;  //* NB
        return data;
    }

  
    public void insertAtBottom(int data){    //* NB
        if (isEmpty()) push(data);
        else{
          int tmp = pop();
          insertAtBottom(data);
          push(tmp); 
        }
    }


    public int peek(){
        if (isEmpty()) return -1;
        return stack_arr[top].data;
    }

    public void print(){
      if (isEmpty()) return;
        for(int i=top; i>=0; i--) 
              System.out.println("Item : " + stack_arr[i].data);
    }


    public boolean isEmpty(){
        return top < 0;
    }


    public int getLength(){
        return top+1;
    }


}



public class Main{ 
    public static void main(String[] args) 
    { 
        
        MyStack ms = new MyStack();
        System.out.println("The stack is empty? "+ms.isEmpty());
        ms.push(20);
        ms.push(10);
        ms.push(13);

        ms.print();

        System.out.println("After inserting at bottom... ");
        ms.insertAtBottom(25);
        ms.print();

        System.out.println("item at top : "+ms.peek());
        System.out.println("Stack length : "+ms.getLength());
        
        System.out.println("Pop : "+ms.pop());
        System.out.println("Pop : "+ms.pop());
        System.out.println("Pop : "+ms.pop());
        System.out.println("Pop : "+ms.pop());
        ms.insertAtBottom(25);
        ms.push(1);
        ms.print();

    } 

}