/**
 * 
 */
package fileIO;

import java.util.*;

import competitors.Competitor;

/**
 * @author patrickFrendo
 *
 */
public class CompetitorList {
	// Attribute for ArrayList competitor list.
	private ArrayList<Competitor> Competitorlist;

	// Empty constructor
	public CompetitorList() {
		Competitorlist = new ArrayList<>();
	}

	/**
	 * Method to add each competitor object into the ArrayList.
	 * 
	 * @param competitor
	 */
	public void add(Competitor value) {
		Competitorlist.add(value);
	}

	/**
	 * Method to obtain the whole list of competitors form the ArrayList.
	 * 
	 * @return Competitorlist
	 */
	public ArrayList<Competitor> getList() {
		return Competitorlist;
	}

	/**
	 * Method to validate if the competitorNumber entered by the user matched with
	 * any of the competitors in the ArrayList.This method is only used in the
	 * Manager class. If found then return true, if not then return false.
	 * 
	 * @param competitorNumber
	 * @return true
	 * @return false
	 */
	public boolean validate(int value) {
		for (Competitor competitor : Competitorlist) {
			if (competitor.getCompetitorNumber() == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method used in the Manager class to obtain the details of the
	 * competitorNumber entered in the console by the user. Uses a loop to go
	 * through each competitor and once the competitor is found, return the
	 * competitor object.
	 * 
	 * @param competitorNumber
	 * @return competitor
	 * @return null
	 */
	public Competitor getDetails(int value) {
		for (Competitor competitor : Competitorlist) {
			if (competitor.getCompetitorNumber() == value) {
				return competitor;
			}
		}
		return null;
	}


	/**
	 * Method to acquire the competitor object with the max score. First we create
	 * an empty object for competitor called competitorMax and initialize it with
	 * details of the first competitor details.
	 * 
	 * Then use a for loop to loop through each competitor comparing their
	 * overallScore with the previous competitor overall score. Once the loop is
	 * done then the method will return the competitor object called competitorMax.
	 * 
	 * @return competitorMax
	 */
	public Competitor getMax() {
		Competitor competitorMax = Competitorlist.get(0);
		for (Competitor competitor : Competitorlist) {
			if (competitor.getOverallScore() > competitorMax.getOverallScore()) {
				competitorMax = competitor;
			}
		}
		return competitorMax;
	}

	/**
	 * Method that creates a new ArrayList with the required subclass. This is done
	 * by creating a new ArrayList called result and use a for loop to go through
	 * each competitor with similar CompetitionName (equalsIgnoreCase is used to
	 * ignore if the user entered the subclass String in lower or uppercase.).If a
	 * match is found than that competitor object is added to the new ArrayList
	 * result.
	 * 
	 * @param subclass
	 * @return result
	 */
	public ArrayList<Competitor> searchCompetitorBySubclass(String subclass) {
		ArrayList<Competitor> result = new ArrayList<Competitor>();
		for (Competitor c : Competitorlist) {
			if (c.getCompetitionName().equalsIgnoreCase(subclass)) {
				result.add(c);
			}
		}
		return result;
	}

}
