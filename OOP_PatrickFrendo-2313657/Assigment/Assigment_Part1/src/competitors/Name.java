package competitors;

public class Name {
	// Attributes
	private String firstName;
	private String lastName;

	// constructor to create object with a first and last name
	public Name(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}

	// returns the first name
	public String getFirstName() {
		return firstName;
	}

	// returns the last name
	public String getLastName() {
		return lastName;
	}

	// change the first name to the value provided in the parameter
	public void setFirstName(String value) {
		firstName = value;
	}

	// change the last name to the value provided in the parameter
	public void setLastName(String value) {
		lastName = value;
	}

	// returns the first name then a space then the last name
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/***
	 * Method to get the fullname of the competitor and acquire the initials by
	 * splitting their names and use a for loop to get the first character of each
	 * name.
	 * 
	 * @param name
	 * @return intials.ToUpperCase()
	 */
	public static String getInitials(Name value) {
		String fullName = value.getFullName();
		String[] names = fullName.split(" ");
		String initials = "";

		for (String singleName : names) {
			initials += singleName.charAt(0);
		}
		return initials.toUpperCase().substring(0, 2);
	}

}