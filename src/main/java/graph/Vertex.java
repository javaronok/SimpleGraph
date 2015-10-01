package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 17:27
 */
public class Vertex<T> {
  private T value;

  private Set<Edge> links = new HashSet<Edge>();

  public Vertex(T value) {
    this.value = value;
  }

  public void addLink(Edge link) {
    links.add(link);
  }

  public T getValue() {
    return value;
  }

  public Collection<Edge> getLinkEdges() {
    return this.links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vertex)) return false;

    Vertex vertex = (Vertex) o;
    return !(value != null ? !value.equals(vertex.value) : vertex.value != null);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "(" + value + ")";
  }
}
