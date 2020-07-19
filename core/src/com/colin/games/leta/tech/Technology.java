package com.colin.games.leta.tech;

import java.util.List;

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
    public boolean isResearched(){
        return isDone;
    }
    public abstract void onDone();
    public String getName(){
        return name;
    }
    public abstract List<Technology> requires();
    public abstract List<Technology> conflicts();
}
