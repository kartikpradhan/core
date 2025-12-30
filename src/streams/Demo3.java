package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo3 {
	public static void main(String[] args) {

		String word = "aeppel";// aepple

		// First repeated character
		for (char ch : word.toCharArray()) {
			if (word.indexOf(ch) != word.lastIndexOf(ch)) {
				System.out.println("First repeated char:: " + ch);
				break;
			}
		}

		Entry<Character, Long> entry = word.chars().mapToObj(ch -> Character.valueOf((char) ch))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(key -> key.getValue() > 1).findFirst().get();

		System.out.println(entry.getKey() + " = " + entry.getValue());

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : word.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		map.entrySet().stream().filter(e -> e.getValue() > 1).findFirst();
	}

}
