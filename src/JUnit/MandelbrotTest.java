package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;

import org.junit.Test;

import Model.BurningShip;
import Model.Julia;
import Model.Mandelbrot;
import edu.buffalo.fractal.FractalPanel;

public class MandelbrotTest {

	@Test
	public void testMandelbrotEquationWithPositives() {
		double x = 0.50;
		double y = 1.00;
		Point2D testPoint = new Point2D.Double(x, y);
		Point2D truPoint = new Point2D.Double(0.5, 1.00);
		Point2D testPoint1 =new Point2D.Double(0.00,0.00);
		Mandelbrot mand = new Mandelbrot();
		assertEquals(truPoint, mand.equation(testPoint1, testPoint));
	}

	@Test
	public void testMandelbrotEquationWithZero() {
		double x = 0.00;
		double y = 1.00;
		Point2D testPoint = new Point2D.Double(x, y);
		Point2D truPoint = new Point2D.Double(0.00, 1.00);
		Point2D testPoint1=new Point2D.Double(0.00,0.00);
		Mandelbrot mand = new Mandelbrot();
		assertEquals(truPoint, mand.equation(testPoint1, testPoint));
	}

	@Test
	public void testMandelbrotEquationWithNegatives() {
		double x = -1.00;
		double y = 1.00;
		Point2D testPoint = new Point2D.Double(x, y);
		Point2D truPoint = new Point2D.Double(-1.00, 1.00);
		Point2D testPoint1 = new Point2D.Double(0.00,0.00);
		Mandelbrot mand = new Mandelbrot();
		assertEquals(truPoint, mand.equation(testPoint1, testPoint));
	}

	@Test
	public void mandLoopingTestNeverEscapes() {
		Point2D p = new Point2D.Double(0.3207031250000001, -0.07109374999999386);
		Mandelbrot mand = new Mandelbrot();
		int escapeTime = mand.Looping(p);
		assertTrue(escapeTime >= 255);
	}

	@Test
	public void mandLoopingTestEscapesAfterFirst() {
		Point2D p = new Point2D.Double(0.5946289062500001, 1.2949218750000122);
		Mandelbrot mand = new Mandelbrot();
		int escapeTime = mand.Looping(p);
		assertTrue(escapeTime > 1);
	}
	@Test
	public void mandLoopingTestWhenEscapeDistenceIs3() {
		Point2D p = new Point2D.Double(0.46007827788650374, -0.3383561643835661);
		Mandelbrot mand = new Mandelbrot(3,255,1,new FractalPanel());
		int escapeTime = mand.Looping(p);
		assertEquals(10,escapeTime);
	}
	@Test
	public void mandLoopingTestEscapesDistenceIs2andMaxEscapeTimeIs135(){
		Point2D p=new Point2D.Double(0.3207031250000001, -0.07109374999999386);
		Mandelbrot mand = new Mandelbrot(2,135,1,new FractalPanel());
		int escapeTime = mand.Looping(p);
		assertEquals(135,escapeTime);
	}
}
