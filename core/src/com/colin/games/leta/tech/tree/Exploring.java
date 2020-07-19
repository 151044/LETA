package com.colin.games.leta.tech.tree;

import com.colin.games.leta.tech.Technologies;
import com.colin.games.leta.tech.Technology;

import java.util.List;

public class Exploring extends Technology {
    public Exploring(){
        super(2,"Exploring");
    }

    @Override
    public void onDone() {

    }

    @Override
    public List<Technology> requires() {
        return List.of(Technologies.getTech("Tools"));
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Exploring;
    }
}
