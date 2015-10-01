package graph;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 19:17
 */
public class UndirectedGraph extends Graph {
  @Override
  protected Edge createEdge(Vertex from, Vertex to) {
    return new UndirectedEdge(from, to);
  }
}
