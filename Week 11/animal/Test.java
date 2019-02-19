public class Test {
	
	public static void main(String[] args) {
		Speakable animal;
		animal = new Cat("Harry");
		animal.speak();
		animal = new Dog("Molly");
		animal.speak();
		
		Animal animal2;
		animal2 = new Dog("Winny");
		System.out.println("This is the name of animal2: " + animal2.getName());
	}
}
