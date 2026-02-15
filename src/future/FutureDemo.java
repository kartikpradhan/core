package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	private static String getFirstName() {
		try {
			System.out.println("getFirstName: executed by: "+Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Kartik";
	}
	private static String getLastName() {
		try {
			System.out.println("getLastName: executed by: "+Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Pradhan";
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long milliSecs = System.currentTimeMillis();
		
		Callable<String> firstNameCallable = () -> getFirstName();
		Callable<String> lastNameCallable = () -> getLastName();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Future<String> firstNameSubmit = executor.submit(firstNameCallable);
		Future<String> lastNameSubmit = executor.submit(lastNameCallable);
		
		String firstName = firstNameSubmit.get();
		String lastName = lastNameSubmit.get();
		
		executor.shutdown();
		
		System.out.println(firstName+ " "+ lastName);
		System.out.println("Time Taken to execute: "+ (System.currentTimeMillis()-milliSecs));
	}



}
