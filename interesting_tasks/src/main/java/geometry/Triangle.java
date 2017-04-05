package geometry;

public class Triangle {

    public static void main(String[] args) {
        Point point1 = new Point(2.3, 4.2);
        Point point2 = new Point(2.3, 5.7);
        Point point3 = new Point(5, 9);
        System.out.println(isTriangle(point1, point2, point3));
        System.out.println(getTriangleType(point1, point2, point3).toString());
    }

    public static TriangleType getTriangleType(Point p1, Point p2, Point p3) {
        Point vectorP1P2 = new Point(p2.x - p1.x, p2.y - p1.y);
        Point vectorP1P3 = new Point(p3.x - p1.x, p3.y - p1.y);
        Point vectorP2P1 = new Point(p1.x - p2.x, p1.y - p2.y);
        Point vectorP2P3 = new Point(p3.x - p2.x, p3.y - p2.y);
        Point vectorP3P1 = new Point(p1.x - p3.x, p1.y - p3.y);
        Point vectorP3P2 = new Point(p2.x - p3.x, p2.y - p3.y);

        double result = scalarProduct(vectorP1P2, vectorP1P3);
        result *= scalarProduct(vectorP2P1, vectorP2P3);
        result *= scalarProduct(vectorP3P1, vectorP3P2);

        if (result == 0) {
            return TriangleType.Right;
        } else if (result > 0) {
            return TriangleType.Acute;
        } else {
            return TriangleType.Obtuse;
        }
    }


    public static boolean isTriangle(Point p1, Point p2, Point p3) {
        Point vector1 = new Point(p2.x - p1.x, p2.y - p1.y);
        Point vector2 = new Point(p3.x - p2.x, p3.y - p2.y);
        double vectorProduct = vector1.x * vector2.y - vector2.x * vector1.y;
        return vectorProduct != 0;
    }

    private static double scalarProduct(Point p1, Point p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

    private enum TriangleType {
        Obtuse,
        Acute,
        Right
    }

    private static class Point {
        private final double x;
        private final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
