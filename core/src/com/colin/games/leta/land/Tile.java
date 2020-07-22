package com.colin.games.leta.land;

import com.badlogic.gdx.Screen;
import com.colin.games.leta.actors.Group;

import java.util.Objects;

public abstract class Tile {
    private String name;
    private double movementMod;
    public Tile(String name,double movementModifier){
        this.name = name;
        movementMod = movementModifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return name.equals(tile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract boolean hasAction();
    public abstract void onAction();
    public abstract Screen onClick();
    //public abstract boolean canPass(Group people);
}
