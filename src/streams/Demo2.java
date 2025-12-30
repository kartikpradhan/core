package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo2 {
	public static void main(String[] args) {

		String str = "My name is kp".toLowerCase().replaceAll("\s", "");

		Map<Character, Long> charcount = str.chars().mapToObj(c -> Character.valueOf((char) c))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,  Collectors.counting()));
		System.out.println(charcount);
		System.out.println("==============");
		
		

		// character dup count using getOrDefault() method of hashmap
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (Character ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		System.out.println("===============");

		// sort map
		Map<Character, Integer> map2 = map.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(map2);
		System.out.println("===============");

		//repeat dup character using repeat() method
		StringBuilder builder = new StringBuilder();
		for (Entry<Character, Integer> entry : map2.entrySet()) {
			builder.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
		}
		System.out.println(builder);
	}

}
