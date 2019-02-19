public class Salary {
	public static void main (String[] args) {
		// Store input salaries into an array
		double[] salary_list = new double[args.length];
		int salary_count = 0;

		for (int i = 0; i < args.length; i++) {
			// Check if the input string is valid
			if (args[i].matches("^\\$\\d+(\\.\\d\\d)?$")){
				salary_list[salary_count] = Double.parseDouble(args[i].substring(1));
				salary_count++;
			} else {
				System.out.printf("The input salary value is not valid and not considered: %s\n", args[i]);
			}
		}

		// Sort salary array using insertion sort
		for (int i = 0; i < salary_count; i++) {
			double temp = salary_list[i];
			int loc = i - 1;
			while (loc >= 0 && salary_list[loc] > temp) {
				salary_list[loc + 1] = salary_list[loc];
				loc--;
			}
			salary_list[loc + 1] = temp;
		}

		// Calculate mean
		double salary_mean = 0;
		for (int i = 0; i < salary_count; i++)  salary_mean = salary_mean + salary_list[i]/salary_count;

		// Count number of values above and below mean
		int salary_below_mean = 0;
		int salary_above_mean = 0;
		for (int i = 0; i < salary_count; i++) {
			if (salary_list[i] < salary_mean) {
				salary_below_mean++;
			} else {
				salary_above_mean++;
			}
		}

		// Print results
		System.out.printf("The mean salary is: $%.2f\n", salary_mean);
		System.out.printf("The number of salaries below the mean is: %d\n", salary_below_mean);
		System.out.printf("The number of salaries equal or above the mean is: %d\n", salary_above_mean);
		System.out.println("Sorted salary array:");
		for (int i = 0; i < salary_count; i++) {
			System.out.printf("$%.2f\n", salary_list[i]);
		}
	}
}
