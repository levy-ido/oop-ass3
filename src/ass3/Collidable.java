package ass3;

import ass2.Point;
import ass2.Velocity;

/**
 * Defines the behavior of collidable objects.
 */
public interface Collidable {
    /**
     * Returns a rectangle representing this collidable.
     *
     * @return A Rectangle object representing this collidable
     */
    Rectangle getCollisionRectangle();

    /**
     * Returns an updated velocity based on the given collision point and an objects' current velocity.
     *
     * @param collisionPoint  A Point object representing the collision point of the object and this collidable
     * @param currentVelocity A Velocity object representing the objects' velocity
     * @return A new Velocity object representing the updated velocity
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}