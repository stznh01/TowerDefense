package game.model;

import game.math.Point2D;

/**
 * The base model of any interactive entity in the game.
 *
 * @author Hansen
 */
public abstract class GameEntity {
    private Point2D p2d;
    
    public GameEntity() {
        this.p2d = new Point2D();
    }
    
    public GameEntity(double x, double y) {
        this.p2d = new Point2D(x, y);
    }

    public double getX() {
        return p2d.getX();
    }

    public void setX(double x) {
        p2d.setX(x);
    }

    public double getY() {
        return p2d.getY();
    }

    public void setY(double y) {
        p2d.setY(y);
    }
    
    protected Point2D getPoint2D() {
        return p2d;
    }
    
    public abstract void update(int delta);
    public abstract void reset();
}
