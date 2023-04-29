package ass3_tests;

import ass2.Point;

import ass3.Block;
import ass3.Collidable;
import ass3.CollisionInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests ass3.CollisionInfo.
 */
public class TestCollisionInfo {
    private static Point collisionPoint;
    private static Collidable collidedWith;
    private static CollisionInfo collisionInfo;

    /**
     * Initialize collisionPoint, collidedWith and collisionInfo.
     */
    @BeforeEach
    public void init() {
        collisionPoint = new Point(80.0, 0.0);
        collidedWith = new Block(0.0, 0.0, 80.0, 40.0);
        collisionInfo = new CollisionInfo(collisionPoint, collidedWith);
    }

    /**
     * Tests ass3.CollisionInfo.collisionPoint.
     */
    @Test
    public void testCollisionPoint() {
        assertEquals(collisionPoint, collisionInfo.collisionPoint(), "Incorrect collision point.");
    }

    /**
     * Tests ass3.CollisionInfo.collisionObject.
     */
    @Test
    public void testCollisionObject() {
        assertEquals(collidedWith, collisionInfo.collisionObject(), "Incorrect collision object");
    }
}
