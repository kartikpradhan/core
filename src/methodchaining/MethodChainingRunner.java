package methodchaining;

public class MethodChainingRunner {
	
	public static void main(String[] args) {
		
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				Student std1 = new Student().setName("KP").setAge(32).setAddress("BBRD");
				Student std2 = new Student().setName("SR").setAge(23).setAddress("BBRD1");
				System.out.println(std1);
				System.out.println(std2);
			}
		});
		t1.start();
		Student std2 = new Student().setName("SR1").setAge(15).setAddress("BBRD1");
		System.out.println(std2);
	}

}
