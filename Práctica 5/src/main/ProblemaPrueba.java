package main;

public class ProblemaPrueba {

	public static void main(String[] args) {
		Integer n =5;
		
		System.out.println(P(n));
	}
	
	public static Integer P(Integer n) {
		Integer i, a, b, c;
		//a= P(i), b=(P(i-1) c = P(i-2)
		i = 2; a = 1; b = 1; c = 1; //Instanciación
		while (i < n) {
			Integer aaux = c + 2*a;
			c = b;
			b = a;
			a = aaux;
			i++;
		}
		if (n <= 2) {
			a = 1;
		}
		return a;
	}

}
