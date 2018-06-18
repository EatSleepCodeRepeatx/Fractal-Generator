package JUnit;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

import Model.BurningShip;
import Model.FractalCreation;
import Model.Julia;
import Model.Mandelbrot;
import Model.Multibrot;
import edu.buffalo.fractal.FractalPanel;

public class FractalCreationTest {

	@Test
	public void PointPlotAssignTest() {
		FractalCreation testPlotAssign = new FractalCreation();
		Point2D xyzX = new Point2D.Double();
		Point2D xyzY = new Point2D.Double();
		xyzX.setLocation(-2.15, 0.6);
		xyzY.setLocation(-1.3, 1.3);
		testPlotAssign.plotAssign(xyzX, xyzY);
		assertEquals(-2.15, testPlotAssign.getCoordinates()[0][0].getX(), .001);
		assertEquals(-1.3, testPlotAssign.getCoordinates()[0][0].getY(), .001);
		assertEquals(-2.15, testPlotAssign.getCoordinates()[0][4].getX(), .001);
		assertEquals(-1.2949, testPlotAssign.getCoordinates()[0][4].getY(), .001);
		assertEquals(-2.1446, testPlotAssign.getCoordinates()[4][0].getX(), .001);
		assertEquals(-1.3, testPlotAssign.getCoordinates()[4][0].getY(), .001);
		assertEquals(0.6, testPlotAssign.getCoordinates()[2047][2047].getX(), .001);
		assertEquals(1.3, testPlotAssign.getCoordinates()[2047][2047].getY(), .001);
	}

	@Test
	public final void createArrayTest() {
		FractalCreation dist = new FractalCreation();
		dist.createArray(512, 512);
		assertEquals("the length is 512", 512, dist.getCoordinates().length);
		assertEquals("the area is 262144", 262144, dist.getCoordinates().length * dist.getCoordinates().length);
	}

	@Test
	public void distanceTestWithPythag() {
		int xVal = 3;
		int yVal = 4;
		Point2D p = new Point2D.Double(xVal, yVal);
		FractalCreation dist = new FractalCreation();
		assertEquals(5.00, dist.distance(p), 0.001);
	}

	@Test
	public void distanceTestWith1() {
		int xVal = 1;
		int yVal = 1;
		Point2D p = new Point2D.Double(xVal, yVal);
		FractalCreation dist = new FractalCreation();
		assertEquals(1.41, dist.distance(p), 0.01);
	}

	@Test
	public void distanceTestWith0() {
		int xVal = 0;
		int yVal = 7;
		Point2D p = new Point2D.Double(xVal, yVal);
		FractalCreation dist = new FractalCreation();
		assertEquals(7.00, dist.distance(p), 0.001);
	}

	@Test
	public void testJuliaFractalPoints() {
		FractalCreation testPlotAssign = new FractalCreation();
		Point2D xyzX = new Point2D.Double();
		Point2D xyzY = new Point2D.Double();
		xyzX.setLocation(-1.7, 1.7);
		xyzY.setLocation(-1.0, 1.0);
		testPlotAssign.plotAssign(xyzX, xyzY);
		assertEquals(-1.7, testPlotAssign.getCoordinates()[0][0].getX(), .001);
		assertEquals(-1.0, testPlotAssign.getCoordinates()[0][0].getY(), .001);
		assertEquals(-1.7, testPlotAssign.getCoordinates()[0][4].getX(), .001);
		assertEquals(-0.996, testPlotAssign.getCoordinates()[0][4].getY(), .001);
		assertEquals(-1.693359, testPlotAssign.getCoordinates()[4][0].getX(), .001);
		assertEquals(-1, testPlotAssign.getCoordinates()[4][0].getY(), .001);
		assertEquals(1.7, testPlotAssign.getCoordinates()[2047][2047].getX(), .001);
		assertEquals(1.0, testPlotAssign.getCoordinates()[2047][2047].getY(), .001);
	}

	@Test
	public void testMandelbrotFractalPoints() {
		Point2D xyzX = new Point2D.Double();
		Point2D xyzY = new Point2D.Double();
		xyzX.setLocation(-2.15, 0.6);
		xyzY.setLocation(-1.3, 1.3);
		Mandelbrot mand = new Mandelbrot(xyzX, xyzY,4,255,1, new FractalPanel());
		assertEquals(-2.15, mand.getCoordinates()[0][0].getX(), .001);
		assertEquals(-1.3, mand.getCoordinates()[0][0].getY(), .001);
		assertEquals(-2.15, mand.getCoordinates()[0][4].getX(), .001);
		assertEquals(-1.2949, mand.getCoordinates()[0][4].getY(), .001);
		assertEquals(-2.1446, mand.getCoordinates()[4][0].getX(), .001);
		assertEquals(-1.3, mand.getCoordinates()[4][0].getY(), .001);
		assertEquals(0.6, mand.getCoordinates()[2047][2047].getX(), .001);
		assertEquals(1.3, mand.getCoordinates()[2047][2047].getY(), .001);
	}

	@Test
	public void testBurningShipFractalPoints() {
		FractalCreation testPlotAssign = new FractalCreation();
		Point2D xyzX = new Point2D.Double();
		Point2D xyzY = new Point2D.Double();
		xyzX.setLocation(-1.8, 1.7);
		xyzY.setLocation(-0.08, 0.025);
		testPlotAssign.plotAssign(xyzX, xyzY);
		assertEquals(-1.8, testPlotAssign.getCoordinates()[0][0].getX(), .001);
		assertEquals(-0.08, testPlotAssign.getCoordinates()[0][0].getY(), .001);
		assertEquals(-1.8, testPlotAssign.getCoordinates()[0][4].getX(), .001);
		assertEquals(-0.07979, testPlotAssign.getCoordinates()[0][4].getY(), .001);
		assertEquals(-1.793, testPlotAssign.getCoordinates()[4][0].getX(), .001);
		assertEquals(-0.08, testPlotAssign.getCoordinates()[4][0].getY(), .001);
		assertEquals(1.7, testPlotAssign.getCoordinates()[2047][2047].getX(), .001);
		assertEquals(0.025, testPlotAssign.getCoordinates()[2047][2047].getY(), .001);
	}

	@Test
	public void testMultibrotFractalPoints() {
		FractalCreation testPlotAssign = new FractalCreation();
		Point2D xyzX = new Point2D.Double();
		Point2D xyzY = new Point2D.Double();
		xyzX.setLocation(-1, 1);
		xyzY.setLocation(-1.3, 1.3);
		testPlotAssign.plotAssign(xyzX, xyzY);
		assertEquals(-1, testPlotAssign.getCoordinates()[0][0].getX(), .001);
		assertEquals(-1.3, testPlotAssign.getCoordinates()[0][0].getY(), .001);
		assertEquals(-1, testPlotAssign.getCoordinates()[0][4].getX(), .001);
		assertEquals(-1.2949, testPlotAssign.getCoordinates()[0][4].getY(), .001);
		assertEquals(-.996, testPlotAssign.getCoordinates()[4][0].getX(), .001);
		assertEquals(-1.3, testPlotAssign.getCoordinates()[4][0].getY(), .001);
		assertEquals(1, testPlotAssign.getCoordinates()[2047][2047].getX(), .001);
		assertEquals(1.3, testPlotAssign.getCoordinates()[2047][2047].getY(), .001);
	}
}
