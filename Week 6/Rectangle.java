/**
	Object that represents rectangles on a two-dimensional space.
*/
public class Rectangle {
	// Attributes of the rectangle
	public double width;
	public double height;
	public double centroid_x;
	public double centroid_y;
	
	/**
		Create a rectangle by specifying the width, height and centre coordinates.
		@param in_width width of the rectangle
		@param in_height height of the rectangle
		@param x the x coordinates rectangle centroid
		@param y the y coordinates rectangle centroid
	*/
	public Rectangle(double in_width, double in_height, double x, double y) {
		width = in_width;
		height = in_height;
		centroid_x = x;
		centroid_y = y;
	}

	/**
		Return the area.
  */
	public double area() {
		return width * height;
	}

	/**
		Return the perimeter.
	*/
	public double perimeter() {
		return 2 * (width + height);
	}

	/** 
		Print out description of the rectangle.
	*/
	public void describe() {
		System.out.println("Description of the rectangle:");
		System.out.printf("width: %.2f\n", width);
		System.out.printf("height: %.2f\n", height);
		System.out.printf("centroid x: %.2f, centroid_y: %.2f\n", centroid_x, centroid_y);
		System.out.printf("Area: %.2f\n", area());
		System.out.printf("Perimeter: %.2f\n", perimeter());
		System.out.printf("x min: %.2f, x max: %.2f\n", centroid_x - width/2, centroid_x + width/2);
		System.out.printf("y min: %.2f, y max: %.2f\n", centroid_y - height/2, centroid_x + height/2);
	}

	/**
		Test code
	*/ 
	public static void main(String[] args) {
		Rectangle test = new Rectangle(10, 20, 0, 2);
		double test_area = test.area();
		double test_perimeter = test.perimeter();
		System.out.printf("Calculated area: %.2f\nCalculated perimeter: %.2f\n", test_area, test_perimeter);
		test.describe();
	}
}
