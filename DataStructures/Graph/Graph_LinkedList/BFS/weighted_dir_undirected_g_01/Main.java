/* 
WEIGHTED UNDIRECTED/DIRECTED GRAPH BFS traversal
*/

import java.util.LinkedList;

class Graph {
 int numVertices = 0;
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
    /*
    vertex.next = ptr.next;
    ptr.next = vertex;
    */
    while (ptr.next != null) ptr = ptr.next;
    ptr.next = vertex;

  }
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }



  public void BFS(int startingVertex){
    int curr;
    boolean visited[] = new boolean[numVertices];
    for(boolean i : visited) i = false;
    visited[startingVertex] = true;
  
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(startingVertex);  

    while(queue.size() > 0 ){
      curr = queue.poll();
      Vertex ptr = vertices[curr];
      System.out.println("Vertex : "+ curr);
      while(ptr != null){
        if (!visited[ptr.dst]){
            visited[ptr.dst] = true;
            // System.out.println("Vertex : "+ ptr.dst);
            queue.add(ptr.dst);
        }
        ptr = ptr.next;
      }
    }  
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
 
 
 public void deleteGraph(){
   for(int i=0; i<numVertices; i++)
    vertices[i] = null;
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

  System.out.println("Create undirected graph. ");

  g.addUNDirectedEdge(0, 1, 1);
  g.addUNDirectedEdge(0, 4, 1);
  g.addUNDirectedEdge(0, 5, 1);
  g.addUNDirectedEdge(2, 1, 1);
  g.addUNDirectedEdge(1, 3, 1);
  g.addUNDirectedEdge(1, 4, 1);
  g.addUNDirectedEdge(3, 2, 1);
  g.addUNDirectedEdge(3, 4, 1);
  
  g.printGraph();

  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 0)");
  g.BFS(0);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(1);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(3);

  System.out.println("Delete graph. ");
  g.deleteGraph();


  System.out.println("Create directed graph. ");

  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 4, 1);
  g.addDirectedEdge(0, 5, 1);
  g.addDirectedEdge(2, 1, 1);
  g.addDirectedEdge(1, 3, 1);
  g.addDirectedEdge(1, 4, 1);
  g.addDirectedEdge(3, 2, 1);
  g.addDirectedEdge(3, 4, 1);
  
  g.printGraph();


  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 0)");
  g.BFS(0);
  
    
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(1);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(3);



 }
}


/*
Create undirected graph. 

Vertex : 0 -> 1 -> 4 -> 5

Vertex : 1 -> 0 -> 2 -> 3 -> 4

Vertex : 2 -> 1 -> 3

Vertex : 3 -> 1 -> 2 -> 4

Vertex : 4 -> 0 -> 1 -> 3

Vertex : 5 -> 0
Following is Breadth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 1
Vertex : 4
Vertex : 5
Vertex : 2
Vertex : 3
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 1
Vertex : 0
Vertex : 2
Vertex : 3
Vertex : 4
Vertex : 5
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 3
Vertex : 1
Vertex : 2
Vertex : 4
Vertex : 0
Vertex : 5
Delete graph. 
Create directed graph. 

Vertex : 0 -> 1 -> 4 -> 5

Vertex : 1 -> 3 -> 4

Vertex : 2 -> 1

Vertex : 3 -> 2 -> 4


Following is Breadth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 1
Vertex : 4
Vertex : 5
Vertex : 3
Vertex : 2
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 1
Vertex : 3
Vertex : 4
Vertex : 2
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 3
Vertex : 2
Vertex : 4
Vertex : 1




*/
