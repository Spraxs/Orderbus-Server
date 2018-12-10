package com.spraxs.js.modules.worldobjects.objects.projectiles;

import com.spraxs.js.modules.worldobjects.WorldObject;
import com.spraxs.js.modules.worldobjects.objects.projectiles.framework.ProjectileType;
import lombok.Getter;
import lombok.Setter;

public class Projectile extends WorldObject {

    private @Getter @Setter ProjectileType projectileType;

}
