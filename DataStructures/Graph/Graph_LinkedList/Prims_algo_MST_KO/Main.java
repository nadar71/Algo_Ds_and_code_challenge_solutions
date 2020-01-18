
/*
IN DEVELOPMENT :  Prim's algo 
*/

import java.util.PriorityQueue;
import java.util.Comparator;

public void prim(){
	int dist[] = new int[numVertices];
	int previous[] = new int[numVertices];
	int src = 1;

	for(int i = 0; i < numVertices; i++){
		previous[i] = -1;
		dist[i]     = Integer.MAX_VALUE;		
	}

	dist[src]     = 0;
	previous[src] = -1;

	PriorityQueue<Vertex> pqueue  = new PriorityQueue(numVertices,MyComparator);
	Vertex vertex = new Vertex(src, src, 0);
	pqueue.add(vertex);

	while(pqueue.size() > 0){
		vertex = pqueue.poll();
		if (dist[vertex.dst] < vertex.cost) continue;
		dist[vertex.dst] = vertex.cost;
		previous[vertex.dst] = vertex.src;
		Vertex adl = vertices[vertex.dst];
		Vertex  adn = adl.head;

		while( adn != null){
			if (previous[adn.dst] == -1){
				vertex = new Vertex(adn.src, adn.dst, adn.cost);
				pqueue.add(vertex);
			}
			adn = adn.next;
		}
	}
    
	for(int i = 0; i < numVertices; i++){
		if (dist[i] = Integer.MAX_VALUE) {
			System.out.println("node id : " + i + " prev : " + previous[i] + " distance :  unreacheable.");
		} else {
			System.out.println("node id : " + i + " prev : " + previous[i] + " distance : "  + dist[i]);
		}
	}


}


class MyComparator implements Comparator<Vertex>
{
   @Override
   public int compare(Vertex x, Vertex y)
   {
      return  y.cost() - x.cost();
   }
}