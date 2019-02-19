package POS18s2;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The Resident class stores information about a single resident. 
 * 
 * @author Andrew Thia
 */
public class Resident {
	
	private String name;
	private String address;
	private String postcode;
	private String phone;
	private ArrayList<String> pets;
	private int nPets;  // number of pets to differentiate no pets and missing pet field
	private int birthdayDay;
	private int birthdayMonth;
	private int birthdayYear;
	private ArrayList<String> issues;  // any issues or unexpected behavior while processing
	
	public Resident() {
		this.name = "";
		this.address = "";
		this.postcode = "";
		this.phone = "";
		this.pets = new ArrayList<String>();
		this.birthdayDay = 0;
		this.birthdayMonth = 0;
		this.birthdayYear = 0;
		this.issues = new ArrayList<String>();
	}
		
	/**
	 * @param inputLines information lines to initialize the resident  
	 */
	public Resident(ArrayList<String> inputLines) {
		
		// Initialize fields
		this.name = "";
		this.address = "";
		this.postcode = "";
		this.phone = "";
		this.pets = new ArrayList<String>();
		this.nPets = -1;
		this.birthdayDay = 0;
		this.birthdayMonth = 0;
		this.birthdayYear = 0;
		this.issues = new ArrayList<String>();
		
		// Max days in each month
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// Flag to indicate whether address is being processed
		boolean addressFlag = false;
		
		// Loop across input lines
		for (String line:inputLines) {
			// Split between key (first word) and field values
			line = line.trim();
			String[] lsplit = line.split("\\s", 2);
			String key = lsplit[0].trim();
			String value = "";
			if (lsplit.length > 1) value = lsplit[1].trim();
			
			// Process name
			if (key.matches("^(?i)name$")) {
				addressFlag = false;
				if (value.length() == 0 || !value.matches("^[a-zA-Z\\s]+$")) {
					this.issues.add("invalid name: " + value);
					continue;
				}
				this.name = standardizeName(value);  // standardize name and set value
			
			// Process postcode
			} else if (key.matches("^(?i)postcode$")) {
				addressFlag = false;
				if (value.length() == 0 || !value.matches("^\\d{4}$")) {
					this.issues.add("invalid postcode: " + value);
					continue;
				}
				this.postcode = value; 
			
			// Process phone 
			} else if (key.matches("^(?i)phone$")) {
				addressFlag = false;
				if (value.length() == 0 || !value.matches("^\\d{8}$")) {
					this.issues.add("invalid phone: " + value);
					continue;
				}
				this.phone = value;
			
			// Process pet
			} else if (key.matches("^(?i)pet$")) {
				addressFlag = false;
				if (!value.matches("^[a-zA-Z\\s]*$")) {
					this.issues.add("invalid pet: " + value);
					continue;
				}
				
				// Add pets one by one to the pet list
				String[] values = value.split("\\s");
				for (int i = 0; i < values.length; i++) {
					if (values[i].length() > 0) {
						String currentPet = values[i].substring(0, 1).toUpperCase();
						if (values[i].length() > 1) currentPet = currentPet + values[i].substring(1).toLowerCase();
						this.pets.add(currentPet);
					}
				}
				this.nPets = this.pets.size();  // set number of pets
			
			// Process birthday
			} else if (key.matches("^(?i)birthday")) {
				addressFlag = false;
				if ((!value.matches("^\\d\\d?-\\d\\d?-\\d\\d(\\d\\d)?$")) && 
					(!value.matches("^\\d\\d?/\\d\\d?/\\d\\d(\\d\\d)?$"))) {
					this.issues.add("invalid birthday: " + value);
					continue;
				}
									
				// Separate day, month and year
				String[] values = value.split("(-|/)");
				int valueDay = Integer.parseInt(values[0]);
				int valueMonth = Integer.parseInt(values[1]);
				int valueYear = Integer.parseInt(values[2]);
				
				// Infer four digit year if two digit supplied
				this.birthdayYear = valueYear;
				if (valueYear < 19) {
					this.birthdayYear = 2000 + valueYear;
					this.issues.add("inferred birthday year " + this.birthdayYear + ", entry: " + valueYear); 
				} else if (valueYear >= 18 & valueYear < 100) {
					this.birthdayYear = 1900 + valueYear;
					this.issues.add("inferred birthday year " + this.birthdayYear + ", entry: " + valueYear);
				}
				
				// Check month value is between 1 and 12
				if (valueMonth < 1 || valueMonth > 12) {
					this.issues.add("invalid birthday month: " + value);
					continue;
				}
				this.birthdayMonth = valueMonth;
									
				// Check day value relative to month
				if (valueMonth != 2 && (valueDay < 1 || valueDay > monthDays[valueMonth-1])) {
					this.issues.add("invalid birthday day: " + value);
					continue;
				} else if (valueMonth == 2) {
					if ((this.birthdayYear % 4 != 0) && (valueDay < 1 || valueDay > 28)) {  // non-leap years
					    this.issues.add("invalid birthday day: " + value);
					    continue;
					} else if ((this.birthdayYear % 4 == 0) && (valueDay < 1 || valueDay > 29)) {  // leap years
						this.issues.add("invalid birthday day: " + value);
					    continue;
					}
				}
				this.birthdayDay = valueDay;
			
			// Process address
			} else if (key.matches("^(?i)address")) {
				if (value.length() == 0) {
					this.issues.add("invalid address: " + value);
					continue;
				} else {
					this.address = value;
					addressFlag = true;  // flag that address was processed in this loop
				}
			
			// Continuation of address on next line
			} else if (addressFlag == true) {
				if (line.length() > 0) this.address = this.address + ", " + line;
			
			// Unable to match key - if blank line, just ignore
			} else if (line.length() > 0) {
				this.issues.add("unknown field key: " + line);
			}
		}
		
		// Check if address is valid (has suburb), set to blank if not
		if (this.address.length() > 0) if (!isValidAddress()) {
			this.issues.add("ignoring address with no suburb: " + this.address);
			this.address = "";
		}
	}
	
	/**
	 * @return whether the address is valid (has a suburb)
	 */
	private boolean isValidAddress() {
		// Assume suburb is present if there is a field in address that is all character 
		//  and has length greater than 3 (to differentiate from state) 		
		String values[] = this.address.split("\\s*,\\s*");
		for (int i = 0; i < values.length; i++) {
			String value = values[i].trim();
			if (value.matches("^[a-zA-Z\\s]+$") && value.length() > 3) {
				return true;
			}
		}
		return false;  // no fields matching suburb assumptions 
	}
	
	/**
	 * @return whether the current resident record has all the compulsory fields
	 */
	public boolean isValid() {
		if (this.name.length() > 0 && this.phone.length() > 0 && this.postcode.length() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return whether the current resident record is valid to use for updating
	 */
	public boolean isValidUpdate() {
		if (this.name.length() > 0 && this.phone.length() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return outputs the resident's details to a string, each field is output to its own line, 
	 * 	missing fields are excluded - implicitly assumes name is present
	 */
	public String toString() {
		String out = "name " + this.name;
		if (this.birthdayDay != 0) { 
			out = out + String.format("\r\nbirthday %02d-%02d-%d", this.birthdayDay, this.birthdayMonth, this.birthdayYear);
		}
		if (this.address.length() > 0) out = out + "\r\naddress " + this.address;
		if (this.postcode.length() > 0) out = out + "\r\npostcode " + this.postcode;
		if (this.phone.length() > 0) out = out + "\r\nphone " + this.phone;
		if (this.nPets > 0) {
			out = out + "\r\npet";
			for (String pet : this.pets) out = out + " " + pet; 
		}
		return out;
	}
	
	/**
	 * @return returns issues as a single string
	 */
	public String issuesToString() {
		String out = "";
		for (int i = 0; i < this.issues.size(); i++) {
			if (i > 0) out = out + "\r\n";
			out = out + this.issues.get(i);
		}
		return out;
	}
	
	/**
	 * @param currentDay current calendar day
	 * @param currentMonth current calendar month
	 * @param currentYear current calendar year
	 * @return the resident's age since last birthday relative to the specified date, -1 if unknown
	 */
	public int calculateAge(int currentDay, int currentMonth, int currentYear) { 
		if (this.birthdayDay == 0) return -1;  // invalid birthday recorded
		
		// Initial age based on year
		int age = currentYear - this.birthdayYear;  
		
		// Compare month and day, subtract 1 if birthday greater than current month and day
		if (this.birthdayMonth > currentMonth) {
			age = age - 1;
		} else if (this.birthdayMonth == currentMonth) {
			if (this.birthdayDay > currentDay) age = age - 1;
		}
		
		// Check whether age is still valid (greater or equal to 0)
		if (age < 0) age = -1;
		return age;
	}
	
	/**
	 * @return the resident's age since last birthday relative to system date, -1 if unknown
	 */
	public int calculateAge() {
		// Format system date to easily extract day, month and year
		Date date = new Date();  // system date
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormatted = formatDate.format(date);
		
		// Extract day, month and year
		String[] values = dateFormatted.split("\\/");
		int sysDay = Integer.parseInt(values[0]);
		int sysMonth = Integer.parseInt(values[1]);
		int sysYear = Integer.parseInt(values[2]);
		return calculateAge(sysDay, sysMonth, sysYear);
	}
	
	/**
	 * Clears the current list of issues.
	 */
	public void clearIssues() {
		this.issues.clear();
	}
	
	/**
	 * @param value name string to process
	 * @return standardized format of name, start with capital letters and separated by single space
	 */
	private String standardizeName(String value) {
		String[] values = value.trim().split("\\s");
		String standardizedName = values[0].substring(0, 1).toUpperCase();  // first item will not be blank due to trim
		if (values[0].length() > 1) standardizedName = standardizedName + values[0].substring(1).toLowerCase();
		
		for (int i = 1; i < values.length; i++) {
			if (values[i].length() == 0) continue;  // skip blanks
			standardizedName = standardizedName + " " + values[i].substring(0, 1).toUpperCase();
			if (values[i].length() > 1) standardizedName = standardizedName + values[i].substring(1).toLowerCase();
		}
		return standardizedName;
	}
	
	/**
	 * @param value name to match
	 * @return indicates whether the resident matches the specified name
	 */
	public boolean matchName(String value) {
		// Standardize the name value
		String matchValue = standardizeName(value);
		
		if (this.name.equals(matchValue)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param value phone number to match
	 * @return indicates whether the resident matches the phone number
	 */
	public boolean matchPhone(String value) {
		if (this.phone.equals(value.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param value postcode to match
	 * @return indicates whether the resident matches the specified postcode
	 */
	public boolean matchPostcode(String value) {
		if (this.postcode.equals(value.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param value name value to compare against
	 * @return true if the input value has a higher order name (or the same name) than the resident
	 */
	public boolean compareNameHigher(String value) {
		// Alphabetical order of letters
		char[] order = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
						'r','s','t','u','v','w','x','y','z'};
		
		// Standardize the input value before comparing
		String compare = standardizeName(value);
		
		// Compare character by character
		int minLength = Math.min(this.name.length(), compare.length());
		
		for (int i = 0; i < minLength; i++) {
			char v1 = this.name.toLowerCase().charAt(i);
			char v2 = value.toLowerCase().charAt(i);
			int order1 = -1;
			int order2 = -1;
			
			// Check alphabet index of characters
			for (int j = 0; j < order.length; j++) {
				if (v1 == order[j]) order1 = j;  // found index character
				if (v2 == order[j]) order2 = j;
				if (order1 >= 0 && order2 >= 0) break;  // stop if found index of both characters
			}
			
			// Compare order of characters and stop if different
			if (order1 != order2) {
				return order1 < order2;
			}
		}
		
		// If all characters the same up to this point, order the lower length string first
		// If strings exactly the same, also return true;
		return this.name.length() <= compare.length();
	}
		
	/**
	* @param value phone number to compare against
	* @return true if the input value has a larger (or equal) phone number than the resident
	*/
	public boolean comparePhoneHigher(String value) {
		int v1 = Integer.parseInt(this.phone);
		int v2 = Integer.parseInt(value.trim());
		return v1 <= v2;
	}
	
	/**
	 * @param newDetails new details stored in a Resident object format
	 */
	public void updateDetails(Resident newDetails) {
		// Update from new fields that are non-empty except name and phone
		if (newDetails.getAddress().length() > 0) this.address = newDetails.getAddress();
		if (newDetails.getPostcode().length() > 0) this.postcode = newDetails.getPostcode();
		if (newDetails.getNPets() >= 0) {
			this.pets = newDetails.getPets();
			this.nPets = this.pets.size();
		}
		if (newDetails.getBirthdayDay() > 0) {
			this.birthdayDay = newDetails.getBirthdayDay();
			this.birthdayMonth = newDetails.getBirthdayMonth();
			this.birthdayYear = newDetails.getBirthdayYear();
		}
	}
	
	/**
	 * @param petType name of the pet type to count
	 * @return the number of pets of the specified pet type owned by the resident
	 */
	public int numberOfSpecificPetType(String petType) {
		int n = 0;
		for (String pet : this.pets) {
			if (pet.equalsIgnoreCase(petType.trim())) n++;
		}
		return n;
	}
	
	/**
	 * @return name of the resident 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the address lines in a String array, 
	 * 	each line represented as a separate item of the array  
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * @return the postcode of the resident
	 */
	public String getPostcode() {
		return this.postcode;
	}
	
	/**
	 * @return the phone number of the resident
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * @return the pets of the resident
	 */
	public ArrayList<String> getPets() {
		return this.pets;
	}
	
	/**
	 * @return the number of pets of the resident
	 */
	public int getNPets() {
		return this.nPets;
	}
	
	/**
	 * @return the calendar day of the resident's birthday
	 */
	public int getBirthdayDay() {
		return this.birthdayDay;
	}
	
	/**
	 * @return the calendar month of the resident's birthday
	 */
	public int getBirthdayMonth() {
		return this.birthdayMonth;
	}
	
	/**
	 * @return the year of the resident's birthday
	 */
	public int getBirthdayYear() {
		return this.birthdayYear;
	}
	
	/**
	 * @return list of issues encountered while processing input
	 */
	public ArrayList<String> getIssues(){
		return this.issues;
	}
}