package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problema2 {

	public static void main(String[] args) {
		int n = 6;
		int k = 4;
		
		System.out.println(comb(n,k));
	}

	public static Integer comb(Integer n, Integer k) {
		return combG(n, k, new HashMap<List<Integer>, Integer>());
	}

	private static Integer combG(Integer n, Integer k, HashMap<List<Integer>, Integer> m) {
		Integer u;
		List<Integer> p = Arrays.asList(n,k);
		if (m.containsKey(p)) {
			u = m.get(p);
		} else if (k==0 || k ==n) {
			u = 1;
		} else if (k == 1 || k == n-1) {
			u = n;
		} else {
			u = combG(n-1, k-1, m) + combG(n-1, k, m);
		}
		m.put(p, u);
		return u;
	}

}
