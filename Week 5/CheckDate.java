import java.util.Scanner;

public class CheckDate {
	public static void main(String[] args) {
		// Prompt user to input a date
		System.out.println("Please input a date of format (d)d-(m)m-(yy)yy:");
		Scanner scn = new Scanner(System.in);
		String date = scn.nextLine();
		
		// Check if the date is of valid format
		if (! date.matches("^\\d\\d?-\\d\\d?-(\\d\\d)?\\d\\d$")){
			System.out.printf("false: %s does not have a format of (d)d-(m)m-(yy)yy\n", date);
			return;
		}

		// Check components
		String[] date_components = date.split("-");
		int day = Integer.parseInt(date_components[0]);
		int month = Integer.parseInt(date_components[1]);
		int year = Integer.parseInt(date_components[2]);

		if (day <= 0 | day > 31){
			System.out.printf("false: the value for day, %d, is not valid\n", day);
		} else if (month <= 0 | month > 12){
			System.out.printf("false: the value for month, %d, is not valid\n", month);
		} else {
			System.out.println("true");
		}
	}
}
