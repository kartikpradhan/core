package ds;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 5, 7, 8, 9, 10 };
		int target = 4;
		int startIndex = 0;
		int endIndex = nums.length - 1;

		int result = binarySearch(nums, target, startIndex, endIndex);
		if (result != -1)
			System.out.println("Element found at index " + result);
		else
			System.out.println("Element not found");

		Arrays.binarySearch(nums, 34);
	}

	private static int binarySearch(int[] nums, int target, int startIndex, int endIndex) {

		int steps = 0;
		while (startIndex <= endIndex) {
			steps++;
			int midIndex = (startIndex + endIndex) / 2;
			if (nums[midIndex] == target) {
				System.out.println("No of steps::" + steps);
				return midIndex;
			} else if (nums[midIndex] < target) {
				startIndex = midIndex + 1;
			} else {
				endIndex = midIndex - 1;
			}
		}
		System.out.println("No of steps::" + steps);
		return -1;
	}
}
