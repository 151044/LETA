package com.colin.games.leta.land;

import com.badlogic.gdx.Screen;
import com.colin.games.leta.actors.Group;

public abstract class Tile {
    private String name;
    private double movementMod;
    public Tile(String name,double movementModifier){
        this.name = name;
        movementMod = movementModifier;
    }
    public abstract boolean hasAction();
    public abstract void onAction();
    public abstract Screen onClick();
    public abstract boolean canPass(Group people);
}
