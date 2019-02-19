public class Q1_Grade
{
	public static void main(String[] args)
	{
		// Use first letter for switch condition (to cater for "Distinction", "Credit", etc...)
		final char input_grade = args[0].charAt(0);
		
		// Convert to lower case in switch to be case insensitive
		switch(Character.toLowerCase(input_grade)){
			case 'h':  // single quotes for char literal, double quotes for String literal
				System.out.println("High Distinction: 85 - 100");
				break;
			case 'd':
				System.out.println("Distinction: 75 - 84");
				break;
			case 'c':
				System.out.println("Credit: 65-74");
				break;
			case 'p':
				System.out.println("Pass: 50-64");
				break;
			case 'f':
				System.out.println("Fail: 0-49");
				break;				
			default:
				System.out.println("Unknown grade input!");
				break;
		}
	}
}
