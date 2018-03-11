package us.lsi.graphs;

/**
 * <a> Tipo que deben implementar la aristas de un grafo que queremos leer de un fichero cuyas íneas
 * representa una arista. Las líneas deben ser de la forma: </a>
 * 
 * <a> s1,s2,v1,v2,v3 </a>
 * 
 * <a> Dónde s1 y s2 son idenficadores únicos de vértices y v1, ... propiedades de la arista </a>
 * 
 * @author Miguel Toro
 *
 * @param <V> Tipo de los vertices
 */
public interface StringEdgeFactory<V, E> {
	/**
	 * @param v1 Vértice origen
	 * @param v2 Vértice destino
	 * @param formato Propiedades v1,v2, ...
	 * @return La arista creada
	 */
	public E createEdge(V v1, V v2, String[] formato);
}
