package ass2;

import ass3.Collidable;
import ass3.CollisionInfo;
import ass3.GameEnvironment;

import java.awt.Color;

import biuoop.DrawSurface;

/**
 * Represents a ball.
 */
public class Ball {
    private static final double TRAJECTORY_LENGTH = 100.0;
    private final int radius;
    private final Color color;
    private Point center;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Constructs a new Ball object with the given center, radius and color.
     *
     * @param center A point object representing the center of the ball
     * @param radius An integer representing the radius of the ball
     * @param color  Color object representing the color of the ball
     */
    public Ball(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Constructs a new Ball object with the given center coordinates, radius and color.
     *
     * @param x      A double representing the x-coordinate of the balls' center
     * @param y      A double representing the y-coordinate of the balls' center
     * @param radius An integer representing the radius of the ball
     * @param color  Color object representing the color of the ball
     */
    public Ball(double x, double y, int radius, Color color) {
        this(new Point(x, y), radius, color);
    }

    /**
     * Sets this balls' velocity to a given velocity.
     *
     * @param dx A double representing the x-coordinate rate of change
     * @param dy A double representing the y-coordinate rate of change
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Returns this balls' current trajectory.
     *
     * @return A Line object representing this balls' current trajectory
     */
    public Line computeTrajectory() {
        Vector trajectoryVector = new Vector(this.velocity.getDx(), this.velocity.getDy());
        double angle = trajectoryVector.angle();
        double x;
        if (Math.abs(angle) < Math.PI / 2) {
            x = this.center.getX() + TRAJECTORY_LENGTH * Math.cos(angle);
        } else {
            x = this.center.getX() - TRAJECTORY_LENGTH * Math.cos(angle);
        }
        double y = this.center.getY() + TRAJECTORY_LENGTH * Math.sin(angle);
        return new Line(this.center.getX(), this.center.getY(), x, y);
    }

    /**
     * Moves the ball one step based on its current position and velocity.
     * If the ball hits a boundary, its velocity is reversed in the corresponding direction.
     */
    public void moveOneStep() {
        Line trajectory = this.computeTrajectory();
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            Point collisionPoint = collisionInfo.collisionPoint();
            if (this.center.distance(collisionPoint) < this.radius) {
                Collidable collidedWith = collisionInfo.collisionObject();
                this.velocity = collidedWith.hit(collisionPoint, this.velocity);
            }
        }
        this.center = this.velocity.applyToPoint(this.center);
    }

    /**
     * Sets this balls' game environment to the given game environment.
     *
     * @param gameEnvironment A GameEnvironment object representing a given game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Returns this balls' velocity.
     *
     * @return A Velocity object representing this balls' velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Draws this Ball object on the given DrawSurface object.
     *
     * @param drawSurface A DrawSurface object
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(this.color);
        drawSurface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    /**
     * @return An integer representing the x-coordinate of the balls' center
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return An integer representing the y-coordinate of the balls' center
     */
    public int getY() {
        return (int) this.center.getY();
    }
}