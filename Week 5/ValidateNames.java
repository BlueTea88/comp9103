import java.util.Scanner;

public class ValidateNames {
	public static void main(String[] args) {
		// Prompt user to input names
		System.out.println("Input a line of names separated by spaces:");
		Scanner scn = new Scanner(System.in);
		String[] scn_line;
		scn_line = scn.nextLine().split(" ");
		
		// Extract names from input
		String[] names = new String[scn_line.length];
		int names_length = 0;

		for (int i = 0; i < scn_line.length; i++) {
			// Check if name is valid
			if (scn_line[i].matches("^[a-zA-Z]+$")) {
				names[names_length] = scn_line[i];
				names_length++;
			} else {
				System.out.printf("This input name is not valid: %s\n", scn_line[i]);
			}
		}

		// Print out names
		System.out.println("Valid names found:");
		for (int i = 0; i < names_length; i++) {
			System.out.println(names[i]);
		}
	}
}
