/**
 * 
 */
package week3Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import week3Src.Car;
import week3Src.Name;

/**
 * @author patrickF
 *
 */
class NameTest {
	Name owner1;
	Car car1;
	Car car2;
	Car car3;
	Car car4;
	Car car5;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create an owner object & set the name attributes only ...no cars have been
		// linked to this owner as yet
		owner1 = new Name();
		owner1.setFirstName("Alan");
		owner1.setMiddleName("Mathson");
		owner1.setSurname("Turing");

		// Create a set of 5 cars and will link them to owner1.
		car1 = new Car("Mercedez Benz", 200, owner1, 0.33);
		car2 = new Car("Toyota Starlet", 150, owner1, 0.23);
		car3 = new Car("Mitsubishi Colt", 100, owner1, 0.88);
		car4 = new Car("MiniCooper", 200, owner1, 0.33);
		car5 = new Car("Ford Fiesta", 450, owner1, 0.33);

		// Create an array of cars whose size is the same as the array of cars in the
		// Name class
		int carArraySize = owner1.getOwnedCars().length;
		Car[] ownedCars = new Car[carArraySize];

		// Filling the array with the data of the cars created.
		ownedCars[0] = car1; // store the first car into the first location of the array
		ownedCars[1] = car2;
		ownedCars[2] = car3;
		ownedCars[3] = car4;
		ownedCars[4] = car5;

		// Set the array of ownedCars as the array of cars owned by the Name object
		owner1.setOwnedCars(ownedCars);
		// Car[] list = owner1.getOwnedCars();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		owner1 = null;
		car1 = null;
		car2 = null;
		car3 = null;
		car4 = null;
		car5 = null;
	}

	// Testing Getters from owner1 object.
	@Test
	void testGetFirstName() {
		assertEquals("Alan", owner1.getFirstName());
	}

	@Test
	void testGetMiddleName() {
		assertEquals("Mathson", owner1.getMiddleName());
	}

	@Test
	void testGetSurname() {
		assertEquals("Turing", owner1.getSurname());
	}

	@Test
	void testGetOwnedCars() {
		Car[] list = owner1.getOwnedCars();
		assertEquals("Mitsubishi Colt", list[2].getModel());
	}

	// Setters of object owner1
	@Test
	void testSetFirstName() {
		owner1.setFirstName("Cuddles");
		assertEquals("Cuddles", owner1.getFirstName());
	}

	@Test
	void testSetMiddleName() {
		owner1.setMiddleName("Midcuddles");
		assertEquals("Midcuddles", owner1.getMiddleName());
	}

	@Test
	void testSetSurname() {
		owner1.setSurname("Lastcuddles");
		assertEquals("Lastcuddles", owner1.getSurname());
	}

	@Test
	void testSetOwnedCars() {
		Car car6 = new Car("Ferrari", 990, owner1, 9);

		int carArraySize = owner1.getOwnedCars().length;
		Car[] ownedCars = new Car[carArraySize];
		ownedCars[0] = car6;

		// Set the array of ownedCars as the array of cars owned by the Name object
		owner1.setOwnedCars(ownedCars);
		Car[] list = owner1.getOwnedCars();
		assertEquals("Ferrari", list[0].getModel());
	}
	//Methods
	
	@Test
	void testGetLastCommaFirst() {
		assertEquals("Turing, Alan", owner1.getLastCommaFirst());
	}
	@Test
	void testGetFullName_WithMiddleName() {
		assertEquals("Alan Mathson Turing", owner1.getFullName());
	}
	@Test
	void testGetFullName_WithoutMiddleName() {
		Name owner2 = new Name();
		owner2.setFirstName("Patrick");
		owner2.setSurname("Frendo");
		assertEquals("Patrick Frendo", owner2.getFullName());
		owner2 = null;
	}
	@Test
	void testGetFirstAndLast() {
		assertEquals("Alan Turing", owner1.getFirstAndLast());
	}
	//Unit test to determine the 3rd car for a given name object
	@Test
	void testGetThirdOwnedCarFromNameObject() {
		Car[] list = owner1.getOwnedCars();
		assertEquals("Mitsubishi Colt", list[2].getModel());
	}
}
