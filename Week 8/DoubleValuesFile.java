import java.util.*;
import java.io.*;

public class DoubleValuesFile {
	public static void main (String args[]) {
		// First argument should be output file name
		String outfile = args[0];
		
		// Write double values to file - second argument onwards should be doubles
		try {
			PrintWriter outfileWrite = new PrintWriter(new FileOutputStream (outfile));
			for (int i = 1; i < args.length; i++) {
				if (args[i].matches("^(\\d*\\.\\d+|\\d+)$")) {
					outfileWrite.print(args[i] + "\r\n");
				} else {
					System.out.printf("invalid value: %s\r\n", args[i]);
				}
			}
			outfileWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
