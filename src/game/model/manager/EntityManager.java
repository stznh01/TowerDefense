package game.model.manager;

import game.model.GameEntity;
import java.util.ArrayList;

/**
 *
 * @author Hansen
 */
public abstract class EntityManager {
    protected ArrayList<GameEntity> entityList;
    public abstract void update(int delta);
    
    public Iterable<GameEntity> getGameEntity()
    {
        return this.entityList;
    }
}
