public class Test {
	public static void main(String[] args){
		int c = 5;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c-i; j++) {
				if (i < j)
					System.out.print(" ");
				else if ((i + j) % 2 == 0)
					System.out.print("*");
				else 
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
