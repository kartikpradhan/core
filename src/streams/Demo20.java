package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo20 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Abrar", 20000);
		map.put("Chand", 35000);
		map.put("Kalam", 45000);
		map.put("Raheem", 35000);
		map.put("Kiran", 50000);
		map.put("Esa", 45000);

		// find 2nd highest salary
		Integer secHighestSal = map.values().stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(0);

		
		//.filter(e->e.getValue()==secHighestSal).forEach(System.out::println);
		
		Map<String, Integer> secHighestSalWithName = map.entrySet().stream()
		.filter(e->e.getValue()==secHighestSal)
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(secHighestSalWithName);

		/*
		 * map.entrySet().stream().filter(e->e.getValue()==45000).forEach(System.out::
		 * println);
		 */

		/*
		 * String s = "indiaauzcskklndsl"; Entry<Character, Long> entry =
		 * s.chars().mapToObj(c->Character.valueOf((char)c))
		 * .collect(Collectors.groupingBy(c->c, LinkedHashMap::new,
		 * Collectors.counting())) .entrySet() .stream()
		 * .filter(e->e.getValue()==1).findFirst().get();
		 * System.out.println(entry.getKey());
		 */

		
		int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};

        int[] sortedArr = Arrays.stream(arr)
                                .boxed()
                                .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                                .mapToInt(Integer::intValue)
                                .toArray();
        Arrays.stream(sortedArr).forEach(num -> System.out.print(num + " "));
        
        System.out.println();
        
        //or
        int[] result =
        	    IntStream.concat(
        	            Arrays.stream(arr).filter(n -> n % 2 == 0),
        	            Arrays.stream(arr).filter(n -> n % 2 != 0)
        	    ).toArray();
        Arrays.stream(result).forEach(num -> System.out.print(num + " "));

	}
}
