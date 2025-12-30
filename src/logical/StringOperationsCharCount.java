package logical;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperationsCharCount {

	public static void main(String[] args) {
		String input = "My name is kp".toLowerCase();
		
		System.out.println(input.replace(" ", ""));

		Map<String, Long> output = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("Output : " + output);

		LinkedHashMap<Character, Long> collect = input.chars().mapToObj(c -> Character.valueOf((char) c))
				.filter(c -> !Character.isWhitespace(c))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(collect);
	}

}
