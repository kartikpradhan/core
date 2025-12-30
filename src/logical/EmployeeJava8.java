package logical;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	int id;
	String name;
	double salary;
	String department;
	int age;
	
	public Employee(int id, String name, double salary, String department,int age) {
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

public class EmployeeJava8 {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee(1, "kp", 20000, "It",30),
				new Employee(2, "ram", 50000, "Finance",34),
				new Employee(3, "arjun", 30000, "It",32), 
				new Employee(4, "karn", 60000, "Hr",29),
				new Employee(5, "karn", 90000, "Hr",40));

		// Question 1: Find all employees with salary > 50,000
		List<Employee> EmpMorethan50k = emps.stream().filter(e -> e.getSalary() > 50000).collect(Collectors.toList());
		System.out.println(EmpMorethan50k);
		emps.stream().filter(e -> e.getSalary() > 50000).forEach(System.out::println);
		
		
		// Question 2: Sort employees by salary (descending order)
		Collections.sort(emps, Comparator.comparing(Employee::getSalary).reversed());
		System.out.println(emps);
		
		// Question 3: Group employees by department
		Map<String, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(collect);
		
		
		// Question 4: Find the highest paid employee
		Optional<Employee> max = emps.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(max);
		//or
		//Optional<Employee> reduce = emps.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		//System.out.println(reduce);
		
		// Question 5: Convert List<Employee> to List<String> of employee names
		List<String> empList = emps.stream().map(emp->emp.getName()).collect(Collectors.toList());
		System.out.println(empList);
		
		//find duplicate employee names
		Set<String> dupEmployess = emps.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e->e.getValue() >1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
				
		System.out.println(dupEmployess);
		
		//Find employee count for each department
		Map<String, Long> empCountPerDept = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(empCountPerDept);
		
		
		//Sum salary of each department
		Map<String, Double> sumSalEachDept = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println(sumSalEachDept);
		
		
		//Get top 3 salary
		List<Double> top3Salary = emps.stream().map(emp->emp.getSalary())
		.sorted(Comparator.reverseOrder())
		.limit(3)
		.collect(Collectors.toList());
		System.out.println(top3Salary);
		
		//Get nth highest salary
		int n=1; //dynamic value
		Double nthSal = emps.stream().map(emp->emp.getSalary())
		 .sorted(Comparator.reverseOrder())
		 .skip(n-1)
		 .findFirst().orElse(0.0);
		 System.out.println(nthSal);
		 
		 
		//Get nth highest salary with name 
		 String empNameWithNthSal = emps.stream().filter(emp->emp.getSalary()==nthSal)
		 .map(emp->emp.getName() + ":" + emp.getSalary())
		 .findFirst()
		 .get();
		System.out.println(empNameWithNthSal);
		
		Employee employee = emps.stream().filter(emp->emp.getSalary()==nthSal).findFirst().get();
		System.out.println(employee);
		
		//Get comma separated employee name
		String commaSeparateName = emps.stream().map(e->e.getName()).collect(Collectors.joining(","));
		System.out.println(commaSeparateName);
		
		
		//Get youngest employee in each dept
		Map<String, Optional<Employee>> youngestEmpEachDept = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getAge))));
			
		youngestEmpEachDept.entrySet().stream().forEach(System.out::println);
		
		
		//Get youngest employee in each dept
		Map<String, Optional<Employee>> oldestEmpEachDept = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getAge))));
					
		oldestEmpEachDept.entrySet().stream().forEach(System.out::println);
		
		
		//Get top 2 paid employees
		emps.stream()
		.sorted(Comparator.comparing(Employee::getSalary).reversed())
		.limit(2)
		.forEach(System.out::println);
		
		
		//remove 3 lowest salaried employee
		emps.stream()
		.sorted(Comparator.comparing(Employee::getSalary))
		.skip(3)
		.forEach(System.out::println);
	}
}
