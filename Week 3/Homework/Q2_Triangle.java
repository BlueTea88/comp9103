public class Q2_Triangle
{
	public static void main(String[] args)
	{
		final int input = Integer.parseInt(args[0]);
		String out_values = "";  // String to keep track of preceding numbers

		// Only print if the number is between 1 and 9
		if (input >= 1 & input < 10){
			for (int i = 1; i <= input; i++){
				// Ternary operator: https://stackoverflow.com/questions/8898590/short-form-for-java-if-statement
				out_values = (i == 1) ? Integer.toString(i) : out_values + " " + Integer.toString(i);
				System.out.println(out_values);
			}
		} else {
			System.out.println("Please enter a number between 1 and 9.");
		}
	}
}
