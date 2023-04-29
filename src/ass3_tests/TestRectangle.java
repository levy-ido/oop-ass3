package ass3_tests;

import ass2.Line;
import ass2.Point;

import ass3.Rectangle;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests ass3.Rectangle.
 */
public class TestRectangle {
    private static Point upperLeft;
    private static Rectangle rectangle;

    /**
     * Initializing upperLeft and rectangle.
     */
    @BeforeEach
    public void init() {
        upperLeft = new Point(0.0, 0.0);
        rectangle = new Rectangle(upperLeft, 80.0, 40.0);
    }

    /**
     * Tests ass3.Rectangle.intersectionPoints.
     */
    @Test
    public void testIntersectionPoints() {
        Line line = new Line(0.0, 0.0, 80.0, 40.0);
        List<Point> list = rectangle.intersectionPoints(line);
        assertEquals(2, list.size(), "Incorrect number of intersection points.");
    }

    /**
     * Tests ass3.Rectangle.getWidth.
     */
    @Test
    public void testGetWidth() {
        assertEquals(80.0, rectangle.getWidth(), "Incorrect width.");
    }

    /**
     * Tests ass3.Rectangle.getHeight.
     */
    @Test
    public void testGetHeight() {
        assertEquals(40.0, rectangle.getHeight(), "Incorrect height.");
    }

    /**
     * Tests ass3.Rectangle.getUpperLeft.
     */
    @Test
    public void testGetUpperLeft() {
        assertEquals(upperLeft, rectangle.getUpperLeft(), "Incorrect upper left.");
    }

    /**
     * Tests ass2.Line.closestIntersectionToStartOfLine.
     */
    @Test
    public void testClosestIntersectionToStartOfLine() {
        Line line = new Line(-10.0, 20.0, 90.0, 20.0);
        Point actual = line.closestIntersectionToStartOfLine(rectangle);
        Point expected = new Point(0.0, 20.0);
        assertEquals(expected, actual, "Wrong closest intersection to start of line.");
    }
}
