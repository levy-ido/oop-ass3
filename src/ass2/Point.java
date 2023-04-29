package ass2;

import java.util.Objects;

/**
 * Represents a point in a two-dimensional coordinate system.
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Constructs a new Point object with the given x and y coordinates.
     *
     * @param x A double representing the x-coordinate of the new point
     * @param y A double representing the y-coordinate of the new point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between this point and a given other point.
     *
     * @param other A Point object representing the point to calculate the distance to
     * @return A double representing the distance from this point to the other point
     */
    public double distance(Point other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * @return A double representing the x-coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return A double representing the y-coordinate of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Compares this point with a given other point for equality. Two points are considered equal if their x and y
     * coordinates are exactly the same, up to a small difference.
     *
     * @param obj An Object representing the other point to compare to
     * @return true if the two points are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point other)) {
            return false;
        }
        return Double.areEqual(this.x, other.x) && Double.areEqual(this.y, other.y);
    }

    /**
     * Generates hash code for this point.
     *
     * @return An integer representing the hash code for this point
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    /**
     * Checks whether this point is on the given vertical line segment.
     *
     * @param verticalLine A Line object representing a vertical line segment
     * @return true if this point is on the given vertical line segment, false otherwise
     */
    public boolean isOnVerticalLine(Line verticalLine) {
        if (!Double.areEqual(this.x, verticalLine.start().x)) {
            return false;
        }
        return !(this.y < verticalLine.minY() || this.y > verticalLine.maxY());
    }

    /**
     * Checks whether this point is on the given horizontal line segment.
     *
     * @param horizontalLine A Line object representing a horizontal line segment
     * @return true if this point is on the given horizontal line segment, false otherwise
     */
    public boolean isOnHorizontalLine(Line horizontalLine) {
        if (!Double.areEqual(this.y, horizontalLine.start().y)) {
            return false;
        }
        return !(this.x < horizontalLine.minX() || this.x > horizontalLine.maxX());
    }
}