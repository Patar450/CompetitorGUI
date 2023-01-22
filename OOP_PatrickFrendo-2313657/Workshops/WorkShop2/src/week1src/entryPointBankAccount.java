/**
 * 
 */
package week1src;

import java.util.Scanner;

import week1src.BankAccount;

/**
 * @author patar450
 * @version 12/10/2022
 *
 */
public class entryPointBankAccount {

	static Scanner allInOneScanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Program is about creating a Bank account system which allows user to: Check Balance, Deposit and withdrawing funds. 

		BankAccount acc1 = new BankAccount("Paul", "12340000", 4000);
		boolean systemOnline = true;
		System.out.println("Wellcome to FBanking the internationally Fake Bank.");
		System.out.println("How may we assist you today?");
		while (systemOnline == true) {
			System.out.println("1)Deposit Money \n2)Withdraw Money \n3)Check Current Balance.\n0)To exit.");
			int menuNumber = allInOneScanner.nextInt();
			int moneyPlaceholder = 0;
			int balancePlaceholder = acc1.getBalance();
			switch (menuNumber) {
			case 1: {
				System.out.println("How much will you be depositing today?");
				moneyPlaceholder = allInOneScanner.nextInt();
				depositMoney(moneyPlaceholder, acc1);
				System.out.println("\nAnything else?");
				break;
			}
			case 2: {
				System.out.println("How much will you be withdrawing today?");
				moneyPlaceholder = allInOneScanner.nextInt();

				int newBalance = acc1.withdrawMoney(moneyPlaceholder);
				if (newBalance != -1) {
					System.out.println(
							"Thank you!\nYour balance was " + balancePlaceholder + "Eu.\nWith the withdrawal of "
									+ moneyPlaceholder + "Eu, brings the new balance to: " + newBalance + "Eu.");
				} else {
					System.out.println(
							"Oh no! It seems you don't have enough funds to take that amount.\nWould you instead like to: \n1)Check your balance. \n2)Deposit money");
					menuNumber = allInOneScanner.nextInt();
					switch (menuNumber) {
					case 1: {
						checkBalance(acc1.getBalance());
						System.out.println("\nAnything else?");
						break;
					}
					case 2: {
						System.out.println("How much will you be depositing today?");
						moneyPlaceholder = allInOneScanner.nextInt();
						depositMoney(moneyPlaceholder, acc1);
						System.out.println("\nAnything else?");
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + menuNumber);
					}

				}
				break;
			}
			case 3: {
				checkBalance(acc1.getBalance());
				System.out.println("\nAnything else?");
				break;
			}
			case 0: {
				systemOnline = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Please choose the options shown in the screen please.");
			}
			
		}
	}

	/***
	 * Method to display the current balance of the object.
	 * 
	 * @param balance
	 */
	public static void checkBalance(int balance) {
		System.out.println("Your current balance is: " + balance + "Eu.");
	}

	/***
	 * Method that increases the value of the object balance. If the value entered
	 * is less than 0 than the program will prompt user to try again.
	 * 
	 * @param moneyPlaceholder
	 * @param acc1
	 */
	public static void depositMoney(int moneyPlaceholder, BankAccount acc1) {
		boolean isItPositive = true;

		do {
			if (moneyPlaceholder < 0) {
				System.out.println("I'm sorry but that amount is less than nothing. Please try again. or enter 0");
				moneyPlaceholder = allInOneScanner.nextInt();
				isItPositive = false;
			}else {
				isItPositive =true;
			}
		} while (isItPositive == false);
		int newBalance = acc1.depositMoney(moneyPlaceholder);
		System.out.println("Thank you!\nYour new balance is " + newBalance + "Eu.");

	}

}
