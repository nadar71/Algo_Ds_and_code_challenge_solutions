

/* 
Check if a WEIGHTED UNDIRECTED/DIRECTED GRAPH is connected
using DFS traversal
*/


class Graph {
 private int numVertexes = 0;

 class AdjVertex{
    int src;
    int dst;
    int cost;
    AdjVertex next;

    public AdjVertex(int src, int dst, int cost){
      this.src = src;
      this.dst = dst;
      this.cost = cost;
      next = null;          
    }

 }


 class AdjList{
    AdjVertex head = null;
 }


 AdjList[] vertexes;

 
 public Graph(int numVertexes){
  this.numVertexes = numVertexes;
  vertexes = new AdjList[numVertexes];
  for(int i=0; i<numVertexes; i++)
    vertexes[i] = new AdjList();
 }


 public void addDirectedEdge(int src, int dst, int cost){
  AdjVertex vertex = new AdjVertex(src, dst, cost);
  /*
  if (vertexes[src].head == null){
    vertexes[src].head = vertex;
    return;
  }
  */
  vertex.next = vertexes[src].head;
  vertexes[src].head = vertex;
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }



public void search(int src, boolean[] visited){
  AdjVertex ptr = vertexes[src].head;
  System.out.println("Vertex : "+ src);
  while(ptr != null){
    if (visited[ptr.dst] == false){
        visited[ptr.dst] = true;
        search(ptr.dst, visited);
    }
    ptr = ptr.next;
  }
}

public boolean[] DFS(int startingVertex){
  boolean visited[] = new boolean[numVertexes];
  for(boolean i : visited) i = false;
  visited[startingVertex] = true;  
  search(startingVertex,visited);
  return visited;
}



public boolean isConnected(){
  boolean visited[] = DFS(vertexes[0].head.src);
  for(boolean i:visited) 
    if (i == false) return false;

  return true;
}


 public void printGraph(){
  for(int i = 0; i < numVertexes; i++){
    AdjVertex ptr = vertexes[i].head;

    while(ptr != null){
      if (ptr == vertexes[i].head) System.out.print("\nVertex : "+ ptr.src + " -> "+ ptr.dst);
      else System.out.print(" -> "+ptr.dst);
      ptr = ptr.next;
    }
    System.out.println();
  }

 }
 
 
 public void deleteGraph(){
   for(int i=0; i<numVertexes; i++)
    vertexes[i].head = null;
 }
 
 
 public boolean isEmpty(){
   int i = 0;
   while( i< numVertexes){
     if  (vertexes[i].head != null) return false;
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

  System.out.println("The graph is connected ? " + g.isConnected());
  

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

  System.out.println("The graph is connected ? " + g.isConnected());

 }
}


/*

Create undirected graph. 

Vertex : 0 -> 5 -> 4 -> 1

Vertex : 1 -> 4 -> 3 -> 2 -> 0

Vertex : 2 -> 3 -> 1

Vertex : 3 -> 4 -> 2 -> 1

Vertex : 4 -> 3 -> 1 -> 0

Vertex : 5 -> 0
Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 3
Vertex : 2
Vertex : 1
The graph is connected ? true
Delete graph. 
Create directed graph. 

Vertex : 0 -> 5 -> 4 -> 1

Vertex : 1 -> 4 -> 3

Vertex : 2 -> 1

Vertex : 3 -> 4 -> 2


Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 1
Vertex : 3
Vertex : 2
The graph is connected ? true




*/
