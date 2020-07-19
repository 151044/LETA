package com.colin.games.leta.tech;

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
            throw new IllegalStateException("Technology incremented when done?");
        }
    }
    public boolean isResearched(){
        return isDone;
    }
    public abstract void onDone();
}