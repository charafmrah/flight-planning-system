package com.example.aviationsystem;

public class LinkedList<edge> {
    private Node root;
    private int size;

    public LinkedList() {
        root = null;
        size = 0;

    }

    public void addEdge(Edge edge) {
        Node node = new Node(edge);
        if (root == null)
            root = node;
        else {
            Node currentNode = root;
            while (currentNode.next != null)
                currentNode = currentNode.next;

            currentNode.next = node;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
