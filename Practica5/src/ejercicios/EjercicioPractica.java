package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class EjercicioPractica {

	public static void main(String[] args) {

//		System.out.println(f(5));
//		System.out.println(f(10));
//		System.out.println("");
//		System.out.println(fCon(5));
//		System.out.println(fCon(10));
//		System.out.println("");
//		System.out.println(fWhile(5));
//		System.out.println(fWhile(10));
		
		System.out.println(fP(5));
		System.out.println(fIt(5));
		System.out.println(fP(10));
		System.out.println(fIt(10));

	}

	public static Integer f(Integer n) {
		Integer res = null;
		if (n == 2 || n == 1) {
			res = 1;
		} else if (n == 0) {
			res = 2;
		} else {
			res = 4 * f(n - 1) + f(n - 2) + f(n - 3);
		}
		return res;

	}

	public static Integer fCon(Integer n) {
		Map<Integer, Integer> m = new HashMap<>();
		return fCon(n, m);
	}

	public static Integer fCon(Integer n, Map<Integer, Integer> m) {
		Integer res = null;
		if (n == 2 || n == 1) {
			res = 1;
			m.put(n, res);
		} else if (n == 0) {
			res = 2;
			m.put(n, res);
		} else if (m.containsKey(n)) {
			res = m.get(n);
		} else {
			res = 4 * fCon(n - 1, m) + fCon(n - 2, m) + fCon(n - 3, m);
			m.put(n, res);
		}
		return res;
	}

	public static Integer fWhile(Integer n) {
		Integer res = null;

		if (n == 2 || n == 1) {
			res = 1;
		} else if (n == 0) {
			res = 2;
		} else {
			Integer r1 = 1;
			Integer r2 = 1;
			Integer r3 = 2;
			Integer i = 3;

			while (n >= i) {
				res = 4 * r1 + r2 + r3;
				r3 = r2;
				r2 = r1;
				r1 = res;
				i = i + 1;
			}
		}
		return res;
	}

	public static Integer fRec(Integer n) {
		Integer res = null;
	
		if (n == 2 || n == 1) {
			res = 1;
		} else if (n == 0) {
			res = 2;
		} else {
			//Integer a1 = 1;
			//Integer a2 = 1;
			//Integer a3 = 2;
			//Integer i = 3;
			res = fRec(n,3,1,1,2);
		}
		return  res;
	}

	private static Integer fRec(Integer n, Integer i, Integer a1, Integer a2, Integer a3) {
		Integer res = null;
		if(!(n>=i)) {
			res = a1;
		} else {
			res = 4 * a1 + a2 + a3;
			a3 = a2;
			a2 = a1;
			a1 = res;
			i = i + 1;
			res = fRec(n, i, a1, a2, a3);
		}

		return res;
	}

	
	public static Long combi(Long n, Long k) {
		Long r = null;
		if( k == 0 || k == n) {
			r = 1l;
		} else if(k == 1 || k == n-1) {
			r = n;
		} else {
			r = combi(n-1, k-1) + combi(n-1, k);
		}
		return r;
	}
	
	
	public static Integer fP(Integer n) {
		Integer res = null;
		if (n == 2 || n == 1 || n == 0) {
			res = 2;
		} else {
			res = 3*fP(n - 2) + fP(n - 3);
		}
		return res;

	}
	
	public static Integer fIt(Integer n) {
		Integer res = null;	
		if(n == 0 || n == 1 || n == 2) {
			res = 2;
		} else {
			Integer r1 = 2;
			Integer r2 = 2;
			Integer r3 = 2;
			Integer i = 3;
			while (n >= i) {
				res = 3*r2 + r3;  // r1 = n(2) -- r2 = n(1) -- r3 = n(0);
				r3 = r2;
				r2 = r1;
				r1 = res;
				i = i + 1;
			}
		}
		return res;
	}
	
	
}
