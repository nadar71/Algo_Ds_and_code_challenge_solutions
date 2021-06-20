
/*
UNDIRECTED/DIRECTED GRAPH OF INT
*/

class Graph(var numVertices : Int = 0 ){
    val vertices  = mutableListOf<MutableList<Int>>()

    init{
        (0 until numVertices).forEach {
            var item = mutableListOf<Int>()
            vertices.add(item)
        }
    }



    fun addUNDirectedEdge(v: Int, w: Int) {
        addDirectedEdge(v,w)
        addDirectedEdge(w,v)
    }

    fun addDirectedEdge(v: Int, w: Int) {
        vertices[v].add(w)
    }


    fun printGraph(){
        (0 until numVertices).forEach { i ->
            print("Vertex $i :")
            for(vertex in vertices[i])
                print("-> $vertex")
            println("\n")
        }

    }


    fun deleteGraph(){
        (0 until numVertices).forEach { i -> vertices[i] =  mutableListOf<Int>()}
    }

    fun isEmpty() : Boolean{
        if (numVertices <= 0) return true
        (0 until numVertices).forEach { i ->  if (vertices[i].size > 0) return false }
        return true
    }
}

fun main(){
    val graph = Graph(5)
    println("Create graph DIRECTED");
    graph.addDirectedEdge(0, 1);
    graph.addDirectedEdge(0, 4);
    graph.addDirectedEdge(1, 2);
    graph.addDirectedEdge(1, 3);
    graph.addDirectedEdge(1, 4);
    graph.addDirectedEdge(2, 3);
    graph.addDirectedEdge(3, 4);

    graph.printGraph();

    println("Delete graph.");
    graph.deleteGraph();
    println("The graph is empty ? " + graph.isEmpty());

    println("Create graph UNDIRECTED");
    graph.addUNDirectedEdge(0, 1);
    graph.addUNDirectedEdge(0, 4);
    graph.addUNDirectedEdge(1, 2);
    graph.addUNDirectedEdge(1, 3);
    graph.addUNDirectedEdge(1, 4);
    graph.addUNDirectedEdge(2, 3);
    graph.addUNDirectedEdge(3, 4);

    graph.printGraph();


}

/*
Create graph DIRECTED
Vertex 0 :-> 1-> 4

Vertex 1 :-> 2-> 3-> 4

Vertex 2 :-> 3

Vertex 3 :-> 4

Vertex 4 :

Delete graph.
The graph is empty ? true
Create graph UNDIRECTED
Vertex 0 :-> 1-> 4

Vertex 1 :-> 0-> 2-> 3-> 4

Vertex 2 :-> 1-> 3

Vertex 3 :-> 1-> 2-> 4

Vertex 4 :-> 0-> 1-> 3

*/