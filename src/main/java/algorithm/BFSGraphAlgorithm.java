package algorithm;

import graph.Edge;
import graph.Vertex;

import java.util.*;

/**
 * Breadth First Search Algorithm
 *
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 23:02
 */
public class BFSGraphAlgorithm implements GraphAlgorithm {

  public static final String ALG_NAME = "BFS";

  LinkedList<Vertex> queue = new LinkedList<Vertex>();
  Map<Vertex, Edge> edgePath = new HashMap<Vertex, Edge>();

  @Override
  public List<Edge> getPath(Vertex start, Vertex finish) {
    queue.push(start);
    edgePath.put(start, null);

    while (!queue.isEmpty()) {
      Vertex source = queue.pop();

      Collection<Edge> edges = source.getLinkEdges();
      for (Edge edge : edges) {
        Vertex target = edge.getTarget(source);

        if (finish.equals(target))
          return compileResultPath(finish, edge);

        if (target != null && !edgePath.containsKey(target)) {
          edgePath.put(target, edge);
          queue.push(target);
        }

      }
    }
    return null;
  }

  private List<Edge> compileResultPath(Vertex finish, Edge edge) {
    Vertex prev = edge.getSource(finish);
    Deque<Edge> deque = new ArrayDeque<Edge>();
    deque.push(edge);

    Edge pathItem;
    while ((pathItem = edgePath.get(prev)) != null) {
      deque.addFirst(pathItem);
      prev = pathItem.getSource(prev);
    }

    return new LinkedList<>(deque);
  }


}
