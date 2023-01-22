package competitors;

/**
 * @author patrickFrendo
 *
 */

public abstract class Competitor {
	protected String competitionName;
	protected int competitorNumber;
	protected Name competitorName;
	protected String level;
	protected int age;
	protected int[] scores;

	// Getters
	public String getCompetitionName() {
		return competitionName;
	}
	
	public int getCompetitorNumber() {
		return competitorNumber;
	}

	public Name getName() {
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
	public void setCompetionName(String value) {
		this.competitionName = value;
	}
	
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
		this.age = value;
	}

	public void setScores(int[] value) {
		this.scores = value;
	}

	public abstract double getOverallScore();

	public String getShortDetails() {
		return "CN " + this.getCompetitorNumber() + " (" + Name.getInitials(competitorName)
		+ ") has overall score " + this.getOverallScore() + ".";
	}


	public String getFullDetails() {
		String scoresStrings = "";
		for (int i = 0; i < scores.length; i++) {
			scoresStrings += scores[i] + ",";
		}
		scoresStrings = scoresStrings.substring(0, scoresStrings.length() - 1);
		return "Competitor Number " + this.getCompetitorNumber() + ", name " + this.getName().getFullName()
				+ ".\n" + competitorName.getFirstName() + " is a/an " + this.getLevel() + " aged " + this.getAge()
				+ " and received these scores: " + scoresStrings + ".\nThis gives him an overall score of "
				+ this.getOverallScore() + ".\n";
	}

	public Competitor(String competitionN , int competitorNum, Name competitorNam, String lvl, int ag, int scrs[]) {
		this.competitionName = competitionN;
		this.competitorNumber = competitorNum;
		this.competitorName = competitorNam;
		this.level = lvl;
		this.age = ag;
		this.scores = scrs;
	}
}
