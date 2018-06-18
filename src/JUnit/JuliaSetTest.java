package JUnit;

import static org.junit.Assert.*;



import java.awt.geom.Point2D;

import org.junit.Test;

import Model.FractalCreation;
import Model.Julia;
import edu.buffalo.fractal.FractalPanel;

public class JuliaSetTest {

	@Test
	public void testJuliaEquationWithZero() {
		Julia j = new Julia();
		Point2D p1 = new Point2D.Double(0.0, 0.0);
		Point2D p2 = new Point2D.Double(-0.72689, 0.188887);
		Point2D p3 = j.equation(p1, p2);
		assertEquals(-0.72689, p3.getX(), .001);
		assertEquals(0.188887, p3.getY(), .001);
	}

	@Test
	public void testJuliaEquationWith2Negatives() {
		Julia j = new Julia();
		Point2D p1 = new Point2D.Double(-1.0, -1.0);
		Point2D p2 = j.equation(p1, p1);
		assertEquals(-0.72689, p2.getX(), .001);
		assertEquals(2.188887, p2.getY(), .001);
	}

	@Test
	public void testJuliaEquationWith2Positives() {
		Julia j = new Julia();
		Point2D p1 = new Point2D.Double(1.0, 1.0);
		Point2D p2 = j.equation(p1, p1);
		assertEquals(-0.72689, p2.getX(), .001);
		assertEquals(2.188887, p2.getY(), .001);
	}

	@Test
	public void julLoopingTestNeverEscapesWithNegative() {
		Point2D p = new Point2D.Double(1.0492187499999897, -0.234375);
		Julia jul = new Julia();
		int escapeTime = jul.Looping(p);
		assertTrue(escapeTime >= 255);
	}

	@Test
	public void julLoopingTestNeverEscapesWithPositive() {
		Point2D p = new Point2D.Double(1.6933593749999853, 0.9765625);
		Julia jul = new Julia();
		assertTrue(jul.Looping(p) <= 4);
		int escapeTime = jul.Looping(p);
		assertTrue(escapeTime <= 254);

	}

	@Test
	public void julLoopingTestEscapesAfterFirst() {
		Point2D p = new Point2D.Double(1.6933593749999853, 0.9765625);
		Julia jul = new Julia();
		int escapeTime = jul.Looping(p);
		assertTrue(escapeTime > 1);
	}
	@Test
	public void julLoopingTestEscapesWhenEscapeDistenceIs3() {
		Point2D p = new Point2D.Double(1.4538160469667272,-0.13502935420743645);
		Julia jul = new Julia(3,255,1, new FractalPanel());
		int escapeTime = jul.Looping(p);
		assertEquals(10,escapeTime);
	}
	@Test
	public void julLoopingTestEscapesDistenceIs2andMaxEscapeTimeIs135(){
		Point2D p=new Point2D.Double(1.0492187499999897, -0.234375);
		Julia jul = new Julia(2,135,1, new FractalPanel());
		int escapeTime = jul.Looping(p);
		assertEquals(135,escapeTime);
	}
}
