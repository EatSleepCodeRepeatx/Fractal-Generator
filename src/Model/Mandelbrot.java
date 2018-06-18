package Model;

import java.awt.geom.Point2D;

import View.Viewer;
import edu.buffalo.fractal.FractalPanel;

/**
 * This class holds code specific to creation of the Mandelbrot fractal
 */

public class Mandelbrot extends FractalCreation {
	/**
	 * _xRange is the range of X-Coordinates
	 * 
	 *_yRange is the range of Y-Coordinates
	 */
	private static Point2D _xRange=new Point2D.Double(-2.15,.6);
	private static Point2D _yRange=new Point2D.Double(-1.3,1.3);
	

	public Mandelbrot() {
	}

	/**
	 * sends information to super constructor
	 * 
	 * @param xRange
	 *            the range of x points that need to be covered in the
	 *            coordinate array
	 * @param yRange
	 *            the range of y points that need to be covered in the
	 *            coordinate array
	 */
	
	public Mandelbrot(Point2D xRange, Point2D yRange,int escapeDistence, int maxEscapeTime, int threads,FractalPanel  fp) {
		super(xRange, yRange, escapeDistence, maxEscapeTime, threads,fp);
	}
	
	public Mandelbrot(int escapeDistence, int maxEscapeTime, int threads,FractalPanel  fp) {
		super(_xRange,_yRange,escapeDistence, maxEscapeTime , threads,fp);
	}

	/**
	 * take in a 2D point and output another 2D point. rules:
	 * <p>
	 * x' = x² - y² + current point's x-coordinate; y' = 2 * x * y + current
	 * point's y-coordinate
	 * 
	 * @param poi
	 *            the current 2D point being referenced in the array
	 * @return newPoint new point achieved by running the x and y values of poi
	 *         through the calculations above
	 */
	@Override
	public Point2D equation(Point2D poi,Point2D p2) {
		double a = poi.getX();
		double b = poi.getY();
		double xNew = (a * a) - (b * b) + p2.getX();
		double yNew = (2 * a * b) + p2.getY();
		Point2D newPoint = new Point2D.Double(xNew, yNew);
		return newPoint;
	}
}
