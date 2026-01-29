package java17;

public record EmployeeRecord(String name, int age) {

	public EmployeeRecord() {
		this(null, 0);
	}

	public EmployeeRecord { //compact constructor
		if (age < 18)
			throw new RuntimeException("Not eligible");
	}

}
