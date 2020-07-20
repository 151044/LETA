package com.colin.games.leta.tech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TechTreeTest {
    @Test
    void dump() {
        TechTree tree = new TechTree(Technologies.getTech("Tools"),Technologies.getAll());
        tree.dump().forEach(System.out::println);
    }
    @Test
    void dependencies(){
        TechTree tree = new TechTree(Technologies.getTech("Tools"),Technologies.getAll());
        assertEquals(0,tree.dependencies(Technologies.getTech("Tools")).size());
        assertEquals(2,tree.dependencies(Technologies.getTech("Sailing")).size());
        assertEquals(3,tree.dependencies(Technologies.getTech("Settlement")).size());
    }
    @Test
    void dependents(){
        TechTree tree = new TechTree(Technologies.getTech("Tools"),Technologies.getAll());
        assertEquals(0,tree.dependents(Technologies.getTech("Settlement")).size());
        assertEquals(4,tree.dependents(Technologies.getTech("Forestry")).size());
        assertEquals(2,tree.dependents(Technologies.getTech("Tools")).size());
    }
}