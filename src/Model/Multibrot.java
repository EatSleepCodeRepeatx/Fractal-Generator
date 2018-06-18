package Model;

import java.awt.geom.Point2D;

import View.Viewer;
import edu.buffalo.fractal.FractalPanel;

/**
 * This class holds code specific to creation of the Multibrot fractal
 */

public class Multibrot extends FractalCreation {
	/**
	 * _xRange is the range of X-Coordinates
	 * 
	 *_yRange is the range of Y-Coordinates
	 */
	private static Point2D _xRange=new Point2D.Double(-1,1);
	private static Point2D _yRange=new Point2D.Double(-1.3,1.3);
	
	public Multibrot() {
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
	public Multibrot(Point2D xRange, Point2D yRange,int escapeDistence, int maxEscapeTime, int threads,FractalPanel  fp) {
		super(xRange, yRange, escapeDistence, maxEscapeTime, threads,fp);
	}

	public Multibrot(int escapeDistence, int maxEscapeTime,int threads,FractalPanel  fp) {
		super(_xRange,_yRange,escapeDistence, maxEscapeTime, threads,fp);
	}

	/**
	 * take in a 2D point and output another 2D point. rules:
	 * <p>
	 * x' = x³ - (3 * x * y²) + current point's x-coordinate; y' = (3 * x² * y)
	 * - y³ + current point's y-coordinate
	 * 
	 * @param poi
	 *            the current 2D point being referenced in the array
	 * @return retpoi new point achieved by running the x and y values of poi
	 *         through the calculations above
	 */
	@Override
	public Point2D equation(Point2D p1,Point2D p2) {
		double x = p1.getX();
		double y = p1.getY();
		double xNew = Math.pow(x, 3) - (3 * x * Math.pow(y, 2)) + p2.getX();
		double yNew = (3 * Math.pow(x, 2) * y) - Math.pow(y, 3) + p2.getY();
		Point2D retpoi = new Point2D.Double(xNew, yNew);
		return retpoi;
	}
}
