package streams;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		// n number starts from 1

		int[] nums = { 3, 4, 25, 9, 1, 2, 7, 6, 5, 8 };
		Arrays.sort(nums);

		for (int i = 0, j = 1; i < nums.length; i++, j++) {
			if (nums[i] != j) {
				System.out.println("Missing Number::" + j);
				break;
			}
		}

		String s = new String("5");
		System.out.println(1 + 10 + s + 1 + 10); // 115110

		String str = null;
		System.out.println(str.valueOf(10));// NPE

		// sorting
		int[] numArr = { 3, 6, 4, 2, 8 };
		int temp = 0;
		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] > numArr[j]) {
					temp = numArr[j];
					numArr[j] = numArr[i];
					numArr[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numArr));
		int min = 1;
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] == min) {
				min++;
			} else {
				break;
			}
		}
		System.out.println(min);

	}

}
