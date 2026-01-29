package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {

		// find dup element
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 99, 99, 100);
		Set<Integer> unique = new HashSet<>();
		nums.stream().filter(n -> unique.add(n)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("====================");

		// find element which starts with 1
		List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 99, 10, 100);
		nums2.stream().map(n -> n.toString()).filter(n -> n.charAt(0) == '1').collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("====================");

		// find element which ends with 2
		List<Integer> nums3 = Arrays.asList(10, 34, 11, 22, 12, 32, 01, 25, 62);
		nums3.stream().map(n -> n.toString()).filter(n -> n.charAt(n.length() - 1) == '2').collect(Collectors.toList())
				.forEach(System.out::println);
		
		
		
		Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 30);
        map.put("C", 20);

        Map<String, Integer> result =
                map.entrySet()
                   .stream()
                   .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                   .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (e1, e2) -> e1,
                       LinkedHashMap::new
                   ));

        System.out.println(result);
	}

}
