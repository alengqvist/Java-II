package bank;

import java.util.ArrayList;
import java.util.Collections;
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
	 * Adds customer to the Bank.
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	/**
	 * Removes customer from the Bank.
	 * 
	 * @param customerId
	 * @param accountId
	 */
	public boolean removeCustomer(int customerId) {
		Customer customer = getCustomer(customerId);
		
		if (customer != null) {
			customers.remove(getCustomer(customerId));		
			return true;
		}
		return false;
	}
	
	/**
	 * Removes account from the Bank.
	 * 
	 * @param customerId
	 * @param accountId
	 */
	public boolean removeAccount(int customerId, int accountId) {
		Customer customer = getCustomer(customerId);
		
		if (customer != null) {
			Account account = getAccount(customer, accountId);
			
			if (account != null) {
				customer.getAccounts().remove(account);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get all Customers in a list.
	 * 
	 * @return list of customers
	 */
	public List<Customer> getAllCustomers() {
		return customers;
	}
	
	/**
	 * Get customer from id.
	 * 
	 * @param customerId
	 * 
	 * @return customer
	 */
	private Customer getCustomer(int customerId) {
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			}
		}
		return null;
	}
	
	/**
	 * Get account from customer and id.
	 * 
	 * @param customer
	 * @param accountId
	 * 
	 * @return account
	 */
	private Account getAccount(Customer customer, int accountId) {
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
	
	/**
	 * Sorts the list of customers by Name (Ascending). (if same lastname, sort on firstname)
	 */
	public void sortByNameAscending() {
		Collections.sort(customers, (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname()));
		Collections.sort(customers, (c1, c2) -> c1.getLastname().compareTo(c2.getLastname()));
		
		
		// Går det göra om den här under till endast ett lambda-uttryck?
		// Eller är tanken att jag ska göra som ovan? Att jag först sorterar förnamnet, sedan efternamnet.
		
//	   Collections.sort(customers, new Comparator<Customer>() {
//	       public int compare(Customer c1, Customer c2) {
//	            int result = c1.getLastname().compareToIgnoreCase(c2.getLastname());
//	            if (result != 0) {
//	                return result;
//	            }
//	            return c1.getFirstname().compareToIgnoreCase(c2.getFirstname());
//	       }
//	   });
	}
	
	/**
	 * Sorts the list of customers by Civic Registration Number (Ascending)
	 */
	public void sortByCrnAscending() {
		Collections.sort(customers, (c1, c2) -> c1.getCrn().compareTo(c2.getCrn()));
	}

	/**
	 * Sorts the list of customers by Customer Type (Ascending)
	 */
	public void sortByCustomerTypeAscending() {
		Collections.sort(customers, (c1, c2) -> c1.getCustomerType().toString().compareTo(c2.getCustomerType().toString()));
	}
	
	/**
	 * Sorts the list of customers by City (Ascending) (if same city, sort on address)
	 */
	public void sortByCityAscending() {
		Collections.sort(customers, (c1, c2) -> c1.getAddress().compareTo(c2.getAddress()));		
		Collections.sort(customers, (c1, c2) -> c1.getCity().compareTo(c2.getCity()));		
	}

	/**
	 * Sorts the list of customers by how many accounts each customer has (Ascending) 
	 * (if same number of accounts, sort on name)
	 */
	public void sortByNumberOfAccountsAscending() {
		sortByNameAscending();
		Collections.sort(customers, (c1, c2) -> Integer.compare(c1.getAccounts().size(), c2.getAccounts().size()));
	}

	/**
	 * Sorts the list of customers by total balance (Ascending)
	 * (if same balance, sort on number of accounts)
	 */
	public void sortByTotalBalanceAscending() {
		sortByNumberOfAccountsAscending();
		Collections.sort(customers, (c1, c2) -> Double.compare(c1.getTotalBalance(), c2.getTotalBalance()));
	}
}