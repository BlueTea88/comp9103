package bank;

public class Test {
	public static void main(String[] args) {
		TermDepositAccount accountA = new TermDepositAccount(5, 10000, 5, 200);
		System.out.printf("Initial balance: %-8.2f\r\n", accountA.getBalance());
		accountA.addInterest();
		System.out.printf("After adding interest 1: %-8.2f\r\n", accountA.getBalance());
		accountA.addInterest();
		System.out.printf("After adding interest 2: %-8.2f\r\n", accountA.getBalance());
		accountA.withdraw(200);
		System.out.printf("Early withdrawal of $200 (early withdrawal fee of $200): %-8.2f\r\n", accountA.getBalance());
		System.out.printf("Remaining term duration: %d\r\n", accountA.getTerm());
	}
}
