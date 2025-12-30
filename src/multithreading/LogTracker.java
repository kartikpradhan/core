package multithreading;

import java.util.concurrent.Callable;

public class LogTracker implements Callable<String>{

	@Override
	public String call() throws Exception {
		int d = (int) (Math.random()*100);
		return String.valueOf(d);
	}

}
