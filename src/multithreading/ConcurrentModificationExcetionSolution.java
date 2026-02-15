package multithreading;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExcetionSolution extends Thread {
	private static Map<Integer, String> map = new ConcurrentHashMap<>();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("child thread updating list");
			map.put(103, "C");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
		
		
		map.put(101, "A");
		map.put(102, "B");
		new ConcurrentModificationExcetionSolution().start();
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			Thread.sleep(3000);
		}
		System.out.println(map);
	}

}