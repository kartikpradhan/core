package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo30 {
	public static void main(String[] args) {

		int[] intArray = new int[] { 1, 3, 2, 0, 5, 6, 7, -1, 4 };

		int targetSum = 6;

		// possiblePairs = {1,5}, {0,6}, {2,4}

		Set<Integer> seen = new HashSet<>();
		Set<String> result = new HashSet<>();

		for (int num : intArray) {
			int complement = targetSum - num;

			if (seen.contains(complement)) {
				int min = Math.min(num, complement);
				int max = Math.max(num, complement);
				result.add(min + "," + max);
			}

			seen.add(num);
		}
		System.out.println(result);
		/*
		 * for (String pair : result) { String[] values = pair.split(",");
		 * System.out.println("{" + values[0] + "," + values[1] + "}"); }
		 */

		// Map<Boolean, List<Integer>> collect =
		// Arrays.stream(intArray).boxed().collect(Collectors.partitioningBy(n1->n1 % 2
		// ==0));
		// System.out.println(collect);
	}

}

//Given a string s  = "abcabcbb", find the length of the longest substring without repeating characters.
