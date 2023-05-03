package game.sprites;

import game.Game;
import game.collision.Collidable;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import auxiliary.Velocity;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Represents a block.
 */
public class Block implements Collidable, Sprite {
    private final Rectangle outline;
    private final Color color;

    /**
     * Constructs a new Block object with the given outline and color.
     *
     * @param outline A Rectangle object representing the new blocks' outline
     * @param color A Color object representing the new blocks' color
     */
    public Block(Rectangle outline, Color color) {
        this.outline = outline;
        this.color = color;
    }

    /**
     * Constructs a new Block object with the given parameters.
     *
     * @param x      A double representing the blocks' outline upper left corner x-coordinate
     * @param y      A double representing the blocks' outline upper left corner y-coordinate
     * @param width  A double representing the blocks' outline width
     * @param height A double representing the blocks' outline height
     * @param color A Color object representing the blocks' color
     */
    public Block(double x, double y, double width, double height, Color color) {
        this(new Rectangle(x, y, width, height), color);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.outline;
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Line[] sides = this.outline.getSides();
        double dx = currentVelocity.getDx();
        if (sides[0].contains(collisionPoint) || sides[2].contains(collisionPoint)) {
            dx = -dx;
        }
        double dy = currentVelocity.getDy();
        if (sides[1].contains(collisionPoint) || sides[3].contains(collisionPoint)) {
            dy = -dy;
        }
        return new Velocity(dx, dy);
    }
    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) this.outline.getUpperLeft().getX();
        int y = (int) this.outline.getUpperLeft().getY();
        int width = (int) this.outline.getWidth();
        int height = (int) this.outline.getHeight();
        d.setColor(color);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, width, height);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
