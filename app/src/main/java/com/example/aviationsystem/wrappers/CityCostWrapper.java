// This class is used to encapsulate City to get the cheapest path in Graph class

package com.example.aviationsystem.wrappers;

import com.example.aviationsystem.City;

public class CityCostWrapper implements Comparable<CityCostWrapper> {
    private City city;
    private int totalCost;
    private CityCostWrapper predecessor;

    public CityCostWrapper(City city, int totalCost, CityCostWrapper predecessor) {
        this.city = city;
        this.totalCost = totalCost;
        this.predecessor = predecessor;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public CityCostWrapper getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(CityCostWrapper predecessor) {
        this.predecessor = predecessor;
    }

    public City getCity() {
        return this.city;
    }

    @Override
    public int compareTo(CityCostWrapper o) {
        return Integer.compare(this.totalCost, o.totalCost);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}