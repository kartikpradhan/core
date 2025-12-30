package streams;

import java.util.Arrays;

public class Demo10 {
	public static void main(String[] args) {
		
		//merge two array
		int[] n1 = { 10, 8, 15 };
		int[] n2 = { 5, 20, 10, 8, 15 };
		int[] tempArr = new int[n1.length + n2.length];
		int counter = 0;
		for (int i = 0, j = 0; i < n1.length || j < n2.length; i++, j++) {
			if (i < n1.length) {
				tempArr[counter] = n1[i];
				counter++;
			}
			if (j < n2.length) {
				tempArr[counter] = n2[j];
				counter++;
			}

		}
		
		System.out.println(Arrays.toString(tempArr));
		System.out.println("===========================");
		

		//sort array
		//Arrays.sort(tempArr);
		//manual
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = i + 1; j < tempArr.length; j++) {
				if (tempArr[i] > tempArr[j]) {
					int temp = tempArr[i];
					tempArr[i] = tempArr[j];
					tempArr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(tempArr));
		
		String s=new String("h");
		String s2="h";
		System.out.println(s==s2);
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
	}
}