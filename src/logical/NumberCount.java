package logical;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberCount {

	public static void main(String[] args) {
		List<Integer> nums=Arrays.asList(12,43,56,78,12,78);
		
        Map<Integer, Long> charCountMap = 
                    nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         
        System.out.println(charCountMap);
       
        
        
	}
}
