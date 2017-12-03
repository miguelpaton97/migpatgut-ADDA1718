package practica7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import us.lsi.dyv.problemasdelistas.ProblemasDeListas;

public class EjerciciosPractica {

	public static void main(String[] args) {

		// List<Integer> ls = Arrays.asList(7,1,3,2,5,4,10);
		// Integer e = 5;
		// System.out.println("Lista: " + ls);
		// System.out.println("elemento: " + e);
		// System.out.println("buscador: " + buscaSinOrd(e, ls));
		//
		// System.out.println("");
		//
		// List<Integer> lsO = Arrays.asList(1,2,3,4,5,7,10);
		// System.out.println("Lista: " + lsO);
		// System.out.println("elemento: " + e);
		// System.out.println("buscador: " + buscaConOrd(e, lsO));

		List<Cancion> ls = Arrays.asList(Cancion.create(6, 5, "ce"), Cancion.create(4, 3, "cc"),
				Cancion.create(2, 1, "ca"), Cancion.create(8, 7, "cg"), Cancion.create(7, 2, "cf"),
				Cancion.create(5, 4, "cd"), Cancion.create(3, 6, "cb"));

		System.out.println(cancionesDuracion(ls));

	}

	public static <E> Integer buscaSinOrd(E e, List<E> ls) {
		return buscaSinOrd(0, e, ls);

	}

	private static <E> Integer buscaSinOrd(int i, E e, List<E> ls) {
		Integer res;
		if (i == ls.size()) {
			res = -1;
		} else {
			E aux = ls.get(i);
			if (aux.equals(e)) {
				res = i;
			} else {
				res = buscaSinOrd(i + 1, e, ls);
			}
		}
		return res;
	}

	public static <E extends Comparable<E>> Integer buscaConOrd(E e, List<E> ls) {
		return buscaConOrd(0, ls.size(), e, ls, Comparator.naturalOrder());
	}

	public static <E> Integer buscaConOrd(E e, List<E> ls, Comparator<E> cmp) {
		return buscaConOrd(0, ls.size(), e, ls, cmp);
	}

	private static <E> Integer buscaConOrd(int i, int j, E e, List<E> ls, Comparator<E> cmp) {
		Integer res;
		if (i >= j) {
			res = -1;
		} else {
			int k = (i + j) / 2;
			E aux = ls.get(k);
			int rcmp = cmp.compare(e, aux);
			if (rcmp == 0) {
				res = k;
			} else if (rcmp > 0) {
				res = buscaConOrd(k + 1, j, e, ls, cmp);
			} else {
				res = buscaConOrd(i, k, e, ls, cmp);
			}
		}
		return res;

	}

	public static Cancion getKesimoCancionXDuracion(int k, List<Cancion> ls) {
		Comparator<Cancion> cmp = (c1, c2) -> c1.getDuracion() - c2.getDuracion();
		return ProblemasDeListas.getKesimo(ls, k, cmp);

	}

	public static List<Cancion> cancionesDuracion(List<Cancion> ls) {
		List<Cancion> res = new ArrayList<Cancion>();
		Integer i = 0;
		while (i<ls.size()) {
			if(ls.get(i).getDuracion() >= 1 && ls.get(i).getDuracion() <= 3) {
			res.add(ls.get(i));
			}
			i++;
			
		}
		return res;
	}

}
