package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Demo29 {
	public static void main(String[] args) {
		//find 2nd highest word in sentence based on length
		
		String sentence = "welcome to the challenging world!! kartikaji";
		String string = Stream.of(sentence.split("[\\s+]"))
				.distinct()
				.sorted(Comparator.comparing(String::length).reversed())
				.skip(1)
				.findFirst()
				.get();
		System.out.println(string);
		
		//sum of prefix nums
		//input[1,2,3,4]  output[1,3,6,10]
		
		List<Integer> nums = Arrays.asList(1,2,3,4);
		int sum=0;
		List<Integer> temp = new ArrayList<>();
		for(Integer num: nums) {
			sum += num;
			temp.add(sum);
		}
		System.out.println(temp);
		
	}

}
