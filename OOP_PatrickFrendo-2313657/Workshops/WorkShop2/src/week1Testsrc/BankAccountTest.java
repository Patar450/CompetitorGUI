/**
 * 
 */
package week1Testsrc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import week1src.BankAccount;

/**
 * @author patrickF
 * @version 20/10/2022
 *
 */
class BankAccountTest {
	// Created an instance of an object for testing purposes.
	BankAccount acctest;

	@BeforeEach
	void setUp() throws Exception {
		// Ensures that each and every test has a new instance.
		acctest = new BankAccount("Patrick", "99991234", 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Ensure that the object is cleared after each test is done
		acctest = null;
	}

	// Testing Getters
	@Test
	void testGetName() {
		assertEquals("Patrick", acctest.getName());
	}

	@Test
	void testGetAccountNumber() {
		assertEquals("99991234", acctest.getAccountNumber());
	}

	@Test
	void testGetBalance() {
		assertEquals(100, acctest.getBalance());
	}

	// Testing Setters
	@Test
	void testSetName() {
		acctest.setName("John");
		assertTrue("John" == acctest.getName());
	}

	@Test
	void testSetAccountNumber() {
		acctest.setAccountNumber("00000000");
		assertTrue("00000000" == acctest.getAccountNumber());
	}

	@Test
	void testSetBalance() {
		acctest.setBalance(999);
		assertEquals(999, acctest.getBalance());
	}

	// Testing Methods

	// Test case to ensure the balance is adding the expected value.
	@Test
	void testDepositMoney() {
		assertEquals(1100, acctest.depositMoney(1000));
	}

	@Test
	void testWithdrawMoney_PositiveValue() {
		assertEquals(50, acctest.withdrawMoney(50));
	}

	// Test cases to check if a negative value entered in method will ensure the
	// method return -1.
	@Test
	void testWithdrawMoney_NegativeValue() {
		assertEquals(-1, acctest.withdrawMoney(-50));
	}

	// Test cases to check if a larger value than the balance entered in the method
	// will ensure the method return -1.
	@Test
	void testWithdrawMoney_NegativeBalance() {
		assertEquals(-1, acctest.withdrawMoney(150));
	}

	// Constructors
	// Testing the empty constructor.

	@Test
	void testBankAccount_Empty() {
		acctest = new BankAccount();
		// Testing the object is not null.
		assertNotEquals(null, acctest);
		// testing the default values from the getters.
		assertEquals("", acctest.getName());
		assertEquals("", acctest.getAccountNumber());
		assertEquals(0, acctest.getBalance());
	}

	@Test
	void testBankAccount_Overloaded() {
		acctest = new BankAccount("John", "99998765", 100000);
		// Testing the object is not null.
		assertNotEquals(null, acctest);
		// testing the default values from the getters.
		assertEquals("John", acctest.getName());
		assertEquals("99998765", acctest.getAccountNumber());
		assertEquals(100000, acctest.getBalance());
	}
}
