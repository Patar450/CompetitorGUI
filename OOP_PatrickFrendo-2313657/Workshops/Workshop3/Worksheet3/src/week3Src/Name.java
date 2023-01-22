/**
 * 
 */
package week3Src;

/**
 * @author patrickF
 * @version 24/10/2022
 *
 */
public class Name {
	// Attributes
	private String firstName;
	private String middleName;
	private String surname;
	// Up to 5 cars registered for the current name
	private Car[ ] ownedCars = new Car [5]; // attribute capable of storing up to 5 car objects for a Name


	// Constructors
	public Name() {
		// Empty Constructor
	}

	public Name(String firstNm, String middleNm, String lastNm, Car[] cars) {
		// Overloaded Constructor
		this.firstName = firstNm;
		this.middleName = middleNm;
		this.surname = lastNm;
		this.ownedCars = cars;
	}

	// Setters
	public void setFirstName(String value) {
		this.firstName = value;
	}

	public void setMiddleName(String value) {
		this.middleName = value;
	}

	public void setSurname(String value) {
		this.surname = value;
	}
	public void setOwnedCars(Car[] carValues) {
		this.ownedCars = carValues;
	}


	// Getters
	public String getFirstName() {
		return this.firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getSurname() {
		return this.surname;
	}
	public Car[] getOwnedCars() {
		return this.ownedCars;
	}

	// Methods
	/***
	 * Method to return the last name and firstname but with a comma in between.
	 * 
	 * @return this.surname, this.firstname
	 */
	public String getLastCommaFirst() {
		return this.surname + ", " + this.firstName;
	}

	/***
	 * Method to return the full name of the person.
	 * 
	 * @return this.firstname, this.middlename & this.surname;
	 */
	public String getFullName() {
		if (this.middleName != null) {
			return this.firstName + " " + this.middleName + " " + this.surname;
		} else {
			return getFirstAndLast();
		}

	}

	/***
	 * Method to return just the firstname and lastname.
	 * 
	 * @return this.firstname this.lastname
	 */
	public String getFirstAndLast() {
		return this.firstName + " " + this.surname;
	}

}
