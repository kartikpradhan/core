package core;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("D", 5);
		map.put("C", 25);
		map.put("Q", 1);
		map.put("M", 10);
		map.put("M", 12);
		
		Map<String, Integer> map2 = map.entrySet().
				stream().
				sorted(Map.Entry.comparingByValue()).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
		                LinkedHashMap::new));
		
		System.out.println(map2);
	}

}
