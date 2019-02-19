import java.util.*;
import java.io.*;

public class DisplayValues {
	public static void main(String[] args) {
		// Open file and print values
		try {
			Scanner scn = new Scanner(new File(args[0]));
			while (scn.hasNextLine()) {
				System.out.println(scn.nextLine());
			}
			scn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
