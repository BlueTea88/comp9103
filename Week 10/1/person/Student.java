package person;

public class Student extends Person {
	private String major;
	
	public Student(String name, String dateOfBirth, String major){
		super(name, dateOfBirth);
		this.major = major;
	}
	
	public String toString() {
		String out = String.format("Student Class\r\nName: %s\r\nDate of Birth: %s\r\nMajor: %s\r\n",
								   getName(), getDateOfBirth(), this.major);
		return out;
	}
}
