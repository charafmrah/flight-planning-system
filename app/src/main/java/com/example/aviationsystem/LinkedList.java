package com.example.aviationsystem;

public class LinkedList {

    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addStudent(int student) {
        Node newNode = new Node(student);
        Node currentNode = head;

        if(isEmpty())
            head = newNode;
        else {
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void printData() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.println(currentNode.getStudent());
            currentNode = currentNode.next;
        }
    }

    public Node addStudentToGivenPosition(Node head, int position, int data) {
        if(position <= 0)
            System.out.println("invalid position");
        else {
            Node newNode = new Node (data);
            Node previous = head;

            int count = 1;
            while(count < position - 1) {
                previous = previous.next;
                count++;
            }
            if(previous == null) {
                previous = newNode;
            }
            else {
                Node current = previous.next;
                newNode.next = current;
                previous.next = newNode;
            }
        }
        return head;
    }

    public void deleteStudent(int student) {
        Node temp = head, prev = null;

        // The node that we want to delete is the root
        if (temp != null && temp.getStudent() == student) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.getStudent() != student) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;

        prev.next = temp.next;
    }

    public void addToFront(Node student) {
        student.next = head;
        head = student;
    }

}