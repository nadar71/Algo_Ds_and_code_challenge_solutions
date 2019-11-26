/* 
WEIGHTED UNDIRECTED/DIRECTED GRAPH 
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

  Graph g = new Graph(5);
  System.out.println("Create graph DIRECTED");
  g.addDirectedEdge(0, 1, 1);
  g.addDirectedEdge(0, 4, 1);
  g.addDirectedEdge(1, 2, 1);
  g.addDirectedEdge(1, 3, 1);
  g.addDirectedEdge(1, 4, 1);
  g.addDirectedEdge(2, 3, 1);
  g.addDirectedEdge(3, 4, 1);

  g.printGraph();
  
  System.out.println("Delete graph.");  
  g.deleteGraph();
  System.out.println("The graph is empty ? " + g.isEmpty());
  
  System.out.println("Create graph UNDIRECTED");
  g.addUNDirectedEdge(0, 1, 1);
  g.addUNDirectedEdge(0, 4, 1);
  g.addUNDirectedEdge(1, 2, 1);
  g.addUNDirectedEdge(1, 3, 1);
  g.addUNDirectedEdge(1, 4, 1);
  g.addUNDirectedEdge(2, 3, 1);
  g.addUNDirectedEdge(3, 4, 1);
  
  g.printGraph();
  
  
  
 }
}
