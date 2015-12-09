package bank;


/** 
 * This class handles account type Savings Account.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 15, 2015.
 */
public class SavingsAccount extends Account{

	/**
	 * Constructor which creates an new Savings Account.
	 * 
	 * @param balance
	 * @param interestRate
	 */
	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}
	
	@Override
	/**
	 * Withdraws money from the accounts balance.
	 * Also checks that the withdrawal doesn't ends up with a negative balance.
	 * 
	 * @param withdrawal
	 * 
	 * @return if the withdrawal succeed
	 */
	public boolean withdraw(int withdrawal) {
		if (withdrawal > 0 && (balance - withdrawal) >= 0) {
			balance -= withdrawal;
			return true;
		}
		return false;
	}
}