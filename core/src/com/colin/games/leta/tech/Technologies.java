package com.colin.games.leta.tech;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Technologies {
    private static List<Technology> tech = new ArrayList<>();
    private Technologies(){
        throw new AssertionError("Technologies class instance created!");
    }
    public static void addTech(Technology toAdd){
        tech.add(toAdd);
    }
    public static void removeTech(Technology toRemove){
        tech.remove(toRemove);
    }
    public static void removeTech(String byName){
        tech.removeIf(technology -> technology.getName().equals(byName));
    }
    public static Technology getTech(String byName){
        return tech.stream().filter(tech -> tech.getName().equals(byName)).findFirst().orElseThrow(() -> new NoSuchElementException("Unable to find technology by name " + byName + "."));
    }
    public static List<Technology> getAll(){
        return new ArrayList<>(tech);
    }
}
