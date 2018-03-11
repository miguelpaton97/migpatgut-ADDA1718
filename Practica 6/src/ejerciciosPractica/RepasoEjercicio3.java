package ejerciciosPractica;

public class RepasoEjercicio3 {

	public static void main(String[] args) {

	}

	public static Integer sumaPares(Tree<Integer> t) {
		Integer res = null;
		if (t.isLeaf()) {
			res = 0;
		} else {
			for (int i = 0; i < t.getNumChildren(); i++) {
				Tree<Integer> tt = t.getElement(i);

			}
		}
		return res;
	}

}
