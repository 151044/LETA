package com.colin.games.leta.tech;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Technology {
    protected int neededTime;
    protected int currentProgress = 0;
    protected boolean isDone = false;
    protected String name;
    public Technology(int neededTime, String name) {
        this.neededTime = neededTime;
        this.name = name;
    }
    public int getRequiredTime(){
        return neededTime;
    }
    public void incrementProgress(){
        currentProgress++;
        if(currentProgress == neededTime){
            isDone = true;
        }else if(currentProgress > neededTime){
            throw new IllegalStateException("Technology " + name + " incremented when done?");
        }
    }
    public void addProgress(int toAdd){
        currentProgress += toAdd;
        if(neededTime < currentProgress){
            isDone = true;
        }
    }
    public boolean isResearched(){
        return isDone;
    }
    public abstract void onDone();
    public String getName(){
        return name;
    }
    public abstract List<Technology> requires();
    public List<Technology> conflicts(){
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technology that = (Technology) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
