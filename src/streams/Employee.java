package streams;

//List out Employee based on phone number count
public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;
	private String department;
	private String country;
	public Employee(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Employee setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Employee setAge(int age) {
		this.age = age;
		return this;
	}
	public double getSalary() {
		return salary;
	}
	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}
	public String getDepartment() {
		return department;
	}
	public Employee setDepartment(String department) {
		this.department = department;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public Employee setCountry(String country) {
		this.country = country;
		return this;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}
	
	
}
