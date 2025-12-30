package streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindVowelPosition {

	public static void main(String[] args) {
		int a = 'A';
		System.out.println(a);
		
		String str = "Hello World";

        // Convert the string to lowercase
        str = str.toLowerCase();

        // Create a stream of characters from the string
        IntStream stream = str.chars();
       

        // Filter the stream to get only the vowels
        stream = stream.filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');

        // Collect the positions of the vowels into a list
        // Using an Integer array list
        java.util.List<Integer> positions = stream.boxed().collect(Collectors.toList());

        // Print the positions of the vowels
        System.out.println(positions);
	}
}