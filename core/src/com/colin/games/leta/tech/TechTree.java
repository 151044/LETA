package com.colin.games.leta.tech;

import java.util.*;
import java.util.stream.Collectors;

public class TechTree {
    private Node top;
    public TechTree(Technology root,List<Technology> techs){
        top = new Node(root,techs);
    }
    public List<Technology> dependents(Technology toSearch){
        return null;
    }
    public List<String> dump(){
        return allNodes().stream().map(tech -> tech.desc()).collect(Collectors.toList());
    }
    private Set<Node> allNodes(){
        return new HashSet<>(recurse(top));
    }
    private List<Node> recurse(Node toRecurse){
        if(toRecurse.connects.size() == 0){
            return List.of(toRecurse);
        }else{
            List<Node> nodes = toRecurse.connects.stream().flatMap(tech -> recurse(tech).stream()).collect(Collectors.toList());
            nodes.add(toRecurse);
            return nodes;
        }
    }
    private class Node{
        private List<Node> connects = new ArrayList<>();
        private Technology thisTech;
        public Node(Technology toSet,List<Technology> all){
            thisTech = toSet;
            for(Technology tech : all){
                if(tech.requires().contains(toSet)){
                    connects.add(new Node(tech,all));
                }
            }
        }
        public List<Technology> dependents(){
            return connects.stream().map(node -> node.get()).collect(Collectors.toList());
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
