public class Dog extends Animal implements Speakable {
	
	public Dog(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.printf("woof, my name is %s\r\n", getName());
	}
}
