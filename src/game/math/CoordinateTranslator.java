package game.math;
import java.awt.Point;

/**
 *
 * @author Hansen
 */

//screen refers to the screen on monitor where the virtual 2D world is rendered
//world refers to the 2D world using a real world unit
public class CoordinateTranslator {
    private static int screenWidth, screenHeight;
    private static double worldWidth, worldHeight;
    private static int vllx, vlly;
    private static double wrldScrnWidthRate, wrldScrnHeightRate;
    private double wx, wy;
    private int sx, sy;
    /**
     *
     * @param screenWidth width of displaying screen
     * @param screenHeight height of displaying screen
     * @param worldWidth width of game world
     * @param worldHeight height of game world
     * @param vllx the view's lower left corner x coordinate
     * @param vlly the view's lower left corner y coordinate
     */
    public CoordinateTranslator(int screenWidth, int screenHeight, double worldWidth, double worldHeight, int vllx, int vlly) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.vllx = vllx;
        this.vlly = vlly;
        //if screen is 0
        wrldScrnWidthRate = worldWidth/screenWidth;
        wrldScrnHeightRate = worldHeight/screenHeight;

    }
    
    /**
     * Returns the world coordinate of the screen coordinate 
     *
     * @param sx the screen coordinate x
     * @param sy the screen coordinate y
     * @return
     */
    public Point2D screenToWorld(int sx, int sy){
        wx = sx * wrldScrnWidthRate + vllx;
        wy = worldHeight + vlly - sy * wrldScrnHeightRate;
        return new Point2D(wx,wy);
    }

    /**
     *
     * @param p
     * @return
     */
    public Point2D screenToWorld(Point p){
        wx = wrldScrnWidthRate * p.getX() + vllx;
        wy = worldHeight + vlly - wrldScrnHeightRate * p.getY();
        return new Point2D(wx,wy);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Point worldToScreen(double wx, double wy){
        sx = (int)((wx - vllx)/wrldScrnWidthRate);
        sy = (int)((worldHeight - wy + vlly)/wrldScrnHeightRate);
        return new Point(sx,sy);
    }

    /**
     *
     * @param p
     * @return
     */
    public Point worldToScreen(Point2D p) {
        sx = (int)((p.getX() - vllx)/wrldScrnWidthRate);
        sy = (int)((worldHeight - p.getY() + vlly)/wrldScrnHeightRate);
        return new Point(sx,sy);
    }

    public static double getWrldScrnWidthRate() {
        return wrldScrnWidthRate;
    }

    public static double getWrldScrnHeightRate() {
        return wrldScrnHeightRate;
    }
    
}
