public class RecursiveMinimum {
	
	public static void main(String[] args) {
		// Read input values provided		
		double[] input = new double[args.length];
		for (int i = 0; i < args.length; i++) input[i] = Double.parseDouble(args[i]);
		
		// Print out minimum
		System.out.println(min(input));
	}
	
	// Recursively find the minimum of an integer array
	public static double min(double[] values) {
		// Return if only one value
		if (values.length == 1) {
			return values[0];
		
		// If only two values remaining, return the lowest of the two
		} else if (values.length == 2) {
			if (values[0] < values[1]) {
				return values[0];
			} else {
				return values[1];
			}
		
		// Remove one value and replace the first item if lower
		} else {
			double[] valuesPop = new double[values.length - 1];
			double current = values[values.length - 1];
			for (int i = 0; i < (values.length - 1); i++) valuesPop[i] = values[i];
			if (current < valuesPop[0]) valuesPop[0] = current;
			return min(valuesPop);
		}
	}
}
