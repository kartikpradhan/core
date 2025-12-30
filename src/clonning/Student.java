package clonning;

public class Student implements Cloneable {
	private String name;
	private Course course;

	public Student(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Override 
	protected Object clone() throws CloneNotSupportedException {
	  Student s = (Student) super.clone(); //s.setCourse((Course)
	  s.course = (Course) course.clone(); 
	  return s; 
	}

	/*
	 * @Override protected Object clone() throws CloneNotSupportedException {
	 * 
	 * Student std= new Student(); std.setName(this.name);
	 * std.setCourse(this.course); return std; }
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
