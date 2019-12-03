/* 
WEIGHTED UNDIRECTED/DIRECTED GRAPH BFS traversal
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
  vertex.next = vertexes[src].head;
  vertexes[src].head = vertex;
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
 }




public void BFS(int startingVertex){
  int curr;
  boolean visited[] = new boolean[numVertexes];
  for(boolean i : visited) i = false;
  visited[startingVertex] = true;

  Queue<Integer> queue = new Queue<>();
  queue.add(startingVertex);  

  while(queue.getLength() > 0 ){}
    curr = queue.remove();
    AdjVertex ptr = vertexes[curr].head;
    System.out.println("Vertex : "+ curr);
    while(ptr != null){
      if (visited[ptr.dst] == false){
          visited[ptr.dst] = true;
          System.out.println("Vertex : "+ ptr.dst);
          queue.add(ptr.dst);
      }
      ptr = ptr.next;
    }
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

  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 0)");
  g.BFS(0);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(1);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(3);

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


  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 0)");
  g.BFS(0);
  
    
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(1);
  
  System.out.println("Following is Breadth First Traversal " +
   "(starting from vertex 1)");
  g.BFS(3);



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
Following is Breadth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 1
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 1
Vertex : 4
Vertex : 3
Vertex : 2
Vertex : 0
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 3
Vertex : 4
Vertex : 2
Vertex : 1
Delete graph. 
Create directed graph. 

Vertex : 0 -> 5 -> 4 -> 1

Vertex : 1 -> 4 -> 3

Vertex : 2 -> 1

Vertex : 3 -> 4 -> 2


Following is Breadth First Traversal (starting from vertex 0)
Vertex : 0
Vertex : 5
Vertex : 4
Vertex : 1
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 1
Vertex : 4
Vertex : 3
Following is Breadth First Traversal (starting from vertex 1)
Vertex : 3
Vertex : 4
Vertex : 2



*/
