package methodchaining;

public class Student {
	private String name;
	private int age;
	private String address;
	public String getName() {
		return name;
	}
	public Student setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Student setAge(int age) {
		this.age = age;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Student setAddress(String address) {
		this.address = address;
		return this;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
