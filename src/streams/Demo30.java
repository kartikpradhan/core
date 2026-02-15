package streams;

public class Demo30 {
	public static void main(String[] args) {
		//Given a string s  = "abcabcbb", find the length of the longest substring without repeating characters.
		
		String s  = "abcabcbb"; //abc
		char[] chars = s.toCharArray();
		int count = 0;
		String temp = "";
		for(int i=0; i<chars.length; i++) {
			for(int j=i; j<chars.length; j++) {
				if(chars[i] != chars[j]) {
					temp = temp.concat(String.valueOf(chars[j]));
				}
			}
		}
		
	}
	
}
