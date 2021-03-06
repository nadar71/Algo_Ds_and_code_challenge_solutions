/* 
Built step by step 
an WEIGHTED UNDIRECTED/DIRECTED GRAPH : no initial number of vertexes
*/

import java.util.ArrayList;


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


 ArrayList<AdjList> vertexes;

 
 public Graph(){
    vertexes = new ArrayList<>();
 }


 public void addDirectedEdge(int src, int dst, int cost){
  AdjVertex vertex = new AdjVertex(src, dst, cost);
  AdjList list = isNewVertex(src);

  if (list == null) {
    list = new AdjList();
    vertex.next = list.head;
    list.head = vertex;   // new vertex is all and  remain at the head of the list
    vertexes.add(list);
    numVertexes++;
  } else {
    vertex.next = list.head.next;
    list.head.next = vertex;
  }
 }
 

 
 public AdjList isNewVertex(int data){
   for(AdjList list : vertexes ){
     if ( list != null && list.head != null && list.head.src == data ) {
       return list;
     }
   }
   return null;
 }

 

 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }

 


 public void printGraph(){
  if (vertexes.isEmpty())  {
    System.out.print("Graph empty!");
    return;
  }
  for(AdjList list : vertexes){
    AdjVertex ptr = list.head;
    int count = 0;
    while(ptr != null){
      if (count == 0) System.out.print("\nVertex : "+ ptr.src + " -> "+ ptr.dst);
      else System.out.print(" -> "+ptr.dst);
      ptr = ptr.next;
      count++;
    }
    System.out.println();

  }

 }
 
 
 public void deleteGraph(){
   // vertexes.clear();
   for(AdjList list : vertexes) list.head = null;
   numVertexes = 0;
 }
 
 
 public boolean isEmpty(){
   if (vertexes.isEmpty()) return true; 
   else return false;
 }
 
 public int getNumVertexes(){
   return numVertexes;
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
  System.out.println("Num of vertexes : " + g.getNumVertexes());
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


  
  System.out.println("Num of vertexes : " + g.getNumVertexes());
  g.printGraph();
  
  
  
 }
}



/*
Create graph DIRECTED
The graph is empty ? false
Num of vertexes : 4

Vertex : 0 -> 1 -> 4

Vertex : 2 -> 3

Vertex : 1 -> 2 -> 4 -> 3

Vertex : 3 -> 4

Delete graph.
The graph is empty ? false
Create graph UNDIRECTED
Num of vertexes : 5


Vertex : 0 -> 1 -> 4

Vertex : 1 -> 0 -> 4 -> 3 -> 2

Vertex : 4 -> 0 -> 3 -> 1

Vertex : 2 -> 3 -> 1

Vertex : 3 -> 2 -> 4 -> 1



*/
