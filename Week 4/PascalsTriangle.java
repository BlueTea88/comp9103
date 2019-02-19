public class PascalsTriangle {
	public static void main(String[] args) {
		// Read the required depth to print
		final int depth = Integer.parseInt(args[0]);
		
		// Create an array to store the triangle
		int[][] triangle = new int[depth][depth];
		
		// Populate and print triangle values
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 | j == (depth - 1)) {
					triangle[i][j] = 1;  // first and last column is always 1
				} else {
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];  // otherwise take values from the row above
				}

				// Print out results as we go
				System.out.print(triangle[i][j] + " ");
			}
				// Add line break for next row
			  System.out.println("");
		}
	}
}
