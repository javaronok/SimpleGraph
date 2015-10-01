import algorithm.DFSGraphAlgorithm;
import algorithm.GraphAlgorithm;
import algorithm.GraphAlgorithms;
import builder.GraphBuilder;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import model.GraphModel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * User: Dmitriy
 * Date: 29.09.2015
 * Time: 21:47
 */
public class Main {
  public static void main(String args[]) throws IOException {

    String filePath = null;
    String algorithm = null;

    int count = args.length;

    if (count == 0) {
      outputHelp();
      System.exit(0);
    }

    for (int i = 0; i < count; i++) {
      final String arg = args[i];
      if (arg.equals("-model_file") && ++i < count) {
        filePath = args[i];
      } if (arg.equals("-algorithm") && ++i < count) {
        algorithm = args[i];
      } if (arg.equals("-help")) {
        outputHelp();
        System.exit(0);
      }

    }

    Graph graph = null;
    String startVertex = null;
    String finishVertex = null;

    Class<? extends GraphAlgorithm> alg = null;

    try {
      final File graphModelFile = new File("./" + filePath);
      checkGraphModelFile(graphModelFile);

      GraphModel model = parseJsonGraphModelFile(graphModelFile);
      graph = GraphBuilder.buildFromModel(model);

      if (algorithm == null)
        algorithm = DFSGraphAlgorithm.ALG_NAME;

      alg = GraphAlgorithms.lookupAlgorithmClass(algorithm);

      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter start vertex: ");
      startVertex = scanner.next();

      if (startVertex == null)
        throw new IllegalArgumentException("Start vertex con not be empty");

      System.out.print("Enter finish vertex: ");
      finishVertex = scanner.next();

      if (finishVertex == null)
        throw new IllegalArgumentException("Start vertex con not be empty");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      outputHelp();
      System.exit(0);
    }

    if (graph == null)
      throw new RuntimeException("Failed build graph from model");

    Vertex<String> start = new Vertex<String>(startVertex);
    Vertex<String> finish = new Vertex<String>(finishVertex);

    List<Edge> path = graph.getPath(start, finish, alg);

    if (path == null)
      System.out.println("Path from " + startVertex + " to " + finishVertex + " not found, algorithm: " + algorithm);
    else
      System.out.println("Result path: " + path + ", algorithm: " + algorithm);
  }

  private static GraphModel parseJsonGraphModelFile(File jsonFile) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper.readValue(jsonFile, GraphModel.class);
  }

  private static void checkGraphModelFile(File file) {
    if (!file.exists())
      throw new IllegalArgumentException("Graph model file " + file.getPath() + " not exists");
  }

  private static void outputHelp() {
    System.out.printf("Simple graph lib usage" +
            "\n" +
            "-model_file  graph model file path (example:, data/ModelGraph1.json)\n" +
            "-algorithm   path search algorithm (BFS - Breadth First Search Algorithm, DFS - Depth-first search Algorithm), default: DFS\n" +
            "");
  }
}
