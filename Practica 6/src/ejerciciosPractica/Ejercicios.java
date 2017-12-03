package ejerciciosPractica;

import java.util.ArrayList;
import java.util.List;

public class Ejercicios {

	public static void main(String[] args) {

		Tree<String> t0 = Tree.create("A", Tree.create("B", Tree.create("E"), Tree.create("F"), Tree.create("G")),
				Tree.create("C"), Tree.create("D", Tree.create("I"), Tree.create("J")));

		int r1 = numEtiquetas(t0);
		System.out.println(r1);

		Tree<String> r2 = clonar(t0);
		System.out.println(r2);

		System.out.println(altura(t0));
		
		System.out.println(copiaSimetrica(t0));

	}

	public static <E> int numEtiquetas(Tree<E> t0) {
		int res = 0;
		if (t0.isEmpty()) {
			res = 0;
		} else if (t0.isLeaf()) {
			res = 1;
		} else {
			int suma = 0;
			for (int i = 0; i < t0.getNumChildren(); i++) {
				suma += numEtiquetas(t0.getElement(i));
			}
			res = suma + 1;
		}

		return res;

	}

	public static <E> Tree<E> clonar(Tree<E> t) {
		Tree<E> res;

		if (t.isEmpty()) {
			res = Tree.create();
		} else if (t.isLeaf()) {
			res = Tree.create(t.getLabel());
		} else {
			List<Tree<E>> hijosClon = new ArrayList<>();
			for (int i = 0; i < t.getNumChildren(); i++) {
				hijosClon.add(clonar(t.getElement(i)));
			}
			res = Tree.create(t.getLabel(), hijosClon);
		}
		return res;
	}

	public static <E> int altura(Tree<E> t) {
		int res;
		if (t.isLeaf()) {
			res = 0;
		} else {
			int max = 0;
			for (int i = 0; i < t.getNumChildren(); i++) {
				max = Math.max(max, altura(t.getElement(i)));
			}
			res = max + 1;
		}
		return res;
	}

	public static <E> Tree<E> buscaArbol(Tree<E> t, String x) {
		Tree<E> res;

		if (t.isEmpty() || (t.isLeaf() && !t.getLabel().equals(x))) {
			res = null;
		} else if (t.isLeaf() && t.getLabel().equals(x)) {
			res = t;
		} else {
			Tree<E> enc = null;
			for (int i = 0; i < t.getNumChildren(); i++) {
				enc = buscaArbol(t.getElement(i), x);
				if (enc != null) {
					break;
				}
			}
			res = enc;

		}

		return res;

	}
	
	public static <E> Tree<E> copiaSimetrica(Tree<E> t) {
		Tree<E> res;

		if (t.isEmpty()) {
			res = Tree.create();
		} else if (t.isLeaf()) {
			res = Tree.create(t.getLabel());
		} else {
			List<Tree<E>> hijosClon = new ArrayList<>();
			for (int i = t.getNumChildren()-1; i >= 0; i--) {
				hijosClon.add(copiaSimetrica(t.getElement(i)));
			}
			res = Tree.create(t.getLabel(), hijosClon);
		}
		return res;
	}

}
