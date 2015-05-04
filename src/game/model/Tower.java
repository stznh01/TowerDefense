package game.model;

import java.util.PriorityQueue;

/**
 *
 * @author Hansen
 */
public class Tower extends StaticGameEntity {
    private int price;
    private int range;
    private int cooldown;
    private PriorityQueue<Enemy> targetList;
    
    public Tower() {
        
    }
    
    public void detectTarget(){
        // Will this be an expensive function
    }

    public int getPrice() {
        return price;
    }

    public int getRange() {
        return range;
    }

    @Override
    public void update(int delta) {
        
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
