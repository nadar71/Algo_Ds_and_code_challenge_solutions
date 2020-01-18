package tree;

public class Node 
    { 
        public int data; 
        public boolean visited;
        public Node left, right; 
      
        public Node(int item) 
        { 
            data     = item; 
            visited = false;
            left = right = null; 
        } 
    }