import algorithm.GraphAlgorithms;
import builder.GraphBuilder;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * User: Dmitriy
 * Date: 30.09.2015
 * Time: 15:51
 */
public class OrientedGraphTest {

  @Test
  public void testPathIfExistsByDFS() {
    Graph graph = GraphBuilder.newOrientedGraph()
            .withEdge(1,3)
            .withEdge(3,4)
            .withEdge(3,2)
            .withEdge(4,5)
            .build();

    Vertex start = new Vertex<Integer>(1);
    Vertex end = new Vertex<Integer>(5);
    List<Edge> path = graph.getPath(start, end, GraphAlgorithms.ALGORITHM_CLASS_DFS);
    Assert.assertNotNull(path);
    Assert.assertEquals(path.get(0).getBeginVertex(), start);
    Assert.assertEquals(path.get(path.size()-1).getEndVertex(), end);
  }

  @Test
  public void testPathIfExistsByBFS() {
    Graph graph = GraphBuilder.newOrientedGraph()
            .withEdge(1,3)
            .withEdge(3,4)
            .withEdge(3,2)
            .withEdge(4,5)
            .build();

    Vertex start = new Vertex<Integer>(1);
    Vertex end = new Vertex<Integer>(5);
    List<Edge> path = graph.getPath(start, end, GraphAlgorithms.ALGORITHM_CLASS_BFS);
    Assert.assertNotNull(path);
    Assert.assertEquals(path.get(0).getBeginVertex(), start);
    Assert.assertEquals(path.get(path.size() - 1).getEndVertex(), end);
  }

  @Test
  public void testPathNotExistsByBFS() {
    Graph graph = GraphBuilder.newOrientedGraph()
            .withEdge(1,3)
            .withEdge(3,4)
            .withEdge(3,2)
            .withEdge(4,5)
            .build();

    Vertex start = new Vertex<Integer>(2);
    Vertex end = new Vertex<Integer>(5);
    List<Edge> path = graph.getPath(start, end, GraphAlgorithms.ALGORITHM_CLASS_BFS);
    Assert.assertNull(path);
  }

  @Test
  public void testPathNotExistsByDFS() {
    Graph graph = GraphBuilder.newOrientedGraph()
            .withEdge(1,3)
            .withEdge(3,4)
            .withEdge(3,2)
            .withEdge(4,5)
            .build();

    Vertex start = new Vertex<Integer>(2);
    Vertex end = new Vertex<Integer>(5);
    List<Edge> path = graph.getPath(start, end, GraphAlgorithms.ALGORITHM_CLASS_DFS);
    Assert.assertNull(path);
  }
}
