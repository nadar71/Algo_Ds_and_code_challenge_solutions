

/* 
Find if exists a path between 2 vertexes in WEIGHTED UNDIRECTED/DIRECTED GRAPH 
using DFS traversal
*/


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
    while (ptr.next != null) ptr = ptr.next;
    ptr.next = vertex;
  }
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }




  public void search(int src, boolean[] visited){
    visited[src] = true; 
    Vertex ptr   = vertices[src];
    System.out.println("Vertex : "+ src);
    while(ptr != null){
      if (!visited[ptr.dst]){
          visited[ptr.dst] = true;
          search(ptr.dst, visited);
      }
      ptr = ptr.next;
    }
  }
  
  
  public boolean[] DFS(int startingVertex){
    boolean visited[] = new boolean[numVertices];
    for(boolean i : visited) i = false;
    search(startingVertex,visited);
    return visited;
  }
  
  
  
  public boolean isTherePath(int start, int goal){
    boolean visited[] = DFS(start);
    return visited[goal];
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

  System.out.println("I there a path between 1 and 3 ? " + g.isTherePath(1,3));
  System.out.println("I there a path between 4 and 2 ? " + g.isTherePath(4,2));
  System.out.println("I there a path between 0 and 2 ? " + g.isTherePath(0,2));

  
  

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


  System.out.println("I there a path between 1 and 3 ? " + g.isTherePath(1,3));
  System.out.println("I there a path between 4 and 2 ? " + g.isTherePath(4,2));
  System.out.println("I there a path between 0 and 2 ? " + g.isTherePath(0,2));




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
Vertex : 1
Vertex : 0
Vertex : 4
Vertex : 3
Vertex : 2
Vertex : 5
I there a path between 1 and 3 ? true
Vertex : 4
Vertex : 0
Vertex : 1
Vertex : 2
Vertex : 3
Vertex : 5
I there a path between 4 and 2 ? true
Vertex : 0
Vertex : 1
Vertex : 2
Vertex : 3
Vertex : 4
Vertex : 5
I there a path between 0 and 2 ? true
Delete graph. 
Create directed graph. 

Vertex : 0 -> 1 -> 4 -> 5

Vertex : 1 -> 3 -> 4

Vertex : 2 -> 1

Vertex : 3 -> 2 -> 4


Vertex : 1
Vertex : 3
Vertex : 2
Vertex : 4
I there a path between 1 and 3 ? true
Vertex : 4
I there a path between 4 and 2 ? false
Vertex : 0
Vertex : 1
Vertex : 3
Vertex : 2
Vertex : 4
Vertex : 5
I there a path between 0 and 2 ? true




*/
