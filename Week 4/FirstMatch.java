
public class FirstMatch {
	public static void main(String[] args) {
		// String to match
		final String match_word = args[0];
		
		// Loop across the other values in the array
		for (int i = 1; i < args.length; i++){
			// Print index of first match
			if (match_word.equals(args[i])){
				System.out.printf("The index of the first match of '%s' is %d.", match_word, i-1);
				return;
			}
		}

		// Print no match if none found
		System.out.printf("No match was found for '%s.'", match_word);
	}
}
