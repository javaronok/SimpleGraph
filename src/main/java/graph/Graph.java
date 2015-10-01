package graph;

import algorithm.GraphAlgorithm;
import algorithm.GraphAlgorithms;
import algorithm.VertexNotFoundException;

import java.util.*;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 18:19
 */
public abstract class Graph {
  private final Set<Edge> edges;
  private final Map<Vertex, Vertex> vertexes;

  public Graph() {
    this.edges = new HashSet<Edge>();
    this.vertexes = new HashMap<Vertex, Vertex>();
  }

  public void addVertex(Vertex vertex) {
    if (!vertexes.containsKey(vertex))
      this.vertexes.put(vertex, vertex);
  }

  public void addEdge(Vertex from, Vertex to) {
    addVertex(from);
    addVertex(to);

    Edge edge = createEdge(vertexes.get(from), vertexes.get(to));

    if (!edges.contains(edge))
      this.edges.add(edge);
    else
      throw new IllegalArgumentException("Duplicate edge: " + edge);
  }

  public List<Edge> getPath(Vertex start, Vertex finish) {
    return getPath(start, finish, GraphAlgorithms.ALGORITHM_CLASS_DEFAULT);
  }

  public List<Edge> getPath(Vertex start, Vertex finish, Class<? extends GraphAlgorithm> alg) {
    GraphAlgorithm algorithm = GraphAlgorithms.createAlgorithm(alg);

    Vertex sourceVertex = vertexes.get(start);
    if (sourceVertex == null)
      throw new VertexNotFoundException("Start vertex " + start + " not found in graph");

    Vertex targetVertex = vertexes.get(finish);
    if (targetVertex == null)
      throw new VertexNotFoundException("Finish vertex " + finish + " not found in graph");


    return algorithm.getPath(sourceVertex, targetVertex);
  }

  protected abstract Edge createEdge(Vertex from, Vertex to);
}
