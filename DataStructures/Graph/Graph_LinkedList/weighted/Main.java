/* 
WEIGHTED UNDIRECTED/DIRECTED GRAPH 
*/


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
    while (ptr.next != null) ptr = ptr.next;
    ptr.next = vertex;
  }
 }

 
 public void addUNDirectedEdge(int src, int dst, int cost){
  addDirectedEdge(src, dst, cost);
  addDirectedEdge(dst, src, cost);
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

/*
Create graph DIRECTED                                                                                                                 
                                                                                                                                      
Vertex : 0 -> 1 -> 4                                                                                                                  
                                                                                                                                      
Vertex : 1 -> 2 -> 3 -> 4                                                                                                             
                                                                                                                                      
Vertex : 2 -> 3                                                                                                                       
                                                                                                                                      
Vertex : 3 -> 4                                                                                                                       
                                                                                                                                      
Delete graph.                                                                                                                         
The graph is empty ? true                                                                                                             
Create graph UNDIRECTED                                                                                                               
                                                                                                                                      
Vertex : 0 -> 1 -> 4                                                                                                                  
                                                                                                                                      
Vertex : 1 -> 0 -> 2 -> 3 -> 4                                                                                                        
                                                                                                                                      
Vertex : 2 -> 1 -> 3                                                                                                                  
                                                                                                                                      
Vertex : 3 -> 1 -> 2 -> 4                                                                                                             
                                                                                                                                      
Vertex : 4 -> 0 -> 1 -> 3 
*/