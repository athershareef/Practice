package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CMST {

    public static void main(String args[]) {
        int nodeCount = (int) Math.sqrt(args.length);
        int[][] adjacencyMatrix = new int[nodeCount][nodeCount];
        int maximumCap = Integer.parseInt(args[args.length - 1]);
        ArrayList<Edge> selectedEdges = new ArrayList<Edge>();
        int sumWeight = 0;
        int selectedCount = 0;

        // Initialization
        Node[] nodes = new Node[nodeCount];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i, 1);
        }

        for (int i = 0, count = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++, count++) {
                adjacencyMatrix[i][j] = Integer.parseInt(args[count]);
            }
        }

        ArrayList<Edge> adjacencyList = new ArrayList<Edge>();
        for (int i = 0; i < nodeCount; i++) {
            for (int j = i + 1; j < nodeCount && adjacencyMatrix[i][j] !=0; j++) {
                Edge e = new Edge(i, j, adjacencyMatrix[i][j]);
                adjacencyList.add(e);
            }
        }
        System.out.println("Graph Edges are: ");

        System.out.println(adjacencyList);
        // Sort
        Collections.sort(adjacencyList);


        for (Edge edge : adjacencyList) {
            if (selectedCount <= nodeCount - 1) {
                sumWeight = findSumofWeights(edge.getSource(), nodes) + findSumofWeights(edge.getDestination(), nodes);
                if (findParent(nodes, edge.getSource()) == findParent(nodes, edge.getDestination())) {
                    break;
                } else if (edge.getSource() == 0) {
                    selectedEdges.add(edge);
                    selectedCount++;
                    nodes[edge.getDestination()].setParent(findParent(nodes, edge.getSource()));
                } else if (sumWeight <= maximumCap) {
                    selectedEdges.add(edge);
                    selectedCount++;
                    nodes[edge.getDestination()].setParent(findParent(nodes, edge.getSource()));
                    nodes[findRootNode(edge.getSource(), nodes)].setWeight(sumWeight);
                }
            } else {
                break;
            }

        }

        System.out.println(selectedEdges);
    }

    private static int findParent(Node[] nodes, int source) {
        if (source != nodes[source].getParent()) {
            return findParent(nodes ,nodes[source].getParent());
        } else {
            return source;
        }
    }

    private static int findRootNode(int source, Node[] nodes) {
        if (source != nodes[source].getParent() && nodes[source].getParent() != 0) {
            return findRootNode(nodes[source].getParent(), nodes);
        } else {
            return source;
        }
    }

    public static int findSumofWeights(int n, Node[] nodes) {

        return nodes[findRootNode(n, nodes)].getWeight();

    }
}
