package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo14 {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 33, 11, 20);
		List<Integer> nums2 = Arrays.asList(12, 33, 11, 20);
		List<List<Integer>> nestedList = Arrays.asList(nums, nums2);

		nums.stream().map(n -> n * n * n).forEach(System.out::println);

		List<Integer> collect = nestedList.stream().flatMap(n -> n.stream()).collect(Collectors.toList());
		System.out.println(collect);

		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		// Java 8
		String[] result = Stream.of(array) // Stream<String[]>
				.flatMap(Stream::of) // Stream<String>
				.toArray(String[]::new); // [a, b, c, d, e, f]
		System.out.println(Arrays.toString(result));

		List<String> collect2 = Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());
		System.out.println(collect2);
	}
}
