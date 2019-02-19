package bank;

/**
 * An account that earns interest at a fixed rate for a fixed term.
 */
public class TermDepositAccount extends SavingsAccount {
	private int term;
	private double fee;
	
	/**
	 * Constructs a fixed term bank account with a given interest rate, term duration and penalty fee.
	 * @param rate the interest rate per month
	 * @param balance initial balance
	 * @param term the term duration in months
	 * @param fee early withdrawal fee (assume fixed amount)
	 */
	public TermDepositAccount(double rate, double balance, int term, double fee) {
		super(rate);
		deposit(balance);
		this.term = term;
		this.fee = fee;
	}

	/**
	 * Adds the earned interest to the account balance.
	 */
	public void addInterest() {
		super.addInterest();
		if (this.term > 0) this.term = this.term - 1;
	}
	
	/**
	 * Withdraw money and incur early withdrawal fee if term is not 0
	 */
	public void withdraw(double amount) {
		super.withdraw(amount);
		super.withdraw(this.fee);
	}
	
	public int getTerm() {
		return this.term;
	}
}
