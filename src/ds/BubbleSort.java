package ds;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = { 6, 5, 2, 8, 9, 4 };
		int temp = 0;

		System.out.println("Before sort::");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("\n---------------");

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		System.out.println("After sort::");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
