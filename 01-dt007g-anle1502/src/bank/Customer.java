package bank;

import java.util.ArrayList;
import java.util.List;


/** 
 * Customer handles the creation and storing of an customer and his or hers accounts.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 15, 2015.
 */
public class Customer {
	
	// Member variables.
	private static int lastId;		// The last Id that was created.
	private int customerId;			// Customer Id.
	private String firstname;		// Firstname.
	private String lastname;		// Lastname.
	private String crn;				// Civic registration number.
	private String address;			// Address.
	private String postalCode;		// Postal code.
	private String city;			// City.
	private String email;			// E-mail. 
	private CustomerType type;		// Type of customer.
	
	// Defines and initialize a list of accounts.
	private List<Account> accounts = new ArrayList<Account>();
	
	// Enumeration of customer types.
	public enum CustomerType { Private, Business };
	
	/**
	 * Constructor which creates an new Customer.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param crn
	 * @param address
	 * @param postalCode
	 * @param city
	 * @param email
	 * @param type
	 */
	public Customer(String firstname, String lastname, String crn, String address, String postalCode, String city, String email, CustomerType type) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.crn = crn;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.email = email;
		this.type = type;
		this.customerId = ++lastId;
	}
	
	/**
	 * Gets the customer Id.
	 * 
	 * @return customerId
	 */
	public int getCustomerId() {
		return this.customerId;
	}
	
	/**
	 * Gets the list of accounts linked to the customer.
	 * 
	 * @return accounts
	 */
	public List<Account> getAccounts() {
		return this.accounts;
	}
		
	/**
	 * Adds account to the customer.
	 * 
	 * @param account
	 */
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	/**
	 * Returns a pretty String of the Customer content.
	 * 
	 * @return customerAsString
	 */
	public String toString() {
		return this.customerId + ", " + this.firstname + ", " + this.lastname + ", " + this.crn + ", " + this.address + ", " + this.postalCode + ", " + this.city + ", " + this.email + ", " + this.type;
	}
}