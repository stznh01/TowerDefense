package game.main;

import game.math.CoordinateTranslator;
import game.model.dataParser.EnemyParamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Hansen
 */
public class Game extends BasicGame{
    private static Game instance;
    
    private EnemyParamReader enemyParamReader;
    
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    
    private TiledMap map;
    private CoordinateTranslator ct;
    
    private Game(String title)
    {
        super(title);
    }
    
    public static Game getInstance()
    {
        if(instance == null){
            instance = new Game("TowerDefense");
        }
        return instance;
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
            this.enemyParamReader = new EnemyParamReader("res/enemy.ini");
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
