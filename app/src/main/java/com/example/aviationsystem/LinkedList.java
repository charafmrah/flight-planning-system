package com.example.aviationsystem;

// Linked List class is used to store adjacency list in the graph

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node root;
    private int size;

    public LinkedList() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    // add city to the linked list
    public void addCity(City city, int distance, int cost) {
        Node newNode = new Node(new Edge(city, distance, cost));
        Node currentNode = root;

        if(isEmpty())
            root = newNode;
        else {
            while(currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    // used to print graph
    public String printCities() {
        Node currentNode = root;
        String s = "";

        while(currentNode != null) {
            s += currentNode.getCity().getName() + " - ";
            currentNode = currentNode.getNext();
        }
        return s;
    }

    // Returns the cities in the linked list in a Set
    public Set<City> getCitiesSet() {
        Set<City> mySet = new HashSet<>();
        Node currentNode = root;

        while(currentNode != null) {
            mySet.add(currentNode.getCity());
            currentNode = currentNode.getNext();
        }

        return mySet;
    }

    public int getDistance(City dist) {
        Node currentNode = root;
        int result = 0;

        while(currentNode != null) {
            if(currentNode.getEdge().getEndVertex() == dist) {
                result = currentNode.getEdge().getDistance();
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    public int getCost(City dist) {
        Node currentNode = root;
        int result = 0;

        while(currentNode != null) {
            if(currentNode.getEdge().getEndVertex() == dist) {
                result = currentNode.getEdge().getCost();
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    public void deleteCity(City city) {
        Node temp = root, prev = null;

        if (temp != null && temp.getCity() == city) {
            root = temp.getNext();
            return;
        }
        while (temp != null && temp.getCity() != city) {
            prev = temp;
            temp = temp.getNext();
        }
        if (temp == null)
            return;

        prev.setNext(temp.getNext());
        size--;
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

    // Checks if a city is in the linked list
    public boolean contains(City city) {
        Node current = root;

        while (current != null) {
            if (current.getCity().equals(city)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

}