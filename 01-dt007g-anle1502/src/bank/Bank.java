package bank;

import java.util.ArrayList;
import java.util.List;


/** 
 * This class work like a Bank. Where customers and get access to their accounts.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 18:20, September 15, 2015.
 */
public class Bank {

	// Define and initialize list of customers.
	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * Adds customers to the Bank.
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	/**
	 * Get customer from id.
	 * 
	 * @param customerId
	 * 
	 * @return customer
	 */
	public Customer getCustomer(int customerId) {
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			}
		}
		return null;
	}
	
	/**
	 * Adds account from customer and id.
	 * 
	 * @param customer
	 * @param accountId
	 * 
	 * @return account
	 */
	public Account getAccount(Customer customer, int accountId) {
		if (customer != null) {
			for (Account account : customer.getAccounts()) {
				if (account.getAccountId() == accountId) {
					return account;
				}
			}
		}
		return null;
	}
	
	/**
	 * Shows the Balance of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * 
	 * @return balance
	 */
	public double showBalance(int customerId, int accountId) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			return account.getBalance();
		}
		return 0.0;
	}
	
	/**
	 * Shows the Interest Rate of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * 
	 * @return interestRate
	 */
	public double showInterestRate(int customerId, int accountId) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			return account.getInterestRate();
		}
		return 0.0;
	}
	
	/**
	 * Shows the Credit Rate of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * 
	 * @return creditRate
	 */
	public double showCreditRate(int customerId, int accountId) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			return ((CreditAccount) account).getCreditRate();
		}
		return 0.0;
	}
	
	/**
	 * Shows the Credit Limit of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * 
	 * @return creditLimit
	 */
	public double showCreditLimit(int customerId, int accountId) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			return ((CreditAccount) account).getCreditLimit();
		}
		return 0.0;
	}
	
	/**
	 * Changes the Interest Rate of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * @param interestRate
	 * 
	 * @return if the change succeed
	 */
	public boolean changeInterestRate(int customerId, int accountId, double interestRate) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			account.setInterestRate(interestRate);
			return true;
		}
		return false;
	}
	
	/**
	 * Changes the Credit Rate of an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * @param creditRate
	 * 
	 * @return if the change succeed
	 */
	public boolean changeCreditRate(int customerId, int accountId, double creditRate) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			((CreditAccount) account).setCreditRate(creditRate);
			return true;
		}
		return false;
	}
	
	/**
	 * Withdraws money from an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * @param withdrawal
	 * 
	 * @return if the withdrawal succeed
	 */
	public boolean withdraw(int customerId, int accountId, int withdrawal) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			if (account.withdraw(withdrawal)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Deposits money to an selected account.
	 * 
	 * @param customerId
	 * @param accountId
	 * @param deposit
	 * 
	 * @return if the deposit succeed
	 */
	public boolean deposit(int customerId, int accountId, int deposit) {
		Account account = getAccount(getCustomer(customerId), accountId);
		if (account != null) {
			if (account.deposit(deposit)) {
				return true;
			}
		}
		return false;
	}
}