package logical;

import java.util.Scanner;

public class AnagramRunner {

	public static void main(String[] args) {
		
		System.out.println("Enter first string of word::");
		Scanner sc = new Scanner(System.in);
		String word1 = sc.nextLine();
		
		System.out.println("Enter second string of word::");
		Scanner sc2 = new Scanner(System.in);
		String word2 = sc2.nextLine();
		
		//word1=test
		//word2=ttes
		boolean isAnagram = true;
		if(word1.length() == word2.length()) {
			for(int i=0; i<word2.length(); i++) {
				if(!(word1.contains(word2.subSequence(i, i + 1)))) {
					isAnagram = false;
				}
				
			}
			for(int i=0; i<word1.length(); i++) {
				if(!(word2.contains(word1.subSequence(i, i + 1)))) {
					isAnagram = false;
				}
				
			}
		} else {
			isAnagram = false;
		}
		if(isAnagram) {
			System.out.println("Both string are Anagram");
		}else {
			System.out.println("Both string are not Anagram");
		}
		
	}
}
