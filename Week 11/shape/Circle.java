public class Circle extends Shape {
	
	private double r;  // radius
	
	public Circle(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}
	
	public double getR() {
		return this.r;
	}
	
	public double area() {
		return Math.PI * r * r;
	}
	
	public double perimeter() {
		return 2 * Math.PI * r;
	}
	
	public String toString() {
		return String.format("Circle - x: %f, y: %f, area: %f, perimeter: %f", 
							 getX(), getY(), area(), perimeter());
	}
}
