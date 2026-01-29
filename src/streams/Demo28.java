package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Demo28 {
	public static void main(String[] args) {
		// Return the top 3 distinct largest numbers from a list.

		List<Integer> nums = Arrays.asList(10, 9, 15, 12, 5, 13);
		List<Integer> top3Nums = nums.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
		System.out.println(top3Nums);

		// Find the longest word from a list (if tie, return first).Node prev = null;
		List<String> words = Arrays.asList("Mango", "Apple", "cucumber", "Appricot", "Guava");
		String string = words.stream().reduce((w1, w2) -> w1.length() >= w2.length() ? w1 : w2).get();
		System.out.println(string);

		// Convert a list of sentences into a map of word → frequency.
		List<String> sentences = Arrays.asList("How is the day", "It is sunny", "Had your breakfast",
				"Yes I had but the quantity is small");
		Map<String, Long> collect = sentences.stream().flatMap(s -> Arrays.stream(s.split("\\s")))
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		System.out.println(collect);

		//Partition numbers into prime and non-prime using streams.
		List<Integer> numbers = Arrays.asList(10, 9, 15, 12, 5, 13);
		Map<Boolean, List<Integer>> collect2 = numbers.stream().collect(Collectors.partitioningBy(n->isPrime(n)));
		System.out.println(collect2);
	}

	private static boolean isPrime(int i) {
		return IntStream.range(2, i).noneMatch(n -> i % n == 0);
	}
}
