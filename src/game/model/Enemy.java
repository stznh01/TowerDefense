package game.model;

import game.math.PathFinder;
import game.math.Point2D;

/**
 * The prototype for enemy. Initialize through method chaining
 *
 * @author Hansen
 */
public class Enemy extends MovingGameEntity {
    private static int MAXHEALTH;
    private int health;
    private double speed;
    private int armor;
    private String info;
    private Point2D spawnpoint, destination;
    private boolean isDead = false;
    private PathFinder pathfinder;
    
    public Enemy() {
    }
    
    
    public void damageHealth(int damage) {
        if (health <= damage) {
            health = 0;
            isDead = true;
        }
        health -= damage;
    }
    
    public Enemy speed(double speed)
    {
        this.speed = speed;
        return this;
    }
    
    public Enemy armor(int armor)
    {
        this.armor = armor;
        return this;
    }
    
    public Enemy health(int health)
    {
        this.MAXHEALTH = health;
        this.health = health;
        return this;
    }
    
    public Enemy info(String description)
    {
        this.info = description;
        return this;
    }
    
    public Enemy spawnpoint(Point2D spwnpt) {
        this.spawnpoint = spwnpt;
        return this;
    }
    
    public Enemy destination(Point2D goal) {
        this.destination = goal;
        return this;
    }
    
    public Enemy pathFinder(PathFinder pf) {
        this.pathfinder = pf;
        return this;
    }

    public boolean isDead() {
        return isDead;
    }
    

    @Override
    public void update(int delta) {
        
    }

    @Override
    public void reset() {
        
    }
}
