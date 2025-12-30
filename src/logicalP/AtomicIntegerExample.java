package logicalP;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	private static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) {
		Runnable task = () -> {
			for (int i = 0; i < 100; i++) {
				counter.incrementAndGet(); // Atomically increments the counter
				System.out.println(Thread.currentThread().getName() + " " + i + " counter: " + counter);
			}
		};

		// Create multiple threads to execute the task concurrently
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Final counter value: " + counter.get()); // Should print 2000
	}
}
