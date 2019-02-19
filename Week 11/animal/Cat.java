public class Cat extends Animal implements Speakable {
	
	public Cat(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.printf("meow, my name is %s\r\n", getName());
	}
}
