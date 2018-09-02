package com.array;

public class Edge implements Comparable<Edge> {
    private int source;
    private int destination;
    private int weight;

    public Edge() {
        super();
    }

    public Edge(int source, int destination, int weight) {
        super();
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return (this.weight - e.getWeight());
    }

    @Override
    public String toString() {
        return "Edge { From source=" + source + " to " + destination + " => weight=" + weight + "}";
    }


}
