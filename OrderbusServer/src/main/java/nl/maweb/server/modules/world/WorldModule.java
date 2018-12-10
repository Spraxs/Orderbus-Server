package com.spraxs.js.modules.world;

import com.spraxs.js.framework.Module;
import com.spraxs.js.modules.world.framework.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spraxs
 * Date: 26-9-2018
 */

public final class WorldModule extends Module {

    public List<World> worlds;

    @Override
    public void onEnable() {
        worlds = new ArrayList<>();
    }
}
