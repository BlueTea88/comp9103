import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		// Create a shapes list for testing
		ArrayList<Shape> testShapes = new ArrayList<Shape>();
		testShapes.add(new Circle(0, 0, 2));
		testShapes.add(new Rectangle(-1, 2, 3, 4));
		testShapes.add(new Rectangle(0, 0.5, 4, 3));
		testShapes.add(new Circle(5, 10, 3));
		
		// Initiate sort list
		SortShapes testSort = new SortShapes(testShapes);
		System.out.println("Original shapes order:");
		System.out.println(testSort);
		System.out.println("======================");
		
		testSort.sortArea();
		System.out.println("Shapes sorted by area:");
		System.out.println(testSort);
		System.out.println("======================");
		
		testSort.sortPerimeter();
		System.out.println("Shapes sorted by perimeter:");
		System.out.println(testSort);
		System.out.println("======================");
	}
}
