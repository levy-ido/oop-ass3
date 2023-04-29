package ass2;

import java.util.Objects;

/**
 * Representing an objects' velocity.
 */
public class Velocity {
    private final double dx;
    private final double dy;

    /**
     * Constructs a new Velocity object with the given dx and dy values.
     *
     * @param dx A double representing the x-coordinate rate of change
     * @param dy A double representing the y-coordinate rate of change
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return A double representing this velocitys' x-coordinate rate of change
     */
    public double getDx() {
        return dx;
    }

    /**
     * @return A double representing this velocitys' y-coordinate rate of change
     */
    public double getDy() {
        return dy;
    }

    /**
     * Compares this velocity and a given velocity for equality.
     *
     * @param obj An Object representing a given velocity
     * @return true if this velocity equals the given velocity, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Velocity other)) {
            return false;
        }
        return Double.areEqual(this.dx, other.dx) && Double.areEqual(this.dy, other.dy);
    }

    /**
     * Generates hash code for this velocity.
     *
     * @return An integer representing the hash code for this velocity
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.dx, this.dy);
    }

    /**
     * Applies this velocity to a point.
     *
     * @param point A Point object to apply this velocity to
     * @return A new Point object representing the given points' location after applying this velocity to it
     */
    public Point applyToPoint(Point point) {
        return new Point(point.getX() + this.dx, point.getY() + this.dy);
    }
}