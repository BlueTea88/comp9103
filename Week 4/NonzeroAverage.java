public class NonzeroAverage {
	public static void main(String[] args) {
		// Store input values in array
		int[] inputs = new int[args.length];

		for (int i = 0; i < args.length; i++){
			inputs[i] = Integer.parseInt(args[i]);
		}

		// Calculate average of non-zero values
		double total = 0;
		double n = 0;

		for (int i = 0; i < inputs.length; i++){
			if (inputs[i] != 0){
				total = total + (double)inputs[i];
				n++;
			}
		}
		
		if (n == 0){
			System.out.println("There are no non-zero values!");
		} else {
			System.out.println(total/n);
		}
	}
}
