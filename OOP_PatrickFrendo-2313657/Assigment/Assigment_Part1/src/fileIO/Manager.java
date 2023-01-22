/**
 * 
 */
package fileIO;

import java.io.*;
import java.util.*;

import competitors.Competitor;
import competitors.Name;

/**
 * @author patrickFrendo
 *
 */
public class Manager {
	// Attribute of CompetitorList
	private CompetitorList competitors;

	// Empty constructor that initializes competitorList
	public Manager() {
		competitors = new CompetitorList();
	}

	/**
	 * Method to obtain "fileName" attribute and use Scanner to search for the text
	 * file with the same name as the fileName. If it is not found an exception is
	 * triggered. If it is found the while loop is initialized and loops through
	 * every line in the text file. During this process if any errors occur a
	 * RuntimeException triggers.
	 * 
	 * Each line is split whenever the "," is found and placed each text and/or
	 * number in their respective variable. If a letter is found in a section where
	 * a number was expected then a exception is triggered. If not the next check is
	 * initiated on each competitor and if a competitor is found who is less than 15
	 * years old, an error message is triggered but still keeps the system running
	 * as intended. The minor is removed from the system and the report will not
	 * save their details.
	 * 
	 * Finally the details of the eligible competitors are stored in an object
	 * called competitor and the object is added onto the competitors.add() in the
	 * ArrayList found in competitorList.java.
	 * 
	 * @param fileName
	 */
	public void readFile(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String[] partsOfALine = scanner.nextLine().split(",");
				int competitorNumber = Integer.parseInt(partsOfALine[0].trim());
				String firstName = partsOfALine[1].trim();
				String lastName = partsOfALine[2].trim();
				Name competitorName = new Name(firstName, lastName);
				String level = partsOfALine[3].trim();
				int age = Integer.parseInt(partsOfALine[4].trim());
				int[] scores = new int[partsOfALine.length - 5];
				for (int i = 0; i < scores.length; i++) {
					scores[i] = Integer.parseInt(partsOfALine[i + 5].trim());
				}
				if (age < 16) {
					System.err.println("Please be advised that " + firstName + " " + lastName
							+ " isn't eligible for the competition due to being a minor and so their details have been redacted.");
				} else {
					Competitor competitor = new Competitor(competitorNumber, competitorName, level, age, scores);
					competitors.add(competitor);
				}

			}
			scanner.close();

		} catch (FileNotFoundException ef) {
			System.err.println("The file " + fileName + " was not found!");
		} catch (NumberFormatException nex) {
			System.err.println(
					"There is a letter in a section where a number should be. Please, check the text file and try again.");
		} catch (RuntimeException rex) {
			System.err.println(
					"Something went wrong during the process. One thing is for certain it is not in regards having a letter misplaced in the text file.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method to output a short report as suggested in Part1 of OOP assignment. This
	 * is done by acquiring the name of the fileName and competitorNumber which was
	 * entered by console from user.
	 * 
	 * A for loop is used to print the full details of each competitor by using the
	 * method in the competitor.java class. After that the method will add a
	 * statement on who got the highest overall scores, which is obtained by finding
	 * who got the highest score using .getMax method in competitorList.java.Then
	 * use the getFullDetails from the competitor class to find out the details of
	 * the highest scorer competitor.
	 * 
	 * Then a section for Statistics which heavily uses the methods in the
	 * CompetitorList. Such methods include: ~getFrequency() ~getAverage()
	 * ~getMinScore()
	 * 
	 * Finally when the user enters a valid competitor number form the console, the
	 * system will add the short details of the selected competitor.
	 * 
	 * @param fileName
	 * @param competitorNumber
	 */
	public void writeReport(String fileName, int competitorNumber) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Competitors List\n");
			int count = 0;
			for (Competitor c : competitors.getList()) {
				fw.write(c.getFullDetails() + "\n");
				count++;
			}
			fw.write("\n");
			fw.write("The competitor with the highest overall score is:\n" + competitors.getMax().getFullDetails()
					+ "\n");
			fw.write("\n");
			fw.write("Statistics:\n");
			fw.write("There are " + count + " number of competitors.\n");
			fw.write("Average overall score: " + competitors.getAverage() + "\n");
			fw.write("Maximum overall score: " + competitors.getMaxScore() + "\n");
			fw.write("Minimum overall score: " + competitors.getMinScore() + "\n");
			String frequencyStrings = "";
			for (int i = 0; i < competitors.getFrequency().length; i++) {
				frequencyStrings += "\nAmount of competitors scored a " + i + " is: " + competitors.getFrequency()[i]
						+ ",";
			}
			frequencyStrings = frequencyStrings.substring(0, frequencyStrings.length() - 1);
			fw.write("\nFrequency of individual scores: " + frequencyStrings + "\n\n");
			fw.write(getShortDetailsFromPrompt(competitorNumber));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to acquire competitorNumber from the EntryPointCompetitor.java and
	 * search each competitor from the competitor ArrayList. The validation is done
	 * via a valid method in the CompetitorList.java
	 * 
	 * If competitor is found by their competitor number than the system returns the
	 * short details of the competitor. If not then a small warning will be sent as
	 * a string instead.
	 * 
	 * @param competitorNumber
	 * @return shortDetails
	 */
	public String getShortDetailsFromPrompt(int value) {
		String shortDetails;
		if (competitors.validate(value)) {
			shortDetails = "Short details for the searched " + value + ":\n"
					+ competitors.getDetails(value).getShortDetails();
		} else
			shortDetails = "Invalid competitor Number. Please enter a valid number.";
		return shortDetails;
	}

}
