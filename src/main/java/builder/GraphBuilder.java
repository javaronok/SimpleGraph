package builder;

import graph.Graph;
import graph.OrientedGraph;
import graph.UndirectedGraph;
import graph.Vertex;
import model.GraphModel;

import java.util.Arrays;
import java.util.List;

/**
 * User: Dmitriy
 * Date: 30.09.2015
 * Time: 12:41
 */
public class GraphBuilder {
  private Graph graph;

  private GraphBuilder(Graph graph) {
    this.graph = graph;
  }

  public static GraphBuilder newOrientedGraph() {
    return new GraphBuilder(new OrientedGraph());
  }

  public static GraphBuilder newUndirectedGraph() {
    return new GraphBuilder(new UndirectedGraph());
  }

  public GraphBuilder withEdge(String v1, String v2) {
    return withEdge(new Vertex<String>(v1), new Vertex<String>(v2));
  }

  public GraphBuilder withEdge(Integer v1, Integer v2) {
    return withEdge(new Vertex<Integer>(v1), new Vertex<Integer>(v2));
  }

  public GraphBuilder withEdge(Vertex v1, Vertex v2) {
    graph.addEdge(v1, v2);
    return this;
  }

  public Graph build(){
    return graph;
  }

  public static Graph buildFromModel(GraphModel model) {
    Integer orientation = model.getOrientation();

    GraphBuilder graphBuilder;
    if (GraphModel.UNDIRECTED.equals(orientation)) {
      graphBuilder = GraphBuilder.newUndirectedGraph();
    } else if (GraphModel.ORIENTED.equals(orientation)) {
      graphBuilder = GraphBuilder.newOrientedGraph();
    } else {
      throw new IllegalArgumentException("Graph orientation " + orientation + " not supported");
    }

    List<String[]> edges = model.getEdges();

    if (edges == null || edges.isEmpty())
      throw new IllegalArgumentException("Graph not contains edges");

    for (String[] edge : edges) {
      if (edge == null || edge.length != 2)
        throw new IllegalArgumentException("Failed edge " + Arrays.toString(edge));

      graphBuilder.withEdge(edge[0], edge[1]);
    }

    return graphBuilder.build();
  }
}
