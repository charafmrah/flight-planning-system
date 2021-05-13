package com.example.aviationsystem;

public class City {

    private int area;
    private String name;

    public City(int area, String name) {
        this.area = area;
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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
}