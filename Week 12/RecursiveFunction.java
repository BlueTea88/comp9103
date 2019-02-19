public class RecursiveFunction {
	
	public static void main(String[] args) {
		System.out.printf("n = 1, %d\r\n", series(1));
		System.out.printf("n = 2, %d\r\n", series(2));
		System.out.printf("n = 3, %d\r\n", series(3));
		System.out.printf("n = 10, %d\r\n", series(10));
	}
	
	/**
		Recurisve method to return the total of the series.
	*/
	public static int series(int n) {
		if (n == 1) return n;
		return series(n - 1) + n * n;
	}
}
