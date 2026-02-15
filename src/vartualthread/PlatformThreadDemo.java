package vartualthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PlatformThreadDemo {
	static int threadCount = 50000;
	static CountDownLatch countDownLatch = new CountDownLatch(threadCount);
	static AtomicInteger atomicInteger = new AtomicInteger(0);

	private static void handleTask() {
		atomicInteger.incrementAndGet();
		System.out.println("Starting: " + Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		try {
//			System.out.println("Starting: "+Thread.currentThread().getName());
//			var socket = new Socket("www.google.com", 80);
//			socket.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		countDownLatch.countDown();
		System.out.println("Ending: " + Thread.currentThread());
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();

		for (int i = 1; i <= threadCount; i++) {
			new Thread(() -> handleTask()).start();
			//Thread.startVirtualThread(() -> handleTask());
		}
		countDownLatch.await();
		long end = System.currentTimeMillis();
		System.out.println("Thread count:: "+atomicInteger);
		System.out.println("Time taken:: " + (end - start));
	}

}
