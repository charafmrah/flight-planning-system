package com.example.aviationsystem;

public class City implements Comparable<City> {

    private int area;
    private String name;
    public double minDistance = Double.POSITIVE_INFINITY;
    public City previous;

    public City(int area, String name) {
        this.area = area;
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area; // in Km
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City [name = " + name + ", area in km^2 = " + area +"]";
    }
    public int compareTo(City other) {
        // TODO Auto-generated method stub
        return Double.compare(minDistance, other.minDistance);
    }
}
