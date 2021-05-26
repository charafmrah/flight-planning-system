# Flight Planning System
![GraphIllustration](https://user-images.githubusercontent.com/20629020/118331702-9becf000-b511-11eb-8e9b-23eb184ed6bc.jpg)

The flight Planning System is an Android app that helps users find the shortest and cheapest paths from the source to the destination. We naturally went with graphs to represent the different cities. We used a weighted & directed graph to help connect the cities while storing distance & cost on the edge which will be used by Dijkstra’s algorithm to find the shortest and cheapest path. To implement the graph, we used the adjacency list approach using a linked list which we built, and a HashMap from Java’s library. The adjacency list linked lists store the nodes, which store the edges. Lastly, a custom class CityWrapper is used to encapsulate the cities for Dijkstra’s algorithm to calculate the total distance for each city while traversing it. Dijkstra’s algorithm is used using a MinHeap from Java’s library called PriorityQueue.
## Screenshot
![Picture1](https://user-images.githubusercontent.com/20629020/119610665-43b3c900-be02-11eb-89ae-2db77de00f83.png)

## Code path
To find the Graph & Linked List code, use this path: https://github.com/charafmrah/Flight-Planning-System/tree/master/app/src/main/java/com/example/aviationsystem
