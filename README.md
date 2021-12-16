# Flight Planning System

The flight Planning System is an Android app that helps users find the shortest and cheapest paths in a graph. We naturally went with graphs to represent the different airports. We used a weighted & directed graph to help connect the airports while storing distance & cost on the edge which will be used by Dijkstra’s algorithm to find the shortest and cheapest path. To implement the graph, we used the adjacency list approach using a linked list which we built, and a HashMap from Java’s library. The adjacency list linked lists store the nodes, which store the edges. Lastly, a custom class AirportWrapper is used to encapsulate the aiports for Dijkstra’s algorithm to calculate the total distance for each aiport while traversing it. Dijkstra’s algorithm is used using a MinHeap from Java’s library called PriorityQueue.

## The Database ER Diagram:

![ER Diagram](https://user-images.githubusercontent.com/20629020/146383837-57210cfb-d204-4f53-a3f1-a87f54dd60a7.png)


## The Database Relational Schema:
![Relational Schema](https://user-images.githubusercontent.com/20629020/143615801-b5a6918f-ad13-4423-9893-9c1b2541c7fe.png)

## Code path
To find the Graph & Linked List code, use this path: https://github.com/charafmrah/Flight-Planning-System/tree/master/app/src/main/java/com/example/aviationsystem
