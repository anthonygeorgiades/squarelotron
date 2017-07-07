package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSquarelotronInt() {
		Squarelotron testing = new Squarelotron(3);
		assertEquals(3,testing.size);
		assertEquals(testing.squarelotron[1][1], 5);
		assertNotEquals(testing.squarelotron[0][2], 9);
		testing = new Squarelotron(4);
		assertEquals(testing.squarelotron[0][0], 1);
		assertNotEquals(testing.squarelotron[2][2], 7);
	}

	@Test
	public void testSquarelotronIntArray() {	
		int[] array ={1, 2, 3, 4};
		Squarelotron testing = new Squarelotron(array);
		assertEquals(testing.squarelotron[0][0], 1);
		assertEquals(testing.squarelotron[0][1], 2);
		assertEquals(testing.squarelotron[1][0], 3);
		assertEquals(testing.squarelotron[1][1], 4);
		int[] array2 ={11, 15, 8, 24, 36, 22, 2, 9, 10};
		testing = new Squarelotron(array2);
		assertEquals(testing.squarelotron[0][0], 11);
		assertEquals(testing.squarelotron[0][1], 15);
		assertEquals(testing.squarelotron[0][2], 8);
		assertEquals(testing.squarelotron[1][0], 24);
		assertEquals(testing.squarelotron[1][1], 36);
		assertEquals(testing.squarelotron[1][2], 22);
		assertEquals(testing.squarelotron[2][0], 2);
		assertEquals(testing.squarelotron[2][1], 9);
		assertEquals(testing.squarelotron[2][2], 10);
	}

	//@Test
	//public void testMakeSquarelotron() {
		//fail("Not yet implemented");
		//static, do not test???
	//}

	@Test
	public void testNumbers() {
		Squarelotron testingSquare = new Squarelotron(3);
		testingSquare.squarelotron[0][0] = 1;
		testingSquare.squarelotron[0][1] = 2;
		testingSquare.squarelotron[0][2] = 3;
		testingSquare.squarelotron[1][0] = 4;
		testingSquare.squarelotron[1][1] = 5;
		testingSquare.squarelotron[1][2] = 6;
		testingSquare.squarelotron[2][0] = 7;
		testingSquare.squarelotron[2][1] = 8;
		testingSquare.squarelotron[2][2] = 9;
		int[] arrayActual = testingSquare.numbers();
		assertEquals(2, arrayActual[1]);
		assertEquals(9, arrayActual[8]);

	}

	@Test
	public void testUpsideDownFlip() {
		Squarelotron testingSquare1 = new Squarelotron(4);
		Squarelotron arrayActual = testingSquare1.upsideDownFlip(1);
		int[] retArray = arrayActual.numbers();
		assertEquals(13, retArray[0]);
		assertEquals(14, retArray[1]);
		assertEquals(15, retArray[2]);
		assertEquals(2, retArray[13]);
		assertEquals(3, retArray[14]);
		assertEquals(4, retArray[15]);
		Squarelotron testingSquare3 = new Squarelotron(5);
		arrayActual = testingSquare3.upsideDownFlip(2);
		retArray = arrayActual.numbers();
		assertEquals(21, retArray[20]);
		assertEquals(13, retArray[12]);
		Squarelotron testingSquare2 = new Squarelotron(3);
		arrayActual = testingSquare2.upsideDownFlip(1);
		retArray = arrayActual.numbers();
		assertEquals(2, retArray[7]);		
		assertEquals(7, retArray[0]);
		assertEquals(4, retArray[3]);
		assertEquals(5, retArray[4]);
		Squarelotron testingSquare = new Squarelotron(8);
		arrayActual = testingSquare.upsideDownFlip(3);
		retArray = arrayActual.numbers();
		assertEquals(28, retArray[27]);
		assertEquals(10, retArray[9]);
		assertEquals(1, retArray[0]);
		assertEquals(55, retArray[54]);
		assertEquals(28, retArray[27]);

		}

	@Test
	public void testLeftRightFlip() {
		Squarelotron testingSquare1 = new Squarelotron(4);
		Squarelotron arrayActual = testingSquare1.leftRightFlip(1);
		int[] retArray = arrayActual.numbers();
		assertEquals(4, retArray[0]);
		assertEquals(6, retArray[5]);
		assertEquals(10, retArray[9]);
		assertEquals(13, retArray[15]);
		Squarelotron testingSquare = new Squarelotron(8);
		arrayActual = testingSquare.leftRightFlip(3);
		retArray = arrayActual.numbers();
		assertEquals(10, retArray[9]);
		assertEquals(1, retArray[0]);
		assertEquals(55, retArray[54]);
		

		
	}

	@Test
	public void testInverseDiagonalFlip() {
		Squarelotron testingSquare1 = new Squarelotron(5);
		Squarelotron arrayActual = testingSquare1.inverseDiagonalFlip(1);
		int[] retArray = arrayActual.numbers();
		assertEquals(6, retArray[1]);
		assertEquals(11, retArray[2]);
		Squarelotron testingSquare2 = new Squarelotron(5);
		arrayActual = testingSquare2.inverseDiagonalFlip(2);
		retArray = arrayActual.numbers();
		assertEquals(12, retArray[7]);
		assertEquals(17, retArray[8]);
		assertEquals(8, retArray[11]);
	}

	@Test
	public void testMainDiagonalFlip() {
		Squarelotron testingSquare1 = new Squarelotron(4);
		Squarelotron arrayActual = testingSquare1.mainDiagonalFlip(1);
		int[] retArray = arrayActual.numbers();
		assertEquals(16, retArray[0]);
		assertEquals(14, retArray[8]);
		testingSquare1 = new Squarelotron(4);
		arrayActual = testingSquare1.mainDiagonalFlip(2);
		retArray = arrayActual.numbers();
		assertEquals(11, retArray[5]);
		assertEquals(6, retArray[10]);
		assertEquals(9, retArray[8]);
		testingSquare1 = new Squarelotron(5);
		arrayActual = testingSquare1.mainDiagonalFlip(2);
		retArray = arrayActual.numbers();
		assertEquals(19, retArray[6]);
		assertEquals(18, retArray[11]);
		assertEquals(9, retArray[8]);
	}

	@Test
	public void testSideFlip() {
		Squarelotron testingSquare = new Squarelotron(4);
		Squarelotron arrayActual = testingSquare.sideFlip("left");
		int[] retArray = arrayActual.numbers();
		assertEquals(2, retArray[0]);
		assertEquals(1, retArray[1]);
		assertEquals(3, retArray[2]);
		assertEquals(6, retArray[4]);
		assertEquals(5, retArray[5]);
		assertEquals(7, retArray[6]);
		Squarelotron testingSquare2 = new Squarelotron(4);
		arrayActual = testingSquare2.sideFlip("right");
		retArray = arrayActual.numbers();
		assertEquals(4, retArray[2]);
		assertEquals(8, retArray[6]);
		assertEquals(3, retArray[3]);
		Squarelotron testingSquare3 = new Squarelotron(4);
		arrayActual = testingSquare3.sideFlip("top");
		retArray = arrayActual.numbers();
		assertEquals(1, retArray[4]);
		assertEquals(2, retArray[5]);
		assertEquals(5, retArray[0]);
		Squarelotron testingSquare4 = new Squarelotron(4);
		arrayActual = testingSquare4.sideFlip("bottom");
		retArray = arrayActual.numbers();
		assertEquals(13, retArray[8]);
		assertEquals(15, retArray[10]);
		assertEquals(12, retArray[15]);
	}
	@Test
	public void testRotateRight() {
		Squarelotron testingSquare = new Squarelotron(3);
		testingSquare.rotateRight(1);
		int[] retArray = testingSquare.numbers();
		assertEquals(7, retArray[0]);
		assertEquals(4, retArray[1]);
		testingSquare = new Squarelotron(3);
		testingSquare.rotateRight(-1);
		retArray = testingSquare.numbers();
		assertEquals(3, retArray[0]);
		assertEquals(6, retArray[1]);
		testingSquare = new Squarelotron(4);
		testingSquare.rotateRight(1);
		retArray = testingSquare.numbers();
		assertEquals(13, retArray[0]);
		assertEquals(9, retArray[1]);
	}
	
	
	@Test
	
	public void testEquals() {	
		Squarelotron testingSquare = new Squarelotron(2);
		int[] array ={1, 2, 3, 4};
		Squarelotron testing = new Squarelotron(array);
		Squarelotron test2 = new Squarelotron(array);
		assertEquals(testing.equals(test2), true);
		assertEquals(test2.equals(testing), true);
		int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Squarelotron test3 = new Squarelotron(array2);
		assertEquals(test2.equals(test3), false);
		assertArrayEquals(test2.squarelotron, testing.squarelotron);
		
		
	}
	
	
	@Test
	public void testtoString(){
		int[] array ={1, 2, 3, 4};
		Squarelotron testing = new Squarelotron(array);
		System.out.println(testing.toString());
		String str = "";
		str = "[1][2]\n[3][4]";
		
	}
}

