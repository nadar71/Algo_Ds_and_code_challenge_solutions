/*
UNDIRECTED/DIRECTED GRAPH OF INT
*/


import java.util.LinkedList;

class Graph {
   private int numVertexes;
   private LinkedList<Integer> vertexes[];
  
   public Graph(int v) {
   numVertexes   = v;
   vertexes = new LinkedList[v];
   // instantiate linked vertexesacency list for each node
   for (int i = 0; i < v; ++i)
      vertexes[i] = new LinkedList();
 }


 // UNDIRECTED GRAPH : Add an edge and the reverse
 void addUNDirectedEdge(int v, int w) {
    vertexes[v].add(w); 
    vertexes[w].add(v);
 }

 void addDirectedEdge(int v, int w) {
    vertexes[v].add(w); 
 }


 // Print the vertexesacency list representation of graph 
 void printGraph() {
  for (int v = 0; v < numVertexes; v++) {
     System.out.print("numVertexesertex " + v + " :");
   for (Integer vertex: vertexes[v]) {
       System.out.print(" -> " + vertex);
   }
   System.out.println("\n");
  }
 }


 public void deleteGraph(){
   for(int i=0; i<numVertexes; i++)
    vertexes[i] = new LinkedList();
 }
 
 
 public boolean isEmpty(){
   int i = 0;
   while( i< numVertexes){
     if  (vertexes[i] != null) return false;
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
