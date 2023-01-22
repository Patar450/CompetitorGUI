/***
 * @author  patrickF
 * @version 24/10/2022
 */
package week3Src;

public class Car {
	// instance variables

	private int tankSize;
	private String model;
	private double manfMPG;
	private Name ownerName;

	// constructor
	public Car(String model, int tank, Name owner, double mpg) {
		// Overloaded
		this.model = model;
		this.tankSize = tank;
		this.ownerName = owner;
		this.manfMPG = mpg;
	}

	// Setters
	// set value of model
	public void setModel(String value) {
		this.model = value;
	}

	// set value of model
	public void setTankSize(int value) {
		this.tankSize = value;
	}

	// set value of mpg
	public void setManfMPG(double value) {
		this.manfMPG = value;
	}

	// set value of ownerName
	public void setOwnerName(Name value) {
		this.ownerName = value;
	}
	// Getters

	// Return model
	public String getModel() {
		return this.model;
	}

	// Return tankSize
	public int getTankSize() {
		return this.tankSize;
	}

	// Return manfMPG
	public double getManfMPG() {
		return this.manfMPG;
	}

	// Return ownerName
	public Name getOwnerName() {
		return this.ownerName;
	}

	// Methods

	/***
	 * Method to check if the tank has the same size of Size.
	 * 
	 * @param size
	 * @return Inefficient fuel use
	 * @return Good fuel consumption
	 * @return Good fuel consumption
	 */
	public String tankBigger(int size) {
		if (this.tankSize > size) {
			return "Inefficient fuel use";
		} else if (this.tankSize < size) {
			return "Good fuel consumption";
		} else {
			return "Average consumer";
		}

	}

	public String getOwner() {

		return this.getOwnerName().getFullName();
	}

	// estimate distance car can travel
	public double estimateDistance() {
		// there are 0.22 gallons per litre
		double GPL = 0.22;
		return this.tankSize * this.manfMPG * GPL;
	}

}
