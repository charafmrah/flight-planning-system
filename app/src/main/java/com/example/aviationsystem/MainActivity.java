package com.example.aviationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aviationsystem.datastructures.Graph;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner fromSpinner,toSpinner;
    private TextView cheapestPathSolutionTextView,shortestPathSolutionTextView;
    private Button generateButton;

    public static void main(String[] args) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);

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

        Button btn = (Button) findViewById(R.id.generateButton);
        TextView shortestpathtxt = findViewById(R.id.shortestPathSolutionTextView);
        TextView cheapestpathtxt = findViewById(R.id.cheapestPathSolutionTextView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Graph g = new Graph();

                City newYork = new City("New York");
                City dublin = new City("Dublin");
                City berlin = new City("Berlin");
                City london = new City("London");
                City paris = new City("Paris");
                City losAngeles = new City("Los Angeles");
                City moscow = new City("Moscow");
                City rome = new City("Rome");
                City monaco = new City("Monaco");
                City lille = new City("Lille");
                City izmir = new City("Izmir");
                City ankara = new City("Ankara");
                City hongKong = new City("Hong Kong");
                City delhi = new City("Delhi");
                City sydney = new City("Sydney");

                // Boolean is true if the edge is bidirectional
                g.addEdge(newYork, losAngeles, 3944, 2589, true);
                g.addEdge(newYork, dublin, 5112, 3169, true);
                g.addEdge(newYork, moscow, 7531, 6029, false);
                g.addEdge(berlin, dublin, 1317, 509, false);
                g.addEdge(moscow, berlin, 1608, 2281, false);
                g.addEdge(berlin, london, 932, 1350, true);
                g.addEdge(london, paris, 344, 1025, false);
                g.addEdge(london, rome, 1433, 1295, false);
                g.addEdge(london, monaco, 1032, 1379, false);
                g.addEdge(paris, lille, 204, 3764, true);
                g.addEdge(izmir, ankara, 522, 326, true);
                g.addEdge(ankara, rome, 1721, 1427, true);
                g.addEdge(hongKong, monaco, 9568, 3459, true);
                g.addEdge(hongKong, delhi, 3770, 3104, true);
                g.addEdge(delhi, moscow, 4344, 3135, false);
                g.addEdge(delhi, lille, 6373, 5129, true);
                g.addEdge(delhi, sydney, 10426, 8095, true);

                City from = null;
                City to = null;
                switch(fromSpinner.getSelectedItemPosition()) {
                    case 0:
                        from = newYork;
                        break;
                    case 1:
                        from = dublin;
                        break;
                    case 2:
                        from = berlin;
                        break;
                    case 3:
                        from = london;
                        break;
                    case 4:
                        from = paris;
                        break;
                    case 5:
                        from = losAngeles;
                        break;
                    case 6:
                        from = moscow;
                        break;
                    case 7:
                        from = rome;
                        break;
                    case 8:
                        from = monaco;
                        break;
                    case 9:
                        from = lille;
                        break;
                    case 10:
                        from = izmir;
                        break;
                    case 11:
                        from = ankara;
                        break;
                    case 12:
                        from = hongKong;
                        break;
                    case 13:
                        from = delhi;
                        break;
                    case 14:
                        from = sydney;
                        break;
                }

                switch(toSpinner.getSelectedItemPosition()) {
                    case 0:
                        to = newYork;
                        break;
                    case 1:
                        to = dublin;
                        break;
                    case 2:
                        to = berlin;
                        break;
                    case 3:
                        to = london;
                        break;
                    case 4:
                        to = paris;
                        break;
                    case 5:
                        to = losAngeles;
                        break;
                    case 6:
                        to = moscow;
                        break;
                    case 7:
                        to = rome;
                        break;
                    case 8:
                        to = monaco;
                        break;
                    case 9:
                        to = lille;
                        break;
                    case 10:
                        to = izmir;
                        break;
                    case 11:
                        to = ankara;
                        break;
                    case 12:
                        to = hongKong;
                        break;
                    case 13:
                        to = delhi;
                        break;
                    case 14:
                        to = sydney;
                        break;
                }
                String shortest = "";
                String cheapest = "";
                List<String> shortestPath = g.getShortestPath(from,to);
                List<String> cheapestPath = g.getCheapestPath(from,to);
                StringBuilder builder = new StringBuilder();
                for(String s : shortestPath) {
                    builder.append(s + " -> ");
                }
                shortest = builder.toString();

                StringBuilder builder2 = new StringBuilder();
                for(String s : cheapestPath) {
                    builder2.append(s + " -> ");
                }
                cheapest = builder2.toString();

                shortestpathtxt.setText(shortest.substring(0, shortest.length()-4));
                cheapestpathtxt.setText(cheapest.substring(0, cheapest.length()-4));

            }
        });



    }

}