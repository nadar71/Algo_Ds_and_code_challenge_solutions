
/*
ERROR, MUST BE REVIEWED
Shortest path from 1 node to all others node in an unweighted graph (or graph where all the edge hav the same weigth)
*/


import java.util.Queue;
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


 public void shortestPath(int src){
		int curr;
		int distance[] = new int[numVertices];
		int path[] = new int[numVertices];

		LinkedList<Integer> queue = new LinkedList<>();
		for(int i=0; i < numVertices -1; i++ ) distance[i] = -1;
		queue.add(src);
		distance[src]  = 0;

		while(queue.size() > 0){
			curr = queue.poll();
			Vertex ptr = vertices[curr];

			while( ptr != null){
				if(distance[ptr.dst] == -1){
					distance[ptr.dst] = distance[curr] + 1;
					path[ptr.dst] = curr;
					queue.add(ptr.dst);
				}
				ptr = ptr.next;
			}
		}

		for(int i=0; i < numVertices; i++) 
			System.out.println(path[i] + " to " + i + " weight " + distance[i]);
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

  System.out.println("Directed Graph :  Shortest Path from  node " + 0 + 
   " to all other nodes.");
  g.shortestPath(0);
  

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


  System.out.println("Directed Graph : Shortest Path from  node " + 0 + 
   " to all other nodes.");
  g.shortestPath(0);
  
    
  



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
Directed Graph :  Shortest Path from  node 0 to all other nodes.
0 to 0 weight 0
0 to 1 weight 1
1 to 2 weight 2
1 to 3 weight 2
0 to 4 weight 1
0 to 5 weight 0
Delete graph. 
Create directed graph. 

Vertex : 0 -> 1 -> 4 -> 5

Vertex : 1 -> 3 -> 4

Vertex : 2 -> 1

Vertex : 3 -> 2 -> 4


Directed Graph : Shortest Path from  node 0 to all other nodes.
0 to 0 weight 0
0 to 1 weight 1
3 to 2 weight 3
1 to 3 weight 2
0 to 4 weight 1
0 to 5 weight 0



*/