package bank;


/** 
 * This class is the base class of all types of Accounts.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 15, 2015.
 */
public abstract class Account {

	// Member variables.
	private static int lastId;			// The last Id that was created.
	private int accountId;				// Account Id.
	protected double balance;			// Balance.
	protected double interestRate;		// Interest Rate.
	
	/**
	 * Constructor which creates an new Account.
	 * 
	 * @param balance
	 * @param interestRate
	 */
	public Account(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountId = ++lastId;
	}
	
	/**
	 * Gets the current Balance.
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Gets the current Interest Rate.
	 * 
	 * @return interestRate
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * Gets the Account Id.
	 * 
	 * @return accountId
	 */
	public int getAccountId() {
		return this.accountId;
	}		
	
	/**
	 * Sets the Interest Rate to a new value.
	 * 
	 * @param interestRate
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * Withdraws money from the accounts balance.
	 * 
	 * @param withdrawal
	 * 
	 * @return if the withdrawal succeed
	 */
	public boolean withdraw(int withdrawal) {
		if (withdrawal > 0) {
			this.balance -= withdrawal;
			return true;
		}
		return false;
	}		
	
	/**
	 * Deposits money to the accounts balance.
	 * 
	 * @param deposit
	 * 
	 * @return if the deposit succeed
	 */
	public boolean deposit(int deposit) {
		if (deposit > 0) {
			this.balance += deposit;
			return true;
		}
		return false;
	}
}