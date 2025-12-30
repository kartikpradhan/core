package streams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Demo4 {
	public static void main(String[] args) {

		// sum of square of all odd numbers from list of int
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter end Num::");
		int endNum = sc.nextInt();
		sc.close();
		int sum = IntStream.rangeClosed(1, endNum)
				.filter(num -> num % 2 != 0)
				.map(num -> (num * num))
				.sum();
		int sum2 = IntStream.rangeClosed(1, endNum)
				.filter(num -> num % 2 != 0)
				.map(num -> (num * num))
				.reduce(0,(n, n2) -> n + n2);

		System.out.println("sum of square of all odd numbers " + sum);
		System.out.println("sum of square of all odd numbers " + sum2);
	}

}
