package com.practice.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, List<String>> adjList = new HashMap<>();

    public Graph() {

    }

    public HashMap<String, List<String>> getAdjacencyList() {
        return this.adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    // add vertex
    public boolean addVertex(String v) {
        if (!adjList.containsKey(v)) {
            adjList.put(v, new ArrayList<>());
            return true;
        } else {
            return false;
        }
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (!this.adjList.containsKey(vertex2) || !this.adjList.containsKey(vertex1)) {
            return false;
        }
        this.adjList.get(vertex1).add(vertex2);
        this.adjList.get(vertex2).add(vertex1);
        return true;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (this.adjList.containsKey(vertex2) && this.adjList.containsKey(vertex1)) {
            this.adjList.get(vertex2).remove(vertex1);
            this.adjList.get(vertex1).remove(vertex2);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String v) {
        if (this.adjList.containsKey(v)) {
            List<String> vertices = this.adjList.get(v);
            vertices.forEach(vertex -> {
                this.adjList.get(vertex).remove(v);
            });
            this.adjList.remove(v);
            return true;
        }
        return false;
    }

}
