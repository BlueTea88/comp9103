public class Q3_Pyramid
{
	public static void main(String[] args)
	{
		final int last_n = Integer.parseInt(args[0]);
		String pyramid_line;  // one line of the pyramid
		
		// Check if the input number is odd
		if (last_n % 2 == 1){
			for (int i = 1; i <= last_n; i+=2){
				pyramid_line = "";  // reinitialise line to blank
				
				// Add leading spaces, number of spaces: (last_n - i)/2
				for (int j = 1; j <= (last_n - i)/2; j++) pyramid_line = pyramid_line + " ";
				
				// Add asterix, number of asterix: i
				for (int j = 1; j <= i; j++) pyramid_line = pyramid_line + "*";
				System.out.println(pyramid_line);
			}
		} else {
			System.out.println("Please input a positive odd number.");
		}
	}
}
