package com.colin.games.leta.actors;

import com.colin.games.leta.land.Tile;

import java.util.Collections;
import java.util.List;

public abstract class UnitType {
    private String name;
    public UnitType(String name){
        this.name = name;
    }
    public abstract void ability();
    public List<Tile> specialPass(){
        return Collections.emptyList();
    }
}
