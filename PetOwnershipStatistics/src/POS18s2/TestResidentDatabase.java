package POS18s2;
import java.util.*;

/**
 * Unit tests for the ResidentDatabase class.
 * 
 * @author Andrew Thia
 */
public class TestResidentDatabase {
	
	public static void main(String[] args) {
		// Test variables
		ResidentDatabase testDatabase;
		ArrayList<String> testCase = new ArrayList<String>();
		ArrayList<String> testMessages = new ArrayList<String>();
		boolean check = true;
		int countCheck = 0;
		int countPass = 0;
		
		// Header
		System.out.println("Running tests for resident database class...\r\n");
		
		// Standard input test
		System.out.println("*** Standard Input ***");
		testDatabase = new ResidentDatabase();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testMessages = testDatabase.updateResident(testCase, true, 0);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 00000000");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 1);
		for (String msg:testMessages) System.out.println(msg);
		System.out.println(testDatabase);
		check = true;
		countCheck++;
		if (testDatabase.getDatabase().size() != 2) check = false;
		if (check) countPass++;
		System.out.println("Pass: " + check + "\r\n");
		
		// Invalid input
		System.out.println("*** Invalid Input ***");
		testDatabase = new ResidentDatabase();
		testCase.clear();
		testCase.add("name Joker");
		testCase.add("birthday ??-??-????");
		testCase.add("phone abcdefgh");
		testCase.add("pet bear");
		testCase.add("address University of Sydney");
		testCase.add("postcode 2000");
		testMessages = testDatabase.updateResident(testCase, true, 0);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 00000000");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 1);
		for (String msg:testMessages) System.out.println(msg);
		System.out.println(testDatabase);
		check = true;
		countCheck++;
		if (testDatabase.getDatabase().size() != 1) check = false;
		if (check) countPass++;
		System.out.println("Pass: " + check + "\r\n");
		
		// Update same resident details
		System.out.println("*** Update ***");
		testDatabase = new ResidentDatabase();
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("phone 00000000");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 0);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 00000000");
		testCase.add("pet Shell");
		testMessages = testDatabase.updateResident(testCase, true, 1);
		for (String msg:testMessages) System.out.println(msg);
		System.out.println(testDatabase);
		check = true;
		countCheck++;
		if (testDatabase.getDatabase().size() != 1) check = false;
		if (!testDatabase.getDatabase().get(0).getPets().get(0).equals("Shell")) check = false;
		if (testDatabase.getDatabase().get(0).getNPets() != 1) check = false;
		if (testDatabase.getDatabase().get(0).calculateAge() != 118) check = false;
		if (check) countPass++;
		System.out.println("Pass: " + check + "\r\n");
		
		// Delete resident
		System.out.println("*** Delete ***");
		testDatabase = new ResidentDatabase();
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testMessages = testDatabase.updateResident(testCase, true, 0);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 00000000");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 1);
		for (String msg:testMessages) System.out.println(msg);
		System.out.println(testDatabase);
		check = true;
		countCheck++;
		if (testDatabase.getDatabase().size() != 2) check = false;
		testDatabase.deleteResident("Batman", "00000000");
		if (testDatabase.getDatabase().size() != 1) check = false;
		testDatabase.deleteResident("Joker", "00000000");
		if (testDatabase.getDatabase().size() != 1) check = false;
		testDatabase.deleteResident("Josephine Esmerelda Bloggs", "99887766");
		if (testDatabase.getDatabase().size() != 0) check = false;
		System.out.println(testDatabase);
		if (check) countPass++;
		System.out.println("Pass: " + check + "\r\n");
		
		// Sort resident
		System.out.println("*** Sort ***");
		testDatabase = new ResidentDatabase();
		testCase.clear();
		testCase.add("name Josephine Esmerelda Bloggs");
		testCase.add("birthday 13-05-1980");
		testCase.add("phone 99887766");
		testCase.add("pet Cat Dog");
		testCase.add("address 102 Smith St, Summer hill, NSW");
		testCase.add("postcode 2130");
		testMessages = testDatabase.updateResident(testCase, true, 0);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 99999999");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 1);
		for (String msg:testMessages) System.out.println(msg);
		testCase.clear();
		testCase.add("name Batman");
		testCase.add("birthday 01-01-1900");
		testCase.add("phone 12345678");
		testCase.add("pet Lobster");
		testCase.add("address Bruce Wayne Building, Gotham City");
		testCase.add("postcode 1234");
		testMessages = testDatabase.updateResident(testCase, true, 2);
		for (String msg:testMessages) System.out.println(msg);
		System.out.println("\r\nBefore sorting: ");
		System.out.println(testDatabase);
		check = true;
		countCheck++;
		testDatabase.sort();
		if (!testDatabase.getDatabase().get(0).matchName("Batman")) check = false;
		if (!testDatabase.getDatabase().get(1).matchName("Batman")) check = false;
		if (!testDatabase.getDatabase().get(2).matchName("Josephine Esmerelda Bloggs")) check = false;
		if (!testDatabase.getDatabase().get(0).matchPhone("12345678")) check = false;
		if (!testDatabase.getDatabase().get(1).matchPhone("99999999")) check = false;
		if (!testDatabase.getDatabase().get(2).matchPhone("99887766")) check = false;
		System.out.println("\r\nAfter sorting: ");
		System.out.println(testDatabase);
		if (check) countPass++;
		System.out.println("Pass: " + check + "\r\n");
		
		System.out.println("*** Passed " + countPass + " checks out of " + countCheck + " ***");
	}
}
