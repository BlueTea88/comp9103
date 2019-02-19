package POS18s2;
import java.util.ArrayList;

/**
 * The ResidentDatabase keeps a database of residents and contains methods to 
 * manipulate the database. 
 * 
 * @author Andrew Thia
 */
public class ResidentDatabase {
	private ArrayList<Resident> database;
	
	/**
	 * Initialize a new resident database.
	 */
	public ResidentDatabase() {
		this.database = new ArrayList<Resident>();
	}
	
	/**
	 * @param inputLines information lines to update an existing record or add a new record if non-existent 
	 * @param expectNew returns an additional message if the record already exists
	 * @param messageIndex the index value to use for messages, set to -1 if not required   
	 * @return list of issues or unexpected behavior (if any)
	 */
	public ArrayList<String> updateResident(ArrayList<String> inputLines, boolean expectNew, int messageIndex) {
		// Variables for processing
		ArrayList<String> messages = new ArrayList<String>();  // list to store issues or unexpected behavior  
		boolean flagExisting = false;  // flag whether an existing record exists
		
		// Process input lines
		Resident newResident = new Resident(inputLines);
		for (String msg : newResident.getIssues()) messages.add(messageIndex + " - " + msg);
		
		// Check whether the details is at least valid for updating (just require name and phone)
		if (!newResident.isValidUpdate()) {
			messages.add(messageIndex + " - invalid resident details (require name and phone)");
			return messages;
		}
		
		// Check if resident already exists in database and update if present
		for (Resident res : this.database) {
			if (res.matchName(newResident.getName()) && res.matchPhone(newResident.getPhone())) {
				flagExisting = true;
				res.updateDetails(newResident);
				if (expectNew) messages.add(messageIndex + " - updated existing record");
				break;
			}
		}
		
		// Add new resident to database if non-existing
		if (!flagExisting) {
			if (newResident.isValid()) {
				this.database.add(newResident);
			} else {
				messages.add(messageIndex + " - invalid resident details (require name, phone and postcode)");
			}
		}
		return messages;
	}
	
	/**
	 * @return records in the database
	 */
	public ArrayList<Resident> getDatabase() {
		return this.database;
	}
	
	/**
	 * @param newResident new resident to add to the database
	 */
	public void addResident(Resident newResident) {
		this.database.add(newResident);
	}
	
	/**
	 * @param name the name of the resident to delete from database
	 * @param phone the phone number of the resident to delete from database
	 */
	public void deleteResident(String name, String phone) {
		// Loop across records in database to find matching records to delete
		for (int i = this.database.size() - 1; i >= 0; i--) {
			Resident res = this.database.get(i);
			if (res.matchName(name) && res.matchPhone(phone)) this.database.remove(i);
		}
	}
	
	/**
	 * Sorts records in ascending order by name and phone number.
	 */
	public void sort() {
		int databaseSize = this.database.size(); 		
		if (databaseSize < 2) return;  // sorting not required
		
		// Use insertion sort to sort records
		for (int i = 1; i < databaseSize; i++) {
			Resident res = this.database.remove(i);  // temporarily remove current record and keep reference
			boolean foundSpot = false;  // flag to indicate whether a spot is found
			
			for (int j = 0; j < i; j++) {
				// Compare phone number if name is exactly the same
				if (res.matchName(this.database.get(j).getName())) {
					if (res.comparePhoneHigher(this.database.get(j).getPhone())) {
						// Lower phone number than list entry
						this.database.add(j, res);
						foundSpot = true;
						break;
					}
				} else {
					if (res.compareNameHigher(this.database.get(j).getName())) {
						// Lower name order than list entry
						this.database.add(j, res);
						foundSpot = true;
						break;
					}
				}
			}
			
			// Add record back to the same spot if earlier spot found
			if (!foundSpot) this.database.add(i, res);
		}
	}
	
	/**
	 * @param name the name of residents to query
	 * @return details of records that match the specified name, sorted by phone number
	 */
	public String queryName(String name) {
		// Create a temporary database to store records that have the same matching name
		ResidentDatabase db = new ResidentDatabase();
		
		for (Resident res : this.database) {
			if (res.matchName(name)) db.addResident(res);
		}
		
		// Sort temporary database by phone number
		db.sort();
		
		// Store matching records details in string
		String out = "------query name " + name.trim() + "------";
		int outN = out.length();  // used to determine required length of end dash breaks 
		for (int i = 0; i < db.getDatabase().size(); i ++) {
			if (i > 0) out = out + "\r\n";  // separate records by a blank line 
			out = out + "\r\n" + db.getDatabase().get(i).toString();
		}
		out = out + "\r\n";
		for (int i = 0; i < outN; i++) out = out + "-";  // add ending dash breaks
		return out;
	}
	
	/**
	 * @param postcode the value of postcode to query
	 * @return summary of the age profile of a specified postcode
	 */
	public String queryAge(String postcode) {
		// Calculation variables
		int nOwners = 0;
		int nLow = 0;  // age < 18
		int nMiddle = 0;  // 18 <= age < 65 
		int nHigh = 0;  // age >= 65
		int nUnknown = 0;
		
		// Find matching records
		for (Resident res : this.database) {
			if (res.matchPostcode(postcode)) {
				nOwners++;
				int age = res.calculateAge();
				if (age == -1) {
					nUnknown++;
				} else if (age < 18) {
					nLow++;
				} else if (age < 65) {
					nMiddle++;
				} else if (age >= 65) {
					nHigh++;
				}
			}
		}
		
		// Check numbers match
		if (nOwners != (nLow + nMiddle + nHigh + nUnknown)) {
			throw new RuntimeException("Age profile does not reconcile.");
		}
		
		// Calculate percentages
		double percentageLow = (double)nLow / (double)nOwners * 100;
		double percentageMiddle = (double)nMiddle / (double)nOwners * 100;
		double percentageHigh = (double)nHigh / (double)nOwners * 100;
		double percentageUnknown = (double)nUnknown / (double)nOwners * 100;
		
		if (nOwners == 0) {
			percentageLow = 0;
			percentageMiddle = 0;
			percentageHigh = 0;
			percentageUnknown = 0;
		}
		
		// Return output string
		String out = "------query " + postcode + " age------";
		out = out + "\r\nAvailable pet owner size: " + nOwners; 
		out = out + "\r\nAge profile:";
		out = out + String.format("\r\nBelow 18: %.2f%%", percentageLow);  
		out = out + String.format("\r\nOver 18 and Below 65: %.2f%%", percentageMiddle);
		out = out + String.format("\r\nOver 65: %.2f%%", percentageHigh);
		out = out + String.format("\r\nUnknown: %.2f%%", percentageUnknown);
		out = out + "\r\n--------------------------";
		return out;
	}
	
	/**
	 * @return summary of pets, for each pet type number of pets in the most popular postcode(s) and
	 *  a list of the most popular postcode(s)
	 */
	public String queryPet() {
		
		// Create a list of all pet types in the database
		ArrayList<String> petTypes = new ArrayList<String>();
		
		for (Resident res : this.database) {
			for (String value : res.getPets()) {
				if (!petTypes.contains(value)) petTypes.add(value);
			}
		}
		
		// Loop across pet types
		String out = "------query pet------";  // initalize report output lines
		
		for (int i = 0; i < petTypes.size(); i++) {
			// Count the number of pets in postcodes that contain the current pet type
			String petType = petTypes.get(i);
			ArrayList<String> petPostcodes = new ArrayList<String>();
			ArrayList<Integer> petPostcodesCount = new ArrayList<Integer>();
			
			for (Resident res : this.database) {
				int resPetCount = res.numberOfSpecificPetType(petType); 
				if (resPetCount > 0) {
					// Update postcode count if resident's postcode is already listed 
					if (petPostcodes.contains(res.getPostcode())) {
						int postcodeIndex = petPostcodes.indexOf(res.getPostcode());
						int currentCount = petPostcodesCount.get(postcodeIndex);
						petPostcodesCount.set(postcodeIndex, currentCount + resPetCount);
					// Add resident's postcode if postcode has not been listed
					} else {
						petPostcodes.add(res.getPostcode());
						petPostcodesCount.add(resPetCount);
					}
				}
			}
			
			// Find most popular postcode(s) and maximum postcode count
			int petMaxCount = 0;
			ArrayList<String> petMaxPostcodes = new ArrayList<String>();
			
			for (int j = 0; j < petPostcodes.size(); j++) {
				if (petPostcodesCount.get(j) > petMaxCount) {
					petMaxCount = petPostcodesCount.get(j);
					petMaxPostcodes.clear();
					petMaxPostcodes.add(petPostcodes.get(j));
				} else if (petPostcodesCount.get(j) == petMaxCount) {
					// Add to postcode list if same count as maximum
					petMaxPostcodes.add(petPostcodes.get(j));  
				}
			}
			
			// Add current pet type summary to report
			out = out + String.format("\r\n%s: %d; postcode ", petType, petMaxCount);
			for (int j = 0; j < petMaxPostcodes.size(); j ++) {
				if (j > 0) out = out + ", ";
				out = out + petMaxPostcodes.get(j);
			}
		}
		
		// Add ending lines
		out = out + "\r\n---------------------";
		return out;
	}
	
	/**
	 * @return information of all records in a single string, each record separated by a single blank line
	 */
	public String toString() {
		String out = "";
		for (int i = 0; i < this.database.size(); i++) {
			if (i > 0) out = out + "\r\n\r\n";  // separate each record by a single blank line
			out = out + this.database.get(i).toString();
		}
		return out;
	}
}
