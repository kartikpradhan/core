package core;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prie {
	public static void main(String[] args) {
		
		final int range1=2;
		final int range2=100;
		List<Integer> list = IntStream.rangeClosed(range1, range2)
				.filter(i -> isPrime(i))
				.boxed()
				.collect(Collectors.toList());
		System.out.println(list);
		//IntStream.rangeClosed(2, 20).forEach(System.out::println);
	}

	private static boolean isPrime(int i) {
		return IntStream.range(2, i)
				.noneMatch(n->i%n==0);
	}
}
