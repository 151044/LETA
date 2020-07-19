package com.colin.games.leta.tech;

import java.util.ArrayList;
import java.util.List;

public class Technologies {
    private static List<Technology> tech = new ArrayList<>();
    private Technologies(){
        throw new AssertionError("Technologies class instance created!");
    }
    public void addTech(Technology toAdd){
        tech.add(toAdd);
    }
    public void removeTech(Technology toRemove){
        tech.remove(toRemove);
    }
    public void removeTech(String byName){
        tech.removeIf(technology -> technology.getName().equals(byName));
    }
}
