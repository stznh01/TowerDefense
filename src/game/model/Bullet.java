package game.model;

import game.math.Point2D;

/**
 * A bullet is created by a tower and will always hit an enemy through a 
 * predetermined pathway
 *
 * @author Hansen
 */
public class Bullet extends MovingGameEntity {
    private double speed;
    private final int damage;
    private final Enemy enemy;
    private boolean isDead;
    
    public Bullet(Point2D towerLoc, Enemy enemy) {
        damage = 5;
        speed = 2.0;
        this.enemy = enemy;
    }
    
    public void hitEnemy() {
        enemy.damageHealth(damage);
    }

    @Override
    public void update(int delta) {
    }

    @Override
    public void reset() {
        
    }
}
