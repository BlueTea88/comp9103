import java.util.*;
import java.io.*;

public class SearchValue {
	public static void main(String[] args) {
		// Input file
		String inputfile = args[0];
		
		// Ask user for value to search
		System.out.println("Input a double value to search:");
		Scanner scn = new Scanner(System.in);
		String value = scn.next().trim();
		if (!value.matches("(\\d*\\.\\d+|\\d+)")) {
			System.out.println("Invalid double value: " + value);
			return;
		}
		
		try {
			// Open file and print index if value is found
			Scanner scn2 = new Scanner(new File(inputfile));
			int index = 0;
			boolean found = false;
			while (scn2.hasNextLine()) {
				String line = scn2.nextLine().trim();
				if (line.equals(value)) {
					System.out.println("Found value " + value + " at index: " + index);
					found = true;
				}
				index++;
			}
			if (!found) System.out.printf("Could not find the value %s in file %s\r\n", value, inputfile);
			scn2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
