/*
DFS for Undirected graph : do not work for directed ones
*/


import java.io.*;
import java.util.*;
 
class Graph {
 private int numVertices;
 private LinkedList<Integer> vertices[];

 public Graph(int v) {
  numVertices = v;
  vertices = new LinkedList[v];
  // instantiate linked adjacency list for each node
  for (int i = 0; i < v; ++i)
     vertices[i] = new LinkedList();
 }


 // Add a directed edge 
 void addDirectedEdge(int src, int dst) {
  vertices[src].add(dst); 
 }

 // Add an edge 
 void addUNDirectedEdge(int src, int dst) {
  addDirectedEdge(src,dst); 
  addDirectedEdge(dst,src);
 }


 // Search for next nodes
 void search(int currentVertex, boolean visited[]) {
  visited[currentVertex] = true;
  System.out.print(currentVertex + " ");

  for( int i : vertices[currentVertex]){
    if (!visited[i]) search(i, visited);
  }

 }


 // DFS traversal. It uses recursive DFSUtil() 
 void DFS(int startingVertex) {
  // set as false by default in java
  boolean visited[] = new boolean[numVertices];
  for(boolean b : visited) b = false;
  search(startingVertex, visited);
 }


 void deleteGraph(){
  for(LinkedList<Integer> vertex : vertices)
    vertex = new LinkedList(); 
 }

}




public class Main{
 public static void main(String args[]) {
  Graph g = new Graph(6);

  System.out.println("Create undirected graph. ");

  g.addUNDirectedEdge(0, 1);
  g.addUNDirectedEdge(0, 4);
  g.addUNDirectedEdge(0, 5);
  g.addUNDirectedEdge(2, 1);
  g.addUNDirectedEdge(1, 3);
  g.addUNDirectedEdge(1, 4);
  g.addUNDirectedEdge(3, 2);
  g.addUNDirectedEdge(3, 4);

  System.out.println("Following is Depth First Traversal " +
   "(starting from vertex 0)");
  g.DFS(0);

  System.out.println("Delete graph. ");
  g.deleteGraph();


  System.out.println("Create directed graph. ");

  g.addDirectedEdge(0, 1);
  g.addDirectedEdge(0, 4);
  g.addDirectedEdge(0, 5);
  g.addDirectedEdge(2, 1);
  g.addDirectedEdge(1, 3);
  g.addDirectedEdge(1, 4);
  g.addDirectedEdge(3, 2);
  g.addDirectedEdge(3, 4);

  System.out.println("Following is Depth First Traversal " +
   "(starting from vertex 0)");
  g.DFS(0);
  System.out.println("...THAT IS WRONG! CAN'T WORK WITH DIRECTED GRAPH! ");



 }
}


/*
Create undirected graph. 
Following is Depth First Traversal (starting from vertex 0)
0 1 2 3 4 5 Delete graph. 
Create directed graph. 
Following is Depth First Traversal (starting from vertex 0)
0 1 2 3 4 5 ...THAT IS WRONG! CAN'T WORK WITH DIRECTED GRAPH! 



*/
