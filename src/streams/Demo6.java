package streams;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo6 {
	public static void main(String[] args) {

		String input = "JJk";
		Optional<Entry<Character, Long>> first = input.chars()
				.mapToObj(ch -> Character.valueOf((char) ch))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1)
				.findFirst();

		System.out.println(first.isPresent() ? first.get().getKey() : null);
	}

}
