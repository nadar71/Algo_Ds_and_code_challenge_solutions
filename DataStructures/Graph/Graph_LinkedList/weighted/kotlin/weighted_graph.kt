

data class Vertex(val src: Int, val dst: Int, val cost: Int, var next: Vertex? = null)

class Graph(var numVertices : Int = 0 ){
    var vertices : ArrayList<Vertex?> = ArrayList<Vertex?>(numVertices)

    init{
        (0 until numVertices).forEach {it -> vertices.add(it,null) }
        // for(i in 0..numVertices-1) vertices[i] = null
    }


    fun addDirectedEdge(src: Int, dst: Int, cost: Int) {
        val vertex = Vertex(src, dst, cost)

        when (vertices[src]) {
            null -> {
                vertices[src] = vertex
                return
            }
            else -> {
                var ptr = vertices[src]
                while (ptr!!.next != null) ptr = ptr.next
                ptr.next = vertex
            }
        }
    }

    fun addUNDirectedEdge(src: Int, dst: Int, cost: Int) {
        addDirectedEdge(src,dst,cost)
        addDirectedEdge(dst,src,cost)
    }


    fun printGraph(){
        if (isEmpty()) return
        (0 until vertices.size).forEach { it ->
            print("Vertex $it :")
            var ptr = vertices[it]

            while (ptr != null) {
                print("-> ${ptr!!.dst}")
                ptr = ptr.next
            }
            println("\n")
        }
    }


    fun deleteGraph(){
        (0 until numVertices).forEach { it -> vertices[it] = null}
    }

    fun isEmpty() : Boolean{
        if (numVertices <= 0) return true
        (0 until numVertices).forEach { it ->  if (vertices[it] != null) return false }
        return true
    }
}

fun main(){
    val graph = Graph(5)

    println("Create graph DIRECTED");
    graph.addDirectedEdge(0, 1, 1);
    graph.addDirectedEdge(0, 4, 1);
    graph.addDirectedEdge(1, 2, 1);
    graph.addDirectedEdge(1, 3, 1);
    graph.addDirectedEdge(1, 4, 1);
    graph.addDirectedEdge(2, 3, 1);
    graph.addDirectedEdge(3, 4, 1);

    graph.printGraph();

    println("Delete graph.");
    graph.deleteGraph();
    println("The graph is empty ? " + graph.isEmpty());

    println("Create graph UNDIRECTED");
    graph.addUNDirectedEdge(0, 1, 1);
    graph.addUNDirectedEdge(0, 4, 1);
    graph.addUNDirectedEdge(1, 2, 1);
    graph.addUNDirectedEdge(1, 3, 1);
    graph.addUNDirectedEdge(1, 4, 1);
    graph.addUNDirectedEdge(2, 3, 1);
    graph.addUNDirectedEdge(3, 4, 1);

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

objc[50584]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/bin/java (0x1019df4c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x1031ff4e0). One of the two will be used. Which one is undefined.
Vertex 4 :-> 0-> 1-> 3

*/