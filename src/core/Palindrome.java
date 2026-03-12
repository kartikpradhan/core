package core;

import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		String s= "madama";
		Arrays.sort(s.toCharArray(), s.toCharArray().length-1, 0);
		System.out.println(s);
	}
}
