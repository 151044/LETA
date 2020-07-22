package com.colin.games.leta.actors;

import com.colin.games.leta.land.Tile;

import java.util.HashMap;
import java.util.Map;

public class Movement {
    private Movement(){
        throw new AssertionError("Movement class initialized!");
    }
    private static Map<Tile,Boolean> passable = new HashMap<>();
    public static void addTile(Tile tile,boolean isPassable){
        passable.put(tile,isPassable);
    }
    public static void addTile(Tile tile){
        passable.put(tile,false);
    }
    public static void setPassable(Tile tile){
        passable.put(tile,true);
    }
    public static boolean canPass(Tile tile){
        return passable.get(tile);
    }
    public static boolean canPass(Tile tile,UnitType type) {
        return type.specialPass().contains(tile) ? true : canPass(tile);
    }
}
