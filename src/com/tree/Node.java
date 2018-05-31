package com.tree;

public class Node {

    Node left;

    Node right;

    int data;

    private int height;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "{data ->" + data + ", left ->" +  left + ", right ->"  + right +"}";
    }
}
