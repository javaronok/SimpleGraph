package model;

import java.util.List;

/**
 * User: Dmitriy
 * Date: 30.09.2015
 * Time: 16:32
 */
public class GraphModel {
  public static final Integer UNDIRECTED = 0;
  public static final Integer ORIENTED = 1;

  Integer orientation;
  List<String[]> edges;

  public Integer getOrientation() {
    return orientation;
  }

  public void setOrientation(Integer orientation) {
    this.orientation = orientation;
  }

  public List<String[]> getEdges() {
    return edges;
  }

  public void setEdges(List<String[]> edges) {
    this.edges = edges;
  }
}
