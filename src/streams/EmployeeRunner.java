package streams;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRunner {
	
	public static void main(String[] args) {
		
		PersonDept d = new PersonDept();
		d.setId(1);
		d.setName("d11");
		PersonDept d2 = new PersonDept();
		d2.setId(11);
		d2.setName("d111");
		List<PersonDept> deptList = new ArrayList<>();
		deptList.add(d2);
		deptList.add(d);
		for(PersonDept dept : deptList) {
			System.out.println(dept.getId());
		}
	}
}
