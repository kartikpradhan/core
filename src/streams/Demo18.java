package streams;

import java.util.Arrays;
import java.util.List;

public class Demo18 {

	public static void main(String[] args) {
		
		//Find all odd numbers from the input
		//[10, 48, 33, 54, 39, 99]
		
		List<Integer> nums = Arrays.asList(10, 48, 33, 54, 39, 99);
		
		nums.stream().filter(n->n%2 !=0).forEach(n->System.out.println(n));
		
	}
}

