package streams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Demo26 {
	public static void main(String[] args) {

		List<Integer> data = Arrays.asList(1, 2, 3, 2, 3, 4, 2, 3);

		int k = 3;

		Map<List<Integer>, Long> result = data.stream().collect(slidingWindowCollector(k));

		result.forEach((window, count) -> {
			System.out.println(window + " -> " + count);
		});
	}

	public static <T> Collector<T, ?, Map<List<T>, Long>> slidingWindowCollector(int k) {
		if (k <= 0)
			throw new IllegalArgumentException("Window size must be > 0");

		return Collector.of(() -> new Accumulator<T>(k),
				Accumulator::add,
				Accumulator::combine,
				Accumulator::finish
		);
	}

	static class Accumulator<T> {
		private final int k;
		private final Deque<T> window;
		private final Map<List<T>, Long> counts;

		Accumulator(int k) {
			this.k = k;
			this.window = new ArrayDeque<>();
			this.counts = new HashMap<>();
		}

		void add(T value) {
			window.addLast(value);
			if (window.size() == k) {
				List<T> key = new ArrayList<>(window);
				counts.merge(key, 1L, Long::sum);
				window.removeFirst();
			}
		}

		Accumulator<T> combine(Accumulator<T> other) {
			
			other.counts.forEach((key, count) -> counts.merge(key, count, Long::sum));
			return this;
		}

		Map<List<T>, Long> finish() {
			return counts;
		}
	}
}