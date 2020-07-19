package com.colin.games.leta.tech;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechTreeTest {
    @Test
    void dump() {
        List<Technology> all = new ArrayList<>();
        Technologies.addTech(new Technology(1,"Forestry") {
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
        });
        Technologies.addTech(new Technology(2,"Fire") {
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
        });
        Technologies.addTech(new Technology(3,"Mining") {
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
        });
        Technologies.addTech(new Technology(4,"Shelter") {
            @Override
            public void onDone() {

            }

            @Override
            public List<Technology> requires() {
                return List.of(Technologies.getTech("Mining"),Technologies.getTech("Fire"));
            }

            @Override
            public List<Technology> conflicts() {
                return null;
            }
        });
        TechTree tree = new TechTree(Technologies.getTech("Forestry"),Technologies.getAll());
        tree.dump().forEach(System.out::println);
    }
}