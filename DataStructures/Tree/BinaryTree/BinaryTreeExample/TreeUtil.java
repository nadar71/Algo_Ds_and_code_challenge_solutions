

public class TreeUtil extends BinaryTree {
    // from https://github.com/camluca/Samples/blob/master/Tree.java

    class StackNode
    {
      public Node item;
      public StackNode next;
      public StackNode(Node val){
        item = val;
      }  

    }



    class LinkedListStack
    {
      private StackNode first;
      public LinkedListStack(){
        first = null;
      }

      public boolean isEmpty(){
        return (first==null);
      }
      
      //inserts at beginning of list 
      public void insert(Node data)
      {
        StackNode newLLNode = new StackNode(data);
        newLLNode.next = first;
        first = newLLNode;
      }

      //deletes at beginning of list
      public Node delete(){
        StackNode temp = first;
        first = first.next;
        return temp.item;
      }

    }



    class Stack{
      private LinkedListStack listObj;

      public Stack()  {
        listObj = new LinkedListStack();
      }

      public void push(Node num)  {
        listObj.insert(num);
      }

      public Node pop() {
        return listObj.delete();
      }

      public boolean isEmpty()  {
        return listObj.isEmpty();
      }

    }


    public void displayTree(Node root)  {
        Stack globalStack = new Stack();
        globalStack.push(root); 
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(isRowEmpty==false){

          Stack localStack = new Stack();
          isRowEmpty = true;
          for(int j=0; j<emptyLeaf; j++)
            System.out.print(' ');
          while(globalStack.isEmpty()==false){
            Node temp = globalStack.pop();
            if(temp != null)
            {
              System.out.print(temp.data);
              localStack.push(temp.left);
              localStack.push(temp.right);
              if(temp.left != null ||temp.right != null)
                isRowEmpty = false;
            }
            else{
              System.out.print("--");
              localStack.push(null);
              localStack.push(null);
            }
            for(int j=0; j<emptyLeaf*2-2; j++)
              System.out.print(' ');
          }
          System.out.println();
          emptyLeaf /= 2;
          while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
        }
      System.out.println("****......................................................****");
      }
} 



