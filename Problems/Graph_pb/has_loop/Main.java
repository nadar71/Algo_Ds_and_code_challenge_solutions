

/* 
Check if a WEIGHTED UNDIRECTED/DIRECTED GRAPH has loop
using DFS traversal
*/


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


public isDag(){
  DFS(vertices[0].src);
  return isDag;
}

public int getLoops(){
  DFS(vertices[0].src);
  return loops;
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

  System.out.println("The graph has any loops ? " + g.getLoops());
  

  System.out.println("Delete graph. ");
  g.deleteGraph();


  System.out.println("\nCreate directed graph 1 ");


  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 2, 1);
  g.addDirectedEdge(1, 0, 1);
  g.addDirectedEdge(2, 0, 1);
  g.addDirectedEdge(2, 3, 1);
  g.addDirectedEdge(3, 3, 1);
  
  g.printGraph();

  System.out.println("The graph has any loops ? " + g.getLoops());
  System.out.println("Delete graph. ");
  g.deleteGraph();
  
  
  System.out.println("\nCreate directed graph 2. ");

  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 4, 1);
  g.addDirectedEdge(0, 5, 1);
  g.addDirectedEdge(2, 1, 1);
  g.addDirectedEdge(1, 3, 1);
  g.addDirectedEdge(1, 4, 1);
  g.addDirectedEdge(3, 2, 1);
  g.addDirectedEdge(3, 4, 1);
  
  g.printGraph();

  System.out.println("The graph has any loops ? " + g.getLoops());  

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
Vertex : 0
Vertex : 1
New loop found!
Vertex : 2
New loop found!
Vertex : 3
New loop found!
New loop found!
Vertex : 4
New loop found!
New loop found!
New loop found!
Vertex : 5
New loop found!
The graph has any loops ? 8
Delete graph. 

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
Delete graph. 

Create directed graph 2. 

Vertex : 0 -> 1 -> 4 -> 5

Vertex : 1 -> 3 -> 4

Vertex : 2 -> 1

Vertex : 3 -> 2 -> 4


Vertex : 0
Vertex : 1
Vertex : 3
Vertex : 2
New loop found!
Vertex : 4
Vertex : 5
The graph has any loops ? 1





*/
