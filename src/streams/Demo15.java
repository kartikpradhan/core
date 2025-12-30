package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo15 {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee(1),
				new Employee(3),
				new Employee(5),
				new Employee(1));

		List<Integer> nums=Arrays.asList(1,2,5,2);
		nums.stream()
		.filter(n->Collections.frequency(nums, n)==1)
		.forEach(System.out::println);
		
	}
}

