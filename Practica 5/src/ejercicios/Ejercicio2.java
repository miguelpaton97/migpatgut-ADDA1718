package ejercicios;

import java.util.stream.IntStream;

public class Ejercicio2 {

	public static void main(String[] args) {

		System.out.println("Final: " + multiplicacionFinal(3, 7));
		System.out.println("No Final: " + multiplicacionNoFinal(3, 5));
		System.out.println("Iterativo: " + multiplicacionWhile(3, 10));
		System.out.println("Java 8: " + multiplicacionJ8(3, 6));

	}

	public static Integer multiplicacionFinal(Integer x, Integer y) {
		return multiplicacionFinal(x, y, 0, 0);
	}

	public static Integer multiplicacionFinal(Integer x, Integer y, Integer i, Integer acum) {
		Integer res = null;
		if (!(i < y)) {
			res = acum;
		} else {
			res = multiplicacionFinal(x, y, i + 1, acum + x);
		}
		return res;
	}

	public static Integer multiplicacionNoFinal(Integer x, Integer y) {
		return multiplicacionNoFinal(x, y, 0);
	}

	public static Integer multiplicacionNoFinal(Integer x, Integer y, Integer i) {
		Integer res = null;
		if (!(i < y)) {
			res = 0;
		} else {
			res = multiplicacionNoFinal(x, y, i + 1) + x;
		}
		return res;
	}

	public static Integer multiplicacionWhile(Integer x, Integer y) {
		Integer i = 0;
		Integer res = 0;
		while(i<y) {
			res = res + x;
			i++;
		}
		return res;	
	}
	
	public static Integer multiplicacionJ8(Integer x, Integer y) {
		return IntStream.rangeClosed(1, y).map(i -> x).sum();
	}

}
