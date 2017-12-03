package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class EjerciciosPractica {

	public static void main(String[] args) {

		/*
		 * System.out.println(invierteNumero(5261));
		 * System.out.println(invierteNumeroRecursivo(5261));
		 * System.out.println(factorial(4)); System.out.println(sumaFactorialRec(1024,
		 * 10)); System.out.println(numDivisoresWhile(1024));
		 */
		Estudiante e1 =  Estudiante.create("pepe", "sanchez", "48153468T", 25, Estudiante.genero.Masculino);
		Estudiante e2 =  Estudiante.create("marga", "gutierrez", "48153555M", 50, Estudiante.genero.Femenino);
		Estudiante e3 =  Estudiante.create("lola", "flores", "79153468U", 90, Estudiante.genero.Femenino);
		Estudiante e4 =  Estudiante.create("migue", "paton", "48153474P", 20, Estudiante.genero.Masculino);
		Estudiante e5 =  Estudiante.create("peter", "perez", "95867268X", 19, Estudiante.genero.Masculino);
		Estudiante e6 =  Estudiante.create("Inma", "leona", "66666666L", 22, Estudiante.genero.Femenino);

		List<Estudiante> l1 = new ArrayList<Estudiante>();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		l1.add(e4);
		l1.add(e5);
		l1.add(e6);
		
		System.out.println(cambiaSexo(l1));
	}

	public static Integer invierteNumero(Integer n) {
		Integer acum = 0;
		while (n > 0) {
			Integer d = (n % 10);
			acum = acum * 10 + d;
			n = n / 10;
		}
		return acum;
	}

	public static Integer invierteNumeroRecursivo(Integer n) {
		return invierteNumeroAux(0, n);
	}

	private static Integer invierteNumeroAux(Integer acum, Integer n) {
		Integer res = null;
		if (!(n > 0)) {
			res = acum;
		} else {
			Integer d = (n % 10);
			acum = acum * 10 + d;
			n = n / 10;
			res = invierteNumeroAux(acum, n);
		}
		return res;

	}

	public static Long sumaFactorialRec(Integer n, Integer i) {
		return sumaFactorialAux(0l, i, n);
	}

	public static Long sumaFactorialAux(Long acum, Integer r, Integer n) {
		Long res = null;
		if (!(n > 0)) {
			res = acum;
		} else {
			acum = acum + factorial(n % r);
			n = n / r;
			res = sumaFactorialAux(acum, r, n);
		}
		return res;
	}

	public static Integer factorial(Integer n) {
		return factorialAux(1, 1, n);
	}

	private static Integer factorialAux(Integer acum, Integer i, Integer n) {
		Integer res = null;
		if (!(i <= n)) {
			res = acum;
		} else {
			acum = acum * i;
			i = i + 1;
			res = factorialAux(acum, i, n);
		}
		return res;
	}

	public static List<Integer> numDivisoresWhile(Integer n) {
		List<Integer> l = new ArrayList<Integer>();
		Integer i = 1;
		while (i <= n / 2) {
			if (n % i == 0) {
				l.add(i);
			}
			i += 1;
		}
		return l;
	}

	public static List<Estudiante> cambiaSexo(List<Estudiante> e) {
		List<Estudiante> copia = new ArrayList<Estudiante>();
		return cambiaSexoAux(copia, 0, e);
	}

	public static List<Estudiante> cambiaSexoAux(List<Estudiante> copia, Integer i, List<Estudiante> e) {
		List<Estudiante> res = null;
		if (!(e.size() > i)) {
			res = copia;
		} else {
			Estudiante temp = Estudiante.create(e.get(i).getNombre(), e.get(i).getApellidos(), e.get(i).getNif(),
					e.get(i).getEdad(), e.get(i).getSexo());
			if (temp.getSexo().equals(Estudiante.genero.Femenino)) {
				temp.setSexo(Estudiante.genero.Masculino);

			} else {
				temp.setSexo(Estudiante.genero.Femenino);
			}
			copia.add(temp);
			i += 1;
			res = cambiaSexoAux(copia, i, e);
		}
		return res;

	}

}
