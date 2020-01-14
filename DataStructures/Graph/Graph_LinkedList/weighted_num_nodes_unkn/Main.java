/* 
Built step by step 
an WEIGHTED UNDIRECTED/DIRECTED GRAPH : no initial number of vertices
*/

import java.util.ArrayList;


class Graph {
 int numVertices = 0;
 ArrayList<Vertex> vertices = new ArrayList<Vertex>();

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





 public void addDirectedEdge(int src, int dst, int cost){
  Vertex ptr = isVertex(src); 
  Vertex vertex = new Vertex(src, dst, cost);

  if (ptr == null){ 
    vertices.add(vertex);
    return;
  } else{
     while (ptr.next != null) ptr = ptr.next;
     ptr.next = vertex;
   }
   
 }
 
 
 
 public Vertex isVertex(int src){
  for(Vertex vertex: vertices)
     if (vertex.src == src) return vertex;
  
  return null;
 }
 
 

 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }

 


 public void printGraph(){
  if (vertices.isEmpty())  {
    System.out.print("Graph empty!");
    return;
  }
  

   for(Vertex vertex: vertices){
       System.out.print("\nVertex : "+ vertex.src + " -> "+ vertex.dst);
       Vertex ptr = vertex.next;
       while(ptr != null){
          System.out.print(" -> "+ptr.dst);
          ptr = ptr.next;
       }
       System.out.println();
   }
 }

 
 
 
 public void deleteGraph(){
   vertices.clear();
   // for(Vertex vertex: vertices) vertex = null; // doesn't work !!
 }
 
 
 
 public int getNumVertices(){
   return vertices.size();
 }
 

 public boolean isEmpty(){
   if (vertices.isEmpty()) return true; 
   else return false;
 }

}





public class Main{
 public static void main(String args[]) {

  Graph g = new Graph();
  System.out.println("Create graph DIRECTED");
  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 4, 1);
  g.addDirectedEdge(2, 3, 1);
  g.addDirectedEdge(1, 2, 1);
  g.addDirectedEdge(1, 3, 1);
  g.addDirectedEdge(1, 4, 1);
  g.addDirectedEdge(3, 4, 1);


  System.out.println("The graph is empty ? " + g.isEmpty());
  System.out.println("Num of vertices : " + g.getNumVertices());
  g.printGraph();
  
 
  System.out.println("Delete graph.");  
  g.deleteGraph();
  System.out.println("The graph is empty ? " + g.isEmpty());
  
  System.out.println("Create graph UNDIRECTED");
  g.addUNDirectedEdge(0, 1, 1);
  g.addUNDirectedEdge(0, 4, 1);
  g.addUNDirectedEdge(2, 3, 1);
  g.addUNDirectedEdge(1, 2, 1);
  g.addUNDirectedEdge(1, 3, 1);
  g.addUNDirectedEdge(1, 4, 1);
  g.addUNDirectedEdge(3, 4, 1);


  
  System.out.println("Num of vertices : " + g.getNumVertices());
  g.printGraph();
  
  
 }
}



/*
Create graph DIRECTED
The graph is empty ? false
Num of vertices : 4

Vertex : 0 -> 1 -> 4

Vertex : 2 -> 3

Vertex : 1 -> 2 -> 3 -> 4

Vertex : 3 -> 4
Delete graph.
The graph is empty ? true
Create graph UNDIRECTED
Num of vertices : 5

Vertex : 0 -> 1 -> 4

Vertex : 1 -> 0 -> 2 -> 3 -> 4

Vertex : 4 -> 0 -> 1 -> 3

Vertex : 2 -> 3 -> 1

Vertex : 3 -> 2 -> 1 -> 4





*/
