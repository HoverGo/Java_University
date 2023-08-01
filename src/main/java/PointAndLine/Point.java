package PointAndLine;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	public double getDistance(Point p2) {
		// реализуйте метод getDistance
		double x2 = Math.pow((p2.getX() - x), 2);
		double y2 = Math.pow((p2.getY() - y), 2);
		double result = Math.sqrt((x2 + y2));
		System.out.println(result);
		return result;
	}

}
