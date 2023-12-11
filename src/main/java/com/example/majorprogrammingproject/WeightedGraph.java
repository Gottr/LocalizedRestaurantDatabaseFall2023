package com.example.majorprogrammingproject;

import java.util.LinkedList;

public class WeightedGraph {
    int vertices;
    LinkedList<WeightedGraphEdge>[] adjacentList;

    WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacentList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        WeightedGraphEdge edge = new WeightedGraphEdge(source, destination, weight);
        //adjacentList[source].addFirst(edge);
    }
}
