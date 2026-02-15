package multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExcetionTest extends Thread {
	private static List<String> list = new ArrayList<>();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("child thread updating list");
			list.add("C");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		list.add("A");
		list.add("B");
		new ConcurrentModificationExcetionTest().start();
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			Thread.sleep(3000);
		}
		System.out.println(list);
	}

}