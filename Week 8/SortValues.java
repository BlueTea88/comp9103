import java.util.*;
import java.io.*;

public class SortValues {
	public static void main(String[] args) {
		String infile = args[0];
		boolean orderAscending = Boolean.parseBoolean(args[1]);
		
		try {
			// Open and read file into double array
			Scanner scn = new Scanner(new File(infile));
			ArrayList<Double> values = new ArrayList<Double>();
			
			while (scn.hasNextLine()) {
				String value = scn.nextLine().trim();
				if (!value.matches("^(\\d+|\\d*\\.\\d+)$")) {
					if (value.length() > 0) System.out.printf("invalid value from file: %s\r\n", value);
					continue;
				}
				values.add(Double.parseDouble(value));
			}
			scn.close();
			
			// Apply insertion sort
			ArrayList<Double> sortedValues = new ArrayList<Double>();
			for (int i = 0; i < values.size(); i++) {
				double temp = values.get(i);
				for (int j = 0; j <= i; j++) {
					if (j == i) {
						sortedValues.add(j, temp);
						break;
					} else if (orderAscending & temp < sortedValues.get(j)) {
						sortedValues.add(j, temp);
						break;
					} else if (!orderAscending & temp > sortedValues.get(j)) {
						sortedValues.add(j, temp);
						break;
					}
				}
			}
			
			// Overwrite existing file
			PrintWriter pw = new PrintWriter(new FileOutputStream(infile));
			for (int i = 0; i < sortedValues.size(); i++) {
				pw.println(sortedValues.get(i));
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
