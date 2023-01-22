/**
 * 
 */
package competitors;

import java.util.Scanner;
import fileIO.Manager;
import fileIO.CompetitorList;

/**
 * @author patrickFrendo
 *
 */
public class EntryPointCompetitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Name competitor1Name = new Name("John", "Doe");
//		int[] scores1 = { 5, 4, 5, 4, 3 };
//		Competitor competitor1 = new Competitor(100, competitor1Name, "Novice", 25, scores1);
//		System.out.println(competitor1.getFullDetails());
//		System.out.println(competitor1.getShortDetails());
//
//		Name competitor2Name = new Name("Jane", "Smith");
//		int[] scores2 = { 3, 3, 3, 2, 4 };
//		Competitor competitor2 = new Competitor(101, competitor2Name, "Expert", 32, scores2);
//		System.out.println(competitor2.getFullDetails());
//		System.out.println(competitor2.getShortDetails());

		Manager man = new Manager();
		man.readFile("competitors.txt");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter competitor number:");
		int competitorNumber = scanner.nextInt();
		System.out.println(man.getShortDetailsFromPrompt(competitorNumber));
		while (man.getShortDetailsFromPrompt(competitorNumber) == "Invalid competitor Number. Please enter a valid number.") {
			competitorNumber = scanner.nextInt();
			System.out.println(man.getShortDetailsFromPrompt(competitorNumber));
		}
		man.writeReport("Report.txt",competitorNumber);
		scanner.close();
		

	}

}
