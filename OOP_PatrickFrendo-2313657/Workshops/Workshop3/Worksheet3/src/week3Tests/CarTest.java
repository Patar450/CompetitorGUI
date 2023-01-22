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
class CarTest {
	Car car1;
	Car car2;
	Name owner1;

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

		// Create a car and link ut to owner1.
		car1 = new Car("Mercedez Benz", 200, owner1, 0.33);

		// Create an array of cars whose size is the same as the array of cars in the
		// Name class
		int carArraySize = owner1.getOwnedCars().length;
		Car[] ownedCars = new Car[carArraySize];

		// Filling the array with the data of the car created.
		ownedCars[0] = car1; // store the car into the first location of the array of 1

		// Set the array of ownedCars as the array of car owned by the Name object
		owner1.setOwnedCars(ownedCars);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		car1 = null;
		owner1 = null;

	}

	// Testing Getters from car1 object.
	@Test
	void testGetModel() {
		assertEquals("Mercedez Benz", car1.getModel());
	}

	@Test
	void testGetTankSize() {
		assertEquals(200, car1.getTankSize());
	}

	@Test
	void testGetManfMPG() {
		assertEquals(0.33, car1.getManfMPG());
	}

	@Test
	void testGetOwnerName() {
		assertEquals("Alan", car1.getOwnerName().getFirstName());
	}

	// Setters from car1 object.
	@Test
	void testSetModel() {
		car1.setModel("NWMDL");
		assertTrue(car1.getModel() == "NWMDL");
	}

	@Test
	void testSetTankSize() {
		car1.setTankSize(33);
		assertEquals(33, car1.getTankSize());
	}

	@Test
	void testSetManfMPG() {
		car1.setManfMPG(12.55);
		assertEquals(12.55, car1.getManfMPG());
	}

	@Test
	void testSetOwnerName() {
		Name owner2 = new Name();
		owner2.setFirstName("Patrick");
		owner2.setMiddleName("Joseph");
		owner2.setSurname("Frendo");

		car2 = new Car("Ford Fiesta", 450, owner2, 0.33);

		int carArraySize = owner1.getOwnedCars().length;
		Car[] ownedCars1 = new Car[carArraySize];

		ownedCars1[0] = car2;

		car2.setOwnerName(owner2);
		assertEquals("Patrick", car2.getOwnerName().getFirstName());
		owner2 = null;
		car2 = null;
	}

	// Constructors
	@Test
	void testOverloadedConstructorCar() {
		Name owner3 = new Name();
		owner3.setFirstName("Peter");
		owner3.setMiddleName("Paul");
		owner3.setSurname("Vandike");

		Car carx = new Car("Clown Car", 800, owner3, 2);
		
		int carArraySize = owner3.getOwnedCars().length;
		Car[] ownedCars = new Car[carArraySize];
		carx.setOwnerName(owner3);
		assertEquals("Clown Car", carx.getModel());
		assertEquals(800, carx.getTankSize());
		assertEquals("Peter Paul Vandike", carx.getOwnerName().getFullName());
		

	}

	// Methods
	@Test
	void testTankBigger_BiggerThanTankSize() {
		assertEquals("Inefficient fuel use", car1.tankBigger(150));
	}

	@Test
	void testTankBigger_SmallerThanTankSize() {
		assertEquals("Good fuel consumption", car1.tankBigger(750));
	}

	@Test
	void testTankBigger_SameTankSize() {
		assertEquals("Average consumer", car1.tankBigger(200));
	}

	@Test
	void testGetOwner() {
		assertEquals("Alan Mathson Turing", car1.getOwner());
	}

	@Test
	void testEstimateDistance() {
		assertEquals(14.52, car1.estimateDistance());
	}

}
