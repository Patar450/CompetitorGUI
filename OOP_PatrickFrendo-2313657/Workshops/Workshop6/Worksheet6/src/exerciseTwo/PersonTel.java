/**
 * 
 */
package exerciseTwo;

/**
 * Class PersonTel is created as instructed in Exercise 10.
 * 
 * @author patar450
 *
 */
public class PersonTel {
	
	private String name;
	private String phone;

	public PersonTel(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}
	

	public String toString() {
		return name + ": " + phone;
	}
}
