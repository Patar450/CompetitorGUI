
package staffTestsrc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import staff.CharityStaff;
import staff.Name;
import staff.Person;
import staff.Volunteer;

class StaffTest {
	// create a new CharityStaff object
	static CharityStaff cs = new CharityStaff();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// populate the staff list with volunteers and employees
		cs.populate();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// remove population at end of test
		cs = null;
	}

	@Test
	public void testGetTotalHours() {
		// get the total hours worked by all staff
		int totalHours = cs.getTotalHours();
		// assert that the total hours is equal to the expected value
		assertEquals(75, totalHours);
	}

	@Test
	public void testFindPerson() {
		// search for a person by name
		Person p = cs.findPerson("Mary Munro");

		// assert that the person object is not null and has the correct name
		assertNotNull(p);
		assertEquals("Mary Munro", p.getName().getFullName());
	}

	@Test
	public void testListAllVolunteers() {
		// get the list of all volunteers
		String volunteerList = cs.listAllVolunteers();

		// assert that the list of volunteers contains the expected names
		assertTrue(volunteerList.contains("Helen Scott"));
		assertTrue(volunteerList.contains("James Jackson"));
	}

	@Test
	public void testPopulate() {
		// get the list of all staff
		String staffList = cs.listAllNames();

		// assert that the list of staff contains the expected names
		assertTrue(staffList.contains("Helen Scott"));
		assertTrue(staffList.contains("James Jackson"));
		assertTrue(staffList.contains("Tim Moore"));
		assertTrue(staffList.contains("Mary Munro"));
		assertTrue(staffList.contains("Keith Clark"));
	}

	@Test
	public void testVolunteerEquals_True() {
		// create two new Volunteer objects with the same values
		Volunteer v1 = new Volunteer(21, new Name("Helen Scott"), "helen@hotmail.com", "0131 123 1234", 5);
		Volunteer v2 = new Volunteer(21, new Name("Helen Scott"), "helen@hotmail.com", "0131 123 1234", 5);

		// assert that the two Volunteer objects are not equal
		assertTrue(v1.equals(v2));
	}
	
	@Test
	public void testVolunteerEquals_False() {
		// create two new Volunteer objects with different values
		Volunteer v1 = new Volunteer(21, new Name("Helen Scott"), "helen@hotmail.com", "0131 123 1234", 5);
		Volunteer v2 = new Volunteer(23, new Name("Paul Smith "), "Paul@hotmail.com", "0121 456 4567", 8);

		// assert that the two Volunteer objects are not equal
		assertFalse(v1.equals(v2));
	}
	
}
