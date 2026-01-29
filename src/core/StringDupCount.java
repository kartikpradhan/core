package core;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDupCount {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("AA", "BB","ZZ","KK", "AA", "CC", "CC");
		Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) >= 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
		
		//or
		LinkedHashMap<String, Long> collect = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e->e.getValue()>=1l)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1, LinkedHashMap::new));
		System.out.println(collect);
	}
}