/**
 * 
 */
package week3Src;

import java.util.Iterator;
import java.util.List;

/**
 * @author patar450
 *
 */
public class entryPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create an owner object & set the name attributes only ...no cars have been
		// linked to this owner as yet
		Name owner1 = new Name();
		owner1.setFirstName("Alan");
//		owner1.setMiddleName("Mathson");
		owner1.setSurname("Turing");

		// Create a set of 5 cars and will link them to owner1.
		Car car1 = new Car("Mercedez Benz", 200, owner1, 0.33);
		Car car2 = new Car("Toyota Starlet", 150, owner1, 0.23);
		Car car3 = new Car("Mitsubishi Colt", 100, owner1, 0.88);
		Car car4 = new Car("MiniCooper", 200, owner1, 0.33);
		Car car5 = new Car("Ford Fiesta", 450, owner1, 0.33);

		// Create an array of cars whose size is the same as the array of cars in the
		// Name class
		int carArraySize = owner1.getOwnedCars().length;
		Car[] ownedCars = new Car[carArraySize];

		// Filling the array with the data of the cars created.
		ownedCars[0] = car1; // store the first car into the first location of the array
		ownedCars[1] = car2;
		ownedCars[2] = car3;
		ownedCars[3] = car4;
		ownedCars[4] = car5;

		// Set the array of ownedCars as the array of cars owned by the Name object
		owner1.setOwnedCars(ownedCars);
	     Car[] list = owner1.getOwnedCars();
		System.out.println(car1.getOwner());
		
        for (int i = 0; i <list.length; ++i) {
            System.out.println(list[i].getModel());
        }

		
	}

}
