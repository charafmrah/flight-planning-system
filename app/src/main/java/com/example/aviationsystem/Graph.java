package com.example.aviationsystem;

import java.util.*;
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
        } else {
            return "Edge (" + src.getName() + " - " + dst.getName() + ") NOT found!";
        }
    }


    public String hasVertex(City city) {
        if (map.containsKey(city)) {
            return "Vertex " + city.getName() + " found.";
        } else {
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
    private Set<City> settledNodes;
    private Set<City> unSettledNodes;
    private Map<City, City> predecessors;
    private Map<City, Integer> distance;

    // public DijkstraAlgorithm(Graph graph) {
    // create a copy of the array so that we can operate on this array
    //  this.nodes = new ArrayList<Vertex>(graph.getVertexes());
    //   this.edges = new ArrayList<Edge>(graph.getEdges());
    //  }

    public void execute(City source) {
        settledNodes = new HashSet<City>();
        unSettledNodes = new HashSet<City>();
        distance = new HashMap<City, Integer>();
        predecessors = new HashMap<City, City>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            City node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);

        }
    }
    private void findMinimalDistances(City node) {
        List<City> adjacentNodes = getNeighbors(node);
        for (City target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(City node, City target) {
        for (City c : map.keySet()) {
            if (c.equals(node)
                    && map.get(c).getRoot().getEdge().getEndVertex().equals(target)) {
                return map.get(c).getRoot().getEdge().getDistance();
            }
        }
        throw new RuntimeException("Should not happen");
    }


    //this method only returns first neighbor of each city

    private List<City> getNeighbors(City node) {
        List<City> neighbors = new ArrayList<City>();
        for (City c : map.keySet()) {
            if (c.equals(node)
                    && !isSettled(map.get(c).getRoot().getEdge().getEndVertex())) {
                neighbors.add(map.get(c).getRoot().getEdge().getEndVertex());
            }
        }
        return neighbors;
    }

    private City getMinimum(Set<City> vertexes) {
        City minimum = null;
        for (City vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(City vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(City destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public List<City> getPath(City target) {
        List<City> path = new ArrayList<City>();
        City step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}



