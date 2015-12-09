package bank;

import bank.Customer.CustomerType;


/** 
 * This class tests all the Bank classes and their methods.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 18:20, September 15, 2015.
 */
public class TestBank {

	public static void main(String[] args) {
		
		Bank bank = new Bank();

	// ASSIGNMENT 1.
		
		// TEST 1 - Create two customers.
		System.out.println("TEST 1 - Create a Customer:");
		
		try {
			
			Customer c1 = new Customer("Janne", "Jansson", "510918-2955", "Gatan 1", "11122", "Orten", "janne@jansson.se", CustomerType.Private);
			Customer c2 = new Customer("Kalle", "Andersson", "880908-2954", "Gatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
			bank.addCustomer(c1);
			bank.addCustomer(c2);
			System.out.printf("1.1 - Customer created: %s%n", c1.toString());
			System.out.printf("1.2 - Customer created: %s%n", c2.toString());
			System.out.println();

		// TEST 2 - Create two accounts for each customer.
		System.out.println("TEST 2 - Create two accounts for each customer:");
			SavingsAccount sa1 = new SavingsAccount(500.0, 0.5);
			CreditAccount ca1 = new CreditAccount(500.0, 0.75, 1000.0, 1.5);
			c1.addAccount(sa1);
			c1.addAccount(ca1);
			SavingsAccount sa2 = new SavingsAccount(5000.0, 0.5);
			CreditAccount ca2 = new CreditAccount(2500.0, 0.55, 5000.0, 3.5);
			c2.addAccount(sa2);
			c2.addAccount(ca2);
			System.out.printf("2.1 - A Savings Account was created on customer: %s%n Account Id: %d%n Balance: %.2f%n Interest Rate: %.2f %n", c1.getCustomerId(), sa1.getAccountId(), sa1.getBalance(), sa1.getInterestRate());
			System.out.printf("2.2 - A Credit Account was created on customer: %s%n Account Id: %d%n Balance: %.2f%n Interest Rate: %.2f%n Credit Limit: %.2f%n Credit Rate: %.2f %n ", c1.getCustomerId(), ca1.getAccountId(), ca1.getBalance(), ca1.getInterestRate(), ca1.getCreditLimit(), ca1.getCreditRate());
			System.out.printf("2.3 - A Savings Account was created on customer: %s%n Account Id: %d%n Balance: %.2f%n Interest Rate: %.2f %n", c2.getCustomerId(), sa2.getAccountId(), sa2.getBalance(), sa2.getInterestRate());
			System.out.printf("2.4 - A Credit Account was created on customer: %s%n Account Id: %d%n Balance: %.2f%n Interest Rate: %.2f%n Credit Limit: %.2f%n Credit Rate: %.2f %n ", c2.getCustomerId(), ca2.getAccountId(), ca2.getBalance(), ca2.getInterestRate(), ca2.getCreditLimit(), ca2.getCreditRate());
			System.out.println();
			
		} catch (CivicRegistrationNumberException e) {
			System.out.println(e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}

		// TEST 3 - Withdrawal from Savings Account.
		System.out.println("TEST 3 - Withdrawal from Savings Account:");
		System.out.println("3.1 - To POSITIVE balance:");
		if (bank.withdraw(1, 1, 450)) {
			System.out.printf(" A withdrawal was made for customer: %d%n Account: %d%n Withdrawal: %d%n New balance: %.2f%n", 1, 1, 450, bank.showBalance(1, 1));
		} else {
			System.out.println(" No withdraw was made.");
		}
		System.out.println("3.2 - To NEGATIVE balance:");
		if (bank.withdraw(2, 3, 6000)) {
			System.out.printf(" A withdrawal was made for customer: %d%n Account: %d%n Withdrawal: %d%n New balance: %.2f%n", 2, 3, 6000, bank.showBalance(2, 3));
		} else {
			System.out.println(" No withdraw was made.");
		}
		System.out.println();
		
		// TEST 4 - Withdrawal from Credit Account.
		System.out.println("TEST 4 - Withdrawal from Credit Account:");
		System.out.println("4.1 - To Negative balance OVER Credit Limit:");
		if (bank.withdraw(2, 4, 6000)) {
			System.out.printf(" A withdrawal was made for customer: %d%n Account: %d%n Withdrawal: %d%n New balance: %.2f%n", 2, 4, 6000, bank.showBalance(2, 4));
		} else {
			System.out.println(" No withdraw was made.");
		}
		System.out.println("4.2 - To Negative balance UNDER Credit Limit:");
		if (bank.withdraw(2, 4, 7501)) {
			System.out.printf(" A withdrawal was made for customer: %d%n Account: %d%n Withdrawal: %d%n New balance: %.2f%n", 2, 4, 7501, bank.showBalance(2, 4));
		} else {
			System.out.println(" No withdraw was made.");
		}
		System.out.println();

		// TEST 5 - Deposit.
		System.out.println("TEST 5 - Deposit:");
		System.out.println("5.1 - With POSITIVE value:");
		if (bank.deposit(1, 1, 950)) {
			System.out.printf(" A deposit was made for customer: %d%n Account: %d%n Deposit: %d%n New balance: %.2f%n", 1, 1, 450, bank.showBalance(1, 1));
		} else {
			System.out.println(" No deposit was made.");
		}
		System.out.println("5.2 - With NEGATIVE value:");
		if (bank.deposit(2, 3, -500)) {
			System.out.printf(" A deposit was made for customer: %d%n Account: %d%n Deposit: %d%n New balance: %.2f%n", 2, 3, -500, bank.showBalance(2, 3));
		} else {
			System.out.println(" No deposit was made.");
		}
		System.out.println();

		// TEST 6 - Change/Show Interest Rate.
		System.out.println("TEST 6 - Change Interest Rate:");
		double oldInterestRate = bank.showInterestRate(1, 1);
		System.out.println("6.1 - With CORRECT customer:");
		if (bank.changeInterestRate(1, 1, 1.57)) {
			System.out.printf(" Change Interest Rate was made for customer: %d%n Account: %d%n Old Interest Rate: %.2f%n New Interest Rate: %.2f%n", 1, 1, oldInterestRate, bank.showInterestRate(1, 1));
		} else {
			System.out.println(" No change of Interest Rate was made.");
		}
		System.out.println("6.2 - With WRONG customer:");
		oldInterestRate = bank.showInterestRate(3, 1);
		if (bank.changeInterestRate(3, 1, 2.57)) {
			System.out.printf(" Change Interest Rate was made for customer: %d%n Account: %d%n Old Interest Rate: %.2f%n New Interest Rate: %.2f%n", 1, 1, oldInterestRate, bank.showInterestRate(3, 1));
		} else {
			System.out.println(" No change of Interest Rate was made.");
		}
		System.out.println();
		
		// TEST 7 - Change/Show Credit Rate.
		System.out.println("TEST 7 - Change Interest Rate:");
		double oldCreditRate = bank.showCreditRate(1, 2);
		System.out.println("7.1 - With CORRECT customer:");
		if (bank.changeCreditRate(1, 2, 1.57)) {
			System.out.printf(" Change Credit Rate was made for customer: %d%n Account: %d%n Old Credit Rate: %.2f%n New Credit Rate: %.2f%n", 1, 1, oldCreditRate, bank.showCreditRate(1, 2));
		} else {
			System.out.println(" No change of Credit Rate was made.");
		}
		System.out.println("7.2 - With WRONG customer:");
		oldCreditRate = bank.showCreditRate(3, 2);
		if (bank.changeCreditRate(3, 2, 2.57)) {
			System.out.printf(" Change Credit Rate was made for customer: %d%n Account: %d%n Old Credit Rate: %.2f%n New Credit Rate: %.2f%n", 1, 1, oldCreditRate, bank.showCreditRate(3, 2));
		} else {
			System.out.println(" No change of Credit Rate was made.");
		}
		System.out.println();
		
		// TEST 8 - Show Credit Limit.
		System.out.println("TEST 8 - Show Credit Limit:");
		System.out.println("8.1 - With CORRECT customer:");
		System.out.println(bank.showCreditLimit(2, 4));
		System.out.println();

		
	// ASSIGNMENT 2.
		
		// INIT.
		
		try {
			
			Customer c3 = new Customer("David", "Eriksson", "510918-2955", "AGatan 1", "11122", "Orten", "janne@jansson.se", CustomerType.Private);
			Customer c4 = new Customer("Bertil", "Eriksson", "880908-2954", "CGatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
			Customer c5 = new Customer("Bertil", "Bertilsson", "741213-3865", "BGatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
			bank.addCustomer(c3);
			bank.addCustomer(c4);
			bank.addCustomer(c5);
			SavingsAccount sa3 = new SavingsAccount(500.0, 0.5);
			CreditAccount ca3 = new CreditAccount(500.0, 0.75, 1000.0, 1.5);
			c3.addAccount(sa3);
			c3.addAccount(ca3);
			SavingsAccount sa4 = new SavingsAccount(5000.0, 0.5);
			CreditAccount ca4 = new CreditAccount(2500.0, 0.55, 5000.0, 3.5);
			c4.addAccount(sa4);
			c4.addAccount(ca4);
			SavingsAccount sa5 = new SavingsAccount(5000.0, 0.5);
			CreditAccount ca5 = new CreditAccount(2500.0, 0.55, 5000.0, 3.5);
			c5.addAccount(sa5);
			c5.addAccount(ca5);
		
		} catch (CivicRegistrationNumberException e) {
			System.out.println(e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		// TEST 9 - Remove Customer from the Bank.
		System.out.println("TEST 9 - Remove Customer from the Bank:");
		System.out.println("9.1 - Remove EXISTING customer:");
		if(bank.removeCustomer(1)) {
			System.out.println(" Customer 1 deleted.");
		} else {
			System.out.println(" Couldn't find Customer 1.");
		}
		System.out.println("9.2 - Remove NOT EXISTING customer:");
		if(bank.removeCustomer(15)) {
			System.out.println(" Customer 15 deleted.");
		} else {
			System.out.println(" Couldn't find Customer 15.");
		}
		System.out.println();
		
		// TEST 10 - Remove Account from Customer.
		System.out.println("TEST 10 - Remove Account from Customer:");
		System.out.println("10.1 - Remove EXISTING account:");
		if(bank.removeAccount(2, 3)) {
			System.out.println(" Account 3 deleted.");
		} else {
			System.out.println(" Couldn't find Account 3 in Customer 2.");
		}
		System.out.println("10.2 - Remove NOT EXISTING account:");
		if(bank.removeAccount(2, 3)) {
			System.out.println(" Account 3 deleted.");
		} else {
			System.out.println(" Couldn't find Account 3 in Customer 2.");
		}
		System.out.println();

		// TEST 11 - Sort and list all Customers in the Bank.
		System.out.println("TEST 11 - Write out a list of all Customers in the Bank:");
		System.out.println("11.1 - Sort on Name - Ascending:");
		bank.sortByNameAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" %s %s - %s%n", customer.getLastname(), customer.getFirstname(), customer.getCrn());
		}
		System.out.println("11.2 - Sort on Civic Registration Number - Ascending:");
		bank.sortByCrnAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" %s %s - %s%n", customer.getCrn(), customer.getLastname(), customer.getFirstname());
		}
		System.out.println();

	// ASSIGNMENT 3.
		
		// TEST 12 - Throw Exception on invalid Civic Registration Number.
		System.out.println("TEST 12 - Test thrown Exception on Civic Registration Number:");
		System.out.println("12.1 - Invalid number (071103-4455):");
		try {
			new Customer("David", "Eriksson", "071103-4455", "Gatan 1", "11122", "Orten", "janne@jansson.se", CustomerType.Private);
			System.out.println("( 071103-4455) är ett giltigt personnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		System.out.println("12.2 - Valid number (880908-2954):");
		try {
			new Customer("Bertil", "Eriksson", "880908-2954", "Gatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
			System.out.println(" (880908-2954) är ett giltigt personnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		}  catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		System.out.println("12.3 - Too short number (880908):");
		try {
			new Customer("Bertil", "Eriksson", "880908", "Gatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
			System.out.println("(880908) är ett giltigt personnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		System.out.println();

		// TEST 13 - Throw Exception on invalid Postal Code.
		System.out.println("TEST 13 - Test thrown Exception on Civic Registration Number:");
		try {
			System.out.println("13.1 - Too long number (123456):");
			new Customer("Bertil", "Eriksson", "880908-2954", "Gatan 1", "123456", "Orten", "kalle@karlsson.se", CustomerType.Private);
			System.out.println(" (123456) är ett giltigt postnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		try {
			System.out.println("13.2 - Too short number (1234A):");
			new Customer("Bertil", "Eriksson", "880908-2954", "Gatan 1", "1234A", "Orten", "kalle@karlsson.se", CustomerType.Private);
			System.out.println(" (1234A) är ett giltigt postnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		try {
			System.out.println("13.3 - Valid number (12345):");
			new Customer("Bertil", "Eriksson", "880908-2954", "Gatan 1", "12345", "Orten", "kalle@karlsson.se", CustomerType.Private);
			System.out.println(" (12345) är ett giltigt postnummer.");
		} catch (CivicRegistrationNumberException e) {
			System.out.println(" " + e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		System.out.println();
		
	// ASSIGNMENT 9.
		
		// INIT.
		try {
			
			Customer c3 = new Customer("Andreas", "Lengqvist", "880908-2954", "Arrheniusgatan 6C", "11122", "Kalmar", "janne@jansson.se", CustomerType.Private);
			Customer c4 = new Customer("Sverker", "Olsson", "510918-2955", "Gatansvägen 1", "11122", "Timmernabben", "kalle@karlsson.se", CustomerType.Business);
			Customer c5 = new Customer("Evert", "Karlsson", "741213-3865", "Vägengatan 1", "11122", "Timmernabben", "kalle@karlsson.se", CustomerType.Business);
			bank.addCustomer(c3);
			bank.addCustomer(c4);
			bank.addCustomer(c5);
			CreditAccount ca3 = new CreditAccount(100.0, 0.75, 1000.0, 1.5);
			c3.addAccount(ca3);
			SavingsAccount sa4 = new SavingsAccount(7000.0, 0.5);
			CreditAccount ca4 = new CreditAccount(2500.0, 0.55, 5000.0, 3.5);
			c4.addAccount(sa4);
			c4.addAccount(ca4);
			SavingsAccount sa5 = new SavingsAccount(9000.0, 0.5);
			CreditAccount ca5 = new CreditAccount(2500.0, 0.55, 5000.0, 3.5);
			c5.addAccount(sa5);
			c5.addAccount(ca5);
		
		} catch (CivicRegistrationNumberException e) {
			System.out.println(e.getMessage());
		} catch (PostalCodeException e) {
			System.out.println(" " + e.getMessage());
		}
		
		// TEST 14 - Sorting.
		
		System.out.println("TEST 14 - Sort the list of customers on different criterias:");
		System.out.println("14.1 - Sort on CustomerType:");
		bank.sortByCustomerTypeAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" %s, %s %s - %s%n", customer.getCustomerType().toString(), customer.getLastname(), customer.getFirstname(), customer.getCrn());
		}
		
		System.out.println("14.2 - Sort on City - Ascending:");
		bank.sortByCityAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" %s - %s, %s - %s, %s%n", customer.getCrn(), customer.getLastname(),  customer.getFirstname(), customer.getAddress(), customer.getCity());
		}
		
		System.out.println("14.3 - Sort on how many accounts the customer has - Ascending:");
		bank.sortByNumberOfAccountsAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" Antal konton: %d, %s - %s, %s - %s, %s%n", customer.getAccounts().size(), customer.getCrn(), customer.getLastname(),  customer.getFirstname(), customer.getAddress(), customer.getCity());
		}
		
		System.out.println("14.4 - Sort on total balance - Ascending:");
		bank.sortByTotalBalanceAscending();
		for (Customer customer : bank.getAllCustomers()) {
			System.out.printf(" Totalt saldo: %f, Antal konton: %d, %s - %s, %s - %s, %s%n", customer.getTotalBalance(), customer.getAccounts().size(), customer.getCrn(), customer.getLastname(),  customer.getFirstname(), customer.getAddress(), customer.getCity());
		}
		System.out.println();
	}
}