package com.colin.games.leta.tech;

import java.util.ArrayList;
import java.util.List;
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
        return recurse(top).stream().map(tech -> tech.toString()).collect(Collectors.toList());
    }
    private List<Node> recurse(Node toRecurse){
        if(toRecurse.get().requires().size() == 0){
            return List.of(toRecurse);
        }else{
            return toRecurse.connects.stream().flatMap(tech -> recurse(tech).stream()).collect(Collectors.toList());
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
            return thisTech.getName() + " is a dependency of " + connects.stream().map(node -> node.get().getName()).collect(Collectors.joining(", ")) + ".";
        }
    }
}
