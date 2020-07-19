package com.colin.games.leta.tech.tree;

import com.colin.games.leta.tech.Technologies;
import com.colin.games.leta.tech.Technology;

import java.util.Collections;
import java.util.List;

public class Shelter extends Technology {
    public Shelter(){
        super(3,"Shelter");
    }
    @Override
    public void onDone() {

    }

    @Override
    public List<Technology> requires() {
        return List.of(Technologies.getTech("Forestry"));
    }

    @Override
    public List<Technology> conflicts() {
        return Collections.emptyList();
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Shelter;
    }
}
