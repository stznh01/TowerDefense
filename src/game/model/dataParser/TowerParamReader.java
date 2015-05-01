package game.model.dataParser;

import game.model.data.TowerSetting;
import java.io.IOException;
import org.ini4j.Profile;

/**
 *
 * @author Hansen
 */
public class TowerParamReader extends ParamReader {

    public TowerParamReader(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    protected void loadData() {
        String towerName;
        int price;
        int damage;
        int cooldown;
        int range;
        String info;
        
        for(String sectionName : ini.keySet())
        {
            Profile.Section section = ini.get(sectionName);
            for (Object key : section.keySet()) {
                towerName = sectionName;
                price = section.get("price", int.class);
                damage = section.get("damage", int.class);
                cooldown = section.get("cooldown", int.class);
                range = section.get("range", int.class);
                info = section.get("info", String.class);
                this.settingsList.add(new TowerSetting(towerName, price, damage, cooldown, range, info));
            }
        }
    }
    
}
