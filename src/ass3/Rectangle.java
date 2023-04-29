package ass3;

import ass2.Double;
import ass2.Point;
import ass2.Line;

import java.util.ArrayList;
import java.util.Objects;

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
     * Constructs a new Rectangle object with the given parameters.
     *
     * @param x      A double representing the rectangles' upper left corner x-coordinate
     * @param y      A double representing the rectangles' upper left corner y-coordinate
     * @param width  A double representing the rectangles' width
     * @param height A double representing the rectangles' height
     */
    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    /**
     * Returns this rectangles' upper right corner.
     *
     * @return A Point object representing this rectangles' upper right corner
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * Returns this rectangles' bottom right corner.
     *
     * @return A Point object representing this rectangles' bottom right corner
     */
    public Point getBottomRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Returns this rectangles' bottom left corner.
     *
     * @return A Point object representing this rectangles' bottom left corner
     */
    public Point getBottomLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * Returns a line segment representing this rectangles' left side.
     *
     * @return A Line object representing this rectangles' left side
     */
    public Line getLeftSide() {
        return new Line(this.upperLeft, this.getBottomLeft());
    }

    /**
     * Returns a line segment representing this rectangles' top side.
     *
     * @return A Line object representing this rectangles' top side
     */
    public Line getTopSide() {
        return new Line(this.upperLeft, this.getUpperRight());
    }

    /**
     * Returns a line segment representing this rectangles' right side.
     *
     * @return A Line object representing this rectangles' right side
     */
    public Line getRightSide() {
        return new Line(this.getUpperRight(), this.getBottomRight());
    }

    /**
     * Returns a line segment representing this rectangles' bottom side.
     *
     * @return A Line object representing this rectangles' bottom side
     */
    public Line getBottomSide() {
        return new Line(this.getBottomLeft(), this.getBottomRight());
    }

    /**
     * Returns an array whose elements are this rectangles' sides.
     *
     * @return A Line array representing this rectangles' sides
     */
    public Line[] getSides() {
        return new Line[]{this.getLeftSide(), this.getTopSide(), this.getRightSide(), this.getBottomSide()};
    }

    /**
     * Returns a list of intersection points between this rectangle and a given line segment.
     *
     * @param line A Line object representing the given line segment
     * @return A List of Points representing the list of intersection points between this rectangle and the given line
     * segment
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersectionPoints = new ArrayList<>();
        for (Line side : this.getSides()) {
            Point intersectionPoint = line.intersectionWith(side);
            if (intersectionPoint != null && !intersectionPoints.contains(intersectionPoint)) {
                intersectionPoints.add(intersectionPoint);
            }
        }
        return intersectionPoints;
    }

    /**
     * Returns this rectangles' width.
     *
     * @return A double representing this rectangles' width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns this rectangles' height.
     *
     * @return A double representing this rectangles' height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns this rectangles' upper left corner.
     *
     * @return A Point object representing this rectangles' upper left corner
     */
    public Point getUpperLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY());
    }

    /**
     * Compares this rectangle and a given rectangle for equality. Two rectangles are equal iff they have the same upper
     * left corner, width and height.
     *
     * @param obj An Object representing the given rectangle
     * @return true if this rectangle equals the given rectangle, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle other)) {
            return false;
        }
        boolean areUpperLeftsEqual = this.upperLeft.equals(other.upperLeft);
        boolean areWidthsEqual = Double.areEqual(this.width, other.width);
        boolean areHeightsEqual = Double.areEqual(this.height, other.height);
        return areUpperLeftsEqual && areWidthsEqual && areHeightsEqual;
    }

    /**
     * Generates hash code for this rectangle.
     *
     * @return An integer representing the hash code for this rectangle
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.upperLeft, this.width, this.height);
    }
}
