package game.model.factory;

import game.math.PathFinder;
import game.math.Point2D;
import game.model.Enemy;
import java.util.ArrayList;

/**
 *
 * @author Hansen
 */
public class EnemyFactory {
    private final ArrayList<Enemy> wave;
    private final Point2D spawnpoint, destination;
    private PathFinder pathFinder;
    private int waveSize;
    public EnemyFactory(Point2D spwnpt, Point2D dest, PathFinder pathFinder, int waveSize)
    {
        this.wave = new ArrayList<>();
        this.spawnpoint = spwnpt;
        this.destination = dest;
        this.pathFinder = pathFinder;
        this.waveSize = waveSize;
    }
    
    public ArrayList<Enemy> makeAgent()
    {
        for(int i = 0; i < waveSize; i++)
        {
            this.wave.add(new Enemy()
                    .spawnpoint(spawnpoint)
                    .destination(destination));
        }
        return wave;
    }
}
