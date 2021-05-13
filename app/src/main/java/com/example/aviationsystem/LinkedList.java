package com.example.aviationsystem;

public class LinkedList<T> {

    private Node root;
    private int size;

    public LinkedList() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void addCity(City city) {
        Node newNode = new Node(city);
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

    public void printData() {
        Node currentNode = root;

        while(currentNode != null) {
            System.out.println(currentNode.getCity());
            currentNode = currentNode.getNext();
        }
    }

    public Node addCityToGivenPosition(Node root, int position, City city) {
        if(position <= 0)
            System.out.println("invalid position");
        else {
            Node newNode = new Node (city);
            Node previous = root;

            int count = 1;
            while(count < position - 1) {
                previous = previous.getNext();
                count++;
            }
            if(previous == null) {
                previous = newNode;
            }
            else {
                Node current = previous.getNext();
                newNode.setNext(current);
                previous.setNext(newNode);
            }
        }
        return root;
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

    public void addToFront(Node city) {
        city.setNext(root);
        root = city;
    }

    public Node getRoot() {
        return root;
    }

    public void setHead(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}