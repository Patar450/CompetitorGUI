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

/**
 * @author patar450
 *
 */
class CompetitorTest {
	Competitor competitor = new Competitor(0, null, null, 0, null);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		competitor = new Competitor(1, new Name("John", "Doe"), "Beginner", 20, new int[] { 5, 5, 5, 5, 5 });
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		competitor = null;
	}

	@Test
	public void testGetCompetitorNumber() {
		int actual = competitor.getCompetitorNumber();
		assertEquals(1, actual);
	}

	@Test
	public void testSetCompetitorNumber() {
		competitor.setCompetitorNumber(2);
		int actual = competitor.getCompetitorNumber();

		assertEquals(2, actual);
	}

	@Test
	public void testGetCompetitorName() {
		Name competitorName = new Name("John", "Doe");
		assertEquals(competitorName.getFullName(), competitor.getCompetitorName().getFullName());
	}

	@Test
	public void testSetCompetitorName() {
		competitor.setCompetitorName(new Name("Jane", "Doe"));
		assertEquals("Jane Doe", competitor.getCompetitorName().getFullName());
	}

	@Test
	public void testSetLevel() {
		competitor.setLevel("Expert");
		assertEquals("Expert", competitor.getLevel());
	}

	@Test
	public void testSetAge() {
		competitor.setAge(25);
		assertEquals(25, competitor.getAge());
	}

	@Test
	public void testSetAgeInvalidAge() {
		competitor.setAge(10);
		assertEquals(0, competitor.getAge());
	}

	@Test
	public void testGetScoreArray() {
		assertArrayEquals(new int[] { 5, 5, 5, 5, 5 }, competitor.getScoreArray());
	}

	@Test
	public void testGetOverallScore_Beginner() {
		assertEquals(2.0, competitor.getOverallScore());
	}

	@Test
	public void testGetOverallScore_Novice() {
		competitor.setLevel("Novice");
		assertEquals(5.0, competitor.getOverallScore());
	}

	@Test
	public void testGetOverallScore_Veteran() {
		competitor.setLevel("Veteran");
		assertEquals(8.0, competitor.getOverallScore());
	}

	@Test
	public void testGetOverallScore_Expert() {
		competitor.setLevel("Expert");
		assertEquals(10.0, competitor.getOverallScore());
	}

	@Test
	public void testGetFullDetails() {
		assertEquals("Competitor Number 1, name John Doe.\nJohn is a/an Beginner aged 20 and received these scores: 5,5,5,5,5.\nThis gives him an overall score of 2.0.\n", competitor.getFullDetails());
	}

	@Test
	public void testGetShortDetails() {
		assertEquals("CN 1 (JD) has overall score 2.0.", competitor.getShortDetails());
	}
}
