package ejerciciosPractica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicios {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("manzana", "manzana", "platano", "manzana", "naranja", "platano", "papaya");
		System.out.println(wFrutas(items));
		System.out.println(rfFrutas(items));
		System.out.println(rnfFrutas(items));


	}

	public static Map<String, Integer> wFrutas(List<String> l) {
		Map<String, Integer> res = new HashMap<>();
		int i = 0;
		while (i < l.size()) {
			if (res.containsKey(l.get(i))) {
				res.put(l.get(i), res.get(l.get(i)) + 1);
			} else {
				res.put(l.get(i), 1);
			}
			i++;
		}
		return res;
	}

	public static Map<String, Integer> rfFrutas(List<String> l) {
		Map<String, Integer> m = new HashMap<>();
		return rfFrutas(l, 0, m);
	}

	private static Map<String, Integer> rfFrutas(List<String> l, Integer i, Map<String, Integer> m) {
		Map<String, Integer> res = null;
		if (!(i < l.size())) {
			res = m;
		}else {
			if (!m.containsKey(l.get(i))) {
				m.put(l.get(i), 1);
			} else {
				m.put(l.get(i), m.get(l.get(i)) + 1);
			}
			res = rfFrutas(l, i+1, m);
		}
		return res;
	}
	
	public static Map<String, Integer> rnfFrutas(List<String> l){
		return rnfFrutas(l, 0);
	}
	
	public static Map<String, Integer> rnfFrutas(List<String> l, Integer i){
		Map<String, Integer> res = null;
		if (!(i < l.size())) {
			res = new HashMap<>();
		}else {
			res = rnfFrutas(l, i + 1);
			String fruta = l.get(i);
			if(res.containsKey(fruta)) {
				res.put(fruta, res.get(fruta) + 1);		
			}else {
				res.put(fruta, 1);
			}
		}
		return res;
	}

}
