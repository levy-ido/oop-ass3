package ass3;

import ass2.Line;
import ass2.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the games' environment. Holds a collection of environments' collidables.
 */
public class GameEnvironment {
    private final List<Collidable> collidables;

    /**
     * Constructs a new GameEnvironment object.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Adds the given collidable to this game environment.
     *
     * @param c A Collidable object representing a given collidable
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Assuming an object is moving from trajectorys' start to trajectorys' end returns the closest point of collision
     * between the object and this game environments' collidables.
     *
     * @param trajectory A Line object representing the objects' trajectory
     * @return A CollisionInfo object holding information about the closest point of collision between the object and
     * this game environments' collidables. If there are no collision points on the given trajectory returns null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double minDistance = Double.POSITIVE_INFINITY;
        CollisionInfo minCollisionInfo = null;
        for (Collidable collidable : this.collidables) {
            Rectangle outline = collidable.getCollisionRectangle();
            Point closestIntersection = trajectory.closestIntersectionToStartOfLine(outline);
            if (closestIntersection == null) {
                continue;
            }
            double distance = trajectory.start().distance(closestIntersection);
            if (distance < minDistance) {
                minCollisionInfo = new CollisionInfo(closestIntersection, collidable);
                minDistance = distance;
            }
        }
        return minCollisionInfo;
    }

    /**
     * Returns this game environments' collidables.
     *
     * @return A List of Collidables
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

}
