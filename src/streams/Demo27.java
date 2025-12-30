package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class Demo27 {
	public static void main(String[] args) {
		
		List<String> items = Arrays.asList("apple", "banana", "avocado", "blueberry", "apricot");
		
		Map<Boolean, Map<Character, List<String>>> result = items.stream()
				.collect(partitionAndGroup(s -> s.startsWith("a"), s -> s.charAt(0)));
		System.out.println(result);
	}

	public static <T, K> Collector<T, ?, Map<Boolean, Map<K, List<T>>>> partitionAndGroup(
			Predicate<? super T> predicate, Function<? super T, ? extends K> keyMapper) {

		return Collector.of(() -> {

			Map<Boolean, Map<K, List<T>>> map = new HashMap<>();
			map.put(true, new HashMap<>());
			map.put(false, new HashMap<>());
			return map;
		}, (acc, t) -> {

			boolean partition = predicate.test(t);
			Map<K, List<T>> partitionMap = acc.get(partition);
			K key = keyMapper.apply(t);
			partitionMap.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
		}, (acc1, acc2) -> {

			for (Boolean b : Arrays.asList(true, false)) {
				Map<K, List<T>> map1 = acc1.get(b);
				Map<K, List<T>> map2 = acc2.get(b);
				map2.forEach((k, list) -> map1.merge(k, list, (l1, l2) -> {
					l1.addAll(l2);
					return l1;
				}));
			}
			return acc1;
		});
	}
}