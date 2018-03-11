package practica9;

import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.graphs.GraphsFileExporter;
import us.lsi.graphs.GraphsReader;

public class EjerciciosPractica {

	public static void main(String[] args) {
		Graph<Ciudad, Carretera> g = new SimpleWeightedGraph<Ciudad, Carretera>(Carretera::create);
		GraphsReader.newGraph("./ficheros/andalucia.w.txt", Ciudad::create, Carretera::create, g,
				Carretera::getLongitud);
		// System.out.println(g);
		GraphsFileExporter.saveFile(g, "./ficheros/andalucia.gv");

		Ciudad v1 = g.vertexSet().stream().filter(v -> v.getNombre().equals("Huelva")).findFirst().orElse(null);
		Ciudad v2 = g.vertexSet().stream().filter(v -> v.getNombre().equals("Almeria")).findFirst().orElse(null);
		System.out.println(DijkstraShortestPath.findPathBetween(g, v1, v2));

		GreedyColoring<Ciudad, Carretera> color = new GreedyColoring<Ciudad, Carretera>(g);
		System.out.println(color.getColoring().getNumberColors());

	}

}
