/**
 * @author patrickFrendo
 * @version 10/12/2022
 */
package fileIO;

public class EntryPointStudents {

	public static void main(String[] args) {
		
		//Creat an instance of studentList
		StudentList studentList = new StudentList();
		//Use readFile to read an external file called StudentList.csv
		studentList.readFile("StudentList.csv");
		
		//Create a String and add the list of students along with other details by using the methods in the StudentList.
		String report = studentList.getAllStudents()+"\n";
		report += "Number of students in total: " + studentList.getSize()+"\n";
		report += "Student at index 2: " + studentList.getAtIndex(2).getName().getFullName()+"\n";
		report += "Student with ID 1356: " + studentList.findById("1356").getName().getFullName()+"\n";
		report += "Number of students in year 2: " + studentList.getCountOfPeopleAtYear(2)+" students in total.\n";
		report += "Years frequency report: \n" + studentList.getYearsFrequencyReport()+"\n";
		
		//Use writeToFile to export the String into a txt file and call it StudentOut.txt.
		studentList.writeToFile("StudentOut.txt", report);
	}
}