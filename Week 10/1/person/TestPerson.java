package person;

public class TestPerson {
	public static void main(String[] args) {
		Person personA = new Person("Person A", "10-10-1988");
		Student personB = new Student("Person B", "10-12-1980", "Economics");
		Instructor personC = new Instructor("Person C", "10-12-1980", 100000.50);
		
		System.out.println(personA);
		System.out.println(personB);
		System.out.println(personC);
	}
}
