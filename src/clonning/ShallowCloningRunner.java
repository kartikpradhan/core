package clonning;

public class ShallowCloningRunner {
	public static void main(String[] args) throws CloneNotSupportedException {
		Course science = new Course("Physics", "Chemestry", "Biology");
		Student std = new Student("SR", science);

		 Student copyStd = (Student) std.clone();
		 
		
		System.out.println(std);
		System.out.println(copyStd);
		System.out.println(std == copyStd);
		
		copyStd.setName("kp");
		copyStd.getCourse().setSubject1("dummy");
		System.out.println("=========================");
		System.out.println(std);
		System.out.println(copyStd);
		System.out.println(std == copyStd);
	}

}
