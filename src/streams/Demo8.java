package streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo8 {
	public static void main(String[] args) {

		String str = "2,3,1,4,4,1,4,333,3,333,2,2,2,5,222";

		Map<String, Integer> map = new HashMap<>();
		for (String ch : str.split(",")) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Optional<Entry<String, Integer>> entry = map.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder())).findFirst();
		System.out.println(entry.get().getKey());
		System.out.println("==================");

		map.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
				.entrySet().stream().forEach(entr -> System.out.println(entr.getKey() + "-" + entr.getValue()));

	}

}