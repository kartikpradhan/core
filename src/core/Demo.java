package core;

public class Demo {

	public static void main(String[] args) {
		String s = "abbkbkadk";
		String newString = "";
		boolean is_unique_char_found = false;
		for (char c : s.toCharArray()) {
//			if(s.indexOf(c) != s.lastIndexOf(c)) {
//				continue;
//			} else {
//				newString = newString.concat(String.valueOf(c));
//			}
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				is_unique_char_found = true;
				newString = newString.concat(String.valueOf(c));
				break;
			}
		}
		if(!is_unique_char_found) System.out.println("No unique char found...");
		System.out.println(newString);

//		char prevChar = ' ';
//		for (int i = 0; i < s.length(); i++) {
//			
//			if (s.length()-1 != i) {
//				if(i>0)
//					prevChar = s.charAt(i-1);
//				
//				if ((s.charAt(i) == s.charAt(i + 1)) || (prevChar == s.charAt(i))) {
//					continue;
//				} else {
//					newString = newString + s.charAt(i);
//				}
//			}else {
//				newString = newString + s.charAt(i);
//			}
//			
//		}
//		System.out.println(newString);
	}

}
