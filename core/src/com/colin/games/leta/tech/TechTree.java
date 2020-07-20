package com.colin.games.leta.tech;

import java.util.*;
import java.util.stream.Collectors;

public class TechTree {
    private Node top;
    private Set<Node> cache = new HashSet<>();
    public TechTree(Technology root,List<Technology> techs){
        top = new Node(root, techs);
        buildCache();
    }
    public List<Technology> dependents(Technology toSearch){
        return cache.stream().filter(n -> n.get().equals(toSearch)).findFirst().orElseThrow(() -> new NoSuchElementException("Technology " + toSearch.getName() + " does not exist in this tech tree!")).connects.stream().map(Node::get).collect(Collectors.toList());
    }
    public List<Technology> dependencies(Technology toSearch){
        return cache.stream().filter(n -> n.connects.stream().anyMatch(node -> node.get().equals(toSearch))).map(Node::get).collect(Collectors.toList());
    }
    public List<String> dump(){
        return cache.stream().map(Node::desc).collect(Collectors.toList());
    }
    private Set<Node> allNodes(){
        return new HashSet<>(recurse(top));
    }
    private List<Node> recurse(Node toRecurse){
        if(toRecurse.connects.isEmpty()){
            return List.of(toRecurse);
        }else{
            List<Node> nodes = toRecurse.connects.stream().flatMap(tech -> recurse(tech).stream()).collect(Collectors.toList());
            nodes.add(toRecurse);
            return nodes;
        }
    }
    private void buildCache(){
        cache = allNodes();
    }
    private static class Node{
        private List<Node> connects = new ArrayList<>();
        private Technology thisTech;
        public Node(Technology toSet,List<Technology> all){
            thisTech = toSet;
            for(Technology tech : all){
                if(tech.requires().contains(toSet)){
                    connects.add(new Node(tech, all));
                }
            }
        }
        public List<Technology> dependents(){
            return connects.stream().map(Node::get).collect(Collectors.toList());
        }
        public Technology get(){
            return thisTech;
        }
        @Override
        public String toString(){
            return thisTech.name;
        }
        public String desc(){
            return thisTech.getName() + " is a dependency of " + (connects.isEmpty() ? "nothing." : connects.stream().map(node -> node.get().getName()).collect(Collectors.joining(", ")) + ".");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return thisTech.equals(node.thisTech);
        }

        @Override
        public int hashCode() {
            return Objects.hash(thisTech);
        }
    }
}
