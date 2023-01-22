/**
 * 
 */
package exerciseThreeTestsrc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exerciseThree.Car;
import exerciseThree.CarList;

/**
 * @author patar450
 *
 */
class CarTest {
	CarList carList = new CarList();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		carList.populate();
}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		carList = null;
	}

	@Test
	public void testSortByRegNum() {

//		   carList.sortByRegNum();
//		    String expectedRegNum = "N315 JNS";
//		    String actualRegNum = carList.getCarByIndex(0).getRegNum();
//		    assertEquals(expectedRegNum, actualRegNum);
        
        
    }

}
