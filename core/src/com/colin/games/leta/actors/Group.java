package com.colin.games.leta.actors;

import java.util.HashMap;
import java.util.Map;

public class Group {
    private Map<UnitType,Integer> unit = new HashMap<>();
    public Group(UnitType type, int noUnit){
        unit.put(type,noUnit);
    }
    public Group(Map<UnitType,Integer> toSet){
        unit = toSet;
    }
}
