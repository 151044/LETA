package com.colin.games.leta.tech;

import org.junit.jupiter.api.Test;

public class TechTreeTest {
    @Test
    void dump() {
        TechTree tree = new TechTree(Technologies.getTech("Tools"),Technologies.getAll());
        tree.dump().forEach(System.out::println);
    }
}