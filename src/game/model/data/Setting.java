package game.model.data;

/**
 * A class that holds all attributes for a related object.
 * 
 * @author Hansen
 */
public class Setting {
    protected final String settingName;
    public Setting(String settingName){
        this.settingName = settingName;
    }
    public String getSettingName(){
        return this.settingName;
    }
}
