package streams;
import java.util.HashMap;
import java.util.Map;

public class PalindromeCheck {

    public static boolean canFormPalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Count odd frequencies
        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Step 3: Condition check
        System.out.println(oddCount);
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("bangalore"));  // false
        System.out.println(canFormPalindrome("abdybaydk"));   // true
    }
}