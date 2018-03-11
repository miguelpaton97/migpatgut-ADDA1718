package practica9;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Carretera extends DefaultWeightedEdge{
	private Ciudad source = null;
	private Ciudad target = null;
	private String nombre = null;
	private Double longitud = null;
	
	public static Carretera create(Ciudad c1, Ciudad c2, String[] formato) {
		return new Carretera(c1,c2, formato[2], new Double(formato[3]));
	}
	public static Carretera create(Ciudad c1, Ciudad c2) {
		return new Carretera(c1,c2,null, null);
	}
	
	private Carretera(Ciudad source, Ciudad target, String nombre, Double longitud) {
		super();
		this.source = source;
		this.target = target;
		this.nombre = nombre;
		this.longitud = longitud;
	}

	public Ciudad getSource() {
		return source;
	}

	public Ciudad getTarget() {
		return target;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getLongitud() {
		return longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carretera other = (Carretera) obj;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "S= " + source + ", T= " + target + ", N= " + nombre + ", L=" + longitud
				+ "";
	}
	
	
	
	

}
