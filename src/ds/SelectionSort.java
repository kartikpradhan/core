package ds;

public class SelectionSort {
	public static void main(String[] args) {
		int[] nums = {6,5,2,8,9,4};
		int temp=0;
		
		System.out.println("Before sort::");
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println("\n---------------");
		int minIndex = 0;
		for(int i=0; i<nums.length-1; i++) {
			minIndex = i;
			
			for(int j=i+1; j<nums.length-1; j++) {
				if(nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
			
		}
		System.out.println("After sort::");
		for(int num:nums) {
			System.out.print(num+" ");
		}
	}

}
