// This class wraps the City class to add functionality used in the dijkstra algorithm

package com.example.aviationsystem;

public class CityWrapper implements Comparable<CityWrapper> {
    private City city;
    private int totalDistance;
    private CityWrapper predecessor;

    CityWrapper(City city, int totalDistance, CityWrapper predecessor) {
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

    public CityWrapper getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(CityWrapper predecessor) {
        this.predecessor = predecessor;
    }

    public City getCity() {
        return this.city;
    }

    @Override
    public int compareTo(CityWrapper o) {
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
