package game.model.dataParser;

import game.model.data.Setting;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.ini4j.Ini;

/**
 *
 * @author Hansen
 */
public abstract class ParamReader {
    protected Ini ini;
    protected ArrayList<Setting> settingsList;
    
    public ParamReader(String fileName) throws IOException{
        ini = new Ini(new FileReader(fileName));
        this.settingsList = new ArrayList<Setting>();
    }
    public Setting getSetting(int i){
        return this.settingsList.get(i);
    }
    protected abstract void loadData();
}
