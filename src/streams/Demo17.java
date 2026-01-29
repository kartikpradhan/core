package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo17 {

	public static void main(String[] args) {
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 11);
		map.put(3, 15);
		map.put(5, 19);
		
		int intValue = map.entrySet().stream().map(e->e.getValue()).reduce(0, (n1, n2) -> n1 + n2).intValue();
		System.out.println(intValue);
		
		//create pojo emp, sort on the basis of sal and age
		List<Emp> empList = Arrays.asList(new Emp(32, 45000),
				new Emp(25, 5000),
				new Emp(15, 25000));
		
		Collections.sort(empList, Comparator.comparing(Emp::getSalary).thenComparing(Emp::getAge));
		System.out.println(empList);
		
	}
}

class Emp{
	int age;
	double salary;
	
	public Emp(int age, double salary) {
		super();
		this.age = age;
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [age=" + age + ", salary=" + salary + "]";
	}
	
}