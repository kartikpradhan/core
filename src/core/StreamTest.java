package core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(35, 15, 10, 15, 20, 30);

		// condition based
		List<Integer> collect = list.stream().filter(m -> m > 12).collect(Collectors.toList());
		System.out.println(collect);

		// modify every existing object
		List<Integer> collect2 = list.stream().map(m -> m + 2).collect(Collectors.toList());
		System.out.println(collect2);

		// default sorting
		List<Integer> collect3 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(collect3);

		// Customize sorting
		List<Integer> collect4 = list.stream().sorted((m1, m2) -> m2.compareTo(m1)).collect(Collectors.toList());
		System.out.println(collect4);

		// min value --first element consider as min value
		Integer min = list.stream().min((m1, m2) -> m1.compareTo(m2)).get();
		System.out.println(min);

		// max value --last element consider as max value
		Integer max = list.stream().max((m1, m2) -> m1.compareTo(m2)).get();
		System.out.println(max);

		// converting list to integer array
		Integer[] array = list.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(array));

		// or

		Stream.of(array).forEach(System.out::println);

		Random random = new Random();

		System.out.println(">>>");
		random.ints().limit(2).forEach(System.out::println);
		System.out.println(">>>");

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		myList.stream().findFirst().ifPresent(System.out::println);

		List<Integer> list22 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		int max2 = list22.stream().max(Integer::compare).get();
		System.out.println(max2);

		int[] nums = new int[] { 1, 2, 3, 1 };
		List<Integer> list3 = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(list3);

		if (set.size() == list.size()) {
			System.out.println("no dup");
		} else {
			System.out.println("dup");
		}

		List<Integer> myList3 = Arrays.asList(10, 15, 8, 49, 25, 98, 99, 32, 15);
		Integer val = myList3.stream().sorted((v1, v2) -> v2.compareTo(v1)).limit(3).skip(2).findFirst().get();
		System.out.println(val);

	}
}