
public class T4 {
	public static void main(String[] args) {
		int x = 3;
		
		for (int i = 0; i < 5; i++) {
			int j = x - i;
			if (j % 3 == 0) {
				System.out.println("i: " + i + ", j: " + j);
			} else {
				i ++;
			}
		}
	}
}
