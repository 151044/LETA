package com.colin.games.leta.tech.tree;

import com.colin.games.leta.tech.Technology;

import java.util.Collections;
import java.util.List;

public class Tools extends Technology {
    public Tools() {
        super(2, "Tools");
    }

    @Override
    public void onDone() {
        //no-op
    }

    @Override
    public List<Technology> requires() {
        return Collections.emptyList();
    }

    @Override
    public List<Technology> conflicts() {
        return Collections.emptyList();
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Tools;
    }
}
