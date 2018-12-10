package nl.maweb.server.modules.world.framework;

import nl.maweb.server.modules.worldobjects.WorldObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spraxs
 * Date: 26-9-2018
 */

public abstract class World {

    private @Getter String name;

    public List<WorldObject> worldObjects;

    public World(String name) {

        this.name = name;
        worldObjects = new ArrayList<>();
    }

}
