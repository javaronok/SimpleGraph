package graph;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 17:30
 */
public abstract class Edge {
   private Vertex beginVertex;
   private Vertex endVertex;

  public Edge(Vertex beginVertex, Vertex endVertex) {
    this.beginVertex = beginVertex;
    this.endVertex = endVertex;
  }

  public Vertex getBeginVertex() {
    return beginVertex;
  }

  public Vertex getEndVertex() {
    return endVertex;
  }

  public abstract Vertex getTarget(Vertex source);

  public abstract Vertex getSource(Vertex target);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Edge)) return false;

    Edge edge = (Edge) o;
    return beginVertex.equals(edge.beginVertex) && endVertex.equals(edge.endVertex);

  }

  @Override
  public int hashCode() {
    int result = beginVertex.hashCode();
    result = 31 * result + endVertex.hashCode();
    return result;
  }
}
