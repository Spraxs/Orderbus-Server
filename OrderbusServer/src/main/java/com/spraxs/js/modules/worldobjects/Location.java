package com.spraxs.js.modules.worldobjects;

import lombok.Data;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

@Data
public class Location {

    float x;
    float y;
    float z;

    public Location(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
