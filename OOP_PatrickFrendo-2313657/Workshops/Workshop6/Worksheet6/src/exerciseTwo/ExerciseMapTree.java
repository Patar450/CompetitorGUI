/**
 * 
 */
package exerciseTwo;

import java.util.*;

/**
 * @author patar450
 *
 */
public class ExerciseMapTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a treemap with key = name (String) and value = phone (String)
		TreeMap<String, String> phoneBook1 = new TreeMap<String, String>();
		// add a few key/value pairs
		phoneBook1.put("Tim", "411-0914");
		phoneBook1.put("Jo", "411-0210");
		phoneBook1.put("Jack", "131-9873");
		phoneBook1.put("Ann", "411-0210"); // jo and ann share a phone
		// get a value (phone) for a given key (name)
		String phoneNumber = phoneBook1.get("Jack");
		System.out.println("Jack's number is " + phoneNumber);
		System.out.println();
		// use the TreeMap toString method to print the entries
		System.out.println(phoneBook1);
		System.out.println();

		// Exercises:
		// Write code to print out the size of the phone book
		System.out.println("The size of the phone book: " + phoneBook1.size());

		// Write code to remove Jack from the phone book, then check if someone with the
		// name “Jack” is in the phone book
		String removed = phoneBook1.remove("Jack");
		// To check if Jack got removed
		boolean phoneBookSearch = phoneBook1.containsKey(removed);
		System.out.println("The following person called " + removed + " was found?\t" + phoneBookSearch);

		// Write code to empty the phone book of all entries, then check to see if it is
		// empty.
//				phoneBook1.clear();
//				boolean isPhoneBookEmpty = phoneBook1.isEmpty();
//				System.out.println("Is the phone book empty? "+isPhoneBookEmpty);

		// Write code to see if the number “011-9999” is stored in the phone book
		boolean phoneNumberSearch = phoneBook1.containsValue("011-9999");
		System.out.println("Has the phone number been found? " + phoneNumberSearch);

	}

}
