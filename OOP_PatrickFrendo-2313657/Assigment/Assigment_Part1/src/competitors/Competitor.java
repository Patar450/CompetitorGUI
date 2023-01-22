package competitors;

/**
 * @author patrickFrendo
 *
 */

public class Competitor {
	//Attributes
	private int competitorNumber;
	private Name competitorName;
	private String level;
	private int age;
	private int[] scores;

	// Getters

	public int getCompetitorNumber() {
		return competitorNumber;
	}

	public Name getCompetitorName() {
		return competitorName;
	}

	public String getLevel() {
		return level;
	}

	public int getAge() {
		return age;
	}

	public int[] getScoreArray() {
		return scores;
	}

	// Setters
	public void setCompetitorNumber(int value) {
		this.competitorNumber = value;
	}

	public void setCompetitorName(Name value) {
		this.competitorName = value;
	}

	public void setLevel(String value) {
		this.level = value;
	}

	public void setAge(int value) {
		if (value < 15) {
			this.age = 0;
		} else {
			this.age = value;
		}

	}

	public void setScores(int[] value) {
		this.scores = value;
	}

	/**
	 * Method to calculate the competitor overall score. This is done by
	 * initializing totalScore as 0 for a clean slate and a pre-defined double Array
	 * to hold each weight of each individual scores. For each score it gets
	 * multiplied by the current weightAverage number and the total gets summed onto
	 * the totalScore variable.
	 * 
	 * After the loop is finished, the totalScore gets multiplied according to the
	 * competitor's level of expierance. Finally restirct the total number to 2d.p.
	 * to avoid any screen clutter.
	 * 
	 * @return Double.valueOf(String.format("%.2f", totalScore));
	 */
	public double getOverallScore() {
		double totalScore = 0;
		double[] weightedAverage = { 0.2, 0.3, 0.4, 0.5, 0.6 };

		for (int i = 0; i < scores.length; i++) {
			totalScore += scores[i] * weightedAverage[i];
		}

		if (this.level.equals("Beginner")) {
			totalScore = totalScore * 0.2;
		} else if (this.level.equals("Novice")) {
			totalScore = totalScore * 0.5;
		} else if (this.level.equals("Veteran")) {
			totalScore = totalScore * 0.8;
		} else if (this.level.equals("Expert")) {
			totalScore = totalScore * 1;
		}
//		System.out.println(totalScore);
		return Double.valueOf(String.format("%.2f", totalScore));
	}

	/**
	 * Method to get a sentence using the competitors full details. This is obtained
	 * by first separating the scores individually and inserting them into a String
	 * called scoresStrings while adding "," and the end of every score. Then remove
	 * the last "," from the scoresString to be more grammatically correct.
	 * 
	 * @return "Competitor Number " + this.getCompetitorNumber() + ", name " +
	 *         this.getCompetitorName().getFullName() + ".\n" +
	 *         competitorName.getFirstName() + " is a/an " + this.getLevel() + "
	 *         aged " + this.getAge() + " and received these scores: " +
	 *         scoresStrings + ".\nThis gives him an overall score of " +
	 *         this.getOverallScore() + ".\n"
	 */
	public String getFullDetails() {
		String scoresStrings = "";
		for (int i = 0; i < scores.length; i++) {
			scoresStrings += scores[i] + ",";
		}
		scoresStrings = scoresStrings.substring(0, scoresStrings.length() - 1);
		return "Competitor Number " + this.getCompetitorNumber() + ", name " + this.getCompetitorName().getFullName()
				+ ".\n" + competitorName.getFirstName() + " is a/an " + this.getLevel() + " aged " + this.getAge()
				+ " and received these scores: " + scoresStrings + ".\nThis gives him an overall score of "
				+ this.getOverallScore() + ".\n";
	}

	/**
	 * Method to get a sentence using the competitors initial details as well as
	 * their overall score.
	 * 
	 * @return "CN " + this.getCompetitorNumber() + " (" +
	 *         Name.getInitials(this.getCompetitorName()) + ") has overall score " +
	 *         this.getOverallScore() + ".";
	 */
	public String getShortDetails() {
		return "CN " + this.getCompetitorNumber() + " (" + Name.getInitials(this.getCompetitorName())
				+ ") has overall score " + this.getOverallScore() + ".";
	}

	// Overloaded constructor
	/**
	 * Constructor to create a Competitor object with the given parameters.
	 * 
	 * @param competitorNum
	 * @param competitorNam
	 * @param lvl
	 * @param ag
	 * @param scrs
	 */
	public Competitor(int competitorNum, Name competitorNam, String lvl, int ag, int scrs[]) {
		this.competitorNumber = competitorNum;
		this.competitorName = competitorNam;
		this.level = lvl;
		this.age = ag;
		this.scores = scrs;
	}

}
