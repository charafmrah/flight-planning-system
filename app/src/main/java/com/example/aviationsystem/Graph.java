package com.example.aviationsystem;

import java.util.*;

class Graph<T> {

    // edges in graph stored in a hashmap
    private Map<T, List<T> > map = new HashMap<>();

    // add vertex to graph
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    // add edge between src & dst
    public void addEdge(T source, T destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }

    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }

        return count;
    }


    public String hasVertex(T v)
    {
        if (map.containsKey(v)) {
            return "vertix found!";
        }
        else {
            return "vertix was NOT found!";
        }
    }

    public String hasEdge(T src, T dst)
    {
        if (map.get(src).contains(dst)) {
            return "Edge found!";
        }
        else {
            return "Edge was NOT found!";
        }
    }

    // Print the adjacency list for all vertices
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}