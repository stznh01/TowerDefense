package game.model;

import game.math.Point2D;

/**
 * The prototype for enemy
 *
 * @author Hansen
 */
public class Enemy extends MovingGameEntity {
    private static int MAXHEALTH;
    private int health;
    private double speed;
    private double armor;
    private String info;
    private Point2D spawnpoint, destination;
    private boolean isDead = false;
    
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
    
    public Enemy armor(double armor)
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

    @Override
    public void update(int delta) {
        
    }

    @Override
    public void reset() {
        
    }
}
