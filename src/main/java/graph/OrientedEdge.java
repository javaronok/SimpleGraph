package graph;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 18:14
 */
public class OrientedEdge extends Edge {
  public OrientedEdge(Vertex beginVertex, Vertex endVertex) {
    super(beginVertex, endVertex);
    beginVertex.addLink(this);
  }

  @Override
  public Vertex getTarget(Vertex source) {
    return source.equals(getBeginVertex()) ? getEndVertex() : null;
  }

  @Override
  public Vertex getSource(Vertex target) {
    return target.equals(getEndVertex()) ? getBeginVertex() : null;
  }

  @Override
  public String toString() {
    return getBeginVertex() + " -> " + getEndVertex();
  }
}
