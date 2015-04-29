package game.math;

import game.model.GameEntity;

public class IsCollide {
    /**
     * world coordinate
     * 
     * @param x1 x coor of first object
     * @param y1 y coor of first object
     * @param x2 x coor of second object
     * @param y2 y coor of second object
     * @return True if two object collides
     */
    public static boolean IsCollide(double x1, double y1, double x2, double y2){
        return Math.pow(1.0, 2) > Math.pow(x1-x2, 2) + Math.pow(y1-y2,2);
    }
    
    public static boolean IsCollide(Point2D p1, Point2D p2){
        return Math.pow(1.0, 2) > Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(),2);
    }
    
    public static boolean IsCollide(GameEntity e1, GameEntity e2){
        return Math.pow(1.0, 2) > Math.pow(e1.getX()-e2.getX(), 2) + Math.pow(e1.getY()-e2.getY(),2);
    }
}
