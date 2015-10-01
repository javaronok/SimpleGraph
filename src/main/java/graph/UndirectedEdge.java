package graph;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 18:15
 */
public class UndirectedEdge extends Edge {
  public UndirectedEdge(Vertex beginVertex, Vertex endVertex) {
    super(beginVertex, endVertex);

    beginVertex.addLink(this);
    endVertex.addLink(this);
  }

  public boolean isLinked(Vertex vertex) {
    return vertex.equals(getBeginVertex()) || vertex.equals(getEndVertex());
  }

  @Override
  public Vertex getSource(Vertex target) {
    return getLinked(target);
  }

  @Override
  public Vertex getTarget(Vertex source) {
    return getLinked(source);
  }

  private Vertex getLinked(Vertex vertex) {
    if(isLinked(vertex)) {
      if (vertex.equals(getBeginVertex()))
        return getEndVertex();

      if (vertex.equals(getEndVertex()))
        return getBeginVertex();
    }
    return null;
  }

  @Override
  public String toString() {
    return getBeginVertex() + " - " + getEndVertex();
  }
}
