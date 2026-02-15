package methodchaining;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchManager {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2); //if we enter 3 then it will be forever in running state as we are passing only 2 thread
		MyDevTeam teamDevA = new MyDevTeam(countDownLatch, "devA");
		MyDevTeam teamDevB = new MyDevTeam(countDownLatch, "devB");
		teamDevA.start();
		teamDevB.start();
		countDownLatch.await(); //Causes the current thread to wait until the latch has counted down to zero
		MyQATeam qa = new MyQATeam();
		qa.start();
	}
}

class MyDevTeam extends Thread {
	CountDownLatch countDownLatch;

	public MyDevTeam(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Task assigned to development team " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Task finished by development team " + Thread.currentThread().getName());
		this.countDownLatch.countDown();  //Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
		System.out.println(countDownLatch.getCount()); //if count not zero than it will be in a running state only
	}
}

class MyQATeam extends Thread {
	@Override
	public void run() {
		System.out.println("Task assigned to QA team");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Task finished by QA team");
	}
}