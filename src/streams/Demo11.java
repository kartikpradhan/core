package streams;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo11 {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 5, 14, 7, 9, 10, 8, 13, 11);

		Integer integer = list.stream().sorted((n1, n2) -> n2.compareTo(n1)).findFirst().get();
		System.out.println(integer);

		// using reduce
		Integer reduce = list.stream().reduce(0, (n1, n2) -> n1 > n2 ? n1 : n2);
		System.out.println(reduce);

		List<Employee> empList = Arrays.asList(new Employee(11), new Employee(1), new Employee(11));
		Set<Integer> set = new LinkedHashSet<>();
		List<Employee> uniqueEmpList = empList.stream().filter(e -> set.add(e.getId())).collect(Collectors.toList());
		System.out.println(uniqueEmpList);
	}
}