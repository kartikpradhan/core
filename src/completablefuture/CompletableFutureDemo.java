package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

	private String getFirstName() {
		try {
			System.out.println("getFirstName: executed by: " + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Kartik";
	}

	private String getLastName() {
		try {
			System.out.println("getLastName: executed by: " + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Pradhan";
	}

	public static void main(String[] args) {
		long milliSecs = System.currentTimeMillis();
		CompletableFutureDemo demo = new CompletableFutureDemo();

		CompletableFuture<String> firstNameCompletableFuture = CompletableFuture.supplyAsync(() -> demo.getFirstName());
		CompletableFuture<String> lastNameCompletableFuture = CompletableFuture.supplyAsync(() -> demo.getLastName());
		//String fullName = firstNameCompletableFuture
		//		.thenCombine(lastNameCompletableFuture, (first, last) -> first + last).join(); // it takes just 2 sec
		
		CompletableFuture.allOf(firstNameCompletableFuture, lastNameCompletableFuture).join();
		String fname = firstNameCompletableFuture.join();
		String lname = lastNameCompletableFuture.join();
		System.out.println(fname+lname);
		//System.out.println(fullName);
		
		
		//combining in a single line but works as sequential
//		String fullName = CompletableFuture.supplyAsync(()->demo.getFirstName())
//				.thenApplyAsync(firstName -> firstName + " " + demo.getLastName()).join(); //it will take 4 sec as it will supplyAsync then start thenApplyAsync
//		System.out.println(fullName);
		
		System.out.println("Time Taken to execute: " + (System.currentTimeMillis() - milliSecs));
	}

}
