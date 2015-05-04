package game.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Hansen
 */
public class PathFinder {
    private final NavGraph navGraph;

    private final ArrayList<Edge> consideredEdgeList;
    private final ArrayList<Edge> pathEdgeList;
    private Vertex target;
    
    public PathFinder (NavGraph navGraph)
    {
        this.navGraph = navGraph;
        consideredEdgeList = new ArrayList<>();
        pathEdgeList = new ArrayList<>();
    }
    
    public void generatePath(Point2D from, Point2D to)
    {
        this.consideredEdgeList.clear();
        Vertex fromVertex = new Vertex(from);
        Vertex toVertex = new Vertex(to);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        fromVertex.setMinDistance(0);
        priorityQueue.add(fromVertex);
        Vertex currentVertex, nextVertex;
        while(!priorityQueue.isEmpty())
        {
            currentVertex = priorityQueue.poll();
            this.target = currentVertex;
            if (currentVertex.equals(toVertex))
            {
                this.target = currentVertex;
                break;
            }
            for (Point2D next : navGraph.getNeighbors(currentVertex.getPoint()))
            {
                consideredEdgeList.add(new Edge(currentVertex.getPoint(), next));
                nextVertex = new Vertex(next);
                double newDistance = currentVertex.getMinDistance() + getDistance(currentVertex, nextVertex);
                if(!this.isInPriorityQueue(priorityQueue, nextVertex) && newDistance < nextVertex.getMinDistance())
                {
                    priorityQueue.remove(nextVertex);
                    nextVertex.setMinDistance(newDistance);
                    nextVertex.setHeuristicMinDistance(newDistance + heuristic(nextVertex, toVertex));
                    priorityQueue.add(nextVertex);
                    nextVertex.setPreviousVertex(currentVertex);
                }
            }
        }
    }
    
    public void generatePathIgnoringObstacles(Point2D from, Point2D to)
    {
        this.consideredEdgeList.clear();
        Vertex fromVertex = new Vertex(from);
        Vertex toVertex = new Vertex(to);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        fromVertex.setMinDistance(0);
        priorityQueue.add(fromVertex);
        Vertex currentVertex, nextVertex;
        while(!priorityQueue.isEmpty())
        {
            currentVertex = priorityQueue.poll();
            this.target = currentVertex;
            if (currentVertex.equals(toVertex))
            {
                this.target = currentVertex;
                break;
            }
            for (Point2D next : navGraph.getAllNeighbors(currentVertex.getPoint()))
            {
                nextVertex = new Vertex(next);
                double newDistance = currentVertex.getMinDistance() 
                        + getDistance(currentVertex, nextVertex);
                if(!this.isInPriorityQueue(priorityQueue, nextVertex) &&
                        newDistance < nextVertex.getMinDistance())
                {
                    priorityQueue.remove(nextVertex);
                    nextVertex.setMinDistance(newDistance);
                    nextVertex.setHeuristicMinDistance(newDistance + heuristic(nextVertex, toVertex));
                    priorityQueue.add(nextVertex);
                    nextVertex.setPreviousVertex(currentVertex);
                }
            }
        }
    }
    
    public Iterable<Point2D> getPath()
    {
        ArrayList<Point2D> path = new ArrayList<>();
        for(Vertex vertex = this.target; vertex != null; vertex = vertex.getPreviousVertex()){
            Point2D p = vertex.getPoint();
            path.add(p);
        }
        Collections.reverse(path);
        this.pathEdgeList.clear();
        Point2D previousPoint = null;
        Point2D currentPoint;
        int i = 0;
        for(Point2D point : path)
        {
            currentPoint = point;
            if(i==0){
                previousPoint = currentPoint;
                i++;
            } else {
                pathEdgeList.add(new Edge(previousPoint, currentPoint));
                previousPoint = currentPoint;
            }
        }
        return path;
    }
    
    public ArrayList<Point2D> getPathArray()
    {
        ArrayList<Point2D> path = new ArrayList<>();
        for(Vertex vertex = this.target; vertex != null
                ; vertex = vertex.getPreviousVertex())
        {
            Point2D p = vertex.getPoint();
            path.add(p);
        }
        Collections.reverse(path);
        this.pathEdgeList.clear();
        Point2D previousPoint = null;
        Point2D currentPoint;
        int i = 0;
        for(Point2D point : path)
        {
            currentPoint = point;
            if(i==0){
                previousPoint = currentPoint;
                i++;
            } else {
                pathEdgeList.add(new Edge(previousPoint, currentPoint));
                previousPoint = currentPoint;
            }
        }
        return path;
    }
    
    public Iterable<Edge> getConsideredEdges()
    {
        return consideredEdgeList;
    }
    
    public Iterable<Edge> getPathEdges()
    {
        return this.pathEdgeList;
    }
    
    private double getDistance(Vertex a, Vertex b)
    {
        if((a.getPoint().getX() == b.getPoint().getX()) || (a.getPoint().getY() == b.getPoint().getY())){
            return 1;
        }
        return 1.414;
    }
    
    /**
     * Calculate the Manhattan Distance between point a and b
     * 
     * @param a
     * @param b
     * @return 
     */
    private double heuristic(Vertex a, Vertex b)
    {
        return Math.abs(a.getPoint().getX()-b.getPoint().getX()) + Math.abs(a.getPoint().getY()-b.getPoint().getY());
    }
    
    /**
     * Calculate the Euclidian Distance between point a and b
     * 
     * @param a
     * @param b
     * @return 
     */
    private double heuristic2(Vertex a, Vertex b)
    {
        double x = a.getPoint().getX()-b.getPoint().getX();
        double y = a.getPoint().getY()-b.getPoint().getY();
        return x*x + y*y;
    }
    
    private boolean isInPriorityQueue(PriorityQueue frontier, Vertex vertex)
    {
        Vertex[] vertexArray = (Vertex[]) frontier.toArray(new Vertex[0]);
        for (Vertex vertexArray1 : vertexArray) {
            if (vertexArray1.equals(vertex)) {
                return true;
            }
        }
        return false;
    }
    
    public void clear()
    {
        this.consideredEdgeList.clear();
        this.pathEdgeList.clear();
    }
    
    public Vertex getTarget() {
        return this.target;
    }
    
    public NavGraph getNavGraph()
    {
        return this.navGraph;
    }

}
