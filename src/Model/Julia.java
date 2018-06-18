package Model;

import java.awt.geom.Point2D;

import View.Viewer;
import edu.buffalo.fractal.FractalPanel;

/**
 * This class holds code specific to creation of the Julia fractal.
 */

public class Julia extends FractalCreation {

	/**
	 * _xRange is the range of valid X-Coordinates
	 * 
	 * _yRange is the range of valid Y-Coordinates
	 */
	private static Point2D _xRange = new Point2D.Double(-1.7, 1.7);
	private static Point2D _yRange = new Point2D.Double(-1.0, 1.0);

	/**
	 * empty constructor.
	 */
	public Julia() {

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
	 * @param escapeDistence
	 *            The escape distance inputted by the user, used in calculating
	 *            escape time
	 * 
	 * @param maxEscapeTime
	 *            the maximum escape time that is allowed, as inputted by user
	 * 
	 * @param mod
	 *            an instance of Model
	 * @param view
	 *            an instance of Viewer
	 * 
	 * 
	 */
	public Julia(Point2D xRange, Point2D yRange, int escapeDistence, int maxEscapeTime,int threads,FractalPanel  fp) {
		super(xRange, yRange, escapeDistence, maxEscapeTime, threads,fp);
	}

	/**
	 * sends information to super constructor
	 * 
	 * @param escapeDistence
	 *            The escape distance inputted by the user, used in calculating
	 *            escape time
	 * 
	 * @param maxEscapeTime
	 *            the maximum escape time that is allowed, as inputted by user
	 * 
	 * @param mod
	 *            an instance of Model
	 * @param view
	 *            an instance of Viewer
	 * 
	 */
	public Julia(int escapeDistence, int maxEscapeTime,int threads,FractalPanel  fp) {
		super(_xRange, _yRange, escapeDistence, maxEscapeTime, threads,fp);
	}

	/**
	 * take in a 2D point and output another 2D point. rules:
	 * <p>
	 * x' = x^2 - y^2 + -0.72689; y' = 2 * x * y + 0.188887
	 * 
	 * @param p
	 *            the current 2D point being referenced in the array
	 * @return newPoint New point achieved by running the x and y values of p
	 *         through the calculations above.
	 * 
	 */
	@Override
	public Point2D equation(Point2D p, Point2D p2) {
		Point2D newpoint = new Point2D.Double();
		double x1 = p.getX();
		double y1 = p.getY();

		double x2 = (x1 * x1) - (y1 * y1) - 0.72689;
		double y2 = 2 * x1 * y1 + 0.188887;
		newpoint.setLocation(x2, y2);
		return newpoint;
	}
}
