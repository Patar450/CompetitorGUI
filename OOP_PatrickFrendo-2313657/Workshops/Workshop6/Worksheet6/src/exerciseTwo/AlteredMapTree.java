/**
 * 
 */
package exerciseTwo;

import java.util.*;
import exerciseTwo.PersonTel;

/**
 * @author patar450
 *
 */
public class AlteredMapTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create PersonTel objects
		PersonTel tim = new PersonTel("Tim", "411-0914");
		PersonTel jo = new PersonTel("Jo", "411-0210");
		PersonTel jack = new PersonTel("Jack", "131-9873");
		PersonTel ann = new PersonTel("Ann", "411-0210"); // jo and ann share a phone

		// create a TreeMap with key = name (String) and value = PersonTel object
		TreeMap<String, PersonTel> phoneBook2 = new TreeMap<String, PersonTel>();

		// add PersonTel objects to the map
		phoneBook2.put("Tim", tim);
		phoneBook2.put("Jo", jo);
		phoneBook2.put("Jack", jack);
		phoneBook2.put("Ann", ann);

		// What happens if we add another entry for Tim?
		PersonTel newtim = new PersonTel("Tim", "123-4567");
		phoneBook2.put("Tim", newtim);
		// Since Tim already exists, due to the TreeMap not alowing duplicate keys,
		// the old tim will be replaced by the new tim.

		// Or remove the entry for Jack again?
		phoneBook2.remove("Jack");
		PersonTel removed = phoneBook2.remove("Jack");
		System.out.println("The result of Jack is: "+removed);
		//When attempting to remove Jack twice the result comes up as NULL. This is because the
		// key of "Jack" was not found. 

		//Might it be useful to load the keyset into a set to remove duplicates?
		Set<String> phoneBookNames = new HashSet<String>();
		phoneBookNames.addAll(phoneBook2.keySet());
		System.out.println("Using HashSet to remove duplicates from phonebook keysets. \nResult is:\t"+phoneBookNames);
		
		System.out.println(phoneBook2);
		System.out.println();
	}
}
