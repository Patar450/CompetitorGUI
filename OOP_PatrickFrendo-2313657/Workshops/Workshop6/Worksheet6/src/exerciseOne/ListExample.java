/**
 * 
 */
package exerciseOne;

import java.util.*;

/**
 * @author patar450
 *
 */
public class ListExample {

	public static void usingArrayList() {
		/***
		 * ArrayList is slower than the standard arrays but is useful in programs where
		 * lots of manipulation in the array is required. From the ArrayList we can add
		 * and remove items, which also having the functionality of resizing it.
		 */
		List list = new ArrayList();
		list.add("Bernadine");
		list.add("Elizabeth");
		list.add("Gene");
		list.add("Elizabeth");
		list.add("Clara");
		System.out.println(list);
		System.out.println("2: " + list.get(2));
		System.out.println("0: " + list.get(0));

	}
/***
 * LinkedList data structure is a linear data structure in which the items are stored in a
 * contiguous(linked) places and each element consist of a value and a pointer to the next item.
 * One of the disadvantages of linkedList is the problematic way of finding the nth item. This s due 
 * to the developer needing to count the list until it is found.
 */
	public static void usingLinkedList() {
		LinkedList queue = new LinkedList();
		queue.addFirst("Bernadine");
		queue.addFirst("Elizabeth");
		queue.addFirst("Gene");
		queue.addFirst("Elizabeth");
		queue.addFirst("Clara");
		System.out.println(queue);
		queue.removeLast();
		queue.removeLast();
		System.out.println(queue);
	}

	/**
	 * For testing purposes
	 * @param args
	 */
	public static void main(String args[]) {
		
		System.out.println("Use of ArrayList:");
		usingArrayList();
		System.out.println("\nUse of LinkedList:");
		usingLinkedList();

	}
}
