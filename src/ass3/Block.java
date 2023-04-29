package ass3;

import ass2.Line;
import ass2.Point;
import ass2.Velocity;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Objects;

/**
 * Represents a block.
 */
public class Block implements Collidable {
    private final Rectangle outline;

    /**
     * Constructs a new Block object with the given upper left corner, width and height.
     *
     * @param outline A Rectangle object representing this blocks' outline
     */
    public Block(Rectangle outline) {
        this.outline = outline;
    }

    /**
     * Constructs a new Block object with the given parameters.
     *
     * @param x      A double representing the blocks' outline upper left corner x-coordinate
     * @param y      A double representing the blocks' outline upper left corner y-coordinate
     * @param width  A double representing the blocks' outline width
     * @param height A double representing the blocks' outline height
     */
    public Block(double x, double y, double width, double height) {
        this(new Rectangle(x, y, width, height));
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.outline;
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Line[] sides = this.outline.getSides();
        double dx = currentVelocity.getDx();
        if (collisionPoint.isOnVerticalLine(sides[0]) || collisionPoint.isOnVerticalLine(sides[2])) {
            dx = -dx;
        }
        double dy = currentVelocity.getDy();
        if (collisionPoint.isOnHorizontalLine(sides[1]) || collisionPoint.isOnHorizontalLine(sides[3])) {
            dy = -dy;
        }
        return new Velocity(dx, dy);
    }

    /**
     * Compares this block with another block for equality.
     *
     * @param obj An Object representing a given block
     * @return true if the block are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Block other)) {
            return false;
        }
        return this.outline.equals(other.outline);
    }

    /**
     * Generates hash code for this block.
     *
     * @return An integer representing hash code for this block
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.outline);
    }

    /**
     * Draws this block on the given draw surface.
     *
     * @param drawSurface A DrawSurface object
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.PINK);
        Point upperLeft = this.outline.getUpperLeft();
        int x = (int) upperLeft.getX();
        int y = (int) upperLeft.getY();
        int width = (int) this.outline.getWidth();
        int height = (int) this.outline.getHeight();
        drawSurface.fillRectangle(x, y, width, height);
    }
}
