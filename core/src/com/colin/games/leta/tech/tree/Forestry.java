package com.colin.games.leta.tech.tree;

import com.colin.games.leta.tech.Technologies;
import com.colin.games.leta.tech.Technology;

import java.util.Collections;
import java.util.List;

public class Forestry extends Technology {
    public Forestry() {
        super(3, "Forestry");
    }

    @Override
    public void onDone() {

    }

    @Override
    public List<Technology> requires() {
        return List.of(Technologies.getTech("Tools"));
    }

    @Override
    public List<Technology> conflicts() {
        return Collections.emptyList();
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Forestry;
    }
}
