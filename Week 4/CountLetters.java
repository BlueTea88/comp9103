public class CountLetters {
	public static void main(String[] args) {
		// Initialise arrays to count occurances
		char[] letters_lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
													  'q','r','s','t','u','v','w','x','y','z'};
		char[] letters_upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
													  'Q','R','S','T','U','V','W','X','Y','Z'};
		int[] n_lower = new int[26];  // initial values are 0
		int[] n_upper = new int[26];
		
		// Loop across letters of input and count occurances
		for (int i = 0; i < args[0].length(); i++){
			for (int j = 0; j < letters_lower.length; j++){
				if (args[0].charAt(i) == letters_lower[j]) n_lower[j]++;
				if (args[0].charAt(i) == letters_upper[j]) n_upper[j]++;
			}
		}
		
		// Print out occurances
		System.out.println("Lower case letters:");
		for (int j = 0; j < letters_lower.length; j++){
			if (n_lower[j] > 0) System.out.println(letters_lower[j] + ": " + n_lower[j]);
		}
		System.out.println("Upper case letters:");
		for (int j = 0; j < letters_upper.length; j++){
			if (n_upper[j] > 0) System.out.println(letters_upper[j] + ": " + n_upper[j]);
		}
	}
}
