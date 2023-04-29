package ass3_tests;

import ass2.Point;
import ass2.Velocity;

import ass3.Block;
import ass3.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests ass3.Block.
 */
public class TestBlock {
    private static Point upperLeft;
    private static Rectangle outline;
    private static Block block;
    private static Velocity velocity;

    /**
     * Initializing upperLeft, outline, block and velocity.
     */
    @BeforeEach
    public void init() {
        upperLeft = new Point(0.0, 0.0);
        outline = new Rectangle(upperLeft, 80.0, 40.0);
        block = new Block(outline);
        velocity = new Velocity(2.0, 4.0);
    }
    /**
     * Tests ass3.Block.getCollisionRectangle.
     */
    @Test
    public void testGetCollisionRectangle() {
        assertEquals(outline, block.getCollisionRectangle(), "Wrong collision rectangle.");
    }

    /**
     * Tests ass3.Block.hit.
     */
    @Test
    public void testHit() {
        Velocity expected = new Velocity(-2.0, -4.0);
        Velocity actual = block.hit(upperLeft, velocity);
        assertEquals(expected, actual, "Incorrect velocity.");
    }
}
