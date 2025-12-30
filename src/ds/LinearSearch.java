package ds;

public class LinearSearch {
	
	public static void main(String[] args) {
		int[] nums = {2,4,5,7,8,9,10};
		//int[] nums = new int[1000];
		int target = 8221;
		int result = linearSearch(nums, target);
		if(result != -1)
			System.out.println("Elements found at index "+ result);
		else
			System.out.println("Element not found");
	}

	private static int linearSearch(int[] nums, int target) {
		int steps = 0;
		for(int i=0; i<=nums.length -1; i++) {
			steps++;
			if(nums[i] == target) {
				System.out.println("No of steps::"+ steps);
				return i;
			}
		}
		System.out.println("No of steps::"+ steps);
		return -1;
	}

}
