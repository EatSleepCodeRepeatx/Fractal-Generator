package Model;

import java.awt.geom.Point2D;
import edu.buffalo.fractal.FractalPanel;
import threading.ComputePool;
import threading.ComputePool.FractalWorker;

/**
 * Calculations required for all 4 fractal classes to use
 */
public class FractalCreation {
	/**
	 * both instance variables create empty 2D arrays.
	 */
	private Point2D[][] coordinates;
	/**
	 * An array that will contain calculated escape times.
	 */
	private int[][] escapeTimes;

	/**
	 * An array that will later contain workers/threads.
	 */
	private FractalWorker[] workers;

	/**
	 * for Plotter
	 */
	int startRow = 0;
	private int _maxEscapeTime = 255;
	private int _escapeDistence = 4;
	private int _threads = 1;
	private FractalPanel _fp;

	/**
	 * Calls createArray to create a 2048 by 2048 array. This method is used for
	 * testing purposes only.
	 * 
	 */
	public FractalCreation() {
		createArray(2048, 2048);
	}

	/**
	 * Calls createArray to create a 2048 by 2048 array, Calls PlotAssign to
	 * associate parts of the array with points based on the given X and Y
	 * ranges so that Plotter can add escape times later.
	 * 
	 * @param xRange
	 *            the range of x points that need to be covered in the
	 *            coordinate array
	 * @param yRange
	 *            the range of y points that need to be covered in the
	 *            coordinate array
	 */
	public FractalCreation(Point2D xRange, Point2D yRange, int escapeDistence, int maxEscapeTime, int threads,
			FractalPanel fp) {
		_escapeDistence = escapeDistence;
		_maxEscapeTime = maxEscapeTime;
		_threads = threads;
		_fp = fp;
		createArray(2048, 2048);
		plotAssign(xRange, yRange);
		threadCreator();

	}

	/**
	 * Creates coordinate and escapetime arrays of desired size.
	 * 
	 * @param x
	 *            number of rows to be in the array
	 * @param y
	 *            number of columns to be in the array
	 *
	 */
	public void createArray(int x, int y) {
		coordinates = new Point2D[x][y];
		escapeTimes = new int[x][y];
	}

	/**
	 * uses a point and determines the distance between that point and (0,0).
	 * uses pythagorean theorem to find the distance from a given point to the
	 * origin
	 * 
	 * @param p1
	 *            point that is an unknown distance from (0,0)
	 * @return the distance from p1 to the origin as a double
	 */
	public double distance(Point2D p1) {
		double x = p1.getX();
		double y = p1.getY();
		double dist = Math.sqrt((x * x) + (y * y)); // using pythag. thm. to
		return dist; // find dist. from (0,0)
	}

	/**
	 * Loops to calculate escape time of a fractal using *.equation() (
	 * *overridden from a given fractal class) and distance().
	 * 
	 * @param p
	 *            2D starting point to input into *.equation()
	 * @return escape time for a given point. this value will effect the looks
	 *         of a pixel in the final fractal.
	 */

	public int Looping(Point2D p) {
		Point2D p1 = new Point2D.Double(0, 0);
		p1.setLocation(p);
		double dist = distance(p1);
		int passes = 0;
		while ((dist <= _escapeDistence && passes < _maxEscapeTime)) {
			p1 = equation(p1, p);
			passes++;
			dist = distance(p1);
		}
		int escapetime = passes;
		return escapetime;
	}

	/**
	 * exists only so that equation method from other classes can override it.
	 * should never be actually used.
	 * 
	 * @param p
	 * @param p2
	 * 
	 * @return null
	 */
	public Point2D equation(Point2D p, Point2D p2) {
		return null;
	}

	/**
	 * Assigns 2D points to the coordinates array. Essentially
	 * scaling/stretching the given X and Y ranges to perfectly fill the size of
	 * our array.
	 * 
	 * @param xRange
	 *            a 2D point in the form (minimum X value, maximum X value).
	 * @param yRange
	 *            a 2D point in the form (minimum Y value, maximum Y value).
	 */
	public void plotAssign(Point2D xRange, Point2D yRange) {
		double xMin = xRange.getX();
		double xMax = xRange.getY();
		double yMin = yRange.getX();
		double yMax = yRange.getY();
		double xRangeInc = (xMax - xMin) / 2048;
		double yRangeInc = (yMax - yMin) / 2048;
		double xCurr = 0;
		double yCurr = 0;
		// a bunch of local variable with names to make code easier to read
		for (int x = 0; x < coordinates.length; x++) {
			xCurr = xMin + x * (xRangeInc);
			for (int y = 0; y < coordinates[0].length; y++) {
				yCurr = yMin + y * (yRangeInc);
				Point2D currPoint = new Point2D.Double();
				currPoint.setLocation(xCurr, yCurr);
				coordinates[x][y] = currPoint;
			}
			yCurr = 0;
		}

	}

	/**
	 * activates loop() for points in the coordinates array
	 */
	public int[][] Plotter(int startRow, int rowsResponsible) {
		int endRow = startRow + rowsResponsible; // ending row
		int[][] retVal = new int[rowsResponsible][2048];
		int k = 0;
		for (int i = startRow; i < endRow; i++) { // rows

			for (int j = 0; j < coordinates[0].length; j++) { // columns
				// escapeTimes[i][j] = Looping(coordinates[i][j]);
				retVal[k][j] = Looping(coordinates[i][j]);

			} // close column for loop
			k = k + 1;
		} // close row for loop
		return retVal;
	}// close method

	/**
	 * thread creator method which creates an int amount of threads. which then
	 * calls generateFractal and each worker is assigned a number of rows
	 */
	public void threadCreator() {
		ComputePool cp = new ComputePool(this);
		cp.changePanel(_fp);
		workers = new FractalWorker[_threads];
		int rowsResponsible = 2048 / _threads;
		cp.generateFractal(rowsResponsible, workers);
	}

	/**
	 * getter method for the array of 2D point coordinates.
	 * 
	 * @return the array holding 2D Points that were output from equation method
	 */
	public Point2D[][] getCoordinates() {
		return coordinates;
	}

	/**
	 * getter for escapeTime array.
	 * 
	 * @return array full of escapetimes
	 */
	public int[][] getEscapeTimes() {
		return escapeTimes;
	}
}
