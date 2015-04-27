package game.main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Hansen
 */
public class Game extends BasicGame{
    private static Game instance;
    
    public static int WIDTH = 1024;
    public static int HEIGHT = 720;
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
