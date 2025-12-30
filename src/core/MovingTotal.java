package core;

import java.util.LinkedList;
import java.util.List;

public class MovingTotal {
	/**
	 * Adds/appends list of integers at the end of internal list.
	 */
	List<int[]> nums = new LinkedList<>();

	public void append(int[] list) {
		nums.add(list);
		// throw new UnsupportedOperationException("Waiting to be implemented.");
	}

	/**
	 * Returns boolean representing if any three consecutive integers in the
	 * internal list have given total.
	 */
	public boolean contains(int total) {
		for (int[] arr : nums) {
			int sum = 0;
			int sum2 = 0;
			if (arr.length >= 3) {
				sum = arr[0] + arr[1] + arr[2];
				sum2 = arr[arr.length - 1] + arr[arr.length - 2] + arr[arr.length - 3];

				if (sum == total || sum2==total) {
					return true;
				} else {
					return false;
				}

			}

		}
		return false;
	}

	public static void main(String[] args) {
		MovingTotal movingTotal = new MovingTotal();

		movingTotal.append(new int[] { 1, 2, 3, 4 });

		System.out.println(movingTotal.contains(6));
		System.out.println(movingTotal.contains(9));
		System.out.println(movingTotal.contains(12));
		System.out.println(movingTotal.contains(7));

		movingTotal.append(new int[] { 5 });

		System.out.println(movingTotal.contains(6));
		System.out.println(movingTotal.contains(9));
		System.out.println(movingTotal.contains(12));
		System.out.println(movingTotal.contains(7));
	}
}