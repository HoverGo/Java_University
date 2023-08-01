package SrezPointLine;

public class Point {
	
    private double x;
    private double y;
    
   public Point(double x, double y) {
       this.x = x;
       this.y = y;
   }

   public double getX() {
       return this.x;
   }

   public double getY() {
       return this.y;
   }

	public double getLength(Point point) {
		double x2 = Math.pow((point.getX() - x), 2);
		double y2 = Math.pow((point.getY() - y), 2);
		double result = Math.sqrt(x2 + y2);
		return result;
	}

}
