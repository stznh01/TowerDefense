package game.math;

/**
 * Vertex holds a reference to previous vertex
 *
 * @author Hansen
 */
public class Vertex {
    private Point2D point;
    private double minDistance = Double.POSITIVE_INFINITY;

    private double heuristicMinDistance = Double.POSITIVE_INFINITY;
    private Vertex previousVertex;
    public Vertex(Point2D p2d) {
        point = p2d;
    }
    
    public Point2D getPoint() {
        return point;
    }
    
    public void setPreviousVertex(Vertex v) {
        this.previousVertex = v;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double val) {
        this.minDistance = val;
    }

    public double getHeuristicMinDistance() {
        return heuristicMinDistance;
    }

    public void setHeuristicMinDistance(double val) {
        this.heuristicMinDistance = val;
    }
    

    public Vertex getPreviousVertex() {
        return previousVertex;
    }
    
    public boolean equals(Vertex other){
        return point.equals(other.getPoint());
    }
}
