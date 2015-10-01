���������� ���������� ������ � �������.

����������� ��� ���� �����:
- ��������������� (������������). �����: OrientedGraph.java
- �����������������. �����: UndirectedGraph.java

����� ��������� ������ ���������� ������ (addVertex) � ������ (addEdge).

����� ������ ������ ��� ������ ���� (getPath) �������� ������ Graph.java ��������� ����� �����������:
- DFS. ����� ����� � �������. (DFSGraphAlgorithm.java)
- �FS. ����� ����� � ������. (�FSGraphAlgorithm.java)

������ �������������� ���������� ���������������� � GraphAlgorithms.java.
����� Graph::getPath ��������� ������ ������� ��� ������������ �������� �� ���������.

��� �������� ���������� ��������� ����� ������� ����� �������: GraphBuilder.
������ �������������:
Graph graph = GraphBuilder.newOrientedGraph().withEdge(1,3).withEdge(3,4).withEdge(3,2).withEdge(4,5).build();

��� �������� ������ � ������ ��� ������������� � ���������� �������� Unit-����� ��� �������������� (OrientedGraphTest) � ������������������ (UndirectedGraphTest) ������.
� ������ ��������� �������� ���������� ������������ � �������������� ����� ��� ���������������� � ������������������� ����� � �������������� ���� �������������� ����������.

��������� ������ ���������� ����� � ���������� ������.
� �������� �������� ������ ������ ���� ������ ����� � �������� ������ ������ (�������������� ��������� �� ���������: DFS).
������ ����� ������� � ���� JSON � �����. ������:

{"orientation": 1, "edges":[[1,3], [3,2], [3,4], [4,5]]}

�������������� ����� (orientation): 0 - ����������������, 1 - �����������������

������ ������ ���������� � ���������� ������:
java -jar target/GraphSimpleDemo.jar -model_file data/ModelGraph1.json -algorithm DFS

����� ��������� � ������������� ������ �������� ������ �������� � �������� ������� ��� ������ ����.
��������� ����������� � ���� ������ ���������.

java -jar target/GraphSimpleDemo.jar -model_file data/ModelGraph1.json -algorithm DFS
Enter start vertex: 1
Enter finish vertex: 5
Result path: [(1) -> (3), (3) -> (4), (4) -> (5)], algorithm: DFS

������� ������� ������ ����� � ��������� ./data, ����������� jar ���� ���������� target/GraphSimpleDemo.jar.

������ ������� ������������ � ������� Maven 3.0.5, Java 1.7. ����� ��������� ��������� ������� � Intellij Idea v14.
