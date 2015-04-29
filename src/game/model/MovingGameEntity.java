package game.model;

import game.math.Vector2D;

/**
 *
 * @author Hansen
 */
public abstract class MovingGameEntity extends GameEntity {
    Vector2D v2d;
    
    /**
     *  Initialize a moving game entity at (0,0) with a 0 vector.
     */
    public MovingGameEntity() {
        super();
        this.v2d = new Vector2D();
    } 
    
    /**
     * Initialize a moving game entity at (x,y) with a 0 vector.
     *
     * @param v2d
     */
    public MovingGameEntity(double x, double y) {
        super(x,y);
        this.v2d = new Vector2D();
    }
    
    public Vector2D getV2d() {
        return v2d;
    }

    public void setV2d(Vector2D v2d) {
        this.v2d = v2d;
    }
    
    public double getSpeed() {
        return v2d.magnitude();
    }
}
