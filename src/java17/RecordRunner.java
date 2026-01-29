package java17;

public class RecordRunner {

	public static void main(String[] args) {
		EmployeeRecord record = new EmployeeRecord("kartik", 15);
		EmployeeRecord record2 = new EmployeeRecord();
		
		System.out.println(record);
		System.out.println(record2);
		System.out.println(record.name());
		System.out.println(Integer.MIN_VALUE);
	}
}
