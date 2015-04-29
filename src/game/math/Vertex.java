package game.math;

/**
 *
 * @author Hansen
 */
public class Vertex {
    private Point2D point;
    public Vertex(Point2D p2d) {
        point = p2d;
    }

    public Point2D getPoint() {
        return point;
    }
    
    public boolean equals(Vertex other){
        return point.equals(other.getPoint());
    }
}
