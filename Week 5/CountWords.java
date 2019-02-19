import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			String scn_line;

			// Prompt user for word to count
			String search_word = "";
			System.out.println("Input a word to count (case-insensitive):");
			while (search_word.length() == 0) {
				scn_line = scn.nextLine();
				if (scn_line.matches("^[a-zA-z]+$")) {
					search_word = scn_line.toLowerCase();
				} else {
					System.out.println("You entered: " + scn_line);
					System.out.println("Please enter a valid word (should not have numbers or special characters).");
				}
			}

			// Prompt user for paragraph
			int word_count = 0;
			String[] search_line;
			boolean break_loop = false;
			System.out.println("Input a paragraph to search, enter Q at the end of the paragraph to quit:");
			while (scn.hasNextLine()) {
				search_line = scn.nextLine().split("\\b");

				// Loop across words in the line
				for (int i = 0; i < search_line.length; i++) {
					if (search_line[i].toLowerCase().matches("^\\b*" + search_word + "\\b*$")) {
						word_count++;
					}

					// Stop if :q! is found
					if (search_line[i].matches("^\\b*Q\\b*$")) {
						break_loop = true;
						break;
					}
				}
				
				if (break_loop) break;
			}

			// Print out the search word and the number of matches
			System.out.printf("The word %s was found %d times.", search_word, word_count);
	}
}
