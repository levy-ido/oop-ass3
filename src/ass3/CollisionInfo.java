package ass3;

import ass2.Point;

import java.util.Objects;

/**
 * Represents a collision.
 */
public class CollisionInfo {
    private final Point collisionPoint;
    private final Collidable collidedWith;

    /**
     * Constructs a new CollisionInfo object with the given collision point and collidable.
     *
     * @param collisionPoint A Point object representing the point of collision
     * @param collidedWith   A Collidable representing the object the collision occured with
     */
    public CollisionInfo(Point collisionPoint, Collidable collidedWith) {
        this.collisionPoint = collisionPoint;
        this.collidedWith = collidedWith;
    }

    /**
     * Returns the collision point this collision information holds.
     *
     * @return A Point object representing the collision point this collision information holds
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Returns the collidable involved in the collision.
     *
     * @return A Collidable representing the collidable involved in the collision
     */
    public Collidable collisionObject() {
        return this.collidedWith;
    }

    /**
     * Compares this collision info and a given collision info for equality.
     *
     * @param obj An Object representing a given collision info
     * @return true if the collision infos are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CollisionInfo other)) {
            return false;
        }
        return this.collisionPoint.equals(other.collisionPoint) && this.collidedWith.equals(other.collidedWith);
    }

    /**
     * Generates hash code for this collision info.
     *
     * @return An integer representing the hash code for this collision info
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.collisionPoint, this.collidedWith);
    }
}
