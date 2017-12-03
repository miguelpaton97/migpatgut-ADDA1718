package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class EjerciciosPractica {

	public static void main(String[] args) {

		// System.out.println(factorialRecNF(4));
		// System.out.println(factorialRecF(4));
		// System.out.println(sumaFactorialRNF(1024, 10));
		// System.out.println(getDivisores(82));
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(1);l1.add(1);l1.add(1);l1.add(1);l1.add(1);l1.add(1);
		l2.add(2);l2.add(2);l2.add(2);l2.add(2);l2.add(2);l2.add(2);
		
		System.out.println("Recursivo no final: " + l1 + " x " + l2 + " = " + productoEscalarRNF(l1, l2));
		
		
		l1.add(3);
		l2.add(3);
		System.out.println("\nRecursivo final: " + l1 + " x " + l2 + " = " + productoEscalarRf(l1, l2));
	}

	// public static Long sumaFactorialRNF(Integer n, Integer i) {
	// return sumaFactorialRNFAux(0l, i, n);
	// }
	//
	// public static Long sumaFactorialRNFAux(Long acum, Integer r, Integer n) {
	// Long res = null;
	// if (!(n > 0)) {
	// res = acum;
	// } else {
	// acum = acum + factorialRNF(n % r);
	// n = n / r;
	// res = sumaFactorialRNFAux(acum, r, n);
	// }
	// return res;
	// }

	public static Integer factorialRecNF(Integer n) {
		return factorialRNF(n);
	}

	public static Integer factorialRNF(Integer n) {
		Integer res = null;
		if (n <= 1) {
			res = 1;
		} else {
			res = factorialRNF(n - 1) * n;
		}
		return res;
	}

	public static Integer factorialRecF(Integer n) {
		return factorialRF(n, 1);
	}

	public static Integer factorialRF(Integer n, Integer a) {
		Integer res = null;
		if (n <= 1) {
			res = a;
		} else {
			res = factorialRF(n - 1, a * n);
		}
		return res;

	}

	public static Integer sumaFactorialRNF(Integer n, Integer b) {
		Integer res = null;
		if (n < b) {
			res = factorialRNF(n);
		} else {
			res = sumaFactorialRNF(n / b, b) + factorialRNF(n % b);
		}
		return res;

	}

	public static List<Integer> getDivisores(Integer n) {
		return getDivisores(n, 1);
	}

	public static List<Integer> getDivisores(Integer n, Integer i) {
		List<Integer> r = null;
		if (i > n) {
			return new ArrayList<Integer>();
		} else {
			r = getDivisores(n, i + 1);
			if (n % i == 0) {
				r.add(i);
			}
		}
		return r;
	}

	public static Integer productoEscalarRNF(List<Integer> n, List<Integer> m) {
		return productoEscalarRNF(n, m, 0, "  ");
	}

	public static Integer productoEscalarRNF(List<Integer> n, List<Integer> m, Integer i, String tab) {
		Integer res = null;
			if (i >= n.size() || n.size() != m.size()) {
//				System.out.println(tab + res + " if");
				res = 0;
//				System.out.println(tab + res + " if final");
			} else {
//				System.out.println(tab + res + " else");
				res = n.get(i) * m.get(i) + productoEscalarRNF(n, m, i + 1, tab + "  ");
//				System.out.println(tab + res + " sumado");
			}

		return res;

	}
	
	public static Integer productoEscalarRf(List<Integer> n, List<Integer> m) {
		return productoEscalarRF(n, m, 0, 0, "  ");
	}
	
	public static Integer productoEscalarRF(List<Integer> n, List<Integer> m, Integer i, Integer a, String tab) {
		Integer res = null;
		if(i >= n.size() || n.size() != m.size()) {
//			System.out.println(tab + res + " if");
			res = a;
//			System.out.println(tab + res + " if final");
		} else {
//			System.out.println(tab + res + " else");
			a = n.get(i) * m.get(i) + a;
			res = productoEscalarRF(n, m, i + 1, a, tab + "  ");
//			System.out.println(tab + res + " sumado");
		}
		return res;
	}
	
}
