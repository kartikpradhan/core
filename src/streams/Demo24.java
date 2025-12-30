package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Demo24 {
	public static void main(String[] args) {

		List<Double> data = Arrays.asList(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0);

		Moments result = data.stream().collect(MomentsCollector.toMoments());

		System.out.println(result);
	}

	static class Moments {
		final long count;
		final double mean;
		final double variance;
		final double skewness;
		final double kurtosis;

		Moments(long count, double mean, double variance, double skewness, double kurtosis) {
			this.count = count;
			this.mean = mean;
			this.variance = variance;
			this.skewness = skewness;
			this.kurtosis = kurtosis;
		}

		@Override
		public String toString() {
			return "Moments{" + "count=" + count + ", mean=" + mean + ", variance=" + variance + ", skewness="
					+ skewness + ", kurtosis=" + kurtosis + '}';
		}
	}

	static class Accumulator {
		long n = 0;
		double mean = 0;
		double m2 = 0;
		double m3 = 0;
		double m4 = 0;

		// Add one value (single pass)
		void add(double x) {
			long n1 = n;
			n++;

			double delta = x - mean;
			double deltaN = delta / n;
			double deltaN2 = deltaN * deltaN;
			double term1 = delta * deltaN * n1;

			mean += deltaN;
			m4 += term1 * deltaN2 * (n * n - 3 * n + 3) + 6 * deltaN2 * m2 - 4 * deltaN * m3;
			m3 += term1 * deltaN * (n - 2) - 3 * deltaN * m2;
			m2 += term1;
		}

		// Combine for parallel streams
		void combine(Accumulator other) {
			if (other.n == 0)
				return;
			if (this.n == 0) {
				this.n = other.n;
				this.mean = other.mean;
				this.m2 = other.m2;
				this.m3 = other.m3;
				this.m4 = other.m4;
				return;
			}

			long n1 = this.n;
			long n2 = other.n;
			long n = n1 + n2;

			double delta = other.mean - this.mean;
			double delta2 = delta * delta;
			double delta3 = delta2 * delta;
			double delta4 = delta3 * delta;

			m4 += other.m4 + delta4 * n1 * n2 * (n1 * n1 - n1 * n2 + n2 * n2) / (double) (n * n * n)
					+ 6 * delta2 * (n1 * n1 * other.m2 + n2 * n2 * this.m2) / (double) (n * n)
					+ 4 * delta * (n1 * other.m3 - n2 * this.m3) / n;

			m3 += other.m3 + delta3 * n1 * n2 * (n1 - n2) / (double) (n * n)
					+ 3 * delta * (n1 * other.m2 - n2 * this.m2) / n;

			m2 += other.m2 + delta2 * n1 * n2 / n;
			mean = (n1 * mean + n2 * other.mean) / n;
			this.n = n;
		}

		Moments finish() {
			if (n < 2) {
				return new Moments(n, mean, 0, 0, 0);
			}

			double variance = m2 / n;
			double skewness = Math.sqrt(n) * m3 / Math.pow(m2, 1.5);
			double kurtosis = (n * m4) / (m2 * m2) - 3.0;

			return new Moments(n, mean, variance, skewness, kurtosis);
		}
	}

	static class MomentsCollector {

		static Collector<Double, Accumulator, Moments> toMoments() {
			return Collector.of(Accumulator::new, Accumulator::add, (a, b) -> {
				a.combine(b);
				return a;
			}, Accumulator::finish);
		}
	}
}
