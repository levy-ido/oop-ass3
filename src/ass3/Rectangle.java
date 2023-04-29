package ass3;

import ass2.Point;
import ass2.Line;

import java.util.ArrayList;

/**
 * Represents a rectangle.
 */
public class Rectangle {

    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Constructs a new Rectangle object with a given point, width and height.
     *
     * @param upperLeft A Point object representing the rectangles' upper left corner
     * @param width     A double representing the rectangles' width
     * @param height    A double representing the rectangles' height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns this rectangles' upper right corner.
     *
     * @return A Point object representing this rectangles' upper right corner
     */
    public Point upperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * Returns this rectangles' bottom right corner.
     *
     * @return A Point object representing this rectangles' bottom right corner
     */
    public Point bottomRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Returns this rectangles' bottom left corner.
     *
     * @return A Point object representing this rectangles' bottom left corner
     */
    public Point bottomLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * Returns a line segment representing this rectangles' left side.
     *
     * @return A Line object representing this rectangles' left side
     */
    public Line leftSide() {
        return new Line(this.upperLeft, this.bottomLeft());
    }

    /**
     * Returns a line segment representing this rectangles' top side.
     *
     * @return A Line object representing this rectangles' top side
     */
    public Line topSide() {
        return new Line(this.upperLeft, this.upperRight());
    }

    /**
     * Returns a line segment representing this rectangles' right side.
     *
     * @return A Line object representing this rectangles' right side
     */
    public Line rightSide() {
        return new Line(this.upperRight(), this.bottomRight());
    }

    /**
     * Returns a line segment representing this rectangles' bottom side.
     *
     * @return A Line object representing this rectangles' bottom side
     */
    public Line bottomSide() {
        return new Line(this.bottomLeft(), this.bottomRight());
    }

    /**
     * Returns an array whose elements are this rectangles' sides.
     *
     * @return A Line array representing this rectangles' sides
     */
    public Line[] sides() {
        return new Line[]{this.leftSide(), this.topSide(), this.rightSide(), this.bottomSide()};
    }

    /**
     * Returns a list of intersection points between this rectangle and a given line segment.
     *
     * @param line A Line object representing the given line segment
     * @return A List of Point representing the list of intersection points between this rectangle and the given line
     * segment
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> intersectionPoints = new ArrayList<>();
        for (Line side : this.sides()) {
            Point intersectionPoint = line.intersectionWith(side);
            if (intersectionPoint != null && !intersectionPoints.contains(intersectionPoint)) {
                intersectionPoints.add(intersectionPoint);
            }
        }
        return intersectionPoints;
    }

    /**
     * Returns this rectangles' width.
     * @return A double representing this rectangles' width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns this rectangles' height.
     * @return A double representing this rectangles' height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns this rectangles' upper left corner.
     * @return A Point object representing this rectangles' upper left corner
     */
    public Point getUpperLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY());
    }
}
