package game.math;

/**
 * A class that holds a path between Point2D points.
 *
 * @author Hansen
 */
public class Edge {
    private final Point2D from;
    private final Point2D to;
    public Edge(Point2D from, Point2D to)
    {
        this.from = from;
        this.to = to;
    }
    public Point2D getFrom() {
        return from;
    }
    public Point2D getTo() {
        return to;
    }
}
