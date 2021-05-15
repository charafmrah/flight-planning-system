package com.example.aviationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static void main(String[] args) {
        // Object of graph is created.
        Graph g = new Graph();

        City newYork = new City(555, "New York");
        City dublin = new City(999, "Dublin");
        City berlin = new City(325, "Berlin");
        City london = new City(353453, "London");
        City paris = new City(3554, "Paris");
        City losAngeles = new City(5720, "Los Angeles");
        City moscow = new City(997345, "Moscow");
        City rome = new City(98454, "Rome");
        City monaco = new City(423, "Monaco");
        City lille = new City(25643, "Lille");
        City izmir = new City(75857, "Izmir");
        City ankara = new City(7852, "Ankara");
        City hongKong = new City(272527, "Hong Kong");
        City delhi = new City(753773, "Delhi");
        City sydney = new City(72752, "Sydney");

        // Boolean is true if the edge is bidirectional
        g.addEdge(newYork, losAngeles, true);
        g.addEdge(newYork, dublin, true);
        g.addEdge(newYork, moscow, false);
        g.addEdge(berlin, dublin, false);
        g.addEdge(moscow, dublin, false);
        g.addEdge(berlin, london, true);
        g.addEdge(london, paris, false);
        g.addEdge(london, rome, false);
        g.addEdge(london, monaco, false);
        g.addEdge(paris, lille, true);
        g.addEdge(izmir, ankara, true);
        g.addEdge(ankara, rome, true);
        g.addEdge(hongKong, monaco, true);
        g.addEdge(hongKong, delhi, true);
        g.addEdge(delhi, moscow, false);
        g.addEdge(delhi, lille, true);
        g.addEdge(delhi, sydney, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}