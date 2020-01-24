
public class MyStack<T>{

    class Node<T>{
        T data;

        public Node(T data){
            this.data = data;
        }
    }
    
    int STACK_LIMIT = 1000;
    Node stack_arr[] = new Node[STACK_LIMIT];

    int top = -1; // bottom : index = 0;


    public void push(T data){
        Node<T> node = new Node<T>(data);
        stack_arr[++top] = node;
    }


    public T pop(){  
      if (isEmpty()) return null;
        return (T) stack_arr[top--].data;  //* NB
    }

  
    public void insertAtBottom(T data){    //* NB
        if (isEmpty()) push(data);
        else{
          T tmp = pop();
          insertAtBottom(data);
          push(tmp); 
        }
    }


    public T peek(){
        if (isEmpty()) return null;
        return (T) stack_arr[top].data;
    }
    
    public T peekAt(int n){
        if (isEmpty() || (n-1) > getLength()) return null;
        return (T) stack_arr[n-1].data;
    }

    public void print(){
      if (isEmpty()) return;
        for(int i=top; i>=0; i--) 
              System.out.println("Item : " + (T) stack_arr[i].data);
    }


    public boolean isEmpty(){
        return top < 0;
    }


    public int getLength(){
        return top+1;
    }


}







