package POS18s2;
import java.util.*;

/**
 * Unit tests for the Resident class.
 * 
 * @author Andrew Thia
 */
public class TestResident {
	
	public static void main(String[] args) {
		// Test variables
		Resident testResident;
		ArrayList<String> testCase = new ArrayList<String>();
		boolean check = true;
		int countCheck = 0;
		int countPass = 0;
		
		// Header
		System.out.println("Running tests for resident class...\r\n");
		
		// Standard input test
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getName().equals("Josephine Esmerelda Bloggs")) check = false;
		if (!testResident.getPhone().equals("99887766")) check = false;
		if (testResident.getNPets() != 2) check = false;
		if (!testResident.getAddress().equals("102 Smith St, Summer hill, NSW")) check = false;
		if (!testResident.getPostcode().equals("2130")) check = false;
		if (check) countPass++;
		System.out.println("*** Standard Input ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Blank lines
		testCase.clear();
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("")) check = false;
		if (!testResident.getPhone().equals("")) check = false;
		if (testResident.getNPets() != -1) check = false;  // differentiate between 0 pets and unknown
		if (!testResident.getAddress().equals("")) check = false;
		if (!testResident.getPostcode().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** Blank lines ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Case-insensitive key fields
		testCase.clear();
		testCase.add("NaMe Josephine Esmerelda Bloggs");
		testCase.add("birthDAY 13-05-1980");
		testCase.add("phONE 99887766");
		testCase.add("pET Cat Dog");
		testCase.add("addrESs 102 Smith St, Summer hill, NSW");
		testCase.add("poSTcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getName().equals("Josephine Esmerelda Bloggs")) check = false;
		if (!testResident.getPhone().equals("99887766")) check = false;
		if (testResident.getNPets() != 2) check = false;
		if (!testResident.getAddress().equals("102 Smith St, Summer hill, NSW")) check = false;
		if (!testResident.getPostcode().equals("2130")) check = false;
		if (check) countPass++;
		System.out.println("*** Key Fields Casing ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Invalid values
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs1");
		testCase.add("birthday ");
		testCase.add("phone 9988776a");
		testCase.add("pet Cat 123");
		testCase.add("address 1234");
		testCase.add("postcode abcd");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("")) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (!testResident.getPhone().equals("")) check = false;
		if (testResident.getNPets() != -1) check = false;
		if (!testResident.getAddress().equals("")) check = false;
		if (!testResident.getPostcode().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** Invalid Values 1 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Invalid values
		testCase.clear();
		testCase.add("name ");
		testCase.add("birthday ");
		testCase.add("phone ");
		testCase.add("pet ");
		testCase.add("address");
		testCase.add("postcode");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("")) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (!testResident.getPhone().equals("")) check = false;
		if (testResident.getNPets() != 0) check = false;
		if (!testResident.getAddress().equals("")) check = false;
		if (!testResident.getPostcode().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** Invalid Values 2 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// No name
		testCase.clear();
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("")) check = false;
		if (!testResident.getPhone().equals("99887766")) check = false;
		if (testResident.getNPets() != 2) check = false;
		if (!testResident.getAddress().equals("102 Smith St, Summer hill, NSW")) check = false;
		if (!testResident.getPostcode().equals("2130")) check = false;
		if (check) countPass++;
		System.out.println("*** No Name ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// No phone
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("Josephine Esmerelda Bloggs")) check = false;
		if (!testResident.getPhone().equals("")) check = false;
		if (!testResident.getAddress().equals("102 Smith St, Summer hill, NSW")) check = false;
		if (!testResident.getPostcode().equals("2130")) check = false;
		if (check) countPass++;
		System.out.println("*** No Phone ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// No postcode
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getName().equals("Josephine Esmerelda Bloggs")) check = false;
		if (!testResident.getPhone().equals("99887766")) check = false;
		if (!testResident.getPostcode().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** No Postcode ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Name case-formatting
		testCase.clear();
		testCase.add("name tEsT caSe FORMATTING");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getName().equals("Test Case Formatting")) check = false;
		if (check) countPass++;
		System.out.println("*** Name - case formatting ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.clear();
		testCase.add("birthday 32-05-1980");
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - invalid day 1 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 0-05-1980");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - invalid day 2 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-02-1980");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 29) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - leap year ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-02-1981");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - non-leap year ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-13-1981");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - invalid month ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-11-198");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayDay() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - invalid year 1 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-11-25");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayYear() != 1925) check = false;
		if (testResident.getBirthdayDay() != 29) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - two digit year ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29-11-15");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayYear() != 2015) check = false;
		if (testResident.getBirthdayDay() != 29) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - two digit year ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Birthday checks
		testCase.set(0, "birthday 29/11/15");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getBirthdayYear() != 2015) check = false;
		if (testResident.getBirthdayDay() != 29) check = false;
		if (check) countPass++;
		System.out.println("*** Birthday - backslash delimeter ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Multi-line address
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St");
		testCase.add("Summer Hill");
		testCase.add("NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getAddress().equals("102 Smith St, Summer Hill, NSW")) check = false;
		if (check) countPass++;
		System.out.println("*** Multi-line Address ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// No suburb
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, NSW");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getAddress().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** No Suburb ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// No suburb
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address Summer Hill");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getAddress().equals("Summer Hill")) check = false;
		if (check) countPass++;
		System.out.println("*** Has Suburb ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Phone with leading zeros
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 00007766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (!testResident.getPhone().equals("00007766")) check = false;
		if (check) countPass++;
		System.out.println("*** Phone - leading zeros ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Phone with invalid digits
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 000077");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getPhone().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** Phone - invalid number of digits ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Postcode with invalid digits
		testCase.clear();
		testCase.add("name abc");
		testCase.add("phone 00000000");
		testCase.add("postcode 21301");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.isValid()) check = false;
		if (!testResident.getPhone().equals("00000000")) check = false;
		if (!testResident.getPostcode().equals("")) check = false;
		if (check) countPass++;
		System.out.println("*** Postcode - invalid number of digits ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Pet checks
		testCase.clear();
		testCase.add("name abc");
		testCase.add("phone 00000000");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getNPets() != -1) check = false;
		if (check) countPass++;
		System.out.println("*** Pet - unknown ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Pet checks
		testCase.add("pet ");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getNPets() != 0) check = false;
		if (check) countPass++;
		System.out.println("*** Pet - unknown ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Pet checks
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("address Summer Hill");
		testCase.add("postcode 2130");
		testCase.add("Pet dog dog cat");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getNPets() != 3) check = false;
		if (!testResident.getPets().get(0).equals("Dog")) check = false;
		if (!testResident.getPets().get(1).equals("Dog")) check = false;
		if (!testResident.getPets().get(2).equals("Cat")) check = false;
		if (check) countPass++;
		System.out.println("*** Pet - multiple same pet type ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Pet checks
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("address Summer Hill");
		testCase.add("postcode 2130");
		testCase.add("Pet DOG RabBIT CAt");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.isValid()) check = false;
		if (testResident.getNPets() != 3) check = false;
		if (!testResident.getPets().get(0).equals("Dog")) check = false;
		if (!testResident.getPets().get(1).equals("Rabbit")) check = false;
		if (!testResident.getPets().get(2).equals("Cat")) check = false;
		if (check) countPass++;
		System.out.println("*** Pet - case formatting ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Calculate age
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.calculateAge() == 38)
		if (check) countPass++;
		System.out.println("*** Calculate Age 1 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Calculate age
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-12-1980");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.calculateAge() == 37)
		if (check) countPass++;
		System.out.println("*** Calculate Age 2 ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Calculate age
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-12-2020");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.calculateAge() == -1)
		if (check) countPass++;
		System.out.println("*** Calculate Age Invalid ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Match name
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.matchName("Josephine esmereLDA BloggS")) check = false;
		if (testResident.matchName("Josephine")) check = false;
		if (check) countPass++;
		System.out.println("*** Match Name ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Match phone
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.matchPhone("99887766")) check = false;
		if (testResident.matchPhone("99887765")) check = false;
		if (check) countPass++;
		System.out.println("*** Match Phone ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");

		// Match postcode
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.matchPostcode("2130")) check = false;
		if (testResident.matchPostcode("2131")) check = false;
		if (check) countPass++;
		System.out.println("*** Match Postcode ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Compare name
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.compareNameHigher("Josephine Esmerelda Bloggs")) check = false;
		if (!testResident.compareNameHigher("Josephine Fsmerelda")) check = false;
		if (testResident.compareNameHigher("Josephine Dsmerelda")) check = false;
		if (testResident.compareNameHigher("Josephine")) check = false;
		if (check) countPass++;
		System.out.println("*** Compare Name ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");

		// Compare phone
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (!testResident.comparePhoneHigher("99887766")) check = false;
		if (!testResident.comparePhoneHigher("99887767")) check = false;
		if (testResident.comparePhoneHigher("00887750")) check = false;
		if (check) countPass++;
		System.out.println("*** Compare Phone ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Update details
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St");
		testCase.add("Summer Hill");
		testCase.add("NSW");
		testCase.add("postcode 2130");
		ArrayList<String> testCase2 = new ArrayList<String>();
		testCase2.add("name Josephine Esmerelda Bloggs");
		testCase2.add("birthday 13-10-1980");
		testCase2.add("phone 99887766");
		testCase2.add("pet Dog Cat Dog");
		testCase2.add("address 104 Adam St");
		testCase2.add("Winter Hill");
		testCase2.add("NSW");
		testCase2.add("postcode 2132");
		testResident = new Resident(testCase);
		Resident testResident2 = new Resident(testCase2);
		if (testResident2.isValidUpdate()) testResident.updateDetails(testResident2);
		check = true;
		countCheck++;
		if (testResident.getBirthdayMonth() != 10) check = false;
		if (testResident.getNPets() != 3) check = false;
		if (!testResident.getAddress().equals("104 Adam St, Winter Hill, NSW")) check = false;
		if (!testResident.getPostcode().equals("2132")) check = false;
		if (check) countPass++;
		System.out.println("*** Update Details ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		// Count specific pet type
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog Cat Lizard Dog Cat Rabbit");
		testCase.add("postcode 2130");
		testResident = new Resident(testCase);
		check = true;
		countCheck++;
		if (testResident.numberOfSpecificPetType("cat") != 3) check = false;
		if (testResident.numberOfSpecificPetType("dog") != 2) check = false;
		if (testResident.numberOfSpecificPetType("LIZARD") != 1) check = false;
		if (testResident.numberOfSpecificPetType("Rabbit") != 1) check = false;
		if (check) countPass++;
		System.out.println("*** Count Specific Pet ***");
		System.out.println("Pass: " + check);
		System.out.println(testResident.toString());
		System.out.println(testResident.issuesToString() + "\r\n");
		
		System.out.println("*** Passed " + countPass + " checks out of " + countCheck + " ***");
	}
}
