
package game.model.manager;

import game.math.PathFinder;
import game.math.Point2D;
import game.model.Enemy;
import game.model.GameEntity;
import game.model.data.EnemySetting;
import game.model.dataParser.ParamReader;
import java.util.ArrayList;

/**
 *
 * @author Hansen
 */
public class EnemyManager {
    public class AgentManager extends EntityManager {

    private int EnemyCount = 0;
    private int numAgentLimit = 20;
    private int timeSinceLastSpawn, spawnTime;
    private Point2D mapLocation, destinationMapLocation;
    private PathFinder pathFinder;
    private ParamReader enemyParamReader;

    public AgentManager(Point2D mapLocation, ParamReader enemyParamReader, PathFinder pathFinder, Point2D destinationTileLocation) {
        this.entityList = new ArrayList<>();
        this.timeSinceLastSpawn = 0;
        this.spawnTime = 1000;
        this.mapLocation = mapLocation;
        this.enemyParamReader = enemyParamReader;
        this.pathFinder = pathFinder;
        this.destinationMapLocation = destinationTileLocation;
    }

    @Override
    public void update(int delta) {
        for (int i = 0; i < entityList.size(); i++) {
            Enemy e = (Enemy) entityList.get(i);
            if (e.isDead()) {
                entityList.remove(e);
            }
        }
        for (GameEntity entity : entityList) {
            entity.update(delta);
        }
        if (this.EnemyCount < this.numAgentLimit) {
            if (this.timeSinceLastSpawn > this.spawnTime) {
                EnemySetting enemySetting = (EnemySetting)enemyParamReader.getSetting(0);
                //entityList.add(new Enemy(mapLocation, enemySetting, pathFinder, destinationMapLocation));
                entityList.add(new Enemy()
                        .spawnpoint(mapLocation)
                        .destination(destinationMapLocation)
                        .health(enemySetting.getHealth())
                        .speed(enemySetting.getSpeed())
                        .info(enemySetting.getInfo())
                        .armor(enemySetting.getArmor()));
                this.timeSinceLastSpawn = 0;
                this.EnemyCount++;
            } else {
                this.timeSinceLastSpawn += delta;
            }
        }
    }
}
}
