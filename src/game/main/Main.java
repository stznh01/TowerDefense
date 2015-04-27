package game.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Hansen
 */
public class Main {     
    public static void main(String[] args) {
	try {
            AppGameContainer app = new AppGameContainer(Game.getInstance(), Game.WIDTH, Game.HEIGHT, false);
            app.start();
	} catch (SlickException e) {
            
	}
    }
}
