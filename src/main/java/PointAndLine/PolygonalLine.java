package PointAndLine;
import java.util.ArrayList;

public class PolygonalLine {
	ArrayList<Line> lines = new ArrayList<>();

	public double getLength() {
		double summLength = 0;
		for (Line el : lines) {
			summLength += el.getLength();
		}
		return summLength;
	}

	public void addPoint(Point pEnd) {
		Point pStart = lines.get(lines.size()-1).getEndPoint();
		lines.add(new Line(pStart, pEnd));
	}

	public void setPoints(ArrayList<Line> lines) {
		this.lines = lines;
	}

}
