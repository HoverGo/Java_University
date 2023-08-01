package PointAndLine;

public class Line {
	
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public double getLength() {
		return p1.getDistance(p2);
	};

	public boolean hasPoint(Point p) {
		int x = p.getX();
		int y = p.getY();
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();
		return ((( x1 - x ) / ( x1 - x2 )) == (( y1 - y ) / ( y1 - y2 )) && (( x1 - x ) * ( x2 - x ) < 0));
	};

	public Point getStartPoint() {
		return p1;
	};

	public Point getEndPoint() {
		return p2;
	};
	
	public String toString() {
		return p1.toString() + ", " + p2.toString();
	}

}