public class Rectangle extends Shape {
	
	private double l;  // length
	private double w;  // width
	
	public Rectangle(double x, double y, double l, double w) {
		super(x, y);
		this.l = l;
		this.w = w;
	}
	
	public double getL() {
		return this.l;
	}
	
	public double getW() {
		return this.w;
	}
	
	public double area() {
		return l * w;
	}
	
	public double perimeter() {
		return 2 * l + 2 * w;
	}
	
	public String toString() {
		return String.format("Rectangle - x: %f, y: %f, area: %f, perimeter: %f",
							 getX(), getY(), area(), perimeter());
	}
}
