package com.example.aviationsystem;

import java.util.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Graph<T> {


    // edges in graph stored in a hashmap
    private Map<City, LinkedList> map = new HashMap<>();

    // add vertex to graph
    public void addVertex(City city) {
        map.put(city, new LinkedList());
    }

    // add edge between src & dst
    public void addEdge(City source, City destination, int distance, int cost, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source); // if source doesn't exist as a vertex => add it

        if (!map.containsKey(destination))
            addVertex(destination); // if destination doesn't exist as a vertext => add it

        map.get(source).addCity(destination, distance, cost); // gets the source city's linked list and adds destination city
        if (bidirectional == true) {
            map.get(destination).addCity(source, distance, cost); // if bidirectional, then get linked list of destination and add source
        }

    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (City city : map.keySet()) { // keySet() returns the number of keys in the hashmap
            count += map.get(city).getSize(); // gets the size of linked list for each city
        }
        if (bidirection == true) {
            count /= 2; // if graph is bidirectional => count / 2
        }

        return count;
    }

    public String hasEdge(City src, City dst) {
        if (map.get(src).contains(dst)) {
            return "Edge (" + src.getName() + " - " + dst.getName() + ") found.";
        }
        else {
            return "Edge (" + src.getName() + " - " + dst.getName() + ") NOT found!";
        }
    }


    public String hasVertex(City city) {
        if (map.containsKey(city)) {
            return "Vertex " + city.getName() + " found.";
        }
        else {
            return "Vertex " + city.getName() + " NOT found!";
        }
    }
    
    public int getDistance(City v) {
    	return map.get(v).getRoot().getEdge().getCost();
    }
    
    public int getCost(City v) {
    	return map.get(v).getRoot().getEdge().getCost();
    }

    // Print the adjacency list for all vertices
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (City v : map.keySet()) {
            builder.append(v.getName() + ": ");
//             for (T w : map.get(v)) {
//                 builder.append(w.toString() + " ");
//             }
            builder.append(map.get(v).printCities());

            builder.append("\n");
        }

        return (builder.toString());

    }
    public void computePaths(City source)
    {
        source.minDistance = 0.;
        PriorityQueue<City> vertexQueue = new PriorityQueue<City>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            City u = vertexQueue.poll();

            // Visit each edge exiting u
            //.adjancencies was an edge array
            for (Edge e : u.adjacencies)
            {
                City v = e.getEndVertex();
                int weight = e.getDistance();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public List<City> getShortestPathTo(City target)
    {
        List<City> path = new ArrayList<City>();
        for (City vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

}

}
