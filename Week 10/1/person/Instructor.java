package person;

public class Instructor extends Person {
	private double salary;
	
	public Instructor(String name, String dateOfBirth, double salary){
		super(name, dateOfBirth);
		this.salary = salary;
	}
	
	public String toString() {
		String out = String.format("Instructor Class\r\nName: %s\r\nDate of Birth: %s\r\nSalary: %f\r\n",
								   getName(), getDateOfBirth(), this.salary);
		return out;
	}
}
