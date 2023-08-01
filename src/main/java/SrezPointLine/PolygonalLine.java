package SrezPointLine;

import java.util.ArrayList;

public class PolygonalLine {

	ArrayList<Point> pointList = new ArrayList<>();

	public void setPoints(Point[] points) {
		ArrayList<Point> pointList = new ArrayList<>();
		for (Point point : points) {
			pointList.add(point);
		}
		this.pointList = pointList;
	}

	public void addPoint(Point point) {
		pointList.add(point);
	}

	public void addPoint(double x, double y) {
		pointList.add(new Point(x, y));
	}

	public double getLength() {
		double length = 0;
		for(int i = 0; i<pointList.size()-1; i++) {
			length += (pointList.get(i)).getLength(pointList.get(i+1));
		}
		
		return length;
	}

}
