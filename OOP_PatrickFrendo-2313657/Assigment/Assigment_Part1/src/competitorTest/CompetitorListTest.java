/**
 * 
 */
package competitorTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitors.Competitor;
import competitors.Name;
import fileIO.CompetitorList;

/**
 * @author patar450
 *
 */
class CompetitorListTest {
	Competitor competitor = new Competitor(0, null, null, 0, null);
	Competitor competitor1;
	Competitor competitor2;
	Competitor competitor3;
	CompetitorList list = new CompetitorList();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		competitor1 = new Competitor(1, new Name("John", "Doe"), "Beginner", 20, new int[] { 5, 5, 5, 5, 5 });
		competitor2 = new Competitor(2, new Name("Jane", "Smith"), "Expert", 25, new int[] { 5, 4, 3, 2, 1 });
		competitor3 = new Competitor(3, new Name("Bob", "Johnson"), "Veteran", 30, new int[] { 3, 3, 3, 3, 3 });

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		competitor = null;
		competitor1 = null;
		competitor2 = null;
		competitor3 = null;

	}

	@Test
	public void testAdd() {
		list.add(competitor);
		assertEquals(1, list.getList().size());
	}

	// Test for validate() method
	@Test
	public void testValidate() {
		list.add(competitor);
		assertTrue(list.validate(0));
		assertFalse(list.validate(1));
	}

	// Test for getDetails() method
	@Test
	public void testGetDetails() {
		list.add(competitor1);
		assertEquals(competitor1, list.getDetails(1));
		assertNull(list.getDetails(2));
	}

	@Test
	public void testGetAverage() {
		list.add(competitor1);
		list.add(competitor2);
		list.add(competitor3);
		double expected = Double.valueOf(String.format("%.2f",
				(competitor1.getOverallScore() + competitor2.getOverallScore() + competitor3.getOverallScore()) / 3));
		assertEquals(expected, list.getAverage(), 0.001);
	}

	@Test
	public void testGetMaxScore() {
		list.add(competitor1);
		list.add(competitor2);
		list.add(competitor3);

		assertEquals(competitor2.getOverallScore(), list.getMaxScore());
	}

	@Test
	public void testGetMinScore() {
		list.add(competitor1);
		list.add(competitor2);
		list.add(competitor3);

		assertEquals(2.0, list.getMinScore());
	}

	@Test
	public void testGetFrequency() {
		list.add(competitor1);
		list.add(competitor2);
		list.add(competitor3);

		int[] frequency = list.getFrequency();
		int[] expectedFrequency = { 0, 1, 1, 6, 1, 6 };
		assertArrayEquals(expectedFrequency, frequency);
	}

	@Test
	public void testGetMax() {
		list.add(competitor1);
		list.add(competitor2);
		list.add(competitor3);

		assertEquals(competitor2, list.getMax());
		assertNotEquals(competitor1, list.getMax());
	}

}
