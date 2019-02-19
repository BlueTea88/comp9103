public class q3
{
	public static void main(String[] args)
	{
		String qpart = args[0];
		if (qpart.equals("a")){
			for (int i = 15; i >= 2; i--){
				System.out.println(i);
			}
		} else if (qpart.equals("b")){
			for (int i = 14; i > 2; i--){
				System.out.println(i);
			}
		} else if (qpart.equals("c")){
			for (int i = 2; i <= 20; i++){
				if (i % 2 == 0) System.out.println(i);
			}
		} else {
			System.out.print("Invalid input! (should be a, b or c)");
		}
	}
}