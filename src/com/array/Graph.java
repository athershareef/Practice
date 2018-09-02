package com.array;// Java program for Modified Kruskal Algorithm
// Written by kxk171830

import java.util.*;

class Graph
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    class subset
    {
        int parent, rank, capacity;
        boolean root;
    };

    int V, E;
    Edge edge[];
    int root;
    int maxCapacity;

    Graph(int v, int e, int root, int maxCapacity)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
        this.root = root;
        this.maxCapacity = maxCapacity;
    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
            subsets[yroot].capacity += 1;
        }
        else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
            subsets[xroot].capacity += 1;
        }
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
            subsets[xroot].capacity += 1;
        }
    }

    void printEdges() {
        System.out.println("Graph Edges : ");
        for (int i = 0; i < edge.length && edge[i].weight!=0; ++i)
            System.out.println(edge[i].src+" -- " +
                    edge[i].dest+" == " + edge[i].weight);
    }


    void ModifiedKruskalMST()
    {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i)
            result[i] = new Edge();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();

        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
            subsets[v].capacity = 1;
        }

        i = 0;
        while (e < V - 1 && i < edge.length)
        {
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y)
            {
                int xroot = find(subsets, x);
                int yroot = find(subsets, y);
                if(next_edge.src == root && !subsets[yroot].root) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
                else if(!(subsets[xroot].capacity >= maxCapacity) && !(subsets[yroot].capacity >= maxCapacity)) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
        }
        System.out.println("Following are the edges in " +
                "the constructed CMST");
        int total_weight = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
            total_weight+=result[i].weight;
        }
        System.out.println("CMST total weight: " + total_weight);
    }

    void KruskalMST()
    {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }

    void printVertices() {
        System.out.println("Graph Vertices : ");
        for(int i = 0; i < V; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main (String[] args)
    {
        int nodeCount = (int) Math.sqrt(args.length);
        Graph graph = new Graph(nodeCount, nodeCount*nodeCount, 0,  Integer.parseInt(args[args.length -1]));

        int[][] adjacencyMatrix = new int[nodeCount][nodeCount];

        for (int i = 0, count = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++, count++) {
                adjacencyMatrix[i][j] = Integer.parseInt(args[count]);
            }
        }

        for (int i = 0, c =0; i < nodeCount; i++) {
            for (int j = i + 1; j < nodeCount && adjacencyMatrix[i][j] !=0; j++, c++) {
                graph.edge[c].src = i;
                graph.edge[c].dest = j;
                graph.edge[c].weight = adjacencyMatrix[i][j];
            }
        }

        graph.printVertices();
        graph.printEdges();
        System.out.println("Root: " + graph.root);
        System.out.println("W   : " + graph.maxCapacity);
        graph.ModifiedKruskalMST();
        graph.KruskalMST();
    }
}