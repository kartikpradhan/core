package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MutiThreadRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
	
		ExecutorService service = Executors.newFixedThreadPool(availableProcessors);
		List<LogTracker> list = new ArrayList<>();
		list.add(new LogTracker());
		list.add(new LogTracker());
		list.add(new LogTracker());
		list.add(new LogTracker());
//		for(LogTracker lt: list) {
//			Future<String> submit = service.submit(lt);
//			System.out.println(submit.get());
//			System.out.println(submit.isDone());
//		}
		
		service.shutdown();
	}

}
