// Node class is used in LinkedList class

package com.example.aviationsystem.datastructures;

import com.example.aviationsystem.City;

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

    public Node getNext() {
        return next;
    }

    public Edge getEdge() {
        return this.edge;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
