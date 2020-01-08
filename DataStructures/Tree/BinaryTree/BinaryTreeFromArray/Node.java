
public class Node 
    { 
        int data; 
        boolean visited;
        Node left, right; 
      
        public Node(int item) 
        { 
            data     = item; 
            visited = false;
            left = right = null; 
        } 
    }