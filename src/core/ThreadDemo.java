package core;

class ThreadDemoExtend extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {// executing by child thread
			System.out.println("ChildThread" + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		ThreadDemoExtend t = new ThreadDemoExtend();// thread intantiation
		t.start();// starting of a thread
		for (int i = 1; i <= 10; i++) {// executing by main thread
			System.out.println("MainThread" + i);
		}
	}
}