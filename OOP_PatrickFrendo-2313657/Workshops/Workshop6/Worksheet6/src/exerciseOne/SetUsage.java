/**
 * 
 */
package exerciseOne;

import java.util.*;

/**
 * @author patar450
 *
 */
public class SetUsage {
	/***
	 * A hash set is a collection that stores items 
	 * in an unordered manner, but allows for quick 
	 * access to items. 
	 * It does not allow duplicate items, which is 
	 * why Elizabeth doesn't show twice.
	 */
	public static void usingSets() {
		Set<String> set = new HashSet<String>();
		set.add("Bernadine");
		set.add("Elizabeth");
		set.add("Gene");
		set.add("Elizabeth");
		set.add("Clara");
		System.out.println(set);
		
		
	}
	/***
	 * A TreeSet is a collection that stores items in an ordered 
	 * manner. As with the HashSet the TreeSet will not allow duplicate 
	 * elements.The TreeSet uses an upside down tree structure to store
	 * the elements.
	 * 
	 * A SortedSet is an interface in the Java Collections Framework that
	 * adds to the Set interface. SortedSet specifies the elements into a 
	 * sorted ascending order.
	 */
	public static void sortedSets() {
		Set<String> sortedSet = new TreeSet<String>();
		sortedSet.add("Bernadine");
		sortedSet.add("Elizabeth");
		sortedSet.add("Gene");
		sortedSet.add("Elizabeth");
		sortedSet.add("Clara");
		System.out.println(sortedSet);
	}
	/**
	 * For testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Use of Sets(HashSet):");
		usingSets();
		System.out.println("\nUse of SortedSet(TreeSet):");
		sortedSets();
	}

}

