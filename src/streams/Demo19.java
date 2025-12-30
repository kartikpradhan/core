package streams;

public class Demo19 {
	//first non repeat char
	public static void main(String[] args) {

		String s = "abcdabceaafgh";
		
		char[] charArray = s.toCharArray();
		int count=0;
		
		for (int i = 0; i < charArray.length - 1; i++) {
//			if (s.indexOf(charArray[i]) == s.lastIndexOf(charArray[i])) {
//				System.out.println(charArray[i]);
//				break;
//			}
			
			for(int j=i+1; j<charArray.length-1; j++) {
				if(charArray[i] == charArray[j]) {
					count++;
					break;
				}
			}
			if(count==0) {
				System.out.println(charArray[i]);
				break;
			}
			count=0;
		}

	}
}
