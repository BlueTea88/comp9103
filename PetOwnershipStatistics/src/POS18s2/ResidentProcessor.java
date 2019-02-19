package POS18s2;
import java.io.*;
import java.util.*;

/**
 * The ResidentProcessor processes input files of resident records and instructions, and
 * creates files that save the final database and report. 
 * 
 * @author Andrew Thia
 */
public class ResidentProcessor {
	
	private ResidentDatabase dataInterface;
	private ArrayList<String> messages;
	
	/**
	 * Initialize class for processing 
	 */
	public ResidentProcessor() {
		this.dataInterface = new ResidentDatabase();
		this.messages = new ArrayList<String>();
	}
	
	/**
	 * Loads an input resident records file.
	 * <p>
	 * Reads an input resident records text file, splits lines by residents,
	 * passes split records to the ResidentDatabase class for further processing.
	 * </p>
	 * 
	 *  @param input file path of the input resident records file path (should have a .txt extension)
	 */
	public void loadRecords(String input) {
		try {
			// Initialize list to store lines of one resident
			ArrayList<String> currentResident = new ArrayList<String>();
			
			// Keep track of number of residents read from input file
			int currentIndex = 0;
			
			// Open file to read
			this.messages.add("Loading records from: " + input);
			File inputFile = new File(input);
			Scanner scn = new Scanner(inputFile);
			
			while (scn.hasNextLine()) {
				String currentLine = scn.nextLine();
				
				// Update information if not a blank line
				if (!currentLine.matches("^\\s*$")) {
					currentResident.add(currentLine);
				}
				
				// Check end of current resident information (blank line or end of file) 
				if (!scn.hasNextLine() || currentLine.matches("^\\s*$")) {
					if (currentResident.size() > 0) {
						// Pass full information of current resident to ResidentDatabase for processing
						ArrayList<String> processingMessages = this.dataInterface.updateResident(currentResident, false, currentIndex);
						for (String msg:processingMessages) this.messages.add(msg);
						currentResident.clear();  // clear list for next resident 
						currentIndex++;
					}
				}
			}
			scn.close();  // close file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Loads an input instructions file.
	 * <p>
	 * Reads an input instructions text file and processes the specified 
	 * instructions in order of entry, also saves a report file.
	 * </p>
	 * 
	 *  @param input file path of the input instructions file (should have a .txt extension) 
	 *  @param reportFile file path to save the report from queries 
	 */	
	public void loadInstructions(String input, String reportFile) {
		try {
			// Store lines for report in list
			ArrayList<String> report = new ArrayList<String>();
			
			// Open file to read
			this.messages.add("Loading instructions from: " + input);
			File inputFile = new File(input);
			Scanner scn = new Scanner(inputFile);
			int currentIndex = -1;  // index of instruction lines for messages
			
			while (scn.hasNextLine()) {
				String line = scn.nextLine().trim();
				if (line.length() == 0) continue;  // skip blank lines
				
				// Split between key (first word) and field values
				currentIndex++;
				String[] lsplit = line.split("\\s", 2);
				String key = lsplit[0].trim();
				String value = "";
				if (lsplit.length > 1) value = lsplit[1].trim();
				
				// Instruction - update
				if (key.matches("^(?i)update$")) {
					// Split field values into multiple lines
					String[] values = value.split(";");
					ArrayList<String> residentLines = new ArrayList<String>();
					for (int i = 0; i < values.length; i++) {
						residentLines.add(values[i]);
					}
					
					// Pass information to ResidentDatabase for processing
					ArrayList<String> processingMessages = this.dataInterface.updateResident(residentLines, false, currentIndex);
					for (String msg:processingMessages) this.messages.add(msg);

				// Instruction - sort
				} else if (key.matches("^(?i)sort$") && value.matches("^(?i)name$")) {
					this.dataInterface.sort();
					
				// Instruction - delete
				} else if (key.matches("^(?i)delete$")) {
					// Split for name and phone
					String[] values = value.split(";");
					if (values.length < 2) {
						this.messages.add(currentIndex + " - invalid delete specification: " + value);
						continue;
					}
					this.dataInterface.deleteResident(values[0], values[1]);
				
				// Instruction - query name
				} else if (key.matches("^(?i)query$") && value.matches("^(?i)name\\s*[a-zA-Z\\s]+\\s*$")) {
					// Extract name to query
					String[] values = value.split("\\s", 2);
					String name = values[1].trim();
					report.add(this.dataInterface.queryName(name));
				
				// Instruction - query age profile of postcode
				} else if (key.matches("^(?i)query$") && value.matches("^(?i)\\d{4}\\s*age\\s*$")) {
					// Extract suburb to query
					String[] values = value.split("\\s", 2);
					String postcode = values[0].trim();
					report.add(this.dataInterface.queryAge(postcode));
				
				// Instruction - query pet
				} else if (key.matches("^(?i)query$") && value.matches("^(?i)pet$")) {
					report.add(this.dataInterface.queryPet());
				
				// Unknown instruction
				} else {
					this.messages.add(currentIndex + " - invalid instructions: " + line);
				}
			}
			scn.close();  // close file
			
			// Write lines to report file
			this.messages.add("Writing report to: " + reportFile);
			PrintWriter reportOut = new PrintWriter(new FileOutputStream(reportFile));
			for (int i = 0; i < report.size(); i++) {
				if (i > 0) reportOut.print("\r\n\r\n");
				reportOut.print(report.get(i));
			}
			reportOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Saves records to an output results file.
	 * 
	 *  @param resultsFile file path to save records  
	 */
	public void saveRecords(String resultsFile) {
		try {
			this.messages.add("Saving results to: " + resultsFile);
			PrintWriter resultsOut = new PrintWriter(new FileOutputStream(resultsFile));
			resultsOut.print(this.dataInterface.toString());
			resultsOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * @return list of issues or strange behavior encountered during processing
	 */
	public ArrayList<String> getMessages() {
		return this.messages;
	}
}
