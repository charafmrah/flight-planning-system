// This class wraps the City class to add functionality used in the dijkstra algorithm

package com.example.aviationsystem;

public class City {

    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City [name = " + name + " ]";
    }

}
