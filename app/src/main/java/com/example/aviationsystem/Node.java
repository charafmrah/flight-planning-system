package com.example.aviationsystem;

public class Node {
    private Edge edge;
    private Node next;

    public Node() {
        edge = null;
        next = null;
    }

    public Node(Edge edge) {
        this.edge = edge;
        next = null;
    }

    public Node(Edge edge, Node next) {
        this.edge = edge;
        this.next = next;
    }

    public City getCity() {
        return edge.getEndVertex();
    }

//	    public void setCity(City city) {
//	        this.city = city;
//	    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

