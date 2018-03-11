package pli.practica11.ejercicio4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.pl.AlgoritmoPLI;

public class ReinasPLI {

	public static String getConstraints(int N){
		// TODO
		String r = "min: ;\n\n";
		//filas
		r+= IntStream.range(0, N).boxed().map(i ->IntStream.range(0, N).boxed().map(j -> AlgoritmoPLI.getVariable("x", i, j))
				.collect(Collectors.joining("+","","=1;\n"))).collect(Collectors.joining());
		//columnas
		
		//diag prin
		
		//diag sec
		
		//bin
		r+= IntStream.range(0, N).boxed().flatMap(i -> IntStream.range(0, N).boxed()
				.map(j -> AlgoritmoPLI.getVariable("x", i, j))
				).collect(Collectors.joining(",", "bin ", ";\n"));
				
		/*
		r+= "bin ";
		boolean first = true;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(first) {
					r+=","+AlgoritmoPLI.getVariable("x", i, j);
					first = false;
				}else {
					r+=","+AlgoritmoPLI.getVariable("x", i, j);
				}
			}
		}
		r+=";\n"; */
		
		return r;
	}
}
