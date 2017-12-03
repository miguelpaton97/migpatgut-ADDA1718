package main;

import java.util.HashMap;

public class Problema1 {
	public static void main (String[] args) {
		int n= 8;
		int r1 = f(n);
		System.out.println(r1);
		
		int r2 = f2(n);
		System.out.println(r2);
		
		int r3 = fi(n);
		System.out.println(r3);
	}
	
	//Sin memoria. Como no hace falta generalizar es pública
	public static Integer f(Integer n) {
		Integer u;
		if (n==0) {
			u= 2;
		} else if (n <= 2) {
			u = 1;
		} else {
			u = 4*f(n-1) + f(n-2) + f(n-3);
		}
		return u;
	}
	
	//Con memoria.
	public static Integer f2(Integer n) {
		return f2G(n, new HashMap<Integer, Integer>());
	}
	
	private static Integer f2G(Integer n, HashMap<Integer, Integer> m) {
		Integer u;
		if (m.containsKey(n)) {
			u = m.get(n);
		} else if (n==0) {
			u= 2;
			m.put(n, u);
		} else if (n <= 2) {
			u = 1;
			m.put(n, u);
		} else {
			u = 4*f2G(n-1, m) + f2G(n-2, m) + f2G(n-3, m);
			m.put(n, u);
		}
		return u;
	}
	
	//Iterativo
	public static Integer fi(Integer n) {
		Integer i,a,b,c;
		i = 2; a = 1; b = 1; c = 2; //Instanciación
		while(i < n) {
			int aprima = 4*a+b+c;
			c = b;
			b = a;
			a = aprima;
			i++;
		}
		if (n==0) {
			a = 2;
		} else if (n <= 2) {
			a = 1;
		}
		return a;
	}
	
	//TODO pasar de iterativo a recursivo simple final.
}
