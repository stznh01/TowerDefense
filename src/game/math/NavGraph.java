package game.math;

import java.util.ArrayList;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Hansen
 */
public class NavGraph {
    private TiledMap tiledMap;
    private ArrayList<Point2D> ret;
    
    public NavGraph(TiledMap tiledMap)
    {
        this.tiledMap = tiledMap;
    }
    
    /**
     * Gets an array of neighbors on the point of interest, excluding points of
     * other layers
     * 
     * @param point the center
     * @return ArrayList of its neighbors
     */
    public Iterable<Point2D> getNeighbors(Point2D point)
    {
        ret = new ArrayList<>();
        int objectLayer = tiledMap.getLayerIndex("Object");
        for (int i = -1; i < 2; i++)
            for(int j = -1; j < 2; j++)
            {
                int checkX = (int) point.getX()+i;
                int checkY = (int) point.getY()+j;
                if(i!=0 && j!=0)
                {
                }
                else if (i == 0 && j == 0)
                {
                }
                else if((checkX > -1 && checkX <32)
                        && (checkY > -1 && checkY < 22)
                        && tiledMap.getTileId(checkX, checkY, objectLayer) == 0)
                {
                    ret.add(new Point2D(checkX, checkY));
                }
            }
        return ret;
    }
    
    public Iterable<Point2D> getAllNeighbors(Point2D point){
        ret = new ArrayList<>();
        for (int i = -1; i < 2; i++)
            for(int j = -1; j < 2; j++)
            {
                int checkX = (int) point.getX()+i;
                if(checkX < 0){
                    checkX = checkX + 100;
                } else if(checkX > 99){
                    checkX = checkX%100;
                }
                int checkY = (int) point.getY()+j;
                if(checkY < 0){
                    checkY = checkY + 80;
                } else if(checkY > 79){
                    checkY = checkY%80;
                }
                if(i==0 && j==0)
                {
                }
                else if((checkX > -1 && checkX <100)
                        && (checkY > -1 && checkY < 80))
                {
                    ret.add(new Point2D(checkX, checkY));
                }
            }
        return ret;
    }
    
    public TiledMap getTiledMap()
    {
        return this.tiledMap;
    }
}
