/***
 * @author patrickF
 * @version 11/10/2022
 */

package week1Testsrc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import week1src.Car;

class CarTest {
	// Created an instant of an object under test.
	Car car;

	@BeforeEach
	void setUp() throws Exception {
		// Ensures that each and every test has a new instance.
		car = new Car("MDL", 23, 12.6);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Ensure that the car object is cleared after a test is run
		car = null;
	}

	// Testing Getters
	@Test
	void testGetModel() {
		assertEquals("MDL", car.getModel());
	}

	@Test
	void testGetTankSize() {
		assertEquals(23, car.getTankSize());
	}

	@Test
	void testGetManfMPG() {
		assertEquals(12.6, car.getManfMPG());
	}

	// Testing Setters
	@Test
	void testSetModel() {
		car.setModel("NWMDL");
		assertTrue(car.getModel() == "NWMDL");
	}

	@Test
	void testSetTankSize() {
		car.setTankSize(33);
		assertEquals(33, car.getTankSize());
	}

	@Test
	void testSetManfMPG() {
		car.setManfMPG(12.55);
		assertEquals(12.55, car.getManfMPG());
	}
	//Methods
	@Test
	void testShapeConstructor_Overloaded() {
		// Instantiate a copy of the object under test with some values
		car = new Car("NEWCAR", 345, 46.7);
		// Check that the object under test is not null
		assertNotEquals(null, car);
		// Check that each of the attributes has a default (primitive) or null (object)
		// values
		assertTrue("NEWCAR" == car.getModel());
		assertEquals(345, car.getTankSize());
		// -------------------------------------//
		// missing getter
		// assertEquals(46.7, car.manfMPG));
	}

	@Test
	void testEstimateDistance() {
		assertEquals(63.756, car.estimateDistance());
	}

}
