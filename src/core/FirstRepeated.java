package core;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstRepeated{
  public static void main(String args[]) {
	  	  //Given a String, find the first repeated character in it using Stream functions?
          String input = "Java JArticles are Awesome";
          
          LinkedHashMap<Character, Long> collect = input.chars()
          .mapToObj(s -> (char)s)        
          .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
          System.out.println(collect);

          Character result = input.chars() // Stream of String       
                                  .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                  .entrySet()
                                  .stream()
                                  .filter(entry -> entry.getValue() == 1L)
                                  .map(entry -> entry.getKey())
                                  .findFirst()
                                  .get();
          System.out.println(result);    
          
          LinkedHashMap<Character, Long> lhm= input.chars() // Stream of String       
          .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
          .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())); //Store the chars in map with count 
          System.out.println(lhm);
  }
}