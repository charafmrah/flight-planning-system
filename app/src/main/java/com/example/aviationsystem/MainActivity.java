package com.example.aviationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner fromSpinner,toSpinner;



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
        g.addEdge(newYork, losAngeles, 34, 35, true);
        g.addEdge(newYork, dublin, 325, 3525, true);
        g.addEdge(newYork, moscow, 52352, 299, false);
        g.addEdge(berlin, dublin, 29092, 25458, false);
        g.addEdge(moscow, dublin, 9298, 290, false);
        g.addEdge(berlin, london, 394, 9298, true);
        g.addEdge(london, paris, 29394, 20093, false);
        g.addEdge(london, rome, 29834, 928389, false);
        g.addEdge(london, monaco, 354298, 92348, false);
        g.addEdge(paris, lille, 53259, 293584, true);
        g.addEdge(izmir, ankara, 2059838, 209, true);
        g.addEdge(ankara, rome, 2359, 2938, true);
        g.addEdge(hongKong, monaco,388, 9238, true);
        g.addEdge(hongKong, delhi, 230939, 23998, true);
        g.addEdge(delhi, moscow, 238998, 9023, false);
        g.addEdge(delhi, lille, 2983, 9283, true);
        g.addEdge(delhi, sydney, 23908, 2308, true);
        g.computePaths(newYork);
        List<City> path = g.getShortestPathTo(paris);
        System.out.println(path);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Dublin");
        cities.add("Berlin");
        cities.add("London");
        cities.add("Paris");
        cities.add("Los Angeles");
        cities.add("Moscow");
        cities.add("Rome");
        cities.add("Monaco");
        cities.add("Lille");
        cities.add("Izmir");
        cities.add("Ankara");
        cities.add("Hong Kong");
        cities.add("Delhi");
        cities.add("Sydney");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                cities
        );
        fromSpinner.setAdapter(citiesAdapter);
        toSpinner.setAdapter(citiesAdapter);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}