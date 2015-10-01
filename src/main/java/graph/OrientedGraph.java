package graph;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 19:19
 */
public class OrientedGraph extends Graph {
  @Override
  protected Edge createEdge(Vertex from, Vertex to) {
    return new OrientedEdge(from, to);
  }
}
