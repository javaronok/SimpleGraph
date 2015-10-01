package algorithm;

import graph.Edge;
import graph.Vertex;

import java.util.List;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 23:00
 */
public interface GraphAlgorithm {
  List<Edge> getPath(Vertex start, Vertex finish);
}
