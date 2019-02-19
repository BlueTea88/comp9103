public class RecursiveFindValue {
	public static void main(String[] args) {
		// Read inputs from command line
		int target = Integer.parseInt(args[0]);  
		int[] values = new int[args.length - 1];
		for (int i = 1; i < args.length; i++) values[i - 1] = Integer.parseInt(args[i]);
		
		// Print the index of the value if found
		System.out.println(findValue(target, values));
	}
	
	/**
		Recursively search for a target value in a given array.
		@param target value to find
		@param values sorted array of values to search
		@return the index of the first match, otherwise -1
	*/
	public static int findValue(int target, int[] values) {
		// Stopping conditions
		if (values[0] == target) return 0;  // match found
		if (values.length == 1) return -1;  // no match
		
		// Halve search array based on mid-point value
		int midpoint = (values.length - 1)/2;
		int middle = values[midpoint]; 
		int[] values2;
		
		if (target <= middle) {
			values2 = new int[midpoint + 1];
			for (int i = 0; i <= midpoint; i++) values2[i] = values[i];
		} else {
			values2 = new int[values.length - (midpoint + 1)];
			for (int i = 0; i < values2.length; i++) values2[i] = values[midpoint + 1 + i];
		}
		
		// Index from future recursive search
		int index = findValue(target, values2);
		if (index == -1) {
			return index;  // dont overwrite if target is not found
		} else if (target > middle) {
			return index + midpoint + 1;  // shift index found by split start point
		} else {
			return index;  // no adjustment required
		}
	}
}
