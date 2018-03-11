package practica9;

public class Ciudad {
	private String nombre = null;
	private Double poblacion = null;
	
	public static Ciudad create(String[] formato) {
		return new Ciudad(formato[0], new Double(formato[1]));
	}
	
	private Ciudad(String nombre, Double poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPoblacion() {
		return poblacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
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
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + nombre + "";
	}
	
	
	

}
