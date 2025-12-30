package ds;

import java.util.Arrays;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		int[] nums = {2,4,5,7,8,9,10};
		int target = 8;
		int startIndex = 0;
		int endIndex = nums.length - 1;
		
		int result = binarySearch(nums, target, startIndex, endIndex);
		if(result != -1)
			System.out.println("Elements found at index "+ result);
		else
			System.out.println("Element not found");
	}

	private static int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
		
		int steps = 0;
		while(startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			if(nums[midIndex] == target) {
				return midIndex;
			} else if(nums[midIndex] < target) {
				return binarySearch(nums, target, midIndex + 1, endIndex);
			} else {
				return binarySearch(nums, target, startIndex, midIndex - 1);
			}
		}
		return -1;
	}
}
