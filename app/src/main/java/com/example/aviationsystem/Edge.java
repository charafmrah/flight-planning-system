// Edge class contains information to be stored in Node of the linked list

package com.example.aviationsystem;

public class Edge {

    private City endVertex;
    private int distance;
    private int cost;


    public Edge(City endVertex, int distance, int cost){
        this.endVertex = endVertex;
        this.distance = distance;
        this.cost = cost;
    }

    public City getEndVertex(){
        return endVertex;
    }

    public int getDistance(){
        return distance;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }




}
