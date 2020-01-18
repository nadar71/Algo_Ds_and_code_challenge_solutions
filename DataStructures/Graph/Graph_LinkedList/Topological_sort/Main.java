

/* 
Print topological sort
*/

import java.util.Stack;

class Graph {
 int numVertices = 0;
 int loops = 0;
 boolean isDag = true;
 Vertex[] vertices;

 class Vertex{
    int src;
    int dst;
    int cost;
    Vertex next;

    public Vertex(int src, int dst, int cost){
      this.src = src;
      this.dst = dst;
      this.cost = cost;
      next = null;          
    }

 }


 
public Graph(int numVertices){
    this.numVertices = numVertices;
    vertices = new Vertex[numVertices];
  
    for(int i=0; i<numVertices; i++)
      vertices[i] = null;
    
  }
  


 public void addDirectedEdge(int src, int dst, int cost){
  Vertex vertex = new Vertex(src, dst, cost);

  if (vertices[src] == null) {
    vertices[src] = vertex;
    return;
  }
  else {
    Vertex ptr = vertices[src];
    while (ptr.next != null) ptr = ptr.next;
    ptr.next = vertex;
  }
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }



public void search(int src, boolean[] visited, boolean[] recStack){
  visited[src]  = true;
  recStack[src] = true;
  Vertex ptr = vertices[src];
  System.out.println("Vertex : "+ src);
  while(ptr != null){
    if (visited[ptr.dst] == false){
        visited[ptr.dst] = true;
        search(ptr.dst, visited, recStack);
    } 
    if (recStack[ptr.dst] == true){
      System.out.println("New loop found!");
      isDag = false;
      loops++;
    }
    ptr = ptr.next;
  }
  recStack[src] = false;
}


public void DFS(int startingVertex){
  boolean visited[]  = new boolean[numVertices];
  boolean recStack[] = new boolean[numVertices];
  for(int i = 0; i < numVertices-1; i++) {
    visited[i]  = false;
    recStack[i] = false;
  }
  search(startingVertex,visited,recStack);
}


public boolean isDag(){
  DFS(vertices[0].src);
  return isDag;
}

public int getLoops(){
  DFS(vertices[0].src);
  return loops;
}


public void topologicalSortDFS(int src, boolean[] visited, Stack stack){
  Vertex ptr = vertices[src];
  while (ptr != null){
    if (!visited[ptr.dst]){
       visited[ptr.dst] = true;
       topologicalSortDFS(ptr.dst, visited, stack);       
    }
    ptr = ptr.next;
  }
  stack.push(src);
}


public void topologicalSort(){
  System.out.println("isDag ? "+ isDag());
   if (!isDag()) {
     System.out.println("Graph contain cycles");
     return;
   }
   Stack<Integer> stack = new Stack<>();
   boolean visited[]  = new boolean[numVertices];
   for(boolean b: visited) 
     b = false;

   for(int i = 0; i < numVertices-1; i++) {
     if(visited[i] == false){
       visited[i]  = true;
       topologicalSortDFS(i, visited, stack);
     }
    }

   printTopologicalOrder(stack); 

}


public void printGraph(){
  for(int i = 0; i < numVertices; i++){
    Vertex ptr = vertices[i];

    while(ptr != null){
      if (ptr == vertices[i]) System.out.print("\nVertex : "+ ptr.src + " -> "+ ptr.dst);
      else System.out.print(" -> "+ptr.dst);
      ptr = ptr.next;
    }
    System.out.println();
  }

 }

public void printTopologicalOrder(Stack<Integer> stack){
  while( stack.size() > 0)
    System.out.print(stack.pop() + " , ");
  System.out.println(); 
  for(int i: stack)
    System.out.print(i+" , ");
 }
 
 
 public void deleteGraph(){
   for(int i=0; i<numVertices; i++)
     vertices[i] = null;
   loops = 0;
   isDag = true;
 }
 
 
 public boolean isEmpty(){
   int i = 0;
   while( i< numVertices){
     if  (vertices[i] != null) return false;
     i++;
   }
   return true;
 }


}





public class Main{
 public static void main(String args[]) {
  Graph g = new Graph(6);

  System.out.println("\nCreate directed graph 1 ");


  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 2, 1);
  g.addDirectedEdge(1, 0, 1);
  g.addDirectedEdge(2, 0, 1);
  g.addDirectedEdge(2, 3, 1);
  g.addDirectedEdge(3, 3, 1);
  
  g.printGraph();

  System.out.println("The graph has any loops ? " + g.getLoops()); 
  
  System.out.println("Print topological sort ");
  g.topologicalSort();
  
  System.out.println("Delete graph. ");
  g.deleteGraph();
  
  
  System.out.println("\nCreate directed graph 2. ");

  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 3, 1);
  g.addDirectedEdge(3, 1, 1);
  g.addDirectedEdge(3, 2, 1);
  g.addDirectedEdge(2, 4, 1);
  g.addDirectedEdge(2, 5, 1);
  
  g.printGraph();
  
  System.out.println("The graph has any loops ? " + g.getLoops()); 
  
  System.out.println("Print topological sort ");
  g.topologicalSort();
  
  g.deleteGraph();
  
  
  System.out.println("\nCreate directed graph 3. ");
  g = new Graph(8);
  g.addDirectedEdge(0, 2, 1);
  g.addDirectedEdge(4, 2, 1);
  g.addDirectedEdge(4, 1, 1);
  g.addDirectedEdge(2, 5, 1);
  g.addDirectedEdge(2, 6, 1);
  g.addDirectedEdge(2, 3, 1);
  g.addDirectedEdge(2, 1, 1);
  
  g.addDirectedEdge(1, 3, 1);
  g.addDirectedEdge(5, 7, 1);
  g.addDirectedEdge(6, 7, 1);

  g.printGraph();
  
  System.out.println("The graph has any loops ? " + g.getLoops()); 
  
  System.out.println("Print topological sort ");
  g.topologicalSort();

 }
}


/*

Create directed graph 1 

Vertex : 0 -> 1 -> 2

Vertex : 1 -> 0

Vertex : 2 -> 0 -> 3

Vertex : 3 -> 3


Vertex : 0
Vertex : 1
New loop found!
Vertex : 2
New loop found!
Vertex : 3
New loop found!
The graph has any loops ? 3
Print topological sort 
Vertex : 0
Vertex : 1
New loop found!
Vertex : 2
New loop found!
Vertex : 3
New loop found!
isDag ? false
Vertex : 0
Vertex : 1
New loop found!
Vertex : 2
New loop found!
Vertex : 3
New loop found!
Graph contain cycles
Delete graph. 

Create directed graph 2. 

Vertex : 0 -> 1 -> 3


Vertex : 2 -> 4 -> 5

Vertex : 3 -> 1 -> 2


Vertex : 0
Vertex : 1
Vertex : 3
Vertex : 2
Vertex : 4
Vertex : 5
The graph has any loops ? 0
Print topological sort 
Vertex : 0
Vertex : 1
Vertex : 3
Vertex : 2
Vertex : 4
Vertex : 5
isDag ? true
Vertex : 0
Vertex : 1
Vertex : 3
Vertex : 2
Vertex : 4
Vertex : 5
0 , 3 , 2 , 5 , 4 , 1 , 

Create directed graph 3. 

Vertex : 0 -> 2

Vertex : 1 -> 3

Vertex : 2 -> 5 -> 6 -> 3 -> 1


Vertex : 4 -> 2 -> 1

Vertex : 5 -> 7

Vertex : 6 -> 7

Vertex : 0
Vertex : 2
Vertex : 5
Vertex : 7
Vertex : 6
Vertex : 3
Vertex : 1
The graph has any loops ? 0
Print topological sort 
Vertex : 0
Vertex : 2
Vertex : 5
Vertex : 7
Vertex : 6
Vertex : 3
Vertex : 1
isDag ? true
Vertex : 0
Vertex : 2
Vertex : 5
Vertex : 7
Vertex : 6
Vertex : 3
Vertex : 1
4 , 0 , 2 , 1 , 3 , 6 , 5 , 7 , 


*/
