package java17;

public record EmployeeRecord(String name, int age) {

	public EmployeeRecord() {
		this(null,0);
	}

}
