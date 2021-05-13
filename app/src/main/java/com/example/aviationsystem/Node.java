package com.example.aviationsystem;

public class Node {

    private City city;
    private Node next;

    public Node() {
        city = null;
        next = null;
    }

    public Node(City city) {
        this.city = city;
        next = null;
    }

    public Node(City city, Node next) {
        this.next = next;
        this.next = next;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}

