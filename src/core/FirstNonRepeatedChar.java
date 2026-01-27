package core;

public class FirstNonRepeatedChar {
	public static void main(String[] args) {
		String string = "igeeksdffoorrgeeks";
		int index = 0;
		char firstNonRepeatChar = ' ';

		if (string.length() == 0) {
			System.out.println("EMPTY STRING");
		}

		for (char i : string.toCharArray()) {
			if (string.indexOf(i) != string.lastIndexOf(i)) {
				firstNonRepeatChar = i;
				break;
			} else {
				index += 1;
			}
		}
		if (index == string.length()) {
			System.out.println("All characters are repeating");
		} else {
			System.out.println("First non-repeating character is :: " + firstNonRepeatChar);
		}
	}
}