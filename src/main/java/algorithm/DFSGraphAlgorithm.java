package algorithm;

import graph.Edge;
import graph.Vertex;

import java.util.*;

/**
 * Depth-first search Algorithm
 *
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 23:01
 */
public class DFSGraphAlgorithm implements GraphAlgorithm {

  public static final String ALG_NAME = "DFS";

  private Set<Vertex> marked;
  private Stack<Edge> path;

  public DFSGraphAlgorithm() {
    this.marked = new HashSet<Vertex>();
    this.path = new Stack<Edge>();
  }

  @Override
  public List<Edge> getPath(Vertex start, Vertex finish) {
      return getPathFromTarget(start, finish) ? this.path : null;
  }

  private boolean getPathFromTarget(Vertex current, Vertex finish) {
    if (finish.equals(current))
      return true;

    this.marked.add(current);

    Collection<Edge> edges = current.getLinkEdges();
    for (Edge edge : edges) {
      Vertex target = edge.getTarget(current);
      if (target != null && !this.marked.contains(target)) {
        this.path.push(edge);
        if (getPathFromTarget(target, finish))
          return true;
      }
    }

    if (!this.path.isEmpty())
      this.path.pop();
    return false;
  }
}
