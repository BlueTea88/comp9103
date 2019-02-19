public abstract class Shape {
	
	private double X;
	private double Y;
	
	public Shape(double x, double y) {
		this.X = x;
		this.Y = y;
	}
	
	public double getX() {
		return this.X;
	}
	
	public double getY() {
		return this.Y;
	}
	
	public abstract double area();
	public abstract double perimeter();
}
