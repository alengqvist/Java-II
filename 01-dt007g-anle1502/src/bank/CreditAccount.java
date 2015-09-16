package bank;


/** 
 * This class handles account type Credit Account.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 15, 2015.
 */
public class CreditAccount extends Account {
	
	// Member variables.
	private double creditLimit;		// Credit Limit.
	private double creditRate;		// Credit Rate.

	/**
	 * Constructor which creates an new Credit Account.
	 * 
	 * @param balance
	 * @param interestRate
	 * @param creditLimit
	 * @param creditRate
	 */
	public CreditAccount(double balance, double interestRate, double creditLimit, double creditRate) {
		super(balance, interestRate);
		this.creditLimit = creditLimit;
		this.creditRate = creditRate;
	}

	/**
	 * Gets the current Credit Limit.
	 * 
	 * @return creditLimit
	 */
	public double getCreditLimit() {
		return this.creditLimit;
	}
	
	/**
	 * Gets the current Credit Rate.
	 * 
	 * @return creditRate
	 */
	public double getCreditRate() {
		return this.creditRate;
	}
	
	/**
	 * Sets the Credit Rate to a new value.
	 * 
	 * @param creditRate
	 */
	public void setCreditRate(double creditRate) {
		this.creditRate = creditRate;
	}
	
	
	@Override
	/**
	 * Withdraws money from the accounts balance.
	 * Also checks if the Credit Limit allows a withdrawal.
	 * 
	 * @param withdrawal
	 * 
	 * @return if the withdrawal succeed
	 */
	public boolean withdraw(int withdrawal) {
		if ((creditLimit + balance) - withdrawal >= 0) {
			this.balance -= withdrawal;
			return true;
		}
		return false;
	}
}