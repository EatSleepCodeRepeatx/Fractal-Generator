package Model;

import java.awt.geom.Point2D;

import View.Viewer;
import edu.buffalo.fractal.FractalPanel;

/**
 * This class holds code specific to creation of the BurningShip fractal
 */

public class BurningShip extends FractalCreation {
	/**
	 * _xRange is the range of X-Coordinates
	 * 
	 *_yRange is the range of Y-Coordinates
	 */
	private static Point2D _xRange=new Point2D.Double(-1.8,-1.7);
	private static Point2D _yRange=new Point2D.Double(-0.08,0.025);
	
	public BurningShip() {
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
	public BurningShip(Point2D xRange, Point2D yRange,int escapeDistence, int maxEscapeTime, int threads,FractalPanel  fp) {
		super(xRange, yRange, escapeDistence, maxEscapeTime, threads,fp);
	}

	public BurningShip(int escapeDistence, int maxEscapeTime,int threads,FractalPanel  fp) {
		super(_xRange,_yRange,escapeDistence, maxEscapeTime, threads,fp);
	}

	/**
	 * take in a 2D point and output another 2D point. rules:
	 * <p>
	 * x' = x² - y² + current point's x-coordinate
	 * <p>
	 * y' = Math.abs(2 * x * y) + current point's y-coordinate
	 * 
	 * @param poi
	 *            the current 2D point being referenced in the array
	 * @return newPoint new point achieved by running the x and y values of p
	 *         through the calculations above
	 */
	@Override
	public Point2D equation(Point2D p, Point2D p2 ) {
		double x = p.getX();
		double y = p.getY();
		
		double xNew = Math.pow(x, 2) - Math.pow(y, 2) + p2.getX();
		double yNew = Math.abs(2 * x * y) + p2.getY();
		Point2D newPoint = new Point2D.Double(xNew, yNew);
		return newPoint;
	}
}
