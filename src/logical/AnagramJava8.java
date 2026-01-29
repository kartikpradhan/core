package logical;

import java.util.Map;
import java.util.stream.Collectors;

public class AnagramJava8 {

	public static void main(String[] args) {
		String s1 = "test", s2 = "ttes";
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			System.out.println("not anagram");
		}

		Map<Character, Long> map1 = s1.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		Map<Character, Long> map2 = s2.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println("Is anagram: " + map1.equals(map2));
		
		
		//or
		
		String str1 = s1.chars().sorted()
				.mapToObj(c->String.valueOf(c))
				.collect(Collectors.joining());
		String str2 = s2.chars().sorted()
				.mapToObj(c->String.valueOf(c))
				.collect(Collectors.joining());
		System.out.println("Is anagram: "+ str1.equals(str2));
	}
}
