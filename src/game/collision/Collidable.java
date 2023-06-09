package game.collision;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import auxiliary.Velocity;

/**
 * Defines the behavior of collidable objects.
 */
public interface Collidable {
    /**
     * Returns a rectangle representing this collidables' outline.
     *
     * @return A Rectangle object representing this collidables' outline
     */
    Rectangle getCollisionRectangle();

    /**
     * Returns an updated velocity based on a collision point and a collision velocity.
     *
     * @param collisionPoint  A Point object representing the collision point
     * @param currentVelocity A Velocity object representing the collision velocity
     * @return A new Velocity object representing the updated velocity
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}