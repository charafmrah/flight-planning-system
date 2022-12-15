<br />
<div align="center">
<h3 align="center">Flight Planning System</h3>

  <p align="center">
    Flight planning system android application.
    <br />
    <a href="https://github.com/charafmrah/flight-planning-system"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/charafmrah/flight-planning-system/issues">Report Bug</a>
    ·
    <a href="https://github.com/charafmrah/flight-planning-system/issues">Request Feature</a>
  </p>
</div>



<!-- ABOUT THE PROJECT -->
## About The Project

![Flight planning system Screen Shot][product-screenshot-1]   ![Flight planning system Screen Shot][product-screenshot-2]

The flight Planning System is an Android app that helps users find the shortest and cheapest paths in a graph. We naturally went with graphs to represent the different airports. We used a weighted & directed graph to help connect the airports while storing distance & cost on the edge which will be used by Dijkstra’s algorithm to find the shortest and cheapest path. To implement the graph, we used the adjacency list approach using a linked list which we built, and a HashMap from Java’s library. The adjacency list linked lists store the nodes, which store the edges. Lastly, a custom class AirportWrapper is used to encapsulate the aiports for Dijkstra’s algorithm to calculate the total distance for each aiport while traversing it. Dijkstra’s algorithm is used using a MinHeap from Java’s library called PriorityQueue.

## The Database ER Diagram:
![ER Diagram](https://user-images.githubusercontent.com/20629020/147767137-4bef7af5-e1e7-4043-8ef0-3c65b28094ac.png)

## The Database Relational Schema:
![Relational Schema](https://user-images.githubusercontent.com/20629020/143615801-b5a6918f-ad13-4423-9893-9c1b2541c7fe.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Java][java]][java-url]
* [![Kotlin][kotlin]][kotlin-url]
* [![Android][android]][android-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Charaf Mrah - [@charafmrah](https://twitter.com/charafmrah) - charaf4charaf@gmail.com 

Project Link: [https://github.com/charafmrah/flight-planning-system](https://github.com/charafmrah/flight-planning-system)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[product-screenshot-1]: Screenshot_1.png
[product-screenshot-2]: Screenshot_2.png
[java]: https://img.shields.io/badge/-Java-black.svg?style=for-the-badge&logo=Java&colorB=555
[java-url]: https://www.java.com/
[kotlin]: https://img.shields.io/badge/-Kotlin-black.svg?style=for-the-badge&logo=kotlin&colorB=555
[kotlin-url]: https://kotlinlang.org/
[android]: https://img.shields.io/badge/-Android-black.svg?style=for-the-badge&logo=android&colorB=555
[android-url]: https://developer.android.com/
