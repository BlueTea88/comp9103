public class RectangleDetails
{
	static public void main(String[] args)
	{
		// Store the first two arguments as the length and width of the rectangle
		final double s1 = Double.parseDouble(args[0]);
		final double s2 = Double.parseDouble(args[1]);
		
		// Calculate area and perimeter
		double area = s1 * s2;
		double perimeter = 2 * (s1 + s2);
		
		// Calculate diagonal using Pythagoras theorem: a^2 + b^2 = c^2
		double diagonal = Math.sqrt(Math.pow(s1,2) + Math.pow(s2,2));
		
		// Print results
		System.out.println("Area: " + area);
		System.out.println("Perimeter: " + perimeter);
		System.out.println("Diagonal: " + diagonal);
	}
}