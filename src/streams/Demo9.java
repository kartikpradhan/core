package streams;

public class Demo9 {
	public static void main(String[] args) {

		String str1 = "1";
		String str2 = "999";
		String formatStr1 = "1,000";
		String formatStr2 = "2,000";

		// String result = addTwoBigNums(str1, str2);

		formatNumber(formatStr1, formatStr2);
		formatNumber("9,234", "1,234");
		formatNumber("317,811", "514,229");
		formatNumber("701,408,733", "433,494,437");
		formatNumber("8,944,394,323,791,464", "14,472,334,024,676,221");
		formatNumber("98", "2");
		formatNumber("123,456", "123,456");

//		System.out.println(result);
//		System.out.println(addTwoBigNums("144", "89"));
//		System.out.println(addTwoBigNums("8944394323791464", "14472334024676221"));
//		System.out.println(addTwoBigNums("222232244629420445529739893461909967206666939096499764990979600", "1"));

	}

	private static String formatNumber(String formatStr1, String formatStr2) {

		String str = removeComma(formatStr1);
		String str2 = removeComma(formatStr2);
		String sumOfTwoBigNums = addTwoBigNums(str, str2);
		// 3000 - 3,000
		// 30000 - 30,000
		StringBuilder foramttedStr = new StringBuilder();
		// for(int i=0; i<sumOfTwoBigNums.length(); i++) {
		int counter = 0;
		for (int i = sumOfTwoBigNums.length() - 1; i >= 0; i--) {

			if (counter == 3) {
				foramttedStr.append(",");
				counter = 0;
			}
			counter++;
			foramttedStr.append(sumOfTwoBigNums.charAt(i));
		}
		System.out.println(foramttedStr.reverse());
//		StringBuilder sum = new StringBuilder();
//		int carryForward = 0;
//		for (int i = formatStr1.length() - 1, j = formatStr2.length() - 1; i >= 0 || j >= 0; i--, j--) {
//
//			int num1 = (i >= 0) ? Character.getNumericValue(formatStr1.charAt(i)) : 0;
//			int num2 = (j >= 0) ? Character.getNumericValue(formatStr2.charAt(j)) : 0;
//
//			int result = num1 + num2 + carryForward;
//
//			sum.insert(0, result % 10);
//			carryForward = result / 10;
//		}
//		if(carryForward > 0)
//			sum.insert(0, carryForward);
		return null;
	}

	private static String removeComma(String formatStr1) {
		return formatStr1.replaceAll("[,\\s]", "");
	}

	private static String addTwoBigNums(String str1, String str2) {

		StringBuilder sum = new StringBuilder();
		int carryForward = 0;
		for (int i = str1.length() - 1, j = str2.length() - 1; i >= 0 || j >= 0; i--, j--) {

			int num1 = (i >= 0) ? Character.getNumericValue(str1.charAt(i)) : 0;
			int num2 = (j >= 0) ? Character.getNumericValue(str2.charAt(j)) : 0;

			int result = num1 + num2 + carryForward;

			sum.insert(0, result % 10);
			carryForward = result / 10;
		}
		if (carryForward > 0)
			sum.insert(0, carryForward);
		return sum.toString();
	}

}