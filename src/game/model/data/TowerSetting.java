package game.model.data;

/**
 *
 * @author Hansen
 */
public class TowerSetting extends Setting{
    private final int price;
    private final int damage;
    private final int range;
    private final int cooldown;
    private final String info;
    
    public TowerSetting(String TowerName, int price, int damage, int cooldown, int range, String info){
        super(TowerName);
        this.price = price;
        this.damage = damage;
        this.cooldown = cooldown;
        this.range = range;
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public int getDamage() {
        return damage;
    }
    
    public int getCooldown() {
        return cooldown;
    }
    
    public int getRange() {
        return range;
    }
    
    public String getInfo() {
        return info;
    }
}
