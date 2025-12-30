package streams;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Demo12 {
	public static void main(String[] args) {

		String[] s = { "test", "cools", "not cool" };
		String join = String.join("|", s);
		System.out.println(join);

		List<Integer> number = Arrays.asList(2, 3, 4, 5);
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println(even);

		String reduce = Arrays.stream(s).reduce("dummy", (a, b) -> a.length() > b.length() ? a : b);
		System.out.println(reduce);

		StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
		stringJoiner.add("test");
		stringJoiner.add("test1");
		stringJoiner.add("test2");
		System.out.println(stringJoiner);
	}
}