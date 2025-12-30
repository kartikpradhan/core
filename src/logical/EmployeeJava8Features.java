package logical;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class EmployeeTest {
	int id;
	String name;
	double salary;
	String department;
	List<Integer> contacts;

	public EmployeeTest(int id, String name, double salary, String department, List<Integer> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.contacts = contacts;
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

	public List<Integer> getContacts() {
		return contacts;
	}

	public void setContacts(List<Integer> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "EmployeeTest [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", contacts=" + contacts + "]";
	}

}

public class EmployeeJava8Features {

	public static void main(String[] args) {
		List<EmployeeTest> employees = Arrays.asList(new EmployeeTest(1, "Alice", 60000, "IT", Arrays.asList(111, 222)),
				new EmployeeTest(2, "Bob", 45000, "HR", Arrays.asList(333, 555)),
				new EmployeeTest(3, "Charlie", 80000, "IT", Arrays.asList(444, 555)),
				new EmployeeTest(4, "David", 50000, "Finance", Arrays.asList(666)),
				new EmployeeTest(5, "Eva", 70000, "HR", Arrays.asList(777, 888)),
				new EmployeeTest(6, "Pradhan", 90000, "IT", Arrays.asList(777, 999)));

		// 1. Get all contacts number
		List<Integer> contacts = employees.stream().flatMap(e -> e.getContacts().stream()).toList();
		System.out.println(contacts);

		// 2. find employees who is having more than 1 contact
		List<String> moreThan1Contacts = employees.stream().filter(e -> e.getContacts().size() > 1)
				.map(e -> e.getName()).toList();
		System.out.println(moreThan1Contacts);

		// 3. Increase salary by 10% (immutable)
		List<EmployeeTest> salaryIncreased1 = employees.stream().map(
				e -> new EmployeeTest(e.getId(), e.getName(), e.getSalary() * 1.10, e.getDepartment(), e.getContacts()))
				.toList();
		System.out.println(salaryIncreased1);

		// 4. Increase salary by 10% for the original object (mutable)
		List<EmployeeTest> salaryIncreased2 = employees.stream().peek(e -> e.salary = e.getSalary() * 1.10).toList();
		System.out.println(salaryIncreased2);

		// 5. Increase salary by 10% only for IT department
		List<EmployeeTest> itEmpSalaryIncrease = employees.stream().map(e -> {
			if ("IT".equalsIgnoreCase(e.getDepartment())) {
				return new EmployeeTest(e.getId(), e.getName(), e.getSalary() * 1.10, e.getDepartment(),
						e.getContacts());
			}
			return e;
		}).toList();
		System.out.println(itEmpSalaryIncrease);

		
		// 6. department wise salary hike
		List<EmployeeTest> departmentwiseIncrement = employees.stream().map(e -> {
			double increment = 0;
			switch (e.getDepartment()) {
			case "IT" -> increment = 0.20;
			case "HR" -> increment = 0.10;
			case "Finance" -> increment = 0.15;
			}

			return new EmployeeTest(e.getId(), e.getName(), e.getSalary() * (1 + increment), e.getDepartment(),
					e.getContacts());
		}).toList();
		System.out.println(departmentwiseIncrement);
		
		
		
		//1. find average salary of employee
		double avgSal = employees.stream()
				.mapToDouble(e->e.getSalary())
				.average()
				.orElse(0);
		System.out.println(avgSal);
		
		
		//2. remove duplicate contacts
		Set<Integer> uniqueContact = employees.stream()
				.flatMap(e->e.getContacts().stream())
				.collect(Collectors.toSet());
		System.out.println(uniqueContact);
		
		
		//3. convert employee list to map
		Map<Integer, String> empMap = employees.stream()
				.collect(Collectors.toMap(e->e.getId(), e->e.getName(), (e1, e2)->e1));
		System.out.println(empMap);
		
		
		//4. convert employee list to linkedhashmap
		LinkedHashMap<Integer, String> linkedhashmapEmp = employees.stream()
		.collect(Collectors.toMap(e->e.getId(), e->e.getName(), (e1, e2)->e1, LinkedHashMap::new));
		System.out.println(linkedhashmapEmp);
		
		
		//5. find employee with longest name
		EmployeeTest employeeTest = employees.stream()
				.max(Comparator.comparingInt(e->e.getName().length()))
				.get();
		System.out.println(employeeTest);
		
		
		//6. find employee with longest name if longest name has duplicate print both.
		employees.stream()
		.collect(Collectors.groupingBy(e->e.getName().length()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByKey())
		.get()
		.getValue()
		.forEach(System.out::println);
		
		
		//1.sort multiple fields 
		List<EmployeeTest> sortedEmployees = employees.stream()
		                 .sorted(Comparator
		                 .comparing(EmployeeTest::getDepartment)
		                 .thenComparing(EmployeeTest::getSalary).reversed())
		                 .toList();
		System.out.println(sortedEmployees);
		
		
		//2. Employees Earning More Than Department Average
		Map<String, Double> deptAvg = employees.stream()
		                 .collect(Collectors.groupingBy(EmployeeTest::getDepartment, Collectors.averagingDouble(EmployeeTest::getSalary)));

		List<EmployeeTest> result = employees.stream()
		                 .filter(e -> e.getSalary() > deptAvg.get(e.getDepartment()))
		                 .toList();
		System.out.println(deptAvg);
		System.out.println(result);
		
		
		//3. Check if all employee belongs to same dept
		long count = employees.stream().map(e->e.getDepartment()).distinct().count();
		if (count == 1) System.out.println("All Emps belong to same dept");
		else System.out.println("Employees have different dept");
		
		
		//4 Sum total salary of each dept
		Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(EmployeeTest::getDepartment, Collectors.summingDouble(EmployeeTest::getSalary)));
		System.out.println(collect);
		
		
		//5. Employee counts for each dept
		Map<String, Long> collect2 = employees.stream().collect(Collectors.groupingBy(EmployeeTest::getDepartment, Collectors.counting()));
		System.out.println(collect2);
	}
}
