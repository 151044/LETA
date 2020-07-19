package com.colin.games.leta.tech;

import com.colin.games.leta.tech.tree.*;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Technologies {
    private static List<Technology> tech = new ArrayList<>();
    static{
        tech.add(new Tools());
        tech.add(new Exploring());
        tech.add(new Forestry());
        tech.add(new Farming());
        tech.add(new Fire());
        tech.add(new Sailing());
        tech.add(new Shelter());
        tech.add(new Settlement());
    }
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
