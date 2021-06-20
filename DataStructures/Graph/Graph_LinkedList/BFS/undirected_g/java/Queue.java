
/*
Queue as a LinkedList
*/

public class Queue<T>{

  // inner node class
  private static class Node<T>{
      private T data;
      private Node<T> next;
      

      public Node(T data){
          this.data = data;
      }
  }

  private Node<T> first = null;
  private Node<T> last  = null;
  private int length  = 0;



  public void add(T data){
    Node<T> node = new Node<T>(data);

    if( last == null ) last = node;
    else {
      last.next = node;
      last      = node;
      length++;
    }

    if(first == null){
      first = last;
    }
  }

  
  public T remove(){
    if (first == null) return null;
    T data = first.data;
    first = first.next;
    if (length>0) length-- ;
    
    // in case removed the last remaining element in list
    if (first == null) last = null;
    return data;
  }

  
  public void print(){
    if (isEmpty()) return;
    Node<T> ptr = first;

    while(ptr != null){
      System.out.println("Item : "+ptr.data);
      ptr = ptr.next;
    }
  }

  public T peek(){
    if (first == null) return  null;
    return first.data;
  }



  public boolean isEmpty(){
    return first == null;
  }
  
  public int getLength(){
    return length;
  }

}

  
