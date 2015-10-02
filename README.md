Simple Graph library.

Implemented two types of graphs:
- Oriented (directed). Class: OrientedGraph.java
- Undirected. Class: UndirectedGraph.java

Classes implement methods of add vertex (addVertex) and edges (addEdge) to the graph.

Method of search path for vertexes (getPath) in based class Graph.java been implemented with two algorithms:
- DFS. Traversing the graph in depth (Depth First Search). (DFSGraphAlgorithm.java)
- ÂFS. Traversing the graph in width (Breadth First Search). (ÂFSGraphAlgorithm.java)

Class of supported algorithms registered in GraphAlgorithms.java.
Method Graph::getPath allow choose algorithm or use default.

For useful construction of graph structure was written builder class: GraphBuilder.
Usage example:
Graph graph = GraphBuilder.newOrientedGraph().withEdge(1,3).withEdge(3,4).withEdge(3,2).withEdge(4,5).build();

Was developed Unit-tests for oriented (OrientedGraphTest) and undirected (UndirectedGraphTest) graphs.
Tests checked ways of search existing and not existing paths for oriented and undirected graphs with using all supported algorithms.

Show the operations of the library can be in console mode.
Source params should be graph model and graph path search algorithm (optional, default: DFS)

Graph model is presented in JSON file, example: {"orientation": 1, "edges":[[1,3], [3,2], [3,4], [4,5]]}
Graph direction (orientation): 0 - undirected, 1 - oriented

Example run of application in console mode:
java -jar target/GraphSimpleDemo.jar -model_file data/ModelGraph1.json -algorithm DFS

Next, the program interactively ask you to enter the source and target vertexes for path search.
Result is presented as a list of edges.

java -jar target/GraphSimpleDemo.jar -model_file data/ModelGraph1.json -algorithm DFS
Enter start vertex: 1
Enter finish vertex: 5
Result path: [(1) -> (3), (3) -> (4), (4) -> (5)], algorithm: DFS

Examples of graph models locate in directory ./data of project catalog, executable jar library file is target/GraphSimpleDemo.jar

Build project is carried of Maven 3.0.5 on Java 1.7. Also attached Intellij Idea v14 project settings.
