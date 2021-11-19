// Graph is implemented using a hashmap,
// which stores adjacency list in a linked list. The citys are the keys.

package com.example.aviationsystem.datastructures;

import com.example.aviationsystem.City;
import com.example.aviationsystem.wrappers.CityCostWrapper;
import com.example.aviationsystem.wrappers.CityDistanceWrapper;

import java.util.*;

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
            addVertex(destination); // if destination doesn't exist as a vertex => add it

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

    // Print the adjacency list for all vertices
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (City v : map.keySet()) {
            builder.append(v.getName() + ": ");
            builder.append(map.get(v).printCities());
            builder.append("\n");
        }

        return (builder.toString());

    }

    public List<String> getShortestPath(City source, City target) {
        PriorityQueue<CityDistanceWrapper> queue = new PriorityQueue(); // Min heap
        Map<City, CityDistanceWrapper> cityWrappers = new HashMap<>(); // Get corresponding CityWrapper for city
        Set<City> shortestPathFound = new HashSet<>(); // Edges.endvertex already visited

        CityDistanceWrapper sourceWrapper = new CityDistanceWrapper(source, 0, null);
        cityWrappers.put(source, sourceWrapper);
        queue.add(sourceWrapper);


        while(!queue.isEmpty()) {
            CityDistanceWrapper cityDistanceWrapper = queue.poll();
            City city = cityDistanceWrapper.getCity();
            shortestPathFound.add(city);


            // If we reach the target, return the path
            if(city.equals(target)) {
                return buildShortPath(cityDistanceWrapper);
            }

            // Iterate over all neighbors
            Set<City> neighbors = map.get(city).getCitiesSet();
            for(City neighbor : neighbors) {
                // Ignore neighbor if the shortest path was already found
                if(shortestPathFound.contains(neighbor)) {
                    continue;
                }

                // Calculate the total distance to neighbor from current node
                int distance = map.get(city).getDistance(neighbor);
                int totalDistance = cityDistanceWrapper.getTotalDistance() + distance;

                // If neighbor is not discovered yet:
                CityDistanceWrapper neighborWrapper = cityWrappers.get(neighbor);
                if(neighborWrapper == null) {
                    neighborWrapper = new CityDistanceWrapper(neighbor, totalDistance, cityDistanceWrapper);
                    cityWrappers.put(neighbor, neighborWrapper);
                    queue.add(neighborWrapper);
                }

                // Update the total distance & predecessor if neighbor is discovered and distance via current is shorter
                else if(totalDistance < neighborWrapper.getTotalDistance()) {
                    neighborWrapper.setTotalDistance(totalDistance);
                    neighborWrapper.setPredecessor(cityDistanceWrapper);

                    // re-heap the min heap
                    queue.remove(neighborWrapper);
                    queue.add(neighborWrapper);
                }
            }

        }

        // If no path is found:
        List<String> path = new ArrayList<>();
        path.add("No available path");
        return path;
    }

    public List<String> getCheapestPath(City source, City target) {
        PriorityQueue<CityCostWrapper> queue = new PriorityQueue(); // Min heap
        Map<City, CityCostWrapper> cityCostWrappers = new HashMap<>(); // Get corresponding CityWrapper for city
        Set<City> shortestPathFound = new HashSet<>(); // Edges.endvertex already visited

        CityCostWrapper sourceWrapper = new CityCostWrapper(source, 0, null);
        cityCostWrappers.put(source, sourceWrapper);
        queue.add(sourceWrapper);

        while(!queue.isEmpty()) {
            CityCostWrapper cityWrapper = queue.poll();
            City city = cityWrapper.getCity();
            shortestPathFound.add(city);

            if(city.equals(target)) {
                return buildCheapPath(cityWrapper);
            }

            Set<City> neighbors = map.get(city).getCitiesSet();
            for(City neighbor : neighbors) {
                if(shortestPathFound.contains(neighbor)) {
                    continue;
                }

                int cost = map.get(city).getCost(neighbor);
                int totalCost = cityWrapper.getTotalCost() + cost;

                CityCostWrapper neighborWrapper = cityCostWrappers.get(neighbor);
                if(neighborWrapper == null) {
                    neighborWrapper = new CityCostWrapper(neighbor, totalCost, cityWrapper);
                    cityCostWrappers.put(neighbor, neighborWrapper);
                    queue.add(neighborWrapper);
                }

                else if(totalCost < neighborWrapper.getTotalCost()) {
                    neighborWrapper.setTotalCost(totalCost);
                    neighborWrapper.setPredecessor(cityWrapper);

                    // re-heap
                    queue.remove(neighborWrapper);
                    queue.add(neighborWrapper);
                }
            }

        }

        List<String> path = new ArrayList<>();
        path.add("No available path");
        return path;
    }

    // build the shortest path
    public List<String> buildShortPath(CityDistanceWrapper cityDistanceWrapper) {
        List<String> path = new ArrayList<>();

        while(cityDistanceWrapper != null) {
            path.add(cityDistanceWrapper.getCity().getName());
            cityDistanceWrapper = cityDistanceWrapper.getPredecessor();
        }

        Collections.reverse(path);

        return path;
    }

    // build the cheapest path
    public List<String> buildCheapPath(CityCostWrapper cityCostWrapper) {
        List<String> path = new ArrayList<>();

        while(cityCostWrapper != null) {
            path.add(cityCostWrapper.getCity().getName());
            cityCostWrapper = cityCostWrapper.getPredecessor();
        }

        Collections.reverse(path);

        return path;
    }

}