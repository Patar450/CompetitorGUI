/**
 * 
 */
package competitors;

/**
 * @author patar450
 *
 */
public class CyclingCompetitor extends Competitor {

	    private double time;

	    public CyclingCompetitor(String competitionName, int competitorNumber, Name competitorName, String level, int age,int scores[], double time) {
	        super(competitionName, competitorNumber, competitorName, level, age, scores);

	        this.time = time;
	    }
	    
	    public double getTime() {
			return time;
		}
		
		public void setTime(double value) {
			this.time = value;
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
//				System.out.println(totalScore);
			return Double.valueOf(String.format("%.2f", totalScore+time));
		
	    }
}
