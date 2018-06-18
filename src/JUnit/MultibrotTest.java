package JUnit;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

import Model.Julia;
import Model.Multibrot;
import edu.buffalo.fractal.FractalPanel;

public class MultibrotTest {

	@Test
	public void testMultibrotEquationWithPositives() {
		Multibrot m = new Multibrot();
		Point2D p1 = new Point2D.Double(0.1, 0.1);
		double x = m.equation(p1, p1).getX();
		double y = m.equation(p1, p1).getY();
		double act = 0.001;
		assertEquals(0.098, x, act);
		assertEquals(0.102, y, act);
	}

	@Test
	public void testMultibrotEquationWith2Negatives() {
		Multibrot m = new Multibrot();
		Point2D p1 = new Point2D.Double(-0.8, -1.2);
		double x = m.equation(p1, p1).getX();
		double y = m.equation(p1, p1).getY();
		double act = 0.001;
		assertEquals(2.144, x, act);
		assertEquals(-1.776, y, act);
	}

	@Test
	public void testMultibrotEquationWith1Negative() {
		Multibrot m = new Multibrot();
		Point2D p1 = new Point2D.Double(0.9, -0.23);
		double x = m.equation(p1, p1).getX();
		double y = m.equation(p1, p1).getY();
		double act = 0.001;
		assertEquals(1.48617, x, act);
		assertEquals(-0.776733, y, act);
	}
	public void multiLoopingTestNeverEscapes() {
		Point2D p = new Point2D.Double(0.5859375, 0.24375000000000108);
		Multibrot mult = new Multibrot();
		assertTrue(mult.Looping(p) >= 255);
	}

	@Test
	public void multiLoopingTestEscapesAfterFirst() {
		Point2D p = new Point2D.Double(0.9921875, 1.05625);
		Multibrot mult = new Multibrot();
		assertTrue(mult.Looping(p) > 1);
	}
	@Test
	public void multiLoopingTestWhenEscapeDistenceIs3() {
		Point2D p = new Point2D.Double(0.7025440313111545, -0.5520547945205528);
		Multibrot mult = new Multibrot(3,255,1,new FractalPanel());
		int escapeTime = mult.Looping(p);
		assertEquals(10,escapeTime);
	}
	@Test
	public void multLoopingTestEscapesDistenceIs2andMaxEscapeTimeIs135(){
		Point2D p=new Point2D.Double(0.5859375, 0.24375000000000108);
		Multibrot mult = new Multibrot(2,135,1,new FractalPanel());
		int escapeTime = mult.Looping(p);
		assertEquals(135,escapeTime);
}}
