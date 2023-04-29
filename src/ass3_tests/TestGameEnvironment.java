package ass3_tests;

import ass2.Ball;
import ass2.Line;
import ass2.Point;
import ass2.Velocity;

import ass3.Block;
import ass3.CollisionInfo;
import ass3.GameEnvironment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests ass3.GameEnvironment.
 */
public class TestGameEnvironment {
    private static GameEnvironment gameEnvironment;

    /**
     * Initializes gameEnvironment.
     */
    @BeforeEach
    public void init() {
        gameEnvironment = new GameEnvironment();
    }

    /**
     * Tests ass3.GameEnvironment.addCollidable.
     */
    @Test
    public void testAddCollidable() {
        Block block = new Block(0.0, 0.0, 80.0, 40.0);
        gameEnvironment.addCollidable(block);
        assertTrue(gameEnvironment.getCollidables().contains(block), "Collidable addition failed.");
    }

    /**
     * Tests ass3.GameEnvironment.getClosestCollision.
     */
    @Test
    public void testGetClosestCollision() {
        Line trajectory = new Line(0.0, 0.0, 8.0, 8.0);
        assertNull(gameEnvironment.getClosestCollision(trajectory));
        gameEnvironment.addCollidable(new Block(6.0, 7.0, 3.0, 1.0));
        Block closestCollidable = new Block(0.0, 4.0, 4.0, 1.0);
        gameEnvironment.addCollidable(closestCollidable);
        gameEnvironment.addCollidable(new Block(5.0, 0.0, 10.0, 5.0));
        CollisionInfo expected = new CollisionInfo(new Point(4.0, 4.0), closestCollidable);
        CollisionInfo actual = gameEnvironment.getClosestCollision(trajectory);
        assertEquals(expected, actual, "Wrong closest collision.");
    }

    /**
     * Tests ass3.Ball.moveOneStep.
     */
    @Test
    public void testMoveOneStep() {
        Ball ball = new Ball(0.0, 0.0, 5, null);
        gameEnvironment.addCollidable(new Block(-5.0, 1.0, 10.0, 2.5));
        ball.setGameEnvironment(gameEnvironment);
        ball.setVelocity(0.0, 5.1);
        ball.moveOneStep();
        assertEquals(new Velocity(0.0, -5.1), ball.getVelocity(), "Collision mechanism malfunction.");
    }
}
