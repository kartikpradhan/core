package streams;

import java.util.Arrays;

public class Demo16 {

	public static void main(String[] args) {

		int[] nums = { 10, 0, 23, 4, 0 }; // 0,0,10,23,4

		int[] zeroArray = Arrays.stream(nums).filter(n -> n == 0).toArray();
		int[] nonZeroArray = Arrays.stream(nums).filter(n -> n != 0).toArray();

		int[] temp = new int[nums.length];
		System.arraycopy(zeroArray, 0, temp, 0, zeroArray.length);
		System.arraycopy(nonZeroArray, 0, temp, zeroArray.length, nonZeroArray.length);

		System.out.println(Arrays.toString(zeroArray));
		System.out.println(Arrays.toString(nonZeroArray));
		System.out.println(Arrays.toString(temp));
		
		Arrays.sort(temp);
	}
}
