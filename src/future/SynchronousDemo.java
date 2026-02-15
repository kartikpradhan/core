package future;



public class SynchronousDemo {
	private static String getFirstName() {
		try {
			Thread.sleep(2000);
			System.out.println("getFirstName: executed by: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Kartik";
	}
	private static String getLastName() {
		try {
			Thread.sleep(2000);
			System.out.println("getLastName: executed by: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Pradhan";
	}
	public static void main(String[] args) {
		long milliSecs = System.currentTimeMillis();
		String firstName = getFirstName();
		String lastName = getLastName();
		String fullName = firstName+" "+lastName;
		System.out.println(fullName);
		System.out.println("Time Taken to execute: "+ (System.currentTimeMillis()-milliSecs));
	}

}
