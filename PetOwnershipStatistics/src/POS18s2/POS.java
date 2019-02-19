package POS18s2;
import java.util.ArrayList;

/**
 * Simple command-line interface to the Pet Ownership Statistics system.
 * The user should specify four arguments:
 * <ol> 
 *   <li>File path of an input records text file.</li>
 *   <li>File path of an input instructions text file.</li>
 *   <li>Location to save the output records file.</li>
 *   <li>Location to save the output report file.</li>
 * </ol>
 * 
 * @author Andrew Thia
 */
public class POS {
	
	public static void main(String[] args) {
		// Quick check of inputs
		if (args.length != 4) {
			System.out.println("POS application expects four arguments:");
			System.out.println("  - file path of an input records text file.");
			System.out.println("  - file path of an input instructions text file.");
			System.out.println("  - location to save the output records file.");
			System.out.println("  - location to save the output report file.");
			return;
		}
		
		// Create a new ResidentProcessor for processing
		ResidentProcessor databaseProcessor = new ResidentProcessor();
		databaseProcessor.loadRecords(args[0]);
		databaseProcessor.loadInstructions(args[1], args[3]);
		databaseProcessor.saveRecords(args[2]);
		
		// Print out any messages encountered during processing
		ArrayList<String> messages = databaseProcessor.getMessages();
		for (String msg : messages) System.out.println(msg);
	}
}
