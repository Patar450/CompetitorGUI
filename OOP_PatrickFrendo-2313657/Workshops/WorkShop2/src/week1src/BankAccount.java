/**
 * 
 */
package week1src;

/**
 * Class that represents bank account
 * 
 * @author patar450
 * @version 11/10/2022
 */

public class BankAccount {

	// Attributes - data stored about the object
	private String name;
	private String accountNumber;
	private int balance;

	// Getters
	public String getName() {
		return this.name;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public int getBalance() {
		return this.balance;
	}

	// Setters
	/***
	 * Sets the deposit,withdraw &balance attribute to the given value if this is
	 * valid
	 * 
	 * @param is set according to value;
	 */
	public void setName(String value) {
		this.name = value;
	}

	public void setAccountNumber(String value) {
		this.accountNumber = value;
	}

	public void setBalance(int value) {

		this.balance = value;
	}

	// Methods
	
	/***
	 * Method to get the parameter deposit and add the amount to the account
	 * balance.
	 * @param deposit, current balance
	 * @return newbalance;
	 */
	public int depositMoney(int deposit) {
		return this.balance += deposit;
	}
	
	/***
	 * Method to get the parameter withdraw and subtract the amount of the account
	 * balance. If the balance would be in the negative than the return will be -999.
	 * @param deposit, current balance
	 * @return -1;
	 * @return updated balance.
	 */
	public int withdrawMoney(int withdraw) {
		if(this.balance - withdraw < 0|| withdraw < 0) {
			return -1;
		}else {
			return this.balance -= withdraw;
		}
		
	}
	
	// Constructors
	// Constructors with a default string of account holder & value of 0 for
	// balance.
	public BankAccount() {
		this.name = "";
		this.accountNumber = "";
		this.balance = 0;
	}

	// Overloaded Constructor.
	public BankAccount(String nam, String acc, int bal) {
		this.name = nam;
		this.accountNumber = acc;
		this.balance = bal;
	}

}
