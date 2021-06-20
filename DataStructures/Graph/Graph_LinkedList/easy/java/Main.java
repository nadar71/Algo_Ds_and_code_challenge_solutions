/*
UNDIRECTED/DIRECTED GRAPH OF INT
*/


import java.util.LinkedList;

class Graph {
   int numVertices;
   LinkedList<Integer> vertices[];
  
   public Graph(int v) {
     numVertices   = v;
     vertices = new LinkedList[v];
     // instantiate linked verticesacency list for each node
     for (int i = 0; i < v; ++i)
        vertices[i] = new LinkedList();
   }


 // UNDIRECTED GRAPH : Add an edge and the reverse
 void addUNDirectedEdge(int v, int w) {
    vertices[v].add(w); 
    vertices[w].add(v);
 }

 void addDirectedEdge(int v, int w) {
    vertices[v].add(w); 
 }


 // Print the vertices in the adjacency list representation of graph 
 void printGraph() {
  for (int v = 0; v < numVertices; v++) {
     System.out.print("Vertex " + v + " :");
   for (int vertex: vertices[v]) {
       System.out.print(" -> " + vertex);
   }
   System.out.println("\n");
  }
 }


 public void deleteGraph(){
   for(int i=0; i<numVertices; i++)
    vertices[i] = new LinkedList();
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

  Graph g = new Graph(5);
  System.out.println("Create graph DIRECTED");
  g.addDirectedEdge(0, 1);
  g.addDirectedEdge(0, 4);
  g.addDirectedEdge(1, 2);
  g.addDirectedEdge(1, 3);
  g.addDirectedEdge(1, 4);
  g.addDirectedEdge(2, 3);
  g.addDirectedEdge(3, 4);

  g.printGraph();
  
  System.out.println("Delete graph.");  
  g.deleteGraph();
  System.out.println("The graph is empty ? " + g.isEmpty());
  
  System.out.println("Create graph UNDIRECTED");
  g.addUNDirectedEdge(0, 1);
  g.addUNDirectedEdge(0, 4);
  g.addUNDirectedEdge(1, 2);
  g.addUNDirectedEdge(1, 3);
  g.addUNDirectedEdge(1, 4);
  g.addUNDirectedEdge(2, 3);
  g.addUNDirectedEdge(3, 4);
  
  g.printGraph();

 }
}
