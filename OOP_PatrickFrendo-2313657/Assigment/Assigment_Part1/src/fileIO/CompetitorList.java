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
	//Attribute for ArrayList competitor list.
	private ArrayList<Competitor> Competitorlist;

	//Empty constructor
	public CompetitorList() {
		Competitorlist = new ArrayList<>();
	}

	/**
	 * Method to add each competitor object into the ArrayList.
	 * @param competitor
	 */
	public void add(Competitor value) {
		Competitorlist.add(value);
	}
	
	/**
	 * Method to obtain the whole list of competitors form the ArrayList.
	 * @return Competitorlist
	 */
	public ArrayList<? extends Competitor> getList() {
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
	 * Method that obtains the average of all overall scores for the whole
	 * competitor list. Initialize sum as 0 then use a loop to get each overall
	 * score of each individual competitors. Then return the answer by dividing the
	 * sum by the amount of competitors found in the ArrayList. Restrict the double
	 * by 2dp to avoid any screen clutter.
	 * 
	 * @return Double.valueOf(String.format("%.2f", sum / Competitorlist.size())
	 */
	public double getAverage() {
		double sum = 0;
		for (Competitor competitor : Competitorlist) {
			sum += competitor.getOverallScore();
		}
		return Double.valueOf(String.format("%.2f", sum / Competitorlist.size()));
	}

	/**
	 * Method that obtains the competitor object who has the most amount of
	 * overallScores. Initialize a double max with the competitor details of the
	 * first competitor in the arrayList.
	 * 
	 * The loop through each competitors with their overallScore and compare the
	 * most overall score competitor currently found.
	 * 
	 * @return max
	 */
	public double getMaxScore() {
		double max = Competitorlist.get(0).getOverallScore();
		for (Competitor competitor : Competitorlist) {
			if (competitor.getOverallScore() > max) {
				max = competitor.getOverallScore();
			}
		}
		return max;
	}

	/**
	 * Method that obtains the competitor object who has the least amount of
	 * overallScores. Initialize a double min with the competitor details of the
	 * first competitor in the arrayList.
	 * 
	 * The loop through each competitors with their overallScore and compare the
	 * least overall score competitor currently found.
	 * 
	 * @return min
	 */
	public double getMinScore() {
		double min = Competitorlist.get(0).getOverallScore();
		for (Competitor competitor : Competitorlist) {
			if (competitor.getOverallScore() < min) {
				min = competitor.getOverallScore();
			}
		}
		return min;
	}

	/**
	 * Method to get the amount of each score per competitor. To find out how many
	 * competitors obtained a score of 1,2,3,4 or 5. This is done by initializing an
	 * array called frequency with size 6 each element is set to 0.
	 * 
	 * Then loop through each competitor. Initialize an array called scores and fill
	 * the array with the score array of the current competitor. Another loop is
	 * created to separate each individual scores and store them into the frequency
	 * array.
	 * 
	 * frequency[scores[i]]++;
	 * 
	 * For example the score of the competitor is 1,2,3 frequency array will add +1
	 * for the index of 1,2 and 3.
	 * 
	 * @return frequency
	 */
	public int[] getFrequency() {
		int[] frequency = new int[6];
		for (Competitor competitor : Competitorlist) {
			int[] scores = competitor.getScoreArray();
			for (int i = 0; i < scores.length; i++) {
				frequency[scores[i]]++;
			}
		}
		return frequency;
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
	
	
}
