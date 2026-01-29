package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class EmployeeModel {
	int id;
	String name;
	double salary;
	String department;
	int age;

	public EmployeeModel(int id, String name, double salary, String department, int age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + ", age="
				+ age + "]";
	}

}

public class EmployeeRunner {

	public static void main(String[] args) {
		List<EmployeeModel> emps = Arrays.asList(new EmployeeModel(1, "kp", 20000, "It", 30),
				new EmployeeModel(2, "ram", 50000, "Finance", 34), new EmployeeModel(3, "arjun", 30000, "It", 32),
				new EmployeeModel(4, "karn", 60000, "Hr", 29), new EmployeeModel(5, "karn", 90000, "Hr", 40));
		
		Map<String, Optional<EmployeeModel>> result = emps.stream()
				.collect(Collectors.groupingBy(EmployeeModel::getDepartment,Collectors.maxBy(Comparator.comparingDouble(EmployeeModel::getSalary))));
		System.out.println(result);
	}
}
