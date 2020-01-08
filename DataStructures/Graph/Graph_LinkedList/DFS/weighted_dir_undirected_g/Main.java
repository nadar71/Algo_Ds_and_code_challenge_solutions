/* 
WEIGHTED UNDIRECTED/DIRECTED GRAPH DFS traversal
*/


class Graph {
 private int numVertices = 0;

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


 AdjList[] vertices;

 
 public Graph(int numVertices){
  this.numVertices = numVertices;
  vertices = new AdjList[numVertices];
  for(int i=0; i<numVertices; i++)
    vertices[i] = new AdjList();
 }


 public void addDirectedEdge(int src, int dst, int cost){
  AdjVertex vertex = new AdjVertex(src, dst, cost);
  /*
  if (vertices[src].head == null){
    vertices[src].head = vertex;
    return;
  }
  */
  vertex.next = vertices[src].head;
  vertices[src].head = vertex;
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }



public void search(int src, boolean[] visited){
  AdjVertex ptr = vertices[src].head;
  System.out.println("Vertex : "+ src);
  while(ptr != null){
    if (visited[ptr.dst] == false){
        visited[ptr.dst] = true;
        search(ptr.dst, visited);
    }
    ptr = ptr.next;
  }
}

public void DFS(int startingVertex){
  boolean visited[] = new boolean[numVertices];
  for(boolean i : visited) i = false;
  visited[startingVertex] = true;  
  search(startingVertex,visited);
}


 public void printGraph(){
  for(int i = 0; i < numVertices; i++){
    AdjVertex ptr = vertices[i].head;

    while(ptr != null){
      if (ptr == vertices[i].head) System.out.print("\nVertex : "+ ptr.src + " -> "+ ptr.dst);
      else System.out.print(" -> "+ptr.dst);
      ptr = ptr.next;
    }
    System.out.println();
  }

 }
 
 
 public void deleteGraph(){
   for(int i=0; i<numVertices; i++)
    vertices[i].head = null;
 }
 
 
 public boolean isEmpty(){
   int i = 0;
   while( i< numVertices){
     if  (vertices[i].head != null) return false;
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

  System.out.println("Following is Depth First Traversal " +
   "(starting from vertex 0)");
  g.DFS(0);

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


  System.out.println("Following is Depth First Traversal " +
   "(starting from vertex 0)");
  g.DFS(0);



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
Following is Depth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 3
Vertex : 2
Vertex : 1
Delete graph. 
Create directed graph. 

Vertex : 0 -> 5 -> 4 -> 1

Vertex : 1 -> 4 -> 3

Vertex : 2 -> 1

Vertex : 3 -> 4 -> 2


Following is Depth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 1
Vertex : 3
Vertex : 2



*/
