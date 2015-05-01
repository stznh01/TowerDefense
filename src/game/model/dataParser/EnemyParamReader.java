package game.model.dataParser;

import game.model.data.EnemySetting;
import java.io.IOException;
import org.ini4j.Profile.Section;

/**
 *
 * @author Hansen
 */
public class EnemyParamReader extends ParamReader {
    
    public EnemyParamReader(String Filename) throws IOException {
        super(Filename);
        this.loadData();
    }
    
    @Override
    protected void loadData(){
        String enemyName;
        int health;
        double speed;
        int armor;
        String info;
        
        for(String sectionName : ini.keySet())
        {
            Section section = ini.get(sectionName);
            for (Object key : section.keySet()) {
                enemyName = sectionName;
                health = section.get("health", int.class);
                speed = section.get("speed", double.class);
                armor = section.get("armor", int.class);
                info = section.get("info", String.class);
                this.settingsList.add(new EnemySetting(enemyName, health, speed, armor, info));
            }
        }
    }
}
