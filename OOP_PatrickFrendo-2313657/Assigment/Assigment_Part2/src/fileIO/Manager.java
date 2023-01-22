/**
 * 
 */
package fileIO;

import java.io.*;
import java.util.*;

import competitors.Competitor;
import competitors.CyclingCompetitor;
import competitors.DancingCompetitor;
import competitors.Name;
import guiCode.GuiCompetitor;

/**
 * @author patrickFrendo
 *
 */
public class Manager {
	// Attribute of CompetitorList
	private CompetitorList cList;

	//To acquire the list of competitors objects. 
	public CompetitorList getCompetitorList() {
		return this.cList;
	}

	public ArrayList<Competitor> getCompetitors() {
		return cList.getList();
	}

	public Manager() {
		cList = new CompetitorList();
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
				String typeOfCompetition = partsOfALine[0].trim();

				int competitorNumber = Integer.parseInt(partsOfALine[1].trim());
				String firstName = partsOfALine[2].trim();
				String lastName = partsOfALine[3].trim();
				Name competitorName = new Name(firstName, lastName);
				String level = partsOfALine[4].trim();
				int age = Integer.parseInt(partsOfALine[5].trim());
				int[] scores = new int[partsOfALine.length - 7];
				for (int i = 0; i < scores.length; i++) {
					scores[i] = Integer.parseInt(partsOfALine[i + 7].trim());
				}
				if (typeOfCompetition.equals("Dancing")) {
					int minutesOfApplause = Integer.parseInt(partsOfALine[6].trim());
					DancingCompetitor competitor = new DancingCompetitor(typeOfCompetition, competitorNumber,
							competitorName, level, age, scores, minutesOfApplause);
					cList.add(competitor);
				} else if (typeOfCompetition.equals("Cycling")) {
					int timeInSeconds = Integer.parseInt(partsOfALine[6].trim());
					CyclingCompetitor competitor = new CyclingCompetitor(typeOfCompetition, competitorNumber,
							competitorName, level, age, scores, timeInSeconds);
					cList.add(competitor);
				} else if (typeOfCompetition.equals("Swimming")) {
					int timeInSeconds = Integer.parseInt(partsOfALine[6].trim());
					CyclingCompetitor competitor = new CyclingCompetitor(typeOfCompetition, competitorNumber,
							competitorName, level, age, scores, timeInSeconds);
					cList.add(competitor);
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
	 * Method to output a short report as suggested in Part2 of OOP assignment. 
	 * 
	 * A for loop is used to print the full details of each competitor by using the
	 * method in the competitor.java class. After that the method will add a
	 * statement on who got the highest overall scores, which is obtained by finding
	 * who got the highest score using .getMax method in competitorList.java.Then
	 * use the getFullDetails from the competitor class to find out the details of
	 * the highest scorer competitor.
	 * 
	 * @param fileName
	 */
	public void writeReport(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Table of Competitors:\n");
			for (Competitor c : cList.getList()) {
				fw.write(c.getShortDetails() + "\n");
			}
			fw.write("\n");
			fw.write("Competitor with the highest overall score: \n");
			fw.write(cList.getMax().getFullDetails() + "\n");
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
		if (cList.validate(value)) {
			shortDetails = "Short details for the searched " + value + ":\n"
					+ cList.getDetails(value).getShortDetails();
		} else
			shortDetails = "Invalid competitor Number. Please enter a valid number.";
		return shortDetails;
	}

	/**
	 * Method to check if the integer inputed by user matches with the competitor
	 * Number in the ArrayList. Uses a method from Validate to valid the numbers
	 * Existence and returns the validated competitor object.
	 * 
	 * @param value
	 * @return cList.getDetails(value);
	 * @return null;
	 */
	public Competitor competitorSearch(int value) {
		if (cList.validate(value)) {
			return cList.getDetails(value);
		}
		return null;
	}

}
