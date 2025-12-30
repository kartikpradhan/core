package logical;

import java.math.BigDecimal;

public class AddLargeNumber {

//	public static void main(String args[]) {

//	}

	public static void main(String args[]) {
		// "8944394323791464", "14472334024676221" 23416728348467685
		// "23416728348467685"
		// "1,234", "1,234", "2,468"
		// "701,408,733", "433,494,437", "1,134,903,170"
		// "317,811", "514,229", "832,040"
		// "8,944,394,323,791,464", "14,472,334,024,676,221",
		// "23,416,728,348,467,685"
		
		//bigNumberSum();
		String num1 = "8,944,394,323,791,464";
		String num2 = "14,472,334,024,676,221";
		String result = add(num1, num2);
		System.out.println(result);
	}

	private static void bigNumberSum() {
		// "8944394323791464", "14472334024676221" 23416728348467685
		// "23416728348467685"
		String num1 = "8944394323791464";
		String num2 = "14472334024676221";
		String result = add1(num1, num2);
		System.out.println(result);
		System.out.println(BigDecimal.valueOf(894439432379146495l).add(BigDecimal.valueOf(144723340246762286l)));
	}

	public static String add1(String a, String b) {
		StringBuilder sum = new StringBuilder();
		int carry = 0;

		// Start from least digit
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
			int digitA = (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
			int digitB = (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;
			int currentSum = digitA + digitB + carry;
			sum.insert(0, currentSum % 10); // insert the remainig digit
			carry = currentSum / 10;
		}
		return sum.toString();
		
	}

	public static String add(String a, String b) {

		a = a.replaceAll("[,\\s]", "");
		b = b.replaceAll("[,\\s]", "");
		//
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();

		int carry = 0;
		int i = 0;
		StringBuilder sum = new StringBuilder();
		//
		while (i < a.length() || i < b.length() || carry > 0) {
			int digitA = (i < a.length()) ? Character.getNumericValue(a.charAt(i)) : 0;
			int digitB = (i < b.length()) ? Character.getNumericValue(b.charAt(i)) : 0;
			int currentSum = digitA + digitB + carry;
			sum.append(currentSum % 10);
			carry = currentSum / 10;
			i++;
		}
	
		String result = sum.reverse().toString();
		StringBuilder stringWihComma = new StringBuilder();
		int commonindex = result.length() % 3;
		System.out.println(result);
		System.out.println(commonindex);
		for (int j = 0; j < result.length(); j++) {
			if (j > 0 && j % 3 == commonindex) {
				stringWihComma.append(",");
			}
			stringWihComma.append(result.charAt(j));
		}
		return stringWihComma.toString();

	}
}
