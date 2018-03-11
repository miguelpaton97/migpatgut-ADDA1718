package practica8;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

import us.lsi.stream.Stream2;

public class Ejercicios {
	
	public static void main(String[] args) {
		Graph<String, DefaultEdge> g = new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		System.out.println(g);
		
		Graph<String, DefaultWeightedEdge> g1 = new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		g1.addVertex("A");
		g1.addVertex("B");
		g1.addVertex("C");
		g1.addEdge("A", "B");
		g1.setEdgeWeight(g1.getEdge("A", "B"), 3);
		g1.addEdge("B", "C");
		g1.setEdgeWeight(g1.getEdge("B", "C"), 3);
		System.out.println(g1);
		
		Graph<Integer, DefaultEdge> g2 = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
//		for(int i=1; i<=100; i++) {
//			g2.addVertex(i);
//		}
		IntStream.rangeClosed(1, 100).forEach(v -> g2.addVertex(v));
		IntStream.rangeClosed(1, 100).forEach(i -> IntStream.rangeClosed(i+1, 100).forEach(j -> g2.addEdge(i, j)));
		System.out.println(g2);
		
		boolean algo = g2.vertexSet().stream().allMatch(v -> g2.degreeOf(v) == g2.vertexSet().size());
		System.out.println(algo);
		
		Graph<String, DefaultEdge> g3 = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		g3.addVertex("A");
		g3.addVertex("B");
		g3.addVertex("C");
		g3.addVertex("D");
		g3.addVertex("E");
		g3.addVertex("F");
		g3.addEdge("A", "B");
		g3.addEdge("B", "C");
		g3.addEdge("C", "F");
		g3.addEdge("F", "E");
		g3.addEdge("E", "B");
		g3.addEdge("B", "D");
		System.out.println(g3);
		
		Iterator<String> it = new DepthFirstIterator<String, DefaultEdge>(g3, "A");
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println("");
		
		Graph<String, DefaultWeightedEdge> g4 = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		String a = "Sevilla"; String b = "Madrid"; String c = "Barcelona"; String d = "Valencia";
		g4.addVertex(a);
		g4.addVertex(b);
		g4.addVertex(c);
		g4.addVertex(d);
		g4.setEdgeWeight(g4.addEdge(a, b), 500);
		g4.setEdgeWeight(g4.addEdge(a, c), 800);
		g4.setEdgeWeight(g4.addEdge(a, d), 600);
		g4.setEdgeWeight(g4.addEdge(b, c), 300);
		g4.setEdgeWeight(g4.addEdge(b, d), 200);
		g4.setEdgeWeight(g4.addEdge(c, d), 100);
		
		Iterator<String> it1 = new BreadthFirstIterator<String, DefaultWeightedEdge>(g4, c);
		while(it1.hasNext()) {
			System.out.print(it1.next() + " - ");
		}
		Double dist = 0.;
		for(DefaultWeightedEdge s : g4.edgeSet()) {
			dist = dist + g4.getEdgeWeight(s);
		}
		System.out.println(dist);
		
		
		
		
	}
	

}
