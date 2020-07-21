package com.colin.games.leta.actors;

public abstract class UnitType {
    private String name;
    public UnitType(String name){
        this.name = name;
    }
    public abstract void ability();
}
