package com.example.aviationsystem.datastructures;

import static org.junit.Assert.*;

import com.example.aviationsystem.City;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GraphTest {

    @Test
    public void get_the_shortest_path() {
        // get the shortest path
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        graph.addEdge(city1, city2, 1, 1, false);
        graph.addEdge(city1, city3, 2, 1, false);
        graph.addEdge(city2, city4, 3, 1, false);
        graph.addEdge(city3, city4, 1, 1, false);
        graph.addEdge(city4, city5, 1, 1, false);
        graph.addEdge(city4, city6, 2, 1, false);
        graph.addEdge(city5, city6, 1, 1, false);

        assertEquals(4, graph.getShortestPath(city1, city6).size());
    }

    @Test
    public void get_the_shortest_path_with_no_path() {
        // get the shortest path with no path
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        graph.addEdge(city1, city2, 1, 1, false);
        graph.addEdge(city1, city3, 2, 1, false);
        graph.addEdge(city4, city5, 1, 1, false);
        graph.addEdge(city4, city6, 2, 1, false);
        graph.addEdge(city5, city6, 1, 1, false);

        assertEquals(-1, graph.getShortestPath(city1, city4).size());
    }

    @Test
    public void get_the_shortest_path_with_no_edge() {
        // get the shortest path with no edge
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        assertEquals(-1, graph.getShortestPath(city1, city6).size());
    }

    @Test
    public void get_the_shortest_path_with_no_vertex() {
        // get the shortest path with no vertex
        Graph graph = new Graph();

        assertEquals(-1, graph.getShortestPath(null, null));
    }

    @Test
    public void get_the_shortest_path_with_one_vertex() {
        // get the shortest path with one vertex
        Graph graph = new Graph();

        City city1 = new City("city1");

        graph.addVertex(city1);

        assertEquals(0, graph.getShortestPath(city1, city1).size());
    }

    @Test
    public void get_the_shortest_path_with_two_vertex() {
        // get the shortest path with two vertex
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");

        graph.addVertex(city1);
        graph.addVertex(city2);

        graph.addEdge(city1, city2, 1, 1, false);

        assertEquals(1, graph.getShortestPath(city1, city2).size());
    }

    @Test
    public void get_the_shortest_path_with_two_vertex_no_edge() {
        // get the shortest path with two vertex no edge
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");

        graph.addVertex(city1);
        graph.addVertex(city2);

        assertEquals(-1, graph.getShortestPath(city1, city2).size());
    }

    @Test
    public void get_the_cheapest_path() {
        // get the cheapest path
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        graph.addEdge(city1, city2, 1, 1, false);
        graph.addEdge(city1, city3, 2, 1, false);
        graph.addEdge(city2, city4, 3, 1, false);
        graph.addEdge(city3, city4, 1, 1, false);
        graph.addEdge(city4, city5, 1, 1, false);
        graph.addEdge(city4, city6, 2, 1, false);
        graph.addEdge(city5, city6, 1, 1, false);

        assertEquals(4, graph.getCheapestPath(city1, city6).size());
    }

    @Test
    public void get_the_cheapest_path_with_no_path() {
        // get the cheapest path with no path
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        graph.addEdge(city1, city2, 1, 1, false);
        graph.addEdge(city1, city3, 2, 1, false);
        graph.addEdge(city2, city4, 3, 1, false);
        graph.addEdge(city3, city4, 1, 1, false);
        graph.addEdge(city4, city5, 1, 1, false);
        graph.addEdge(city4, city6, 2, 1, false);
        graph.addEdge(city5, city6, 1, 1, false);

        assertEquals(-1, graph.getCheapestPath(city1, city4).size());
    }

    @Test
    public void get_the_cheapest_path_with_no_edge() {
        // get the cheapest path with no edge
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");
        City city3 = new City("city3");
        City city4 = new City("city4");
        City city5 = new City("city5");
        City city6 = new City("city6");

        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);
        graph.addVertex(city4);
        graph.addVertex(city5);
        graph.addVertex(city6);

        assertEquals(-1, graph.getCheapestPath(city1, city6).size());
    }

    @Test
    public void get_the_cheapest_path_with_no_vertex() {
        // get the cheapest path with no vertex
        Graph graph = new Graph();

        assertEquals(-1, graph.getCheapestPath(null, null));
    }

    @Test
    public void get_the_cheapest_path_with_one_vertex() {
        // get the cheapest path with one vertex
        Graph graph = new Graph();

        City city1 = new City("city1");

        graph.addVertex(city1);

        assertEquals(0, graph.getCheapestPath(city1, city1).size());
    }

    @Test
    public void get_the_cheapest_path_with_two_vertex() {
        // get the cheapest path with two vertex
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");

        graph.addVertex(city1);
        graph.addVertex(city2);

        graph.addEdge(city1, city2, 1, 1, false);

        assertEquals(1, graph.getCheapestPath(city1, city2).size());
    }

    @Test
    public void get_the_cheapest_path_with_two_vertex_no_edge() {
        // get the cheapest path with two vertex no edge
        Graph graph = new Graph();

        City city1 = new City("city1");
        City city2 = new City("city2");

        graph.addVertex(city1);
        graph.addVertex(city2);

        assertEquals(-1, graph.getCheapestPath(city1, city2).size());
    }

}