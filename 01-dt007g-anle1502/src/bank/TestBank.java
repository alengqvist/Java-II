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

		// TEST 1 - Create two customers.
		System.out.println("TEST 1 - Create a Customer:");
			Customer c1 = new Customer("Janne", "Jansson", "112233-4455", "Gatan 1", "11122", "Orten", "janne@jansson.se", CustomerType.Private);
			Customer c2 = new Customer("Kalle", "Karlsson", "112233-4455", "Gatan 1", "11122", "Orten", "kalle@karlsson.se", CustomerType.Private);
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
	}
}