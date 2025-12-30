package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo13 {
	public static void main(String[] args) {

		oddEvenWithOutModuloOperator();
		sortStringBasedOnNumber();
	}

	private static void sortStringBasedOnNumber() {
		String[] arr = {"aa4c", "bc4d", "aa8a", "dd1a"}; //dd1a , aa4c , bc4d , aa8a
		
		Map<String, String> map = new HashMap<>();
		for(String s : arr) {
			String num = extractNumber(s);
			map.put(s, num);
		}
		System.out.println(map);
		map.entrySet().stream().sorted(Entry.comparingByValue())
		.forEach(entry->System.out.print(entry.getKey()+" ,"));
	}

	private static String extractNumber(String s) {
		for(int i=0; i<s.length()-1; i++) {
			if(s.substring(i, i+1).matches("[0-9]")) {
				return s.substring(i, i+1);
			}
		}
		return null;
	}

	private static void oddEvenWithOutModuloOperator() {
		int k=52101;
		for(int even=2, odd=3; even<=k || odd<=k; even++, odd++) {
			if(even==k) {
				System.out.println("EVEN");
				break;
			}
			if(odd==k) {
				System.out.println("ODD");
				break;
			}
			even++;
			odd++;
		}
		
	}
}