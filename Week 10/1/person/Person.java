package person;

public class Person {
	private String name;
	private String dateOfBirth;
	
	public Person(String name, String dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String toString() {
		String out = String.format("Person Class\r\nName: %s\r\nDate of Birth: %s\r\n",
								   this.name, this.dateOfBirth);
		return out;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
}
