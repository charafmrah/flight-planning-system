package com.example.aviationsystem;

public class Node {
    private Edge edge;
    public Node next;

    public Node(Edge edge) {
        this.edge = edge;
        next = null;
    }

    public Edge getEdge() {
        return edge;
    }

}
