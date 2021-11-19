// This class wraps the City class to add functionality used in the dijkstra algorithm

package com.example.aviationsystem.wrappers;

import com.example.aviationsystem.City;

public class CityDistanceWrapper implements Comparable<CityDistanceWrapper> {
    private City city;
    private int totalDistance;
    private CityDistanceWrapper predecessor;

    public CityDistanceWrapper(City city, int totalDistance, CityDistanceWrapper predecessor) {
        this.city = city;
        this.totalDistance = totalDistance;
        this.predecessor = predecessor;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public CityDistanceWrapper getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(CityDistanceWrapper predecessor) {
        this.predecessor = predecessor;
    }

    public City getCity() {
        return this.city;
    }

    @Override
    public int compareTo(CityDistanceWrapper o) {
        return Integer.compare(this.totalDistance, o.totalDistance);
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
