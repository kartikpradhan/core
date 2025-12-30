
package core;

class TestD {
	public void message1() {
		System.out.println("TestD::message1");
	}
}

class TestDD extends TestD {
	public void message1(String msg) {
		System.out.println("TestDD::message1");

	}
}

public class OverloadingTest {

	public static void main(String[] args) {
		TestD t = new TestDD();
		t.message1();
	}
}
