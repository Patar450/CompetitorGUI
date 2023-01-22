/**
 * 
 */
package competitors;

/**
 * @author patrickFrendo
 *
 */
public class SwimmingCompetitor extends Competitor {
    private double strokes;

    public SwimmingCompetitor(String competitionName, int competitorNumber, Name competitorName, String level, int age,int scores[], double strokes) {
        super(competitionName, competitorNumber, competitorName, level, age, scores);
        this.strokes = strokes;
    }
    
    public double getStrokes() {
		return strokes;
	}
	
	public void setStrokes(double value) {
		this.strokes = value;
	}

    @Override
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
//			System.out.println(totalScore);
		return Double.valueOf(String.format("%.2f", totalScore+strokes));
    }
}
