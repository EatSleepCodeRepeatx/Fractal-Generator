package JUnit;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import org.junit.Test;
import Model.BurningShip;
import Model.Julia;
import edu.buffalo.fractal.FractalPanel;

public class BurningShipTest {

	@Test
	public void EquationTest() {
		Point2D actual = new Point2D.Double(-1.75, 0.02);
		BurningShip bs = new BurningShip();
		double x = bs.equation(actual, actual).getX();
		double y = bs.equation(actual, actual).getY();
		double act = 0.01;
		assertEquals(1.3121, x, act);
		assertEquals(0.09000000000000001, y, act);
	}

	@Test
	public void EquationTestWith2Negatives() {
		Point2D actual = new Point2D.Double(-1.70, -0.08);
		BurningShip bs = new BurningShip();
		double x = bs.equation(actual, actual).getX();
		double y = bs.equation(actual, actual).getY();
		double act = 0.01;
		assertEquals(1.1836, x, act);
		assertEquals(0.192, y, act);
	}

	@Test
	public void escapeTimeis0or1Test() {
		BurningShip bs = new BurningShip();
		int[][] newArray = bs.getEscapeTimes();
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[0].length; j++) {
				assertTrue((newArray[i][j] != 0 || newArray[i][j] != 1));
			}
		}
	}
	@Test
	public void escapesTimeWhenEscapeDistenceIs3() {
		Point2D p = new Point2D.Double(-1.6999999999999802, 0.0030136986301371603);
		BurningShip bs = new BurningShip(3,255,1, new FractalPanel());
		int escapeTime = bs.Looping(p);
		assertEquals(10,escapeTime);
	}
	
	@Test
	public void burLoopingTestEscapesDistenceIs2andMaxEscapeTimeIs135(){
		Point2D p=new Point2D.Double(-1.7443359374999874, -0.017451171875000338);
		BurningShip bur = new BurningShip(2,135,1, new FractalPanel());
		int escapeTime = bur.Looping(p);
		assertEquals(135,escapeTime);
	}
}
