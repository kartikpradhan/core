package logical;

import java.text.NumberFormat;
import java.util.Locale;

public class AddCommaSeparateNum {

	public static void main(String[] args) {
		String s1 = "1,123";
		String s2 = "1,123";
		int length1 = s1.length() - 1;
		int length2 = s1.length() - 1;
		int carry = 0;
		String result="";
		
		while (length1 >= 0 && length2 >= 0) {
			if (s1.charAt(length1) == ',') {
				length1--;
			}
			if (s1.charAt(length2) == ',') {
				length2--;
			}
			int sum = 0;
			if (length1 >= 0) {
				sum = sum + Integer.valueOf(String.valueOf(s1.charAt(length1)));
			}
			if (length2 >= 0) {
				sum = sum + Integer.valueOf(String.valueOf(s2.charAt(length2)));
			}
			result = sum + carry + result;
			carry = sum / 10;
			length1--;
			length2--;
			
		}
		int len = result.length()-1;
		System.out.println(len%3);
		System.out.println(result);
		
		result="89443943237914";
		
		String format = NumberFormat
				.getCurrencyInstance(new Locale("en","IN"))
				.format(Long.valueOf(result));
				
		System.out.println(format);
		String substring = format.substring(1, format.length()-3);
		System.out.println(substring);
	}
}
