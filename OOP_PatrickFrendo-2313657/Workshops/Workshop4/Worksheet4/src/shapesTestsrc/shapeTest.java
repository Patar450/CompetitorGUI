/**
 * 
 */
package shapesTestsrc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapes.*;

/**
 * @author patar450
 *
 */
class shapeTest {
	
	AllShapes shapes = new AllShapes();
	Rectangle r1;
	Rectangle r2;
	Rectangle r3;
	RtAngleTriangle t1;
	Circle c1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		r1 = new Rectangle ("red", 2,3);
		shapes.add(r1);

		r2 = new Rectangle ("red", 2,3);
		shapes.add (r2);	

		r3 = new Rectangle ("green", 2,3);
		shapes.add (r3);

		t1 = new RtAngleTriangle ("red", 2,4);
		shapes.add(t1);

		c1 = new Circle ("green", 4);
		shapes.add(c1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		r1 = null;
		r2 = null;
		r3 = null;
		t1 = null;
		c1 = null;
	}

	@Test
	void testSameShapeCheck() {

		assertEquals(r1.getColour(), r2.getColour());
		assertEquals(r1.getLength(), r2.getLength());
		assertEquals(r1.getWidth(), r2.getWidth());
	}

	@Test
	void testSameShapeDifferentColor() {
		assertNotEquals(r2.getColour(), r3.getColour());
		assertEquals(r2.getLength(), r3.getLength());
		assertEquals(r2.getWidth(), r3.getWidth());
	}

	@Test
	void testSetBaseValue() {
		//	t1.setBase(2.22); <-- only accepts int??
		assertEquals(t1.getBase(), 4);
	}

	@Test
	void testShapeArrayList() {
		assertEquals(c1.getColour(), shapes.getShape(4).getColour());
		assertEquals(c1.getArea(), shapes.getShape(4).getArea());
	}

}
