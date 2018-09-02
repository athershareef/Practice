package com.array;

public class Node {

    private int parent;
    private int weight;

    public Node(int parent, int weight) {
        super();
        this.parent = parent;
        this.weight = weight;
    }

    public Node() {
        super();
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
