package streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	private String name;
	private PersonDept personDept;
	private double salary;

	public Person(String name, PersonDept personDept, double salary) {
		super();
		this.name = name;
		this.personDept = personDept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public PersonDept getPersonDept() {
		return personDept;
	}

	public double getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonDept(PersonDept personDept) {
		this.personDept = personDept;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personDept=" + personDept + ", salary=" + salary + "]";
	}

}

enum PersonDept {
	IT, HR, SALES
}

public class Demo23 {
	public static void main(String[] args) {
		
		List<Person> persons = List.of(
				new Person("Jeevan", PersonDept.IT, 100000),
				new Person("Harsha", PersonDept.IT, 120000), 
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95015),
				new Person("Dheeraj", PersonDept.SALES, 95008),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),
				new Person("Dheeraj", PersonDept.SALES, 95000),

				new Person("Janaki", PersonDept.SALES, 50000), 
				new Person("Kartik", PersonDept.HR, 52000),
				new Person("James", PersonDept.HR, 48000));

		
		Map<PersonDept, Double> avgSalaryByDept = persons.stream()
				.collect(Collectors.groupingBy(Person::getPersonDept, Collectors.mapping(Person::getSalary,
						Collectors.collectingAndThen(Collectors.toList(), Demo23::trimmedAverage))));

		
		avgSalaryByDept.forEach((dept, avg) -> System.out.println(dept + " → " + avg));
	}

	private static double trimmedAverage(List<Double> salaries) {

		int eachDeptSalary = salaries.size();
		Collections.sort(salaries);

		// Calculate excluding the top and bottom 5%
		int trim = (int) (eachDeptSalary * 0.05);

		// if no records to trim (required at least 20 person with same dept)
		if (trim == 0 ) {
			return salaries.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		}

		// exclude(trim) lowest and highest salaries
		List<Double> trimmed = salaries.subList(trim, eachDeptSalary - trim);

		// Average of remaining values
		return trimmed.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
	}

}
