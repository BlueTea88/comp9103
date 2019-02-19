public class q1{
	public static void main(String[] args){
		final int button = Integer.parseInt(args[0]);
		String drink;
		switch (button) {
			case 1: drink = "cola";
					break;
			case 2: drink = "lemonade";
					break;
			case 3: drink = "orange";
					break;
			case 6: drink = "cola and lemonade";
					break;
			default: drink = "NONE";
					break;
		}
		System.out.print(drink);
	}
}