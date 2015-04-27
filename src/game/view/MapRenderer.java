package game.view;
import game.main.Game;
import game.math.CoordinateTranslator;
import java.awt.Point;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Hansen
 */
public class MapRenderer {
    private TiledMap map;
    private double wx,wy;
    private int mapX, mapY;
    private final CoordinateTranslator ct;
    // the number of tile the map should start rendering
    private int sx, sy;
    // the number of pixel in the tile that map should start rendering
    private int tx, ty;
    private int dsx, dsy;
    private int plotX, plotY;
    
    private final int screenWidth, screenHeight, worldWidth, worldHeight;
    
    public MapRenderer(TiledMap map)
    {
        this.map = map;
        this.screenWidth = Game.WIDTH;
        this.screenHeight = Game.HEIGHT;
        this.worldWidth = map.getWidth();
        this.worldHeight = map.getHeight();
        ct = new CoordinateTranslator(screenWidth, screenHeight, worldWidth, worldHeight, 0, 0);
    }
    public void update(double worldX, double worldY) {
        this.wx = worldX;
        this.wy = worldY;
        Point mapCoor = ct.worldToScreen(wx, wy);
        mapX = mapCoor.x;
        mapY = mapCoor.y - screenHeight; //double check this line
        sx = mapX/32;
        sy = mapY/32;
        tx = mapX%32;
        ty = mapY%32;
        plotX = -1*tx;
        plotY = -1*ty;
        
        dsx = screenWidth/32 + 2;
        dsy = screenHeight/32 + 2;
        // Wrap up the world
        if(mapX < -screenWidth/2){
            wx = ((worldWidth*32 - screenWidth/2)*worldWidth)/screenWidth;
        }
        if(mapX > worldWidth*32 - screenWidth/2){
            wx = -worldWidth/2;
        }
        if(mapY < -screenHeight/2){
            wy = (worldHeight*32 - screenHeight/2)*worldHeight/-screenHeight;
        }
        if(mapY > worldHeight*32 - screenHeight/2){
            wy = (screenHeight/2*worldHeight)/screenHeight;
        }
    }
    
    // Can further condense
    public void render() {
        map.render(plotX, plotY, sx, sy, dsx, dsy);
        // Tried to fold this list but leads to duplication
        if(mapX < 0){
            map.render(plotX - 32, plotY, (sx + worldWidth - 1)%worldWidth, sy, dsx, dsy);
        }
        else if(mapX > worldWidth*32 - screenWidth){
            map.render(plotX, plotY, (sx - worldWidth)%worldWidth, sy, dsx, dsy);
        }
        if(mapY < 0){
            map.render(plotX, plotY - 32, sx, (sy + worldHeight - 1)%worldHeight, dsx, dsy);
        }
        else if(mapY > worldHeight*32 - screenHeight){
            map.render(plotX, plotY, sx, (sy - worldHeight)%worldHeight, dsx, dsy);
        }
        if(mapX < 0 && mapY < 0){
            map.render(plotX - 32, plotY - 32, (sx + worldWidth - 1)%worldWidth, (sy + worldHeight - 1)%worldHeight, dsx, dsy);
        }
        else if(mapX < 0 && mapY > worldHeight*32 - screenHeight){
            map.render(plotX - 32, plotY, (sx + worldWidth - 1)%worldWidth, (sy - worldHeight)%worldHeight, dsx, dsy);
        }
        if(mapX > worldWidth*32 - screenWidth && mapY < 0){
            map.render(plotX, plotY - 32, (sx - worldWidth)%worldWidth, (sy + worldHeight - 1)%worldHeight, dsx, dsy);
        }
        else if(mapX > worldWidth*32 - screenWidth && mapY > worldHeight*32 - screenHeight){
            map.render(plotX, plotY, (sx - worldWidth)%worldWidth, (sy - worldHeight)%worldHeight, dsx, dsy);
        }
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
    
}
