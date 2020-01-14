/*
Stack as Linked List implementation
*/
public class MyStack<T>{

  // inner node class
  private static class Node<T>{
      private T data;
      private Node<T> next;

      public Node(T data){
          this.data = data;
          next = null;
      }
  }

  private Node<T> top = null;
  private int length = 0;

  public T pop(){
    if (top == null) return null;
    T item = (T) top.data;
    top = top.next;
    if (length>0) length--;
    return item;
  }

  public T peek(){
    if (top == null) return null;
    return (T) top.data;
  }

  public void push(T data){
    Node<T> n = new Node<T>(data);
    n.next  = top;
    top = n;
    length++;
  }

  public void insertAtBottom(T data){
    if (isEmpty()) push(data);
    else {
      T tmp = pop();
      insertAtBottom(data);
      push(tmp);
    }
  }


  public void print(){
    if (isEmpty()) return;
    Node<T> ptr = top;
    while(ptr != null){
      System.out.println("Item : "+ptr.data+" from top.");
      ptr = ptr.next;
    }
  }

  public boolean isEmpty(){
    return top == null;
  }

  public int getLength(){
    return length;
  }


}



