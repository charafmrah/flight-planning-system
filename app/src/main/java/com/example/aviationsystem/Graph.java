package com.example.aviationsystem;

import java.util.*;

class Graph {

    // edges in graph stored in a hashmap
    private Map<City, LinkedList> map = new HashMap<>();

    // add vertex to graph
    public void addVertex(City city) {
        map.put(city, new LinkedList());
    }

    // add edge between src & dst
    public void addEdge(City source, City destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).addCity(destination);
        if (bidirectional == true) {
            map.get(destination).addCity(source);
        }

    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (City city : map.keySet()) {
            count += map.get(city).getSize();
        }
        if (bidirection == true) {
            count = count / 2;
        }

        return count;
    }


    public String hasVertex(City city)
    {
        if (map.containsKey(city)) {
            return "vertix found!";
        }
        else {
            return "vertix was NOT found!";
        }
    }
    

    // Print the adjacency list for all vertices
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (City city1 : map.keySet()) {
            builder.append(city1.toString() + ": ");
            for (City city2 : map.get(city1)) {
                builder.append(city2.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}