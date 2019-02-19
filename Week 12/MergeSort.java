public class MergeSort {
	
	public static void main(String[] args) {
		// Convert command line arguments to integer array
		int[] vals = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			vals[i] = Integer.parseInt(args[i]);
		}
		
		// Sort and print out values
		int[] vals2 = sort(vals);
		System.out.println("Sorted values:");
		for (int i = 0; i < vals2.length; i++) {
			System.out.println(vals2[i]);
		}
	}
	
	public static int[] sort(int[] values) {
		// Return if less than 2 values (no sorting required)
		if (values.length < 2) {
			return values;
		}
		
		// Split into halves
		int midpoint = (values.length - 1)/2;
		int[] left = new int[midpoint + 1];  // put middle value into left
		int[] right = new int[values.length - (midpoint + 1)];
		
		for (int i = 0; i <= midpoint; i++) {
			left[i] = values[i];
		} 
		for (int j = 0; j < right.length; j++) {
			right[j] = values[midpoint + 1 + j];
		}
		
		// Sort halves
		left = sort(left);
		right = sort(right);
		
		// Merge halves
		int[] merge = new int[values.length];  // merged array
		int m = 0;  // merged index
		int l = 0;  // left index
		int r = 0;  // right index
		
		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				merge[m] = left[l];
				l++;
			} else {
				merge[m] = right[r];
				r++;
			}
			m++;
		}
		
		// Put remaining values in left or right halves into the merged array
		while (l < left.length) {
			merge[m] = left[l];
			l++;
			m++;
		}
		while (r < right.length) {
			merge[m] = right[r];
			r++;
			m++;
		}
		return merge;  // return merged array
	}
}
