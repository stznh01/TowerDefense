package game.model.data;

/**
 *
 * @author Hansen
 */
public class EnemySetting extends Setting {
    private final int health;
    private final double speed;
    private final double armor;
    private final String info;
    
    public EnemySetting(String enemyName, int health, double speed, int armor, String info){
        super(enemyName);
        this.health = health;
        this.speed = speed;
        this.armor = armor;
        this.info = info;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }
    
    public double getArmor() {
        return armor;
    }
    
    public String getInfo() {
        return info;
    }
}
