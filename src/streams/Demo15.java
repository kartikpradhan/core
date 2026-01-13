package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo15 {

	public static void main(String[] args) {
		List<EmployeeBean> empList = Arrays.asList(new EmployeeBean(1),
				new EmployeeBean(3),
				new EmployeeBean(5),
				new EmployeeBean(1));

		List<Integer> nums=Arrays.asList(1,2,5,2);
		nums.stream()
		.filter(n->Collections.frequency(nums, n)==1)
		.forEach(System.out::println);
		
	}
}

